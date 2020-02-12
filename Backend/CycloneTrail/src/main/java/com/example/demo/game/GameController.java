package com.example.demo.game;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.User;

/**
 * GameController is a Rest API Controller for the frontend of the application to use to update, and get information about a GameInstance
 * 
 * 
 * @author Ethan McGill
 *
 */
@RestController
@RequestMapping(path="/game")
public class GameController {
	
	private GameRepository gameRepo = new GameRepository();
	private Location location;
	private Events event;
	private final Logger logger = LoggerFactory.getLogger(GameController.class);
	
	/**
	 * Get a list of all the current GameInstances (people currently playing the game)
	 * 
	 * @return List<GameInstance> allGames
	 */
	@GetMapping(value="/list")
	public List<GameInstance> getAllGames(){
		return gameRepo.allGames();
	}
	
	/**
	 * Get the Backpack Object of a current game give the users name
	 * 
	 * @param String username
	 * @return Backpack backpack
	 */
	@PostMapping(value="/instance/backpack")
	public Backpack getBackpack(@RequestBody GameWrapper username){
		GameInstance game = gameRepo.getGameByName(username.getUsername());
		return game.getBackpack();
	}
	
	/**
	 * Get a GameInstance by the given username as a path variable
	 * 
	 * @param String name
	 * @return GameInstance game
	 */
	@GetMapping(value="/{name}")
	public GameInstance getGameInstanceByName(@PathVariable("name") String name) {
		return gameRepo.getGameByName(name);
	}
	
	/**
	 * Create a new GameInstance with a given username and password in the GameInstance variable
	 * 
	 * @param GameInstance game
	 * @return GameInstance addedGame
	 */
	@PostMapping(value="/new")
	public GameInstance postGame(@RequestBody GameInstance game) {
		gameRepo.addGame(game.getUsername(), game);
		return game;
	}
	
	/**
	 * Remove a GameInstance with a given username in the GameInstance variable
	 * 
	 * @param GameInstance game
	 * @return null
	 */
	@PostMapping(value="/remove")
	public GameInstance removeGame(@RequestBody GameInstance game) {
		gameRepo.removeGame(game.getUsername());
		return null;
	}
	
	/**
	 * Insert an item into the backpack if there is room, and the user has enough money to purchase the item, the name of the object to be inserted
	 * is given in the GameWrapper variable items.object, and the users name is given in items.username 
	 * 
	 * @param GameWrapper items
	 * @return Backpack backpack
	 */
	@PostMapping(value="/backpack/insert")
	public Backpack insertIntoBackpack(@RequestBody GameWrapper items){
		GameInstance game = getGameInstanceByName(items.getUsername());
		if(game.getBackpack().getIsFull() == false) {
			if(items.getObject().equals("Water")) {
				if(game.getMoney()>=1) {
					game.getBackpack().insertObject(BPObject.WATER);
					game.getBackpack().setIsFull();
					game.setMoney(game.getMoney()-1);
					return game.getBackpack();
				}else {
					game.getBackpack().setIsFull();
					return game.getBackpack();
				}
			}
			if(items.getObject().equals("Food")) {
				if(game.getMoney()>=2) {
					game.getBackpack().insertObject(BPObject.FOOD);
					game.getBackpack().setIsFull();
					game.setMoney(game.getMoney()-2);
					return game.getBackpack();
				}else {
					game.getBackpack().setIsFull();
					return game.getBackpack();
				}
			}
			if(items.getObject().equals("School Supplies")) {
				if(game.getMoney()>=2) {
					game.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
					game.getBackpack().setIsFull();
					game.setMoney(game.getMoney()-2);
					return game.getBackpack();
				}else {
					game.getBackpack().setIsFull();
					return game.getBackpack();
				}
			}
		}
		return game.getBackpack();
	}
	
	/**
	 * Insert an object into a users backpack a specific location, the item to insert is given by the GameWrapper variable gw.object, and the
	 * users name is given by gw.username
	 * 
	 * @param GameWrapper gw
	 * @return Backpack backpack
	 */
	@PostMapping(value="/backpack/insertByIndex")
	public Backpack insertIntoBackpackByIndex(@RequestBody GameWrapper gw){
		GameInstance game = getGameInstanceByName(gw.getUsername());
		game.getBackpack().setIsFull();
		if(game.getBackpack().getIsFull() == false) {
			if(gw.getObject().equals("Water") && game.getBackpack().getObjectAtIndex(gw.getIndex())==null && game.getMoney() >= 1.0) {
				game.getBackpack().setObjectAtIndex(gw.getIndex(),BPObject.WATER);
				return game.getBackpack();
			}
			if(gw.getObject().equals("Food") && game.getBackpack().getObjectAtIndex(gw.getIndex())==null && game.getMoney() >= 2.0) {
				game.getBackpack().setObjectAtIndex(gw.getIndex(),BPObject.FOOD);
				return game.getBackpack();
			}
			if(gw.getObject().equals("School Supplies") && game.getBackpack().getObjectAtIndex(gw.getIndex())==null && game.getMoney() >= 2.0) {
				game.getBackpack().setObjectAtIndex(gw.getIndex(),BPObject.SCHOOL_SUPPLIES);
				return game.getBackpack();
			}
		}
		return game.getBackpack();
	}
	
	/**
	 * Remove a given object from the backpack of the given user. The item to be removed is given by the GameWrapper variable gw.object,
	 * and the users name is given by gw.username
	 * 
	 * @param GameWrapper gw
	 * @return Backpack backpack
	 */
	@PostMapping(value="/backpack/remove")
	public Backpack removeItemFromBackpack(@RequestBody GameWrapper gw) {
		GameInstance game = gameRepo.getGameByName(gw.getUsername());
		String object = gw.getObject();
		if(object.equals("Water")) {
			game.getBackpack().removeObject(BPObject.WATER);
		}
		if(object.equals("Food")) {
			game.getBackpack().removeObject(BPObject.FOOD);
		}
		if(object.equals("School Supplies")) {
			game.getBackpack().removeObject(BPObject.SCHOOL_SUPPLIES);
		}
		return game.getBackpack();
	}
	
	/**
	 * Checks to see if a certain users backpack is full, given the users name in the GameWrapper variable name.username
	 * 
	 * @param GameWrapper name
	 * @return boolean isFull
	 */
	@PostMapping(value="/backpack/full")
	public boolean isBackpackFull(@RequestBody GameWrapper name) {
		GameInstance game = gameRepo.getGameByName(name.getUsername());
		return game.getBackpack().getIsFull();
	}
	
	/**
	 * Get a hashmap of all events that could occur during the game
	 * 
	 * @return HashMap<String, Events> allEvents
	 */
	@GetMapping(path = "/events/all")
	public HashMap<String, Events> getAllEvents() {
		Events event = new Events("","","","","",new Location("none",0.0,0.0,0));
		return event.listEvents(event);
	}
	
	/**
	 * Based on the players location draw for a set or random event. The users name will be given by the GameWrapper variable game.username.
	 * Updates the users GameInstance to the event that was drawn, if there was a event drawn
	 * 
	 * @param GameWrapper game
	 * @return Events event
	 */
	@PostMapping(path ="/events/drawEvent")
	public Events drawEvent(@RequestBody GameWrapper game) {
		GameInstance gameInst = gameRepo.getGameByName(game.getUsername());
		Events event = new Events("","","","","",new Location("none",0.0,0.0,0));
		location = gameInst.getLocation();
		gameInst.setEvent(event.getEvent(location.getTitle()));
		return event.getEvent(location.getTitle());
	}
	
	/**
	 * Gets the results from an event that occured. The users name is given by the GameWrapper variable gw.username, the users choice is
	 * given by gw.eventChoice. The users GameInstance is updated automatically when the getResults it called. The result is stored as a string
	 * in the GameWrapper variable result
	 * 
	 * @param GameWrapper gw
	 * @return GameWrapper results
	 */
	@PostMapping(path="/events/getResults")
	public GameWrapper getResults(@RequestBody GameWrapper gw) {
		
		GameInstance game = gameRepo.getGameByName(gw.getUsername());
		Events event = game.getEvent();
		int choiceNum = gw.getEventChoice();
		event.updateAfterEvent(game, event.getResults(game, choiceNum));
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(game, choiceNum));
		return result;
	}
	
	/**
	 * Update the users GameInstance given their username, and the result string. The username is given in the GameWrapper variable gw.username,
	 * and the result string is given by gw.eventResult
	 * 
	 * @param GameWrapper gw
	 * @return GameInstance game
	 */
	@PostMapping(path="/events/update")
	public GameInstance updatePostEvent(@RequestBody GameWrapper gw) {
		
		GameInstance game = getGameInstanceByName(gw.getUsername());
		
		event = game.getEvent();
		event.updateAfterEvent(game, gw.getEventResult());
		
		return gameRepo.getGameByName(gw.getUsername());
	}
	
	/**
	 * Given a location, make the hashamp and return all locations
	 * 
	 * @param location - A user's current location
	 * @return A hashmap of all the locations
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/location")
	public HashMap<String, Location[]> getLocationHash(@RequestBody Location location) {
		return location.makeHash();
	}
	
	/**
	 * Based on a username given, the method finds the corresponding game instance, 
	 * makes the location hashmap, and returns the left location.  In the game instance, 
	 * the location is set to none to allow time for random events.
	 * 
	 * @param location - The user's current location
	 * @param username - The username to find the game instance
	 * @return A left location
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/location/left")
	public Location getLeft(@RequestBody Location location, @RequestParam("username") String username) {
		HashMap<String, Location[]> hash = location.makeHash();
		
		GameInstance game = gameRepo.getGameByName(username);
		game.setLocation(new Location("None", 0, 0, 0));
		
		return hash.get(location.getTitle())[0];
	}
	
	
	/**
	 * Based on a username given, the method finds the corresponding game instance, 
	 * makes the location hashmap, and returns the right location.  In the game instance, 
	 * the location is set to none to allow time for random events.
	 * 
	 * @param location - The user's current location
	 * @param username - The username to find the game instance
	 * @return A right location
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/location/right")
	public Location getRight(@RequestBody Location location, @RequestParam("username") String username) {
		HashMap<String, Location[]> hash = location.makeHash();
		
		GameInstance game = gameRepo.getGameByName(username);
		game.setLocation(new Location("None", 0, 0, 0));
		
		return hash.get(location.getTitle())[1];
	}
	
	/**
	 * When the user arrives at the new location, set the location in the 
	 * game instance to that location
	 * 
	 * @param location - The new current location
	 * @param username - The username used to find the game instance
	 * @return The updated game instance
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/location/atLocation")
	public GameInstance setLocation(@RequestBody Location location, @RequestParam("username") String username) {
		GameInstance game = gameRepo.getGameByName(username);
		game.setLocation(location);
		return game;
	}
	
}
