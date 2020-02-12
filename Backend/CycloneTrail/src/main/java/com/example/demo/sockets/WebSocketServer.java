package com.example.demo.sockets;

import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.score.Score;
import com.example.demo.score.ScoreRespository;
import com.example.demo.user.User;
import com.example.demo.user.UserController;
import com.example.demo.user.UserRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ServerEndpoint("/socket/{username}")
@Component
public class WebSocketServer {
	
	private static Map<Session, String> sessionUsernames = new HashMap<>();
	private static Map<String, Session> usernameSessions = new HashMap<>();
	private ArrayList<String> blacklistedWords = createBlacklist();
	//private WebSocketController control = new WebSocketController();
	private static WebSocketRepo repo = new WebSocketRepo();
	private static ArrayList<String> bannedUsers = new ArrayList<>();
	
	private final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
	
	@OnOpen
	public void onOpen(Session session, @PathParam("username") String username) throws IOException{
		logger.info("Got into open");
		
		sessionUsernames.put(session, username);
		usernameSessions.put(username, session);
		
		//logger.info(user.toString());
		
		logger.info("Put session info");
		if(repo.getAll().size() >50) {
			for(int i=0; i<50; i++) {
				int mess = repo.getAll().size()-50;
				broadcast(repo.getAll().get(mess + i));
			}
		}else {
			for(int i=0; i<repo.getAll().size(); i++) {
				//logger.info("Got into the for loop");
				broadcast(repo.getAll().get(i));
			}
		}
		
		String message = "User: " + username + " has entered the room\n";
		repo.store(message);
		broadcast(message);
		logger.info(""+repo.getAll().size());
	}
	
	@OnMessage
	public void onMessage(Session session, String message) throws IOException{
		
		logger.info("Entered into Message, got message: " + message);
		String username = sessionUsernames.get(session);
		String fullMessage = "";
		
		char arr[] = message.toCharArray();
		int alphaCount =0;
		int uppercaseCount =0;
		
		for(int i=0; i<arr.length; i++) {
			if(Character.isUpperCase(arr[i])) {
				uppercaseCount++;
				logger.info("upperCount: " + uppercaseCount);
			}
			if(Character.isAlphabetic(arr[i])) {
				alphaCount++;
				logger.info("alpabet chars: " + alphaCount);
			}
		}
		
		if(uppercaseCount == alphaCount) {
			message = "message was deleted because of all caps\n";
		}
		
		for(int i=0; i<blacklistedWords.size(); i++) {
			if(message.contains(blacklistedWords.get(i))) {
				message = "messsage was deleted because of foul language\n";
			}
		}
		
//		for(int i=0; i<repo.getBanned().size(); i++) {
//			if(repo.getBanned().get(i).equals(username)) {
//				logger.info("Got into banned condition");
//				message = "@" + username + " : you have been banned from chatting";
//			}
//		}
		
		if(message.startsWith("/ban ")) {
			repo.addToBanned(message.split("/ban ")[1]);
			//bannedUsers.add(message.split("/ban")[1]);
			message = "@" + username + " : " + message.split("/ban")[1] + " banned";
		}
		if(message.startsWith("/unban ")) {
			repo.unban(message.split("/unban ")[1]);
			message = "@" + username + " : " + message.split("/unban")[1] + " unbanned";
		}
		if(repo.getBanned().contains(username)) {
			logger.info("Got into banned condition");
			message = "@" + username + " : you have been banned from chatting";
		}
		if(message.startsWith("@")) {
			String destUsername = message.split(" ")[0].substring(1);
			sendMessageToParticularUser(destUsername, "[DM] " + username + ": " + message);
			sendMessageToParticularUser(username, "[DM] " + username + ": " + message);
		}
		else {
			broadcast(username + " : " + message);
			fullMessage = username + " : " + message;
			repo.store(fullMessage);
			logger.info(""+repo.getAll().size());
		}
		
		for(int i =0; i<repo.getBanned().size(); i++) {
			logger.info("" +repo.getBanned().get(i));
		}
	}
	
	@OnClose
	public void onClose(Session session) throws IOException{
		logger.info("Entered closed");
		
		String username = sessionUsernames.get(session);
		sessionUsernames.remove(session);
		usernameSessions.remove(username);
		
		String message = username + ": left :(\n";
		
		broadcast(message);
		repo.store(message);
	}
	
	@OnError
	public void onError(Session session, Throwable throwable) {
		logger.info("Entered error");
	}
	
	private void sendMessageToParticularUser(String username, String message) {
		try {
			usernameSessions.get(username).getBasicRemote().sendText(message);
		} catch(IOException e) {
			logger.info("Exception: " + e.getMessage().toString());
			e.printStackTrace();
		}
	}
	
	private static void broadcast(String message)throws IOException{
		sessionUsernames.forEach((session, username) -> { 
			synchronized (session) {
				try {
					session.getBasicRemote().sendText(message);
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static ArrayList<String> createBlacklist(){
		ArrayList<String> list =new ArrayList<>();
		list.add("dang");
		list.add("wtf");
		list.add("shoot");
		list.add("die");
		list.add("kill");
		list.add("dumb");
		list.add("stupid");
		return list;
	}
	
}
