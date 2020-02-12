package com.example.demo.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * User Repository is a interface that contains querries ran on the user table of the cyclone trail database
 * 
 * 
 * @author Ethan McGill
 *
 */
public interface UserRepository extends Repository<User, Integer>{
	
	/**
	 * Get all the user names from the database
	 * 
	 * @return List<String> allUsersNames
	 */
	@Query("SELECT username FROM User user")
	@Transactional(readOnly = true)
	List<String> getAllUserNames();
	
	/**
	 * Get all the users in the database
	 * 
	 * @return List<User? allUsers
	 */
	@Query("SELECT id, username, password, userType FROM User user")
	@Transactional(readOnly = true)
	List<User> getAllUsers();
	
	/**
	 * Insert a new user into the database with the given id, username, password, and userType
	 * 
	 * 
	 * @param int id
	 * @param String username
	 * @param String password
	 * @param String userType
	 */
	@Modifying
	@Query("INSERT INTO User (id,username,password,userType) SELECT DISTINCT :id, :username, :password, :userType from User user")
	@Transactional(readOnly = false)
	void save(int id, String username, String password, String userType);
	
	/**
	 * Check if a username exists in the database
	 * 
	 * @param String username
	 * @return String exists
	 */
	@Query("SELECT username FROM User user where username=:username")
	String userNameExists(@Param("username") String username);
	
	/**
	 * Gets the users password give the username
	 * 
	 * @param String username
	 * @return String password
	 */
	@Query("SELECT password FROM User user where username=:username")
	String getUserPassword(@Param("username") String username);
	
	/**
	 * Get a user from the database given their username
	 * 
	 * @param String username
	 * @return User user
	 */
	@Query("SELECT user FROM User user WHERE username=:username")
	User getUserByUsername(@Param("username") String username);

}