package com.example.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.game.*;
import com.example.demo.score.ScoreRespository;

public class LocationTest {
	
	@InjectMocks
	Location classMock;
	
	@Mock
	Location testL;
	
	@Mock
	GameController control;
	
	@Mock
	GameRepository gameRepo;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void setLocationTest() {

		when(testL.setLocation("Test Location", 20.2, 30.6, 0)).thenReturn(new Location("Test Location", 20.2, 30.6, 0));

		testL = testL.setLocation("Test Location", 20.2, 30.6, 0);
		
		assertEquals("Test Location", testL.getTitle());
		assertEquals(20.2, testL.getLatitude(), 0.00);
		assertEquals(30.6, testL.getLongitude(), 0.00);
		assertEquals(0, testL.getStatus());
	}
	
	@Test
	public void getLeftTest() {
		when(testL.setLocation("Test Location", 20.2, 30.6, 0)).thenReturn(new Location("Test Location", 20.2, 30.6, 0));
		testL.setLocation("Test Location", 20.2, 30.6, 0);
		
		HashMap<String, Location[]> locationHash = new HashMap<>();
		locationHash.put("OGPlace", new Location[] {classMock.setLocation("Left Location", 1.0, 2.0, 0), classMock.setLocation("RightLocation", 3.0, 4.0, 0), classMock.setLocation("CurrentLocation", 5.0, 6.0, 0)});
		Location begining = new Location("Friley Residence Hall", 42.023975, -93.650423, 0);
		
		when(testL.makeHash()).thenReturn(locationHash);
		HashMap<String, Location[]> hash = testL.makeHash();
		
		when(gameRepo.getGameByName("Riley")).thenReturn(new GameInstance("Riley", 10));
		GameInstance nGame = gameRepo.getGameByName("Riley");
		
		assertEquals("Left Location", hash.get("OGPlace")[0].getTitle());
		assertEquals(1.0, hash.get("OGPlace")[0].getLatitude(), 0.0);
		assertEquals(2.0, hash.get("OGPlace")[0].getLongitude(), 0.0);
		assertEquals(0, hash.get("OGPlace")[0].getStatus());

		assertEquals("Riley", nGame.getUsername());
		assertEquals(begining.getTitle(), nGame.getLocation().getTitle());
		assertEquals(begining.getLatitude(), nGame.getLocation().getLatitude(), 0.0);
		assertEquals(begining.getLongitude(), nGame.getLocation().getLongitude(), 0.0);
		assertEquals(begining.getStatus(), nGame.getLocation().getStatus());

	}
	
	@Test 
	public void getRightTest() {
		when(testL.setLocation("Test Location", 20.2, 30.6, 0)).thenReturn(new Location("Test Location", 20.2, 30.6, 0));
		testL.setLocation("Test Location", 20.2, 30.6, 0);
		
		HashMap<String, Location[]> locationHash = new HashMap<>();
		locationHash.put("OGPlace", new Location[] {classMock.setLocation("Left Location", 1.0, 2.0, 0), classMock.setLocation("RightLocation", 3.0, 4.0, 0)});
		Location begining = new Location("Friley Residence Hall", 42.023975, -93.650423, 0);
		
		when(testL.makeHash()).thenReturn(locationHash);
		HashMap<String, Location[]> hash = testL.makeHash();
		
		when(gameRepo.getGameByName("Riley")).thenReturn(new GameInstance("Riley", 10));
		GameInstance nGame = gameRepo.getGameByName("Riley");
		
		assertEquals("RightLocation", hash.get("OGPlace")[1].getTitle());
		assertEquals(3.0, hash.get("OGPlace")[1].getLatitude(), 0.0);
		assertEquals(4.0, hash.get("OGPlace")[1].getLongitude(), 0.0);
		assertEquals(0, hash.get("OGPlace")[1].getStatus());
		
		assertEquals("Riley", nGame.getUsername());
		assertEquals(begining.getTitle(), nGame.getLocation().getTitle());
		assertEquals(begining.getLatitude(), nGame.getLocation().getLatitude(), 0.0);
		assertEquals(begining.getLongitude(), nGame.getLocation().getLongitude(), 0.0);
		assertEquals(begining.getStatus(), nGame.getLocation().getStatus());

	}
	
	@Test
	public void getLeftControllerTest() {
		when(testL.setLocation("Test Location", 20.2, 30.6, 0)).thenReturn(new Location("Test Location", 20.2, 30.6, 0));
		testL.setLocation("Test Location", 20.2, 30.6, 0);
		
		HashMap<String, Location[]> locationHash = new HashMap<>();
		locationHash.put("OGPlace", new Location[] {classMock.setLocation("Left Location", 1.0, 2.0, 0), classMock.setLocation("RightLocation", 3.0, 4.0, 0), classMock.setLocation("CurrentLocation", 5.0, 6.0, 0)});
		Location begining = new Location("Friley Residence Hall", 42.023975, -93.650423, 0);
		
		when(testL.makeHash()).thenReturn(locationHash);
		HashMap<String, Location[]> hash = testL.makeHash();
		
		when(gameRepo.getGameByName("Riley")).thenReturn(new GameInstance("Riley", 10));
		GameInstance nGame = gameRepo.getGameByName("Riley");
		nGame.setLocation(begining);

		Location nLeft = new Location("Left Location", 1.0, 2.0, 0);
		when(control.getLeft(testL, "Riley")).thenReturn(nLeft);
		Location none = new Location("None", 0, 0, 0);
		nGame.setLocation(none);
		Location left = new Location();
		left = control.getLeft(testL, "Riley");
		
		assertEquals(none, gameRepo.getGameByName("Riley").getLocation());
		assertEquals(left, nLeft);
		


	}
	
}
