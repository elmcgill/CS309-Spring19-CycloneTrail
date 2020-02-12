package com.example.demo.score;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * This score class initializes a score table with the corestponding getter and setter methods
 * 
 * @author Gabrielle Johnston
 *
 */
@Entity
@Table(name = "score")
public class Score {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "autoID")
	private int autoID;
	
	@Column(name = "userID")
	@NotFound(action = NotFoundAction.IGNORE)
	private int id;
	
	@Column(name = "username")
	@NotFound(action = NotFoundAction.IGNORE)
	private String username;
	
	@Column(name = "score")
	@NotFound(action = NotFoundAction.IGNORE)
	private int score;

	/**
	 * A getter method to get Auto ID.
	 * 
	 * @return autoID as an int
	 */
	public int getAutoID() {
		return autoID;
	}
	/**
	 * A setter method to set auto id
	 * 
	 * @param id - the auto generated id
	 */
	public void setAutoID(Integer id) {
		this.autoID = autoID;
	}
	
	/**
	 * A getter method to get user id
	 * 
	 * @return a userID as and int
	 */
	public int getUserID() {
		return id;
	}
	
	/**
	 * A setter method to set the user id
	 * 
	 * @param id - A user id as an int
	 */
	public void setUserID(Integer id) {
		this.id = id;
	}
	
	/**
	 * A getter method to get the username
	 * 
	 * @return username as a String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * A setter method to set the username
	 * 
	 * @param username - A username as a String
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * A getter method to get a score
	 * 
	 * @return score as an int
	 */
	public int getScore() {
		return score;
	}

	/**
	 * A setter method to set the score
	 * 
	 * @param score - A score as an int
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * A method that overrides toString()
	 * 
	 * @return Displays all score information as a String
	 */
	@Override
	public String toString() {
		String scoreString;
		scoreString = "AutoID: "+this.getAutoID()+" UserID: "+this.getUserID() + " Username: " + this.getUsername() + " Score: " + this.getScore();
		return scoreString;
	}

}
