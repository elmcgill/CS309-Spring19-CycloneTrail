package com.example.demo.score;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * This is the controller for Score.  It has 3 get and 1 post method that 
 * act as APIs to interface with the front end.
 * 
 * @author Gabrielle Johnston
 *
 */
@RestController
public class ScoreController {
	
	@Autowired
	ScoreRespository scoreRepository;
	
	private final Logger logger = LoggerFactory.getLogger(ScoreController.class);
	
	/**
	 * A controller that gets all of the scores
	 * 
	 * @return A list of scores (List<Score>) 
	 */
	@GetMapping(path = "/score")
	public List<Score> getAllScores() {
		return scoreRepository.findAll();
	}
	
	/**
	 * Get a user id and returns the coresponding score
	 * 
	 * @param id - An int that is a userID
	 * @return A score is returned that has the same userID
	 */
	@GetMapping(path = "/score/{userId}")
	public Optional<Score> findScoreById(@PathVariable("userId") int id) {
        logger.info("Entered into Controller Layer");
        Optional<Score> results = scoreRepository.findById(id);
        return results;
    }
	
	/**
	 * This method gets all of the scores sorted by score.  Then, fills a list of 
	 * 10 scores to be returned in order.
	 * 
	 * @return A list of the top 10 scores, sorted by score (List<Score>)
	 */
	@GetMapping(value = "/score/sortedScores")
	public List<Score> getSortedScores() {
		List<Score> listScores = scoreRepository.findAll(new Sort("score").descending());
		List<Score> sorted = new ArrayList<Score>();
		
		if(listScores.size() < 10) {
			for(int i=0; i < listScores.size(); i++) {
				sorted.add(listScores.get(i));
			}
		}
		else {
			for(int i=0; i < 10; i++) {
				sorted.add(listScores.get(i));
			}
		}
		
		return sorted;
	}
	
	/**
	 * This method receives a new score and saves it in the database.
	 * 
	 * @param score - Gets a new score
	 * @return Will return the same score if stored properly
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/score/new")
    public Score saveOwner(@RequestBody Score score) {
       
		return scoreRepository.save(score);
    }
}
