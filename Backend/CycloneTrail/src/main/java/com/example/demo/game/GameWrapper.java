package com.example.demo.game;

/**
 * GameWrapper is a utility class used in the GameController to send json objects containing multiple variables needed to be sent from the
 * front end
 * 
 * @author Ethan
 *
 */
public class GameWrapper {
	
	private String username;
	private String object;
	private int index;
	private int eventChoice;
	private String eventResult;
	
	/**
	 * Get the username variable from the GameWrapper
	 * 
	 * @return String username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Set the username of the GameWrapper to the given username
	 * 
	 * @param String username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Get the object variable from the GameWrapper
	 * 
	 * @return String object
	 */
	public String getObject() {
		return object;
	}
	
	/**
	 * Set the object variable of the GameWrapper to the given object
	 * 
	 * @param String object
	 */
	public void setObject(String object) {
		this.object = object;
	}
	
	/**
	 * Get the index variable from the GameWrapper
	 * 
	 * @return int index
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Set the index variable of the GameWrapper to the given index
	 * 
	 * @param int index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * Get the eventChoice variable from the GameWrapper
	 * 
	 * @return
	 */
	public int getEventChoice() {
		return eventChoice;
	}
	
	/**
	 * Set the the eventChoice variable of the GameWrapper to the given eventChoice
	 * 
	 * @param String eventChoice
	 */
	public void setEventChoice(int eventChoice) {
		this.eventChoice = eventChoice;
	}
	
	/**
	 * Get the eventResult variable from the GameWrapper
	 * 
	 * @return
	 */
	public String getEventResult() {
		return eventResult;
	}
	
	/**
	 * Set the eventResult variable of the GameWrapper to the given eventResult
	 * 
	 * @param String eventResult
	 */
	public void setEventResult(String eventResult) {
		this.eventResult = eventResult;
	}
	
}
