package com.example.demo.score;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ScoreRespository extends JpaRepository<Score, Integer> {
//	@Query("SELECT DISTINCT username FROM Score score")
//	@Transactional(readOnly = true)
//	List<Score> getAllScores();

//	@Modifying
//	@Query(value = "insert into score (userID, username, score) values (:userID, :username, :score)", nativeQuery=true)
//	@Transactional(readOnly=false)
//	void addScore(@Param("userID") int userID, @Param("username") String username, @Param("score") int score);
	
	
//	@Query(value = "SELECT u FROM Score u")
//	List<Score> findAllScores(Sort sort);

}
