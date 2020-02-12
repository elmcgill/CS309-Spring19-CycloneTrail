package com.example.demo.user;

import javax.validation.constraints.NotEmpty;
import javax.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.core.style.ToStringCreator;
/**
 * The User Class is a model for the Application Cyclone Trail. The User is linked to an entry in the "user" table of
 * the cylconetrail database.
 * 
 * 
 * @author Ethan McGill
 *
 */
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private int id;
	
	@Column(name = "username")
	@NotFound(action = NotFoundAction.IGNORE)
	private String username;
	
	@Column(name = "password")
	@NotFound(action = NotFoundAction.IGNORE)
	private String password;
	
	@Column(name = "usertype")
	@NotFound(action = NotFoundAction.IGNORE)
	private String userType;
	
	/**
	 * Gets the users id
	 * 
	 * @return int id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the users id to the given integer
	 * 
	 * @param int id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the users username
	 * 
	 * @return String username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Set the users username to the given username
	 * 
	 * @param String username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Get the users password
	 * 
	 * @return String password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Set the users password to the given password
	 * 
	 * @param String password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Get the users userType 
	 * 
	 * @return String userType
	 */
	public String getUserType() {
		return userType;
	}
	
	/**
	 * Set the users userType to the given userType
	 * userTypes include: Regular, Admin, VIP
	 * 
	 * @param String userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	/**
	 * Gets the user object as a string
	 * 
	 * @return String userString
	 */
	@Override
	public String toString() {
		String userString;
		userString = "UserID: " + this.getId() + " UserName: " + this.getUsername() + " Password: " + this.getPassword() + " UserType: " + this.getUserType();
		return userString;
	}
	
}
