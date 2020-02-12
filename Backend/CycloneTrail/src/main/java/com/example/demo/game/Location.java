package com.example.demo.game;

import java.lang.reflect.Array;
import java.util.HashMap;

/**
 * A class to represent the locations on a map
 * 
 * @author Gabrielle Johnston
 *
 */
public class Location {
	
	private String title;
	private double latitude;
	private double longitude;
	private int status;
	
	private static final int NEXT = 0;
	private static final int TURN = 1;
	private static final int END = 2;
	
	public Location() {
		this.title = title;
		this.latitude = latitude;
		this.longitude = longitude;
		this.status = status;
	}
	
	public Location(String title, double latitude, double longitude, int status) {
		this.title = title;
		this.latitude = latitude;
		this.longitude = longitude;
		this.status = status;
	}
	
	/**
	 * Given all the parameters, make a new location
	 * 
	 * @param string - Represents the title
	 * @param i - Represents the latitude
	 * @param j - Represents the longitude
	 * @param k - Represents the status
	 * @return A new Location object
	 */
	public Location setLocation(String string, double i, double j, int k) {
		Location newLocation = new Location();
		newLocation.setTitle(string);
		newLocation.setLatitude(i);
		newLocation.setLongitude(j);
		newLocation.setStatus(k);
		return newLocation;
	}
	
	/**
	 * A getter that gets the title of a location
	 * 
	 * @return A string that describes the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * A setter that sets the title of a location
	 * 
	 * @param title - A string that describes the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * A getter that gets the latitude of a location
	 * 
	 * @return A double as a latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * A setter that sets the latitude of a location
	 * 
	 * @param latitude - A double value as latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * A getter that gets the longitude of a location
	 * 
	 * @return A double as a longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * A setter that sets the longitude of a location
	 * 
	 * @param longitude - A double value as longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * A getter that returns the status of a location of 0=next, 1=turn,
	 * or 2=finish
	 * 
	 * @return An int value that represents status
	 */
	public int getStatus() {
		return status;
	}
	
	/**
	 * A setter that sets the status of a location to 0=next, 1=turn,
	 * or 2=finish
	 * 
	 * @param status - An int value that represents status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	/**
	 * Makes a hashmap with a key of a string and with values of 
	 * Location[left, right, current]
	 * 
	 * @return A hashmap of all locations and options
	 */
	public HashMap<String, Location[]> makeHash() {
		HashMap<String, Location[]> locationHash = new HashMap<>();
		String putLoc = "";
		Location[] array;
		
		putLoc = "Friley Residence Hall";
		array =	new Location[] {setLocation("ISU Admissions", 42.025260, -93.649137, NEXT), setLocation("Lake LaVerne", 42.023934, -93.648902, NEXT), setLocation("Friley Residence Hall", 42.023975, -93.650423, NEXT)};
		locationHash.put("Friley Residence Hall", array);
		
		putLoc = "ISU Admissions";
		array = new Location[] {setLocation("Beardshear Hall", 42.026224, -93.648429, NEXT), setLocation("The Campanile", 42.025421, -93.646064, NEXT), setLocation("ISU Admissions", 42.025260, -93.649137, NEXT)};
		locationHash.put(putLoc, array);
		
		putLoc = "Beardshear Hall";
		array = new Location[] {setLocation("The Hub", 42.027435, -93.648452, NEXT), setLocation("Curtiss Hall", 42.026240, -93.644952, NEXT), setLocation("Beardshear Hall", 42.026224, -93.648429, NEXT)};
		locationHash.put(putLoc, array);
		
		putLoc = "The Hub";
		array = new Location[] {setLocation("LeBaron Hall", 42.027878, -93.647177, NEXT), setLocation("Jischke Honors Building", 42.027186, -93.644581, NEXT), setLocation("The Hub", 42.027435, -93.648452, NEXT)};
		locationHash.put(putLoc, array);
		
		putLoc = "LeBaron Hall";
		array = new Location[] {setLocation("MacKay Hall", 42.028511, -93.646515, NEXT), setLocation("Troxel Hall", 42.027856, -93.644009, END), setLocation("LeBaron Hall", 42.027878, -93.647177, NEXT)};
		locationHash.put(putLoc, array);
		
		putLoc = "MacKay Hall";
		array = new Location[] {setLocation("Kildee Hall", 42.029144, -93.644230, TURN), setLocation("Troxel Hall", 42.027856, -93.644009, END), setLocation("MacKay Hall", 42.028511, -93.646515, NEXT)};
		locationHash.put(putLoc, array);
		
		putLoc = "Kildee Hall";
		array = new Location[] {null, null, setLocation("Kildee Hall", 42.029144, -93.644230, TURN)};
		locationHash.put(putLoc, array);
		
		putLoc = "Troxel Hall";
		array = new Location[] {null, null, setLocation("Troxel Hall", 42.027856, -93.644009, END)};
		locationHash.put(putLoc, array);
		
		putLoc = "Jischke Honors Building";
		array = new Location[] {setLocation("Troxel Hall", 42.027856, -93.644009, END), setLocation("Troxel Hall", 42.027856, -93.644009, END), setLocation("Jischke Honors Building", 42.027186, -93.644581, NEXT)};
		locationHash.put(putLoc, array);
		
		putLoc = "Curtiss Hall";
		array = new Location[] {setLocation("Jischke Honors Building", 42.027186, -93.644581, NEXT), setLocation("East Hall", 42.026002, -93.643408, NEXT), setLocation("Curtiss Hall", 42.026240, -93.644952, NEXT)};
		locationHash.put(putLoc, array);
		
		putLoc = "East Hall";
		array = new Location[] {setLocation("Troxel Hall", 42.027856, -93.644009, END), setLocation("East Parking Deck", 42.025555, -93.642856, TURN), setLocation("East Hall", 42.026002, -93.643408, NEXT)};
		locationHash.put(putLoc, array);
		
		putLoc = "East Parking Deck";
		array = new Location[] {null, null, setLocation("East Parking Deck", 42.025555, -93.642856, TURN)};
		locationHash.put(putLoc, array);
		
		putLoc = "The Campanile";
		array = new Location[] {setLocation("Curtiss Hall", 42.026240, -93.644952, NEXT), setLocation("Gerdin Business Building", 42.025153, -93.644380, NEXT), setLocation("The Campanile", 42.025421, -93.646064, NEXT)};
		locationHash.put(putLoc, array);
		
		putLoc = "Gerdin Business Building";
		array = new Location[] {setLocation("Curtiss Hall", 42.026240, -93.644952, NEXT), setLocation("East Hall", 42.026002, -93.643408, NEXT), setLocation("Gerdin Business Building", 42.025153, -93.644380, NEXT)};
		locationHash.put(putLoc, array);
		
		putLoc = "Lake LaVerne";
		array = new Location[] {setLocation("The Campanile", 42.025421, -93.646064, NEXT), setLocation("The Memorial Union", 42.023816, -93.645945, NEXT), setLocation("Lake LaVerne", 42.023934, -93.648902, NEXT)};
		locationHash.put(putLoc, array);
		
		putLoc = "The Memorial Union";
		array = new Location[] {setLocation("Gerdin Business Building", 42.025153, -93.644380, NEXT), setLocation("Knoll", 42.023615, -93.643589, TURN), setLocation("The Memorial Union", 42.023816, -93.645945, NEXT)};
		locationHash.put(putLoc, array);
		
		putLoc = "Knoll";
		array = new Location[] {null, null, setLocation("Knoll", 42.023615, -93.643589, TURN)};
		locationHash.put(putLoc, array);
		
		return locationHash;
		
	}

	/**
	 * A method that overrides toString()
	 * 
	 * @return Displays all location information as a String
	 */
	@Override
	public String toString() {
		String locationString;
		locationString = "Title: " + this.getTitle() + " Latitude: " +
				this.getLatitude() + " Longitude: " + this.getLongitude();
		return locationString;
	}
	
}
