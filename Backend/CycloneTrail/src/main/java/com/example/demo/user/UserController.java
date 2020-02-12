package com.example.demo.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.score.ScoreController;

/**
 * UserController is a Rest API Contoller for the front end of the application to use to get information about the Users stored in the
 * database
 * 
 * @author Ethan McGill
 *
 */
@RestController
@RequestMapping(path="/users")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * Gets a list of all the users in the database
	 * 
	 * 
	 * @return List<User> allUsers
	 */
	@GetMapping(value="/")
	public List<User> displayUserInfo(){
		return userRepo.getAllUsers();
	}
	
	/**
	 * Get a list of all the names of the users in the database
	 * 
	 * @return List<String> names
	 */
	@GetMapping(value="/names")
	public List<String> printUserNames(){
		return userRepo.getAllUserNames();
	}
	/**
	 * Inserts the user that was given into the database
	 * 
	 * @param User user
	 * @return User newUser
	 */
	@PostMapping(value="/new")
	public User createNewUser(@RequestBody User user) {
		if(userRepo.userNameExists(user.getUsername()) == null) {
			userRepo.save(user.getId(),user.getUsername(),user.getPassword(),user.getUserType());
			return userRepo.getUserByUsername(user.getUsername());
		} else {
			user.setUsername(null);
		}
		return user;
	}
	
	/**
	 * Finds the the user with the given username
	 * 
	 * @param String username
	 * @return "User Exists" of "User does not exist"
	 */
	@PostMapping(value="/findUsername")
	public String findUserName(@RequestBody String username) {

		if(userRepo.userNameExists(username) != null) {
			return "User Exists";
		}
		return "User does not exist";
	}
	/**
	 * Gets the users password give the users name
	 * 
	 * @param String username
	 * @return String password or "User does not exist"
	 */
	@PostMapping(value="/getUserPassword")
	public String getUserPassword(@RequestBody String username) {
		if(userRepo.userNameExists(username) != null) {
			return userRepo.getUserPassword(username);
		}
		return "User does not exist";
	}
	
	/**
	 * Verifies the given information is correct for the user given their username and password in the UserCrediatials object
	 * Sets UserCreditial.status to 0 if the login was successful, sets UserCreditial.status to 1 is the password was incorrect,
	 * sets UserCreditials.status to 2 if the username does not exist
	 * 
	 * @param UserCreditials user
	 * @return UserCreditials result
	 */
	@PostMapping(value="/attemptLogin")
	public UserCreditials loginAuth(@RequestBody UserCreditials user){
		
		UserCreditials result = new UserCreditials();
		if(userRepo.userNameExists(user.getUsername()) != null) {
			String pass = userRepo.getUserPassword(user.getUsername());
			//String user = userRepo.getUsername(username)
			if(pass.equals(user.getPassword()) ){
				result.setStatus(0);
				return result;
			}
			else {
				result.setStatus(1);
				return result;
			}
		}
		
		result.setStatus(2);
		return result;
	}
	
	/**
	 * Get the User object by the users username that was given
	 * 
	 * @param String username
	 * @return User user
	 */
	@PostMapping(value="/getUser")
	public User getUserByName(@RequestBody UserCreditials username) {
		logger.info("Got into the controller");
		return userRepo.getUserByUsername(username.getUsername());
	}

}

