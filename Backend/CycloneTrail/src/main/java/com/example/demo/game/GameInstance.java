package com.example.demo.game;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * GameInstance is a class to hold game information for each user while they are playing the game
 * 
 * @author Ethan McGill
 *
 */
public class GameInstance {
	
	private String username;
	//private String major;
	//private double time;
	private Backpack backpack = new Backpack();
	//private int score;
	//private int health;
	private Location location = new Location("Friley Residence Hall", 42.023975, -93.650423, 0);
	private double money;
	private Events event = new Events("none","","","","",location);
	
	public GameInstance () {
		
	}
	
	/**
	 * Public constructor for the GameInstance class, a new GameInstance is created with the given username and money, location and backpack
	 * are always set to empty and Friley Residence Hall at the start of each game
	 * 
	 * @param username
	 * @param money
	 */
	public GameInstance(@JsonProperty String username, @JsonProperty int money) {
		this.username = username;
		//this.major = major;
		//this.time = 5.00;
		//this.score =0;
		//this.health = 100;
		//this.location = new Location("Friley Residence Hall", 42.023975, -93.650423, 0);
		//this.backpack = new Backpack();
		this.money = money;
	}
	
	/**
	 * Get the users name of the GameInstance
	 * 
	 * @return String username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Set the users name in the GameInstance
	 * 
	 * @param String username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Get the users location in the GameInstance
	 * 
	 * @return Location location
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * Set the users location in the GameInstance to the given location
	 * 
	 * @param Location location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	
	/**
	 * Get the users current event
	 * 
	 * @return Events event
	 */
	public Events getEvent() {
		return event;
	}
	
	/**
	 * Set the users current event in the GameInstance to the given event
	 * 
	 * @param Events event
	 */
	public void setEvent(Events event) {
		this.event = event;
	}
	
//	public void setLocation(Location location) {
//		this.location.setTitle(location.getTitle());
//		this.location.setLatitude(location.getLatitude());
//		this.location.setLongitude(location.getLongitude());
//		this.location.setStatus(location.getStatus());
//	}

	/*public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}*/
	
	/**
	 * Get the users backpack from the GameInstance
	 * 
	 * @return Backpack backpack
	 */
	public Backpack getBackpack() {
		return backpack;
	}
	
	/**
	 * Get the users money from the GameInstance
	 * 
	 * @return int money
	 */
	public double getMoney() {
		return this.money;
	}
	/**
	 * Set the users money in the GameInstance to the given amount of money
	 * 
	 * @param int amount
	 */
	public void setMoney(double amount) {
		this.money = amount;
	}
	
	/**
	 * Set the users backpack in the GameInstance to the given backpack
	 * 
	 * @param Backpack backpack
	 */
	public void setBackpack(Backpack backpack) {
		this.backpack = backpack;
	}
	
}
