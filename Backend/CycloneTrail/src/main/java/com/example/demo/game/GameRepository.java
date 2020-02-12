package com.example.demo.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * GameRepository is a class that stores all of the current GameInstances of users that are currently playing the game.
 * 
 * @author Ethan McGill
 *
 */
public class GameRepository {
	
	HashMap<String, GameInstance> gameStorage = new HashMap<String,GameInstance>();
	
	/**
	 * Get the GameInstance of a given user by their username, the key should be the users username
	 * 
	 * @param String key
	 * @return GameInstance game
	 */
	public GameInstance getGameByName(String key) {
		return gameStorage.get(key);
	}
	
	/**
	 * Remove a GameInstance from the repository given the users username, the key should be the users username
	 * 
	 * @param String key
	 */
	public void removeGame(String key) {
		gameStorage.remove(key);
	}
	
	/**
	 * Add a new GameInstance to the repository, the key should be the users username for ease of accessing the GameInstance
	 * 
	 * @param String key
	 * @param GameInstance game
	 * @return GameInstance game
	 */
	public GameInstance addGame(String key, GameInstance game) {
		key = game.getUsername();
		gameStorage.put(key, game);
		return game;
	}
	
	/**
	 * Get a list of all of the currently active games stored in the repository
	 * 
	 * @return List<GameInstance> allGames
	 */
	public List<GameInstance> allGames() {
		List<GameInstance> results = new ArrayList<>();
		for(String key : gameStorage.keySet()) {
			results.add(gameStorage.get(key));
		}
		return results;
	}
	
	/**
	 * Update the given GameInstance in the repository
	 * 
	 * @param GameInstance game
	 */
	public void updateInstance(GameInstance game) {
		String key = game.getUsername();
		gameStorage.remove(key);
		gameStorage.put(key, game);
	}
}
