package com.example.demo.game;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Event class that holds all the logic for the events that happen in game, including set node events and events that are randomly drawn
 * 
 * 
 * @author Ethan McGill
 *
 */
public class Events {
	
	private String eventName;
	private String dialogChoiceOne;
	private String dialogChoiceTwo;
	private String dialogChoiceThree;
	private String dialogChoiceFour;
	private Location location;
	private GameRepository repo;
	
	/**
	 * Event constructor, creates a new event with the given name, dialogOne, dialogTwo, dialogThree, dialogFour, and location
	 * 
	 * 
	 * @param name
	 * @param dialogOne
	 * @param dialogTwo
	 * @param dialogThree
	 * @param dialogFour
	 * @param location
	 */
	public Events(String name, String dialogOne, String dialogTwo, String dialogThree, String dialogFour, Location location) {
		this.eventName = name;
		this.dialogChoiceOne = dialogOne;
		this.dialogChoiceTwo = dialogTwo;
		this.dialogChoiceThree = dialogThree;
		this.dialogChoiceFour = dialogFour;
		this.location = location;
	}
		
	/**
	 * Event constructor, creates a new event
	 * 
	 * 
	 */
	public Events() {
		this.eventName = eventName;
		this.dialogChoiceOne = dialogChoiceOne;
		this.dialogChoiceTwo = dialogChoiceTwo;
		this.dialogChoiceThree = dialogChoiceThree;
		this.dialogChoiceFour = dialogChoiceFour;
		this.location = location;
	}
	
	/**
	 * Gets the event name
	 * 
	 * @return String eventName
	 */
	public String getEventName() {
		return eventName;
	}
	
	/**
	 * Set eventName to the given name
	 * 
	 * @param String name
	 */
	public void setEventName(String name) {
		this.eventName = name;
	}
	
	/**
	 * Get the event dialog for dialogChoiceOne
	 * 
	 * @return String dialogChoiceOne
	 */
	public String getDialogOne() {
		return dialogChoiceOne;
	}
	
	/**
	 * Set the event dialog for dialogChoiceOne to the given dialog string
	 * 
	 * @param String dialog
	 */
	public void setDialogOne(String dialog) {
		this.dialogChoiceOne = dialog;
	}
	
	/**
	 * Get the event dialog for dialogChoiceTwo
	 * 
	 * @return String dialog
	 */
	public String getDialogTwo() {
		return dialogChoiceTwo;
	}
	
	/**
	 * Set the event dialog for dialogChoiceTwo to the given dialog string
	 * 
	 * @param String dialog
	 */
	public void setDialogTwo(String dialog) {
		this.dialogChoiceTwo = dialog;
	}
	
	/**
	 * Get the event dialog for dialogChoiceThree
	 * 
	 * @return String dialog
	 */
	public String getDialogThree() {
		return dialogChoiceThree;
	}
	
	/**
	 * Set the event dialog for dialogChoiceThree to the given dialog string
	 * 
	 * @param String dialog
	 */
	public void setDialogThree(String dialog) {
		this.dialogChoiceThree = dialog;
	}
	
	/**
	 * Get the event dialog for dialogChoiceFour
	 * 
	 * @return String dialog
	 */
	public String getDialogFour() {
		return dialogChoiceFour;
	}
	
	/**
	 * Set the event dialog for dialogChoiceFour to the given dialog string
	 * 
	 * @param Srting dialog
	 */
	public void setDialogFour(String dialog) {
		this.dialogChoiceFour = dialog;
	}
	
	/**
	 * Get the location of the event
	 * 
	 * @return Location location
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * Set the events location to the given location
	 * 
	 * @param Location location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	
	/**
	 * Get the event for the given location, returns an event if the player is at a set node, draws a random number to see if a random event occurs
	 * 
	 * @param String locName
	 * @return Event event
	 */
	public Events getEvent(String locName) {
		if(locName.equals("none")) {
			Random rand = new Random();
			int draw = rand.nextInt(99)+1;
			if(draw >=1 && draw <= 10) {
				int key = rand.nextInt(9)+1;
				return this.makeHashRandEvents().get(key);
			}else {
				return new Events("none","","","","",new Location("none",0.0,0.0,0));
			}
		}
		else {
			return this.makeHashSetEvents().get(locName);
		}
	}
	/**
	 * Get all of the events that could occur during the game
	 * 
	 * @param Event event
	 * @return HashMap<String, Events> eventList
	 */
	public HashMap<String, Events> listEvents(Events event){
		HashMap<String, Events> allEvents = new HashMap<>();
		HashMap<String, Events> set = event.makeHashSetEvents();
		HashMap<Integer, Events> random = event.makeHashRandEvents();
		allEvents.putAll(set);
		for(int i =1; i<10; i++) {
			allEvents.put("random", random.get(i));
		}
		
		return allEvents;
	}
	
	/**
	 * Get the result of the event that the user was currently in. Returns a comma separated string formatted like S,none,0,0,0.
	 * The first letter determines if the event passed or failed S or F, the second is the item that was lost or gained from the backpack
	 * the third is the amount of items that were lost or gained * or -, the fourth is the amount of money that was lost or gained, * or -,
	 * the last is the amounr of time lost or gained * or -.
	 * 
	 * @param GameInstance game
	 * @param int choice
	 * @return String result
	 */
	public String getResults(GameInstance game, int choice) { //This is gona be a big one
		
		if(this.getLocation().getTitle().equals("Lake LaVerne")) {
			
			int numItemsInBackpack = game.getBackpack().length();
			int numFoodItems = game.getBackpack().getItemCounts()[0];
			
			if(choice == 1) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				if(draw >=0 && draw <=50) { //50 percent chance that you get away from the geese
					return "S,none,0,0,*10";
				}
				if(draw >=51 && draw <= 100) {//50 percent chance that you trip and lose 0-3 items and -10 seconds
					if(numItemsInBackpack >= 3) {//If they have more than three items in their bag they can lose 0-3 objects
						int itemLost = rand.nextInt(4);
						return "S,none,-"+itemLost+",0,-10";
						
					}
					if(numItemsInBackpack>0 && numItemsInBackpack<3){ //If they dont have 3 objects in their backpack they can only lose up to the amount they hold
						int itemLost = rand.nextInt(numItemsInBackpack+1);
						return "S,none,-"+itemLost+",0,-10"; 
					}else {
						return "S,none,0,0,-10";
					}
				}
			}
			if(choice == 2) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				
				if(draw >= 1 && draw <=10) { //10 percent chance that it actually works
					if(numItemsInBackpack >= 1) {//If they have at least 1 item the event succeeds
						return "S,none,-1,0,*15";
					}else {
						return "F,none,0,0,0"; //If they dont have a object in backpack make them choose a different option
					}
				}
				if(draw >= 11 && draw <=100) {//90 percent chance that it does not work
					if(numItemsInBackpack >= 1) {
						return "S,none,-1,0,-20";//If they have one object in backpack event succeeds
					}else {
						return "F,none,0,0,0";//If they don't have any objects in backpack make them choose a different option
					}
				}
				
			}
			if(choice == 3) {
				return "S,none,0,0,-5";
			}
			if(choice == 4) {
				if(numFoodItems >= 3) { //If the number of food items is greater than 3 then you can lose 0-3 items
					Random rand = new Random();
					int draw = rand.nextInt(4);
					return "S,food,-"+draw+",0,-10";
				}
				if(numFoodItems <3 && numFoodItems >= 1) {//If the number of food items is 1 or 2 then you can lose 0-2 items
					Random rand = new Random();
					int draw = rand.nextInt(numFoodItems+1);
					return "S,food,-"+draw+",0,-10";
				}
				if(numFoodItems == 0) { //If the player has no food items make them choose a different choice
					return "F,none,0,0,0";
				}
			}
		}
		
		if(this.getLocation().getTitle().equals("The Memorial Union")) {
			int numOfBackPackItems = game.getBackpack().length();
			double money = game.getMoney();
			
			if(choice == 1) {
				if(numOfBackPackItems <9 && money >=2) {
					return "S,supplies,*1,-2,0";
				}else {
					return "F,none,0,0,0";
				}
			}
			if(choice == 2) {
				if(numOfBackPackItems <9 && money >=1) {
					return "S,water,*1,-1,0";
				}else {
					return "F,none,0,0,0";
				}
			}
			if(choice == 3) {
				if(numOfBackPackItems <9 && money >=2) {
					return "S,food,*1,-2,0";
				}else {
					return "F,none,0,0,0";
				}
			}
			if(choice == 4) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				if(draw >=1 && draw <=33) {//33 percent chance that you find some sort of money
					int moneyDraw = rand.nextInt(99)+1;
					if(moneyDraw>=1 && moneyDraw<=10) {
						return"S,none,0,*1,-10";
					}
					if(moneyDraw>=11 && moneyDraw<=33) {
						return"S,none,0,*.5,-10";
					}
					else {
						return"S,none,0,*.25,-10";
					}
					
				}else {//You find nothing and lose 10 seconds
					return"S,none,0,0,-10";
				}
			}
		}
		
		if(this.getLocation().getTitle().equals("Curtiss Hall")) {
			int numOfBackPackItems = game.getBackpack().length();
			double money = game.getMoney();
			
			if(choice == 1) {
				if(numOfBackPackItems <9 && money >=2) {
					return"S,food,*1,-2,0";
				}else {
					return"F,none,0,0,0";
				}
			}
			if(choice == 2) {
				if(numOfBackPackItems<9 && money >=1) {
					return"S,water,*1,-1,0";
				}else {
					return"F,none,0,0,0";
				}
			}
			if(choice == 3) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				if(draw >=1 && draw <=33) {//33 percent chance that you find some sort of money
					int moneyDraw = rand.nextInt(99)+1;
					if(moneyDraw>=1 && moneyDraw<=10) {
						return"S,none,0,*1,-10";
					}
					if(moneyDraw>=11 && moneyDraw<=33) {
						return"S,none,0,*.5,-10";
					}
					else {
						return"S,none,0,*.25,-10";
					}
					
				}else {//You find nothing and lose 10 seconds
					return"S,none,0,0,-10";
				}
			}
			if(choice == 4) {
				if(numOfBackPackItems<9) {//If theres room in the backpack
					Random rand = new Random();
					int draw = rand.nextInt(99)+1;
					if(draw >=1 && draw <=33) {//33 percent chance that they recieve a pencil
						return"S,supplies,*1,0,-10";
					}else {
						return"S,none,0,0,-10";
					}
				}else {//If there is no room make them choose a different choice
					return"F,none,0,0,0";
				}
			}
		}
		
		if(this.getLocation().getTitle().equals("The Hub")) {
			int numOfBackPackItems = game.getBackpack().length();
			double money = game.getMoney();
			
			if(choice == 1) {
				if(numOfBackPackItems <9 && money >=2) {
					return"S,food,*1,-2,0";
				}else {
					return"F,none,0,0,0";
				}
			}
			if(choice == 2) {
				if(numOfBackPackItems<9 && money >=1) {
					return"S,water,*1,-1,0";
				}else {
					return"F,none,0,0,0";
				}
			}
			if(choice == 3) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				if(draw >=1 && draw <=33) {//33 percent chance that you find some sort of money
					int moneyDraw = rand.nextInt(99)+1;
					if(moneyDraw>=1 && moneyDraw<=10) {
						return"S,none,0,*1,-10";
					}
					if(moneyDraw>=11 && moneyDraw<=33) {
						return"S,none,0,*.5,-10";
					}
					else {
						return"S,none,0,*.25,-10";
					}
					
				}else {//You find nothing and lose 10 seconds
					return"S,none,0,0,-10";
				}
			}
			if(choice == 4) {
				if(numOfBackPackItems<9) {//If theres room in the backpack
					Random rand = new Random();
					int draw = rand.nextInt(99)+1;
					if(draw >=1 && draw <=33) {//33 percent chance that they recieve a pencil
						return"S,supplies,*1,0,-10";
					}else {
						return"S,none,0,0,-10";
					}
				}else {//If there is no room make them choose a different choice
					return"F,none,0,0,0";
				}
			}
		}
		
		if(this.getLocation().getTitle().equals("The Campanile")) {
			if(choice == 1) {
				return "S,none,0,0,-10";
			}
			if(choice == 2) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				if(draw>=1 && draw<=10) {//10 percent chance that you get lucky
					return"S,none,0,0,*20";
				}else {//You did not get lucky -15 seconds
					return"S,none,0,0,-15";
				}
			}
			if(choice == 3) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				
				if(draw>=1 && draw<=25) {//25 percent chance of +10 seconds
					return"S,none,0,0,*10";
				}else {
					return"S,none,0,0,-10"; //75 percent chance you lose 10 seconds
				}
			}
			if(choice == 4) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				
				if(draw>=1 && draw<15) {//15 percent chance +5 seconds
					return "S,none,0,0,*5";
				}else {
					return "S,none,0,0,-15";//85 percent chance you lose 15 seconds
				}
			}
		}
		
		if(this.getLocation().getTitle().equals("ISU Admissions")) {
			int numOfBackPackItems = game.getBackpack().length();
			
			if(choice == 1) {
				if(numOfBackPackItems < 9) {//If they have room for 1 item
					Random rand = new Random();
					int draw = rand.nextInt(2);
					return"S,supplies,*"+draw+",0,-10";
				}else {
					return"F,none,0,0,0"; //If they dont make them choose a different option
				}
			}
			if(choice == 2) {
				if(numOfBackPackItems <8) {
					Random rand = new Random();
					int draw = rand.nextInt(3);
					return"S,supplies,*"+draw+",0,-20";
				}else {
					return"F,none,0,0,0";
				}
			}
			if(choice == 3) {
				if(numOfBackPackItems <7) {
					Random rand = new Random();
					int draw = rand.nextInt(4);
					return"S,supplies,*"+draw+",0,-30";
				}else {
					return"F,none,0,0,0";
				}
				
			}
			if(choice == 4) {
				Random rand = new Random();
				int draw = rand.nextInt(2)+1;
				if(draw==1) {
					return"S,none,0,0,-10";
				}
				else {
					return"S,none,0,0,-15";
				}
			}	
		}
		
		if(this.getLocation().getTitle().equals("Beardshear Hall")) {
			int numOfBackPackItems = game.getBackpack().length();
			double money = game.getMoney();
			
			if(choice == 1) {
				if(money >= 2) {
					return"S,none,0,-2,0";
				}else {
					return"F,none,0,0,0";
				}
			}
			if(choice == 2) {
				return"S,none,0,0,-10";
			}
			if(choice == 3) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				
				if(draw>=1 && draw<= 30) {
					return"S,none,0,0,0";
				}
				else {
					return"S,none,0,0,-10";
				}
			}
			if(choice == 4) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				if(draw >=1 && draw <=33) {//33 percent chance that you find some sort of money
					int moneyDraw = rand.nextInt(99)+1;
					if(moneyDraw>=1 && moneyDraw<=10) {
						return"S,none,0,*1,-10";
					}
					if(moneyDraw>=11 && moneyDraw<=33) {
						return"S,none,0,*.5,-10";
					}
					else {
						return"S,none,0,*.25,-10";
					}
					
				}else {//You find nothing and lose 10 seconds
					return"S,none,0,0,-10";
				}
			}
		}
		
		if(this.getLocation().getTitle().equals("LeBaron Hall")) {
			int numOfBackPackItems = game.getBackpack().length();
			int numOfFoodItems = game.getBackpack().getItemCounts()[0];
			
			if(choice == 1) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				
				if(numOfBackPackItems >=2) {
					if(draw>=1 && draw<=10) {
						return"S,none,0,0,*10";
					}
					if(draw>=11 && draw<=100) {
						int itemLost = rand.nextInt(3);
						return"S,none,-"+itemLost+",0,-10";
					}
				}
				if(numOfBackPackItems ==1) {
					if(draw>=1 && draw<=10) {
						return"S,none,0,0,*10";
					}
					if(draw>=11 && draw<=100) {
						int itemLost = rand.nextInt(1);
						return"S,none,-"+itemLost+",0,-10";
					}
				}else {
					return"F,none,0,0,0";
				}
			}
			if(choice == 2) {
				return"S,none,0,0,-5";
			}
			if(choice == 3) {
				if(numOfBackPackItems >=1) {
					return"S,none,-1,0,-15";
				}
				else {
					return"F,none,0,0,0";
				}
			}
			if(choice == 4) {
				if(numOfFoodItems >=2) {
					Random rand = new Random();
					int draw = rand.nextInt(99)+1;
					
					if(draw>=1 && draw<=33) {
						int food = rand.nextInt(3);
						return"S,food,-"+food+",0,*10";
					}else {
						int food = rand.nextInt(3);
						return"S,food,-"+food+",0,-15";
					}
				}
				if(numOfFoodItems == 1) {
					Random rand = new Random();
					int draw = rand.nextInt(99)+1;
					
					if(draw>=1 && draw<=10) {
						return"S,food,-1,0,*10";
					}else {
						return"S,food,-1,0,-15";
					}
				}else {
					return "F,none,0,0,0";
				}
			}		
		}
		
		if(this.getLocation().getTitle().equals("MacKay Hall")) {
			if(choice == 1) {
				return"S,none,0,0,-10";
			}
			if(choice == 2) {
				Random rand = new Random();
				int draw = rand.nextInt();
				
				if(draw>=1 && draw<=33) {
					return"S,none,0,0,*10";
				}else {
					return"S,none,0,0,-15";
				}
			}
			if(choice == 3) {
				return"S,none,0,0,-5";
			}
			if(choice == 4) {
				return"S,none,0,0,-10";
			}		
		}
		
		if(this.getLocation().getTitle().equals("Kildee Hall")) {
			if(choice == 1) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				if(draw >=1 && draw <=33) { //33% chance you get the less consequence
					return "S,none,0,0,-5";
				}
				if(draw >=34 && draw <= 100) {//66% chance you get the greater consequence
					return "S,none,0,0,-20";
				}
			}
			if(choice == 2) {
				return "S,none,0,0,-10";
			}
			if(choice == 3) {
				return "S,none,0,0,-15";
			}
			if(choice == 4) {
				return "S,none,0,0,-10";
			}
		}
		
		if(this.getLocation().getTitle().equals("Jischke Honors Building")) {
			int numOfBackpackItems = game.getBackpack().length();
			int supplies = game.getBackpack().getItemCounts()[2];
			double money = game.getMoney();
			
			if(choice == 1) {
				if(supplies >=3) {
					return"S,supplies,-3,0,0";
				}else {
					return"S,none,0,0,-10";
				}
			}
			if(choice == 2) {
				return"S,none,0,0,-10";
			}
			if(choice == 3) {
				if(numOfBackpackItems < 9) {
					Random rand = new Random();
					int draw = rand.nextInt(99)+1;
					
					if(draw>=1 && draw<=33) {
						return"S,supplies,*1,0,-10";
					}
					else {
						return"S,supplies,0,0,-10";
					}
				}else {
					return"F,none,0,0,0";
				}
			}
			if(choice == 4) {
				if(money>=2 && numOfBackpackItems <9) {
					return"S,supplies,*1,-2,0";
				}else {
					return"F,none,0,0,0";
				}
			}
		}
		
		if(this.getLocation().getTitle().equals("East Hall")) {
			if(choice == 1) {
				return"S,none,0,0,*10";
			}
			if(choice == 2) {
				return"S,none,0,0,-10";
			}
			if(choice == 3) {
				return"S,none,0,0,*20";
			}
			if(choice == 4) {
				return"S,none,0,0,-20";
			}		
		}
		
		if(this.getLocation().getTitle().equals("East Parking Deck")) {
			if(choice == 1) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				if(draw >=1 && draw <=33) { //33% chance you get the less consequence
					return "S,none,0,0,-5";
				}
				if(draw >=34 && draw <= 100) {//66% chance you get the greater consequence
					return "S,none,0,0,-20";
				}
			}
			if(choice == 2) {
				return "S,none,0,0,-10";
			}
			if(choice == 3) {
				return "S,none,0,0,-15";
			}
			if(choice == 4) {
				return "S,none,0,0,-10";
			}
		}
		
		if(this.getLocation().getTitle().equals("Gerdin Business Building")) {
			if(choice == 1) {
				return"S,none,0,0,-5";
			}
			if(choice == 2) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				
				if(draw>=1 && draw <=25) {
					return"S,none,0,0,0";
				}
				else {
					return"S,none,0,0,-10";
				}
			}
			if(choice == 3) {
				return"S,none,0,0,-10";
			}
			if(choice == 4) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				
				if(draw>=1 && draw<=33) {
					return"S,none,0,0,-5";
				}else {
					return"S,none,0,0,-15";
				}
			}		
		}
		
		if(this.getLocation().getTitle().equals("Knoll")) {
			if(choice == 1) {
				return "S,none,0,0,-10";
			}
			if(choice == 2) {
				return "S,none,0,0,-10";
			}
			if(choice == 3) {
				return "S,none,0,0,-10";
			}
			if(choice == 4) {
				return "S,none,0,0,-10";
			}
		}
		if(this.getEventName().equals("Untied Shoe")) {
			
			if(choice == 1) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				
				if(draw >= 1 && draw<=50) {
					return "S,none,0,0,0";
				}
				else {
					return "S,none,0,0,-10";
				}
			}
			
			if(choice == 2) {
				return "S,none,0,0,-10";
			}
			if(choice == 3) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				
				if(draw >=1 && draw <= 33) {
					return "S,none,0,0,-15";
				}
				else {
					return "S,none,0,0,-5";
				}
			}
			if(choice == 4) {
				return "S,none,0,0,-5";
			}
		}
		if(this.getEventName().equals("Group of Slow Walkers")) {
			if(choice == 1) {
				
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				
				if(draw>=1 && draw <=33) {
					return "S,none,0,0,0";
				}
				else {
					return "S,none,0,0,-10";
				}
			}
			if(choice == 2) {
				
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				
				if(draw >=1 && draw <=50) {
					return"S,none,0,0,-5";
				}
				else {
					return "S,none,0,0,-10";
				}
			}
			if(choice == 3) {
				return "S,none,0,0,-10";
			}
			if(choice == 4) {
				
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				
				if(draw >=1 && draw <= 33) {
					return "S,none,0,0,-5";
				}
				else {
					return "S,none,0,0-15";
				}
			}
		}
		if(this.getEventName().equals("Find .25 cents on the ground")) {
			if(choice == 1) {
				return "S,none,0,*.25,-5";
			}
			if(choice == 2) {
				return "S,none,0,*.25,-5";
			}
			if(choice == 3) {
				return "S,none,0,*.25,-5";
			}
			if(choice == 4) {
				return "S,none,0,0,0";
			}
		}
		if(this.getEventName().equals("Find .50 cents on the ground")) {
			if(choice == 1) {
				return "S,none,0,*.5,-5";
			}
			if(choice == 2) {
				return "S,none,0,*.5,-5";
			}
			if(choice == 3) {
				return "S,none,0,*.5,-5";
			}
			if(choice == 4) {
				return "S,none,0,0,0";
			}
		}
		if(this.getEventName().equals("Find .75 cents on the ground")) {
			if(choice == 1) {
				return "S,none,0,*.75,-5";
			}
			if(choice == 2) {
				return "S,none,0,*.75,-5";
			}
			if(choice == 3) {
				return "S,none,0,*.75,-5";
			}
			if(choice == 4) {
				return "S,none,0,0,0";
			}
		}
		if(this.getEventName().equals("Find 1 dollar on the ground")) {
			if(choice == 1) {
				return "S,none,0,*1,-5";
			}
			if(choice == 2) {
				return "S,none,0,*1,-5";
			}
			if(choice == 3) {
				return "S,none,0,*1,-5";
			}
			if(choice == 4) {
				return "S,none,0,0,0";
			}
		}
		if(this.getEventName().equals("Find school supplies on the ground")) {
			int numItemsInBackpack = game.getBackpack().length();
			
			if(choice == 1) {
				if(numItemsInBackpack < 9) {
					return "S,supplies,*1,0,-5";
				}
				else {
					return"F,none,0,0,0";
				}
			}
			if(choice == 2) {
				if(numItemsInBackpack < 9) {
					return "S,supplies,*1,0,-5";
				}
				else {
					return"F,none,0,0,0";
				}
			}
			if(choice == 3) {
				if(numItemsInBackpack < 9) {
					return "S,supplies,*1,0,-5";
				}
				else {
					return"F,none,0,0,0";
				}
			}
			if(choice == 4) {
				return "S,none,0,0,0";
			}
		}
		if(this.getEventName().equals("You see a dog walking")) {
			if(choice == 1) {
				return "S,none,0,0,-5";
			}
			if(choice == 2) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				
				if(draw >= 1 && draw <= 20) {
					return "S,none,0,0,*10";
				}
				else {
					return "S,none,0,0,-10";
				}
			}
			if(choice == 3) {
				return "S,none,0,0,-10";
			}
			if(choice == 4) {
				return "S,none,0,0,-10";
			}
		}
		if(this.getEventName().equals("You stepped in gum")) {
			int numOfSupplies = game.getBackpack().getItemCounts()[2];
			
			if(choice == 1) {
				return "S,none,0,0,-10";
			}
			if(choice == 2) {
				if(numOfSupplies >= 1) {
					return "S,supplies,-1,0,-5";
				}
				else {
					return "F,none,0,0,0";
				}
			}
			if(choice == 3) {
				return "S,none,0,0,-15";
			}
			if(choice == 4) {
				return "S,none,0,0,-10";
			}
		}
		if(this.getEventName().equals("Goose Chase")) {
			int numItemsInBackpack = game.getBackpack().length();
			int numFoodItems = game.getBackpack().getItemCounts()[0];
			
			if(choice == 1) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				if(draw >=0 && draw <=50) { //50 percent chance that you get away from the geese
					return "S,none,0,0,*10";
				}
				if(draw >=51 && draw <= 100) {//50 percent chance that you trip and lose 0-3 items and -10 seconds
					if(numItemsInBackpack >= 3) {//If they have more than three items in their bag they can lose 0-3 objects
						int itemLost = rand.nextInt(4);
						return "S,none,-"+itemLost+",0,-10";
						
					}
					if(numItemsInBackpack>0 && numItemsInBackpack<3){ //If they dont have 3 objects in their backpack they can only lose up to the amount they hold
						int itemLost = rand.nextInt(numItemsInBackpack+1);
						return "S,none,-"+itemLost+",0,-10"; 
					}else {
						return "S,none,0,0,-10";
					}
				}
			}
			if(choice == 2) {
				Random rand = new Random();
				int draw = rand.nextInt(99)+1;
				
				if(draw >= 1 && draw <=10) { //10 percent chance that it actually works
					if(numItemsInBackpack >= 1) {//If they have at least 1 item the event succeeds
						return "S,none,-1,0,*15";
					}else {
						return "F,none,0,0,0"; //If they dont have a object in backpack make them choose a different option
					}
				}
				if(draw >= 11 && draw <=100) {//90 percent chance that it does not work
					if(numItemsInBackpack >= 1) {
						return "S,none,-1,0,-20";//If they have one object in backpack event succeeds
					}else {
						return "F,none,0,0,0";//If they don't have any objects in backpack make them choose a different option
					}
				}
				
			}
			if(choice == 3) {
				return "S,none,0,0,-5";
			}
			if(choice == 4) {
				if(numFoodItems >= 3) { //If the number of food items is greater than 3 then you can lose 0-3 items
					Random rand = new Random();
					int draw = rand.nextInt(4);
					return "S,food,-"+draw+",0,-10";
				}
				if(numFoodItems <3 && numFoodItems >= 1) {//If the number of food items is 1 or 2 then you can lose 0-2 items
					Random rand = new Random();
					int draw = rand.nextInt(numFoodItems+1);
					return "S,food,-"+draw+",0,-10";
				}
				if(numFoodItems == 0) { //If the player has no food items make them choose a different choice
					return "F,none,0,0,0";
				}
			}
		}
		return "F,none,0,0,0";
	}
	
	/**
	 * Updates the GameInstance after the event occurs from the given results
	 * 
	 * 
	 * @param GameInstance game
	 * @param String result
	 */
	public void updateAfterEvent(GameInstance game, String result) {
		String[] arr = new String[5];
		int count =0;
		//GameInstance game = repo.getGameByName(userName);
		Backpack backpack= game.getBackpack();
		
		arr = result.split(",");
		
		for(int i=0; i<5; i++) {
			System.out.println(arr[i]);
		}
		
		if(arr[0].equals("F")) {
			return;
		}
		if(arr[0].equals("S")) {
			if(arr[1].equals("none") && !arr[2].equals("0")) {
				int numBackpackItems = game.getBackpack().length();
				if(arr[2].equals("-1")) {
					backpack.removeFromIndex(numBackpackItems-1);
				}
				if(arr[2].equals("-2")) {
					backpack.removeFromIndex(numBackpackItems-1);
					backpack.removeFromIndex(numBackpackItems-2);
				}
				if(arr[2].equals("-3")) {
					backpack.removeFromIndex(numBackpackItems-1);
					backpack.removeFromIndex(numBackpackItems-2);
					backpack.removeFromIndex(numBackpackItems-3);
				}
			}
			if(arr[1].equals("food")) {
				if(arr[2].equals("-1")) {
					backpack.removeObject(BPObject.FOOD);
				}
				if(arr[2].equals("-2")) {
					backpack.removeObject(BPObject.FOOD);
					backpack.removeObject(BPObject.FOOD);
				}
				if(arr[2].equals("-3")) {
					backpack.removeObject(BPObject.FOOD);
					backpack.removeObject(BPObject.FOOD);
					backpack.removeObject(BPObject.FOOD);
				}
				if(arr[2].equals("*1")) {
					backpack.insertObject(BPObject.FOOD);
				}
				if(arr[2].equals("*2")) {
					backpack.insertObject(BPObject.FOOD);
					backpack.insertObject(BPObject.FOOD);
				}
				if(arr[2].equals("*3")) {
					backpack.insertObject(BPObject.FOOD);
					backpack.insertObject(BPObject.FOOD);
					backpack.insertObject(BPObject.FOOD);
				}
			}
			if(arr[1].equals("water")) {
				if(arr[2].equals("-1")) {
					backpack.removeObject(BPObject.WATER);
				}
				if(arr[2].equals("-2")) {
					backpack.removeObject(BPObject.WATER);
					backpack.removeObject(BPObject.WATER);
				}
				if(arr[2].equals("-3")) {
					backpack.removeObject(BPObject.WATER);
					backpack.removeObject(BPObject.WATER);
					backpack.removeObject(BPObject.WATER);
				}
				if(arr[2].equals("*1")) {
					backpack.insertObject(BPObject.WATER);
				}
				if(arr[2].equals("*2")) {
					backpack.insertObject(BPObject.WATER);
					backpack.insertObject(BPObject.WATER);
				}
				if(arr[2].equals("*3")) {
					backpack.insertObject(BPObject.WATER);
					backpack.insertObject(BPObject.WATER);
					backpack.insertObject(BPObject.WATER);
				}
			}
			if(arr[1].equals("supplies")) {
				if(arr[2].equals("-1")) {
					backpack.removeObject(BPObject.SCHOOL_SUPPLIES);
				}
				if(arr[2].equals("-2")) {
					backpack.removeObject(BPObject.SCHOOL_SUPPLIES);
					backpack.removeObject(BPObject.SCHOOL_SUPPLIES);
				}
				if(arr[2].equals("-3")) {
					backpack.removeObject(BPObject.SCHOOL_SUPPLIES);
					backpack.removeObject(BPObject.SCHOOL_SUPPLIES);
					backpack.removeObject(BPObject.SCHOOL_SUPPLIES);
				}
				if(arr[2].equals("*1")) {
					backpack.insertObject(BPObject.SCHOOL_SUPPLIES);
				}
				if(arr[2].equals("*2")) {
					backpack.insertObject(BPObject.SCHOOL_SUPPLIES);
					backpack.insertObject(BPObject.SCHOOL_SUPPLIES);
				}
				if(arr[2].equals("*3")) {
					backpack.insertObject(BPObject.SCHOOL_SUPPLIES);
					backpack.insertObject(BPObject.SCHOOL_SUPPLIES);
					backpack.insertObject(BPObject.SCHOOL_SUPPLIES);
				}
				game.setBackpack(backpack);
			}
			if(arr[3].equals("-1")) {
				double money = game.getMoney();
				game.setMoney(money-1);
			}
			if(arr[3].equals("-2")) {
				double money = game.getMoney();
				game.setMoney(money-2);
			}
			if(arr[3].equals("*.25")) {
				double money = game.getMoney();
				game.setMoney(money+.25);
			}
			if(arr[3].equals("*.5")) {
				double money = game.getMoney();
				game.setMoney(money+.5);
			}
			if(arr[3].equals("*1")) {
				double money = game.getMoney();
				game.setMoney(money+1);
			}
		}
		
		game.setEvent(new Events("none","","","","",new Location("none",0.0,0.0,0)));
	}
	
	/**
	 * Creates the hashmap that stores all of the set events that can occur at set nodes in the game
	 * 
	 * @return Hashmap<String, Events> eventMap
	 */
	public HashMap<String, Events> makeHashSetEvents() {
		HashMap<String, Events> eventMap = new HashMap<>();
		Location locate = new Location();
		
		eventMap.put("Lake LaVerne",new Events("Lancelot & Elaine", "Run away from them", "Throw one bag item at them", "Calmly walk by them", "Feed them some food", locate.setLocation("Lake LaVerne", 42.023839, -93.647990, 0)));
		eventMap.put("The Memorial Union", new Events("The ISU Book Store", "Buy School Supplies", "Buy Water", "Buy Food", "Check Vending", location.setLocation("The Memorial Union", 42.023816, -93.645945, 0)));
		eventMap.put("Curtiss Hall", new Events("Global Cafe","Buy Food","Buy Water","Check Vending Machine","Ask someone for a pencil",location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0)));
		eventMap.put("The Hub", new Events("The Roasterie","Buy Food","Buy Water","Check Vending","Ask someone for a pencil",location.setLocation("The Hub", 42.027436, -93.648068, 0)));
		eventMap.put("The Campanile", new Events("The Campanile", "Listen to the Bells", "Kiss a Stranger", "Dance to the Bells", "Try to walk through it to save time", location.setLocation("The Campanile", 42.025421, -93.646064, 0)));
		eventMap.put("ISU Admissions", new Events("Free School Supplies","One free school supply","Two free school supplies","Three free school supplies","Ignore everyone", location.setLocation("ISU Admissions", 42.025260, -93.649137, 0)));
		eventMap.put("Beardshear Hall", new Events("Say Cheese","Get a new ISU Card","Update you ISU card","Ask nicely for directions to Troxel","Check Vending Machine",location.setLocation("Beardshear Hall", 42.026224, -93.648429, 0)));
		eventMap.put("LeBaron Hall", new Events("Albino Squirrel","You try to chase the squirrel","You stop to take a picture to show off in class","Throw something at it","Attract it with food to pet it", location.setLocation("LeBaron Hall", 42.027878, -93.647177, 0)));
		eventMap.put("MacKay Hall", new Events("Daycare On A Walk For Recess","Wait for them to cross your path","Try to shoot the gap between kids","Walk around the last child","Change your direction to avoid them", location.setLocation("MacKay Hall", 42.028511, -93.646515, 0)));
		eventMap.put("Kildee Hall", new Events("Watch For Buses","Cross the road without looking","Look both ways","Wait for a group of people to cross with you","Look both ways",location.setLocation("Kildee Hall", 42.029144, -93.644230, 1)));
		eventMap.put("Jischke Honors Building", new Events("Join The Dark Side","Trade three school supplies for a secret boost","Don't take the deal","Ask nicely for school supplies","Buy school supplies from the dark market", location.setLocation("Jischke Honors Building", 42.027186, -93.644581, 0)));
		eventMap.put("East Hall", new Events("Riddle Me This: What is a taco?","It’s a sandwich","It’s a sub","It’s a taco","It’s a ravioli",location.setLocation("East Hall", 42.026002, -93.643408, 0)));
		eventMap.put("East Parking Deck", new Events("Watch For Leaving Faculty","Cross the road without looking","Look both ways","Wait for a group of people to cross with you","Look both ways",location.setLocation("East Parking Deck", 42.025555, -93.642856, 1)));
		eventMap.put("Gerdin Business Building", new Events("Construction","Patiently wait to walk through","Try to cut to the side of the sidewalk","Take a different side walk","Cut through Gerdin",location.setLocation("Gerdin Business Building", 42.025153, -93.644380, 0)));
		eventMap.put("Knoll", new Events("Hot Cocoa With The President", "You have hot cocoa with the president","You have hot cocoa with the president","You have hot cocoa with the president","You have hot cocoa with the president",location.setLocation("Knoll", 42.023615, -93.643589, 1)));
		return eventMap;
	}
	
	/**
	 * Creates the hashmap that stores all of the random events that can occur during the game
	 * 
	 * @return HashMap<String, Events> eventMap
	 */
	public HashMap<Integer, Events> makeHashRandEvents(){
		HashMap<Integer, Events> eventMap = new HashMap<>();
		Location locate = new Location();
		eventMap.put(1, new Events("Untied Shoe", "Keep walking", "Stop and tie it", "Walk Carefully To Next Stop to Tie it", "Tie it quickly", locate.setLocation("random", 0.0, 0.0, 0)));
		eventMap.put(2, new Events("Group of Slow Walkers", "Try to squeeze between the walkers", "Say excuse me and walk around", "Walk through the grass", "Try squeezing beside them on the other side of the sidewalk", locate.setLocation("random", 0.0, 0.0, 0)));
		eventMap.put(3, new Events("Find .25 cents on the ground", "Pick up the money", "Pick up the money", "Pick up the money", "Ignore the money", locate.setLocation("random", 0.0, 0.0, 0)));
		eventMap.put(4, new Events("Find .50 cents on the ground", "Pick up the money", "Pick up the money", "Pick up the money", "Ignore the money", locate.setLocation("random", 0.0, 0.0, 0)));
		eventMap.put(5, new Events("Find .75 cents on the ground", "Pick up the money", "Pick up the money", "Pick up the money", "Ignore the money", locate.setLocation("random", 0.0, 0.0, 0)));
		eventMap.put(6, new Events("Find 1 dollar on the ground", "Pick up the money", "Pick up the money", "Pick up the money", "Ignore the money", locate.setLocation("random", 0.0, 0.0, 0)));
		eventMap.put(7, new Events("Find school supplies on the ground", "Pick up the school supplies", "Pick up the school supplies", "Pick up the school supplies", "Ignore the school supplies", locate.setLocation("random", 0.0, 0.0, 0)));
		eventMap.put(8, new Events("You see a dog walking", "You ignore it", "You try to pet it", "Avoid the dog", "Stop and watch it walk by because its super cute", locate.setLocation("random", 0.0, 0.0, 0)));
		eventMap.put(9, new Events("You stepped in gum", "You try to scrape it off on the sidewalk", "You try to scrape it off with a pencil", "You ignore it", "You walk in the grass to try to get rid of it", locate.setLocation("random", 0.0, 0.0, 0)));
		eventMap.put(10, new Events("Goose Chase", "Run away from them", "Throw one bag item at them", "Calmly walk by them", "Feed them some food", locate.setLocation("random", 0.0, 0.0, 0)));
		return eventMap;
	}
}
