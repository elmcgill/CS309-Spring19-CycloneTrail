package com.example.demo.sockets;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public class WebSocketRepo{
	
	private HashMap<Integer, String> messages = new HashMap<>();
	private ArrayList<String> banned = new ArrayList<>();
	private int count =0;
	
	public WebSocketRepo() {
		
	}
	
	public void store(String message) {
		messages.put(count,message);
		count++;
	}
	
	public HashMap<Integer,String> getAll(){
		return messages;
	}
	
	public void addToBanned(String username) {
		banned.add(username);
	}
	
	public ArrayList<String> getBanned(){
		return banned;
	}
	
	public void unban(String username) {
		banned.remove(username);
	}
	
}
