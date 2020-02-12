package com.example.demo.user;

/**
 * UserCreditials is a wrapper classed used in the UserController for the frontend to send a json object to the backend
 * 
 * 
 * @author Ethan McGill
 *
 */
public class UserCreditials {
	
	private String username;
	private String password;
	private int status;
	
	/**
	 * Get the username from the UserCreditials object
	 * 
	 * @return String username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Set the username of the UserCreditials object to the given username
	 * 
	 * @param String username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Get the password of the UserCreditials object
	 * 
	 * @return String password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Set the password of the UserCreditials object to the given password
	 * 
	 * @param String password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Get the status of the UserCredititals object
	 * 
	 * @return int status
	 */
	public int getStatus() {
		return status;
	}
	
	/**
	 * Set the status of the UserCreditials object to the given status
	 * 
	 * @param int status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
}
