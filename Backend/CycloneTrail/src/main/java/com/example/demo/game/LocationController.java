package com.example.demo.game;

import com.example.demo.game.*;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.score.ScoreController;

@RestController
public class LocationController {
	
	private final Logger logger = LoggerFactory.getLogger(LocationController.class);
	GameRepository gameRepo = new GameRepository();

	// Lists all locations in the hashmap
	@RequestMapping(method = RequestMethod.POST, path = "/location")
	public HashMap<String, Location[]> getLocationHash(@RequestBody Location location) {
		return location.makeHash();
	}
	
	//Based on a location, returns left location
	@RequestMapping(method = RequestMethod.POST, path = "/location/left")
	public Location getLeft(@RequestBody Location location, @RequestParam("username") String username) {
		HashMap<String, Location[]> hash = location.makeHash();
		
		GameInstance game = gameRepo.getGameByName(username);
		game.setLocation(hash.get(location.getTitle())[0]);
		
		return hash.get(location.getTitle())[0];
	}
	
	
	//Based on a location, returns a right location
	@RequestMapping(method = RequestMethod.POST, path = "/location/right")
	public Location getRight(@RequestBody Location location, @RequestParam("username") String username) {
		HashMap<String, Location[]> hash = location.makeHash();
		
		GameInstance game = gameRepo.getGameByName(username);
		game.setLocation(hash.get(location.getTitle())[0]);
		
		return hash.get(location.getTitle())[1];
	}
	
	
	@RequestMapping(method = RequestMethod.POST, path = "/location/atLocation")
	public GameInstance setLocation(@RequestBody Location location, @RequestParam("username") String username) {
		GameInstance game = gameRepo.getGameByName(username);
		game.setLocation(location);
		
		return game;
	}
}
