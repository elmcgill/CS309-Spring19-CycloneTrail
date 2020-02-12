package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.game.BPObject;
import com.example.demo.game.Events;
import com.example.demo.game.GameController;
import com.example.demo.game.GameInstance;
import com.example.demo.game.GameWrapper;
import com.example.demo.game.Location;

public class EventsTest {
	
	
	@InjectMocks
	Events event;
	
	@InjectMocks
	Location location;
	
	@InjectMocks
	GameInstance instance;
	
	@InjectMocks
	GameWrapper gw;
	
	@Mock
	GameController control;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllEvents() {
		HashMap<String, Events> map = new HashMap<>();
		Location locate = new Location();
		location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		
		map.putAll(event.listEvents(event));
		
		when(control.getAllEvents()).thenReturn(map);
		assertEquals(map, control.getAllEvents());
	}
	
	@Test
	public void drawEventTestLakeLavern() {
		location = location.setLocation("Lake LaVerne", 42.023839, -93.647990, 0);
		event = new Events("", "", "","","", location);
		Events ev;
		ev= event.getEvent("Lake LaVerne");
		gw.setUsername("test");
		
		when(control.drawEvent(gw)).thenReturn(event.getEvent(event.getLocation().getTitle()));
		
		assertEquals(ev.getEventName() ,control.drawEvent(gw).getEventName());
		assertEquals(ev.getDialogOne() ,control.drawEvent(gw).getDialogOne());
		assertEquals(ev.getDialogTwo() ,control.drawEvent(gw).getDialogTwo());
		assertEquals(ev.getDialogThree() ,control.drawEvent(gw).getDialogThree());
		assertEquals(ev.getDialogFour() ,control.drawEvent(gw).getDialogFour());
		assertEquals(ev.getLocation().getTitle(), control.drawEvent(gw).getLocation().getTitle());
		assertEquals(ev.getLocation().getLatitude(), control.drawEvent(gw).getLocation().getLatitude(),0);
		assertEquals(ev.getLocation().getLongitude(), control.drawEvent(gw).getLocation().getLongitude(),0);
		assertEquals(ev.getLocation().getStatus(), control.drawEvent(gw).getLocation().getStatus());
	}
	
	@Test
	public void drawEventTestMemorialUnion() {
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events ev;
		ev= event.getEvent("The Memorial Union");
		gw.setUsername("test");
		
		when(control.drawEvent(gw)).thenReturn(event.getEvent(event.getLocation().getTitle()));
		
		assertEquals(ev.getEventName() ,control.drawEvent(gw).getEventName());
		assertEquals(ev.getDialogOne() ,control.drawEvent(gw).getDialogOne());
		assertEquals(ev.getDialogTwo() ,control.drawEvent(gw).getDialogTwo());
		assertEquals(ev.getDialogThree() ,control.drawEvent(gw).getDialogThree());
		assertEquals(ev.getDialogFour() ,control.drawEvent(gw).getDialogFour());
		assertEquals(ev.getLocation().getTitle(), control.drawEvent(gw).getLocation().getTitle());
		assertEquals(ev.getLocation().getLatitude(), control.drawEvent(gw).getLocation().getLatitude(),0);
		assertEquals(ev.getLocation().getLongitude(), control.drawEvent(gw).getLocation().getLongitude(),0);
		assertEquals(ev.getLocation().getStatus(), control.drawEvent(gw).getLocation().getStatus());
	}
	
	@Test
	public void drawEventTestCurtissHall() {
		location = location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0);
		event = new Events("", "", "","","", location);
		Events ev;
		ev= event.getEvent("Curtiss Hall");
		gw.setUsername("test");
		
		when(control.drawEvent(gw)).thenReturn(event.getEvent(event.getLocation().getTitle()));
		
		assertEquals(ev.getEventName() ,control.drawEvent(gw).getEventName());
		assertEquals(ev.getDialogOne() ,control.drawEvent(gw).getDialogOne());
		assertEquals(ev.getDialogTwo() ,control.drawEvent(gw).getDialogTwo());
		assertEquals(ev.getDialogThree() ,control.drawEvent(gw).getDialogThree());
		assertEquals(ev.getDialogFour() ,control.drawEvent(gw).getDialogFour());
		assertEquals(ev.getLocation().getTitle(), control.drawEvent(gw).getLocation().getTitle());
		assertEquals(ev.getLocation().getLatitude(), control.drawEvent(gw).getLocation().getLatitude(),0);
		assertEquals(ev.getLocation().getLongitude(), control.drawEvent(gw).getLocation().getLongitude(),0);
		assertEquals(ev.getLocation().getStatus(), control.drawEvent(gw).getLocation().getStatus());
	}
	
	@Test
	public void drawEventTestTheHub() {
		location = location.setLocation("The Hub", 42.027436, -93.648068, 0);
		event = new Events("", "", "","","", location);
		Events ev;
		ev= event.getEvent("The Hub");
		gw.setUsername("test");
		
		when(control.drawEvent(gw)).thenReturn(event.getEvent(event.getLocation().getTitle()));
		
		assertEquals(ev.getEventName() ,control.drawEvent(gw).getEventName());
		assertEquals(ev.getDialogOne() ,control.drawEvent(gw).getDialogOne());
		assertEquals(ev.getDialogTwo() ,control.drawEvent(gw).getDialogTwo());
		assertEquals(ev.getDialogThree() ,control.drawEvent(gw).getDialogThree());
		assertEquals(ev.getDialogFour() ,control.drawEvent(gw).getDialogFour());
		assertEquals(ev.getLocation().getTitle(), control.drawEvent(gw).getLocation().getTitle());
		assertEquals(ev.getLocation().getLatitude(), control.drawEvent(gw).getLocation().getLatitude(),0);
		assertEquals(ev.getLocation().getLongitude(), control.drawEvent(gw).getLocation().getLongitude(),0);
		assertEquals(ev.getLocation().getStatus(), control.drawEvent(gw).getLocation().getStatus());
	}
	
	@Test
	public void drawEventTestCampanile() {
		location = location.setLocation("The Campanile", 42.025421, -93.646064, 0);
		event = new Events("", "", "","","", location);
		Events ev;
		ev= event.getEvent("The Campanile");
		gw.setUsername("test");
		
		when(control.drawEvent(gw)).thenReturn(event.getEvent(event.getLocation().getTitle()));
		
		assertEquals(ev.getEventName() ,control.drawEvent(gw).getEventName());
		assertEquals(ev.getDialogOne() ,control.drawEvent(gw).getDialogOne());
		assertEquals(ev.getDialogTwo() ,control.drawEvent(gw).getDialogTwo());
		assertEquals(ev.getDialogThree() ,control.drawEvent(gw).getDialogThree());
		assertEquals(ev.getDialogFour() ,control.drawEvent(gw).getDialogFour());
		assertEquals(ev.getLocation().getTitle(), control.drawEvent(gw).getLocation().getTitle());
		assertEquals(ev.getLocation().getLatitude(), control.drawEvent(gw).getLocation().getLatitude(),0);
		assertEquals(ev.getLocation().getLongitude(), control.drawEvent(gw).getLocation().getLongitude(),0);
		assertEquals(ev.getLocation().getStatus(), control.drawEvent(gw).getLocation().getStatus());
	}
	
	@Test
	public void drawEventTestISUAdmissions() {
		location = location.setLocation("ISU Admissions", 42.025260, -93.649137, 0);
		event = new Events("", "", "","","", location);
		Events ev;
		ev= event.getEvent("ISU Admissions");
		gw.setUsername("test");
		
		when(control.drawEvent(gw)).thenReturn(event.getEvent(event.getLocation().getTitle()));
		
		assertEquals(ev.getEventName() ,control.drawEvent(gw).getEventName());
		assertEquals(ev.getDialogOne() ,control.drawEvent(gw).getDialogOne());
		assertEquals(ev.getDialogTwo() ,control.drawEvent(gw).getDialogTwo());
		assertEquals(ev.getDialogThree() ,control.drawEvent(gw).getDialogThree());
		assertEquals(ev.getDialogFour() ,control.drawEvent(gw).getDialogFour());
		assertEquals(ev.getLocation().getTitle(), control.drawEvent(gw).getLocation().getTitle());
		assertEquals(ev.getLocation().getLatitude(), control.drawEvent(gw).getLocation().getLatitude(),0);
		assertEquals(ev.getLocation().getLongitude(), control.drawEvent(gw).getLocation().getLongitude(),0);
		assertEquals(ev.getLocation().getStatus(), control.drawEvent(gw).getLocation().getStatus());
	}
	
	@Test
	public void drawEventTestBeardshearHall() {
		location = location.setLocation("Beardshear Hall", 42.026224, -93.648429, 0);
		event = new Events("", "", "","","", location);
		Events ev;
		ev= event.getEvent("Beardshear Hall");
		gw.setUsername("test");
		
		when(control.drawEvent(gw)).thenReturn(event.getEvent(event.getLocation().getTitle()));
		
		assertEquals(ev.getEventName() ,control.drawEvent(gw).getEventName());
		assertEquals(ev.getDialogOne() ,control.drawEvent(gw).getDialogOne());
		assertEquals(ev.getDialogTwo() ,control.drawEvent(gw).getDialogTwo());
		assertEquals(ev.getDialogThree() ,control.drawEvent(gw).getDialogThree());
		assertEquals(ev.getDialogFour() ,control.drawEvent(gw).getDialogFour());
		assertEquals(ev.getLocation().getTitle(), control.drawEvent(gw).getLocation().getTitle());
		assertEquals(ev.getLocation().getLatitude(), control.drawEvent(gw).getLocation().getLatitude(),0);
		assertEquals(ev.getLocation().getLongitude(), control.drawEvent(gw).getLocation().getLongitude(),0);
		assertEquals(ev.getLocation().getStatus(), control.drawEvent(gw).getLocation().getStatus());
	}
	
	@Test
	public void drawEventTestLeBaronHall() {
		location = location.setLocation("LeBaron Hall", 42.027878, -93.647177, 0);
		event = new Events("", "", "","","", location);
		Events ev;
		ev= event.getEvent("LeBaron Hall");
		gw.setUsername("test");
		
		when(control.drawEvent(gw)).thenReturn(event.getEvent(event.getLocation().getTitle()));
		
		assertEquals(ev.getEventName() ,control.drawEvent(gw).getEventName());
		assertEquals(ev.getDialogOne() ,control.drawEvent(gw).getDialogOne());
		assertEquals(ev.getDialogTwo() ,control.drawEvent(gw).getDialogTwo());
		assertEquals(ev.getDialogThree() ,control.drawEvent(gw).getDialogThree());
		assertEquals(ev.getDialogFour() ,control.drawEvent(gw).getDialogFour());
		assertEquals(ev.getLocation().getTitle(), control.drawEvent(gw).getLocation().getTitle());
		assertEquals(ev.getLocation().getLatitude(), control.drawEvent(gw).getLocation().getLatitude(),0);
		assertEquals(ev.getLocation().getLongitude(), control.drawEvent(gw).getLocation().getLongitude(),0);
		assertEquals(ev.getLocation().getStatus(), control.drawEvent(gw).getLocation().getStatus());
	}
	
	@Test
	public void drawEventTestMacKay() {
		location = location.setLocation("MacKay Hall", 42.028511, -93.646515, 0);
		event = new Events("", "", "","","", location);
		Events ev;
		ev= event.getEvent("MacKay Hall");
		gw.setUsername("test");
		
		when(control.drawEvent(gw)).thenReturn(event.getEvent(event.getLocation().getTitle()));
		
		assertEquals(ev.getEventName() ,control.drawEvent(gw).getEventName());
		assertEquals(ev.getDialogOne() ,control.drawEvent(gw).getDialogOne());
		assertEquals(ev.getDialogTwo() ,control.drawEvent(gw).getDialogTwo());
		assertEquals(ev.getDialogThree() ,control.drawEvent(gw).getDialogThree());
		assertEquals(ev.getDialogFour() ,control.drawEvent(gw).getDialogFour());
		assertEquals(ev.getLocation().getTitle(), control.drawEvent(gw).getLocation().getTitle());
		assertEquals(ev.getLocation().getLatitude(), control.drawEvent(gw).getLocation().getLatitude(),0);
		assertEquals(ev.getLocation().getLongitude(), control.drawEvent(gw).getLocation().getLongitude(),0);
		assertEquals(ev.getLocation().getStatus(), control.drawEvent(gw).getLocation().getStatus());
	}
	
	@Test
	public void drawEventTestKildeeHall() {
		location = location.setLocation("Kildee Hall", 42.029144, -93.644230, 1);
		event = new Events("", "", "","","", location);
		Events ev;
		ev= event.getEvent("Kildee Hall");
		gw.setUsername("test");
		
		when(control.drawEvent(gw)).thenReturn(event.getEvent(event.getLocation().getTitle()));
		
		assertEquals(ev.getEventName() ,control.drawEvent(gw).getEventName());
		assertEquals(ev.getDialogOne() ,control.drawEvent(gw).getDialogOne());
		assertEquals(ev.getDialogTwo() ,control.drawEvent(gw).getDialogTwo());
		assertEquals(ev.getDialogThree() ,control.drawEvent(gw).getDialogThree());
		assertEquals(ev.getDialogFour() ,control.drawEvent(gw).getDialogFour());
		assertEquals(ev.getLocation().getTitle(), control.drawEvent(gw).getLocation().getTitle());
		assertEquals(ev.getLocation().getLatitude(), control.drawEvent(gw).getLocation().getLatitude(),0);
		assertEquals(ev.getLocation().getLongitude(), control.drawEvent(gw).getLocation().getLongitude(),0);
		assertEquals(ev.getLocation().getStatus(), control.drawEvent(gw).getLocation().getStatus());
	}
	
	@Test
	public void drawEventTestJischkeHonorsBuilding() {
		location = location.setLocation("Jischke Honors Building", 42.027186, -93.644581, 0);
		event = new Events("", "", "","","", location);
		Events ev;
		ev= event.getEvent("Jischke Honors Building");
		gw.setUsername("test");
		
		when(control.drawEvent(gw)).thenReturn(event.getEvent(event.getLocation().getTitle()));
		
		assertEquals(ev.getEventName() ,control.drawEvent(gw).getEventName());
		assertEquals(ev.getDialogOne() ,control.drawEvent(gw).getDialogOne());
		assertEquals(ev.getDialogTwo() ,control.drawEvent(gw).getDialogTwo());
		assertEquals(ev.getDialogThree() ,control.drawEvent(gw).getDialogThree());
		assertEquals(ev.getDialogFour() ,control.drawEvent(gw).getDialogFour());
		assertEquals(ev.getLocation().getTitle(), control.drawEvent(gw).getLocation().getTitle());
		assertEquals(ev.getLocation().getLatitude(), control.drawEvent(gw).getLocation().getLatitude(),0);
		assertEquals(ev.getLocation().getLongitude(), control.drawEvent(gw).getLocation().getLongitude(),0);
		assertEquals(ev.getLocation().getStatus(), control.drawEvent(gw).getLocation().getStatus());
	}
	
	@Test
	public void drawEventTestEastHall() {
		location = location.setLocation("East Hall", 42.026002, -93.643408, 0);
		event = new Events("", "", "","","", location);
		Events ev;
		ev= event.getEvent("East Hall");
		gw.setUsername("test");
		
		when(control.drawEvent(gw)).thenReturn(event.getEvent(event.getLocation().getTitle()));
		
		assertEquals(ev.getEventName() ,control.drawEvent(gw).getEventName());
		assertEquals(ev.getDialogOne() ,control.drawEvent(gw).getDialogOne());
		assertEquals(ev.getDialogTwo() ,control.drawEvent(gw).getDialogTwo());
		assertEquals(ev.getDialogThree() ,control.drawEvent(gw).getDialogThree());
		assertEquals(ev.getDialogFour() ,control.drawEvent(gw).getDialogFour());
		assertEquals(ev.getLocation().getTitle(), control.drawEvent(gw).getLocation().getTitle());
		assertEquals(ev.getLocation().getLatitude(), control.drawEvent(gw).getLocation().getLatitude(),0);
		assertEquals(ev.getLocation().getLongitude(), control.drawEvent(gw).getLocation().getLongitude(),0);
		assertEquals(ev.getLocation().getStatus(), control.drawEvent(gw).getLocation().getStatus());
	}
	
	@Test
	public void drawEventTestEastParkingDeck() {
		location = location.setLocation("East Parking Deck", 42.025555, -93.642856, 1);
		event = new Events("", "", "","","", location);
		Events ev;
		ev= event.getEvent("East Parking Deck");
		gw.setUsername("test");
		
		when(control.drawEvent(gw)).thenReturn(event.getEvent(event.getLocation().getTitle()));
		
		assertEquals(ev.getEventName() ,control.drawEvent(gw).getEventName());
		assertEquals(ev.getDialogOne() ,control.drawEvent(gw).getDialogOne());
		assertEquals(ev.getDialogTwo() ,control.drawEvent(gw).getDialogTwo());
		assertEquals(ev.getDialogThree() ,control.drawEvent(gw).getDialogThree());
		assertEquals(ev.getDialogFour() ,control.drawEvent(gw).getDialogFour());
		assertEquals(ev.getLocation().getTitle(), control.drawEvent(gw).getLocation().getTitle());
		assertEquals(ev.getLocation().getLatitude(), control.drawEvent(gw).getLocation().getLatitude(),0);
		assertEquals(ev.getLocation().getLongitude(), control.drawEvent(gw).getLocation().getLongitude(),0);
		assertEquals(ev.getLocation().getStatus(), control.drawEvent(gw).getLocation().getStatus());
	}
	
	@Test
	public void drawEventTestGerdinBusinessBuilding() {
		location = location.setLocation("Gerdin Business Building", 42.025153, -93.644380, 0);
		event = new Events("", "", "","","", location);
		Events ev;
		ev= event.getEvent("Gerdin Business Building");
		gw.setUsername("test");
		
		when(control.drawEvent(gw)).thenReturn(event.getEvent(event.getLocation().getTitle()));
		
		assertEquals(ev.getEventName() ,control.drawEvent(gw).getEventName());
		assertEquals(ev.getDialogOne() ,control.drawEvent(gw).getDialogOne());
		assertEquals(ev.getDialogTwo() ,control.drawEvent(gw).getDialogTwo());
		assertEquals(ev.getDialogThree() ,control.drawEvent(gw).getDialogThree());
		assertEquals(ev.getDialogFour() ,control.drawEvent(gw).getDialogFour());
		assertEquals(ev.getLocation().getTitle(), control.drawEvent(gw).getLocation().getTitle());
		assertEquals(ev.getLocation().getLatitude(), control.drawEvent(gw).getLocation().getLatitude(),0);
		assertEquals(ev.getLocation().getLongitude(), control.drawEvent(gw).getLocation().getLongitude(),0);
		assertEquals(ev.getLocation().getStatus(), control.drawEvent(gw).getLocation().getStatus());
	}
	
	@Test
	public void drawEventTestKnoll() {
		location = location.setLocation("Knoll", 42.023615, -93.643589, 1);
		event = new Events("", "", "","","", location);
		Events ev;
		ev= event.getEvent("Knoll");
		gw.setUsername("test");
		
		when(control.drawEvent(gw)).thenReturn(event.getEvent(event.getLocation().getTitle()));
		
		assertEquals(ev.getEventName() ,control.drawEvent(gw).getEventName());
		assertEquals(ev.getDialogOne() ,control.drawEvent(gw).getDialogOne());
		assertEquals(ev.getDialogTwo() ,control.drawEvent(gw).getDialogTwo());
		assertEquals(ev.getDialogThree() ,control.drawEvent(gw).getDialogThree());
		assertEquals(ev.getDialogFour() ,control.drawEvent(gw).getDialogFour());
		assertEquals(ev.getLocation().getTitle(), control.drawEvent(gw).getLocation().getTitle());
		assertEquals(ev.getLocation().getLatitude(), control.drawEvent(gw).getLocation().getLatitude(),0);
		assertEquals(ev.getLocation().getLongitude(), control.drawEvent(gw).getLocation().getLongitude(),0);
		assertEquals(ev.getLocation().getStatus(), control.drawEvent(gw).getLocation().getStatus());
	}
	
	@Test
	public void testGetReultsLakeLaVerneFullBackpackChoiceOne() {
		
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("Lake LaVerne", 42.023839, -93.647990, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Lake LaVerne");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*10")|| control.getResults(gw).getEventResult().equals("S,none,-1,0,-10")||control.getResults(gw).getEventResult().equals("S,none,-2,0,-10")||control.getResults(gw).getEventResult().equals("S,none,-3,0,-10") || control.getResults(gw).getEventResult().equals("S,none,-0,0,-10"));
	}
	
	@Test
	public void testGetReultsLakeLaVerneThreeBackpackItemsChoiceOne() {
		
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("Lake LaVerne", 42.023839, -93.647990, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Lake LaVerne");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*10")|| control.getResults(gw).getEventResult().equals("S,none,-1,0,-10")||control.getResults(gw).getEventResult().equals("S,none,-2,0,-10")||control.getResults(gw).getEventResult().equals("S,none,-3,0,-10") || control.getResults(gw).getEventResult().equals("S,none,-0,0,-10"));
	}
	
	@Test
	public void testGetReultsLakeLaVerneTwoBackpackItemsChoiceOne() {
		
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("Lake LaVerne", 42.023839, -93.647990, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Lake LaVerne");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		//System.out.println(instance.getBackpack().length());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*10")|| control.getResults(gw).getEventResult().equals("S,none,-1,0,-10")||control.getResults(gw).getEventResult().equals("S,none,-2,0,-10")||control.getResults(gw).getEventResult().equals("S,none,-0,0,-10"));
	}
	
	@Test
	public void testGetReultsLakeLaVerneOneBackpackItemChoiceOne() {
		
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("Lake LaVerne", 42.023839, -93.647990, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Lake LaVerne");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*10")|| control.getResults(gw).getEventResult().equals("S,none,-1,0,-10")||control.getResults(gw).getEventResult().equals("S,none,-0,0,-10"));
	}
	
	@Test
	public void testGetReultsLakeLaVerneEmptyBackpackChoiceOne() {
		
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Lake LaVerne", 42.023839, -93.647990, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Lake LaVerne");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*10")||control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsLakeLeVerneFullBackpackChoiceTwo() {
		
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("Lake LaVerne", 42.023839, -93.647990, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Lake LaVerne");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,-1,0,*15")|| control.getResults(gw).getEventResult().equals("S,none,-1,0,-20"));
	}
	
	@Test
	public void testGetResultsLakeLeVerneOneBackpackItemChoiceTwo() {
		
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("Lake LaVerne", 42.023839, -93.647990, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Lake LaVerne");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,-1,0,*15")|| control.getResults(gw).getEventResult().equals("S,none,-1,0,-20"));
	}
	
	@Test
	public void testGetResultsLakeLeVerneEmptyBackpackChoiceTwo() {
		
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Lake LaVerne", 42.023839, -93.647990, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Lake LaVerne");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsLakeLeVerneChoiceThree() {
		
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Lake LaVerne", 42.023839, -93.647990, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Lake LaVerne");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-5"));
	}
	
	@Test
	public void testGetResultsLakeLeVerneMoreThanThreeFoodObjectsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("Lake LaVerne", 42.023839, -93.647990, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Lake LaVerne");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,-3,0,-10") || control.getResults(gw).getEventResult().equals("S,food,-2,0,-10") || control.getResults(gw).getEventResult().equals("S,food,-1,0,-10") || control.getResults(gw).getEventResult().equals("S,food,-0,0,-10"));
	}
	
	@Test
	public void testGetResultsLakeLeVerneThreeFoodItemsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("Lake LaVerne", 42.023839, -93.647990, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Lake LaVerne");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,-3,0,-10") || control.getResults(gw).getEventResult().equals("S,food,-2,0,-10") || control.getResults(gw).getEventResult().equals("S,food,-1,0,-10") || control.getResults(gw).getEventResult().equals("S,food,-0,0,-10"));
	}
	
	@Test
	public void testGetResultsLakeLeVerneTwoFoodItemsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("Lake LaVerne", 42.023839, -93.647990, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Lake LaVerne");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,-2,0,-10") || control.getResults(gw).getEventResult().equals("S,food,-1,0,-10") || control.getResults(gw).getEventResult().equals("S,food,-0,0,-10"));
	}
	
	@Test
	public void testGetResultsLakeLeVerneOneFoodItemsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("Lake LaVerne", 42.023839, -93.647990, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Lake LaVerne");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,-1,0,-10") || control.getResults(gw).getEventResult().equals("S,food,-0,0,-10"));
	}
	
	@Test
	public void testGetResultsLakeLeVerneNoFoodItemsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("Lake LaVerne", 42.023839, -93.647990, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Lake LaVerne");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionFreeBackpackSpacePlentyOfMoneyChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(10.0);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,-2,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionFreeBackpackSpaceTwoDollarsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(2.0);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,-2,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionOneBackpackSpaceTwoDollarsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(2.0);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,-2,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionNoBackpackSpaceTwoDollarsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(2.0);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionBackpackSpaceNoDollarsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(0.0);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionFreeBackpackSpacePlentyOfMoneyChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(10.0);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,water,*1,-1,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionFreeBackpackSpaceOneDollarsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(1.0);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,water,*1,-1,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionOneBackpackSpaceOneDollarsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(1.0);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,water,*1,-1,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionNoBackpackSpaceOneDollarsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(1.0);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionBackpackSpaceNoDollarsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(0.0);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionFreeBackpackSpacePlentyOfMoneyChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(10.0);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,*1,-2,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionFreeBackpackSpaceTwoDollarsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(2.0);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,*1,-2,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionOneBackpackSpaceTwoDollarsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(2.0);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,*1,-2,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionNoBackpackSpaceTwoDollarsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(2.0);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionBackpackSpaceNoDollarsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(0.0);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsMemorialUnionChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("The Memorial Union", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Memorial Union");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*1,-10") || control.getResults(gw).getEventResult().equals("S,none,0,*.5,-10") || control.getResults(gw).getEventResult().equals("S,none,0,*.25,-10") || control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsCurtissHallFreeBackpackSpacePlentyOfMoneyChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(10.0);
		
		location = location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Curtiss Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,*1,-2,0"));
	}
	
	@Test
	public void testGetResultsCurtissHallFreeBackpackSpaceTwoDollarsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(2.0);
		
		location = location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Curtiss Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,*1,-2,0"));
	}
	
	@Test
	public void testGetResultsCurtissHallOneBackpackSpaceTwoDollarsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(2.0);
		
		location = location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Curtiss Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,*1,-2,0"));
	}
	
	@Test
	public void testGetResultsCurtissHallNoBackpackSpaceTwoDollarsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(2.0);
		
		location = location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Curtiss Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsCurtissHallBackpackSpaceNoDollarsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(0.0);
		
		location = location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Curtiss Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsCurtissHallFreeBackpackSpacePlentyOfMoneyChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(10.0);
		
		location = location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Curtiss Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,water,*1,-1,0"));
	}
	
	@Test
	public void testGetResultsCurtissHallFreeBackpackSpaceOneDollarsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(1.0);
		
		location = location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Curtiss Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,water,*1,-1,0"));
	}
	
	@Test
	public void testGetResultsCurtissHallOneBackpackSpaceOneDollarsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(1.0);
		
		location = location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Curtiss Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,water,*1,-1,0"));
	}
	
	@Test
	public void testGetResultsCurtissHallNoBackpackSpaceOneDollarsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(1.0);
		
		location = location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Curtiss Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsCurtissHallBackpackSpaceNoDollarsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(0.0);
		
		location = location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Curtiss Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsCurtissHallChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Curtiss Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*1,-10") || control.getResults(gw).getEventResult().equals("S,none,0,*.5,-10") || control.getResults(gw).getEventResult().equals("S,none,0,*.25,-10") || control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsCurtissHallPlentyOfRoomInBackpackChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Curtiss Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,0,-10") || control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsCurtissHallOneBackpackSlotChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Curtiss Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,0,-10") || control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsCurtissHallNoBackpackSlotChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("Curtiss Hall", 42.026240, -93.644952, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Curtiss Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsTheHubFreeBackpackSpacePlentyOfMoneyChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(10.0);
		
		location = location.setLocation("The Hub", 42.027436, -93.648068, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Hub");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,*1,-2,0"));
	}
	
	@Test
	public void testGetResultsTheHubFreeBackpackSpaceTwoDollarsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(2.0);
		
		location = location.setLocation("The Hub", 42.027436, -93.648068, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Hub");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,*1,-2,0"));
	}
	
	@Test
	public void testGetResultsTheHubOneBackpackSpaceTwoDollarsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(2.0);
		
		location = location.setLocation("The Hub", 42.027436, -93.648068, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Hub");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,*1,-2,0"));
	}
	
	@Test
	public void testGetResultsTheHubNoBackpackSpaceTwoDollarsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(2.0);
		
		location = location.setLocation("The Hub", 42.027436, -93.648068, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Hub");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsTheHubBackpackSpaceNoDollarsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(0.0);
		
		location = location.setLocation("The Hub", 42.027436, -93.648068, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Hub");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsTheHubFreeBackpackSpacePlentyOfMoneyChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(10.0);
		
		location = location.setLocation("The Hub", 42.027436, -93.648068, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Hub");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,water,*1,-1,0"));
	}
	
	@Test
	public void testGetResultsTheHubFreeBackpackSpaceOneDollarsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(1.0);
		
		location = location.setLocation("The Hub", 42.027436, -93.648068, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Hub");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,water,*1,-1,0"));
	}
	
	@Test
	public void testGetResultsTheHubOneBackpackSpaceOneDollarsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(1.0);
		
		location = location.setLocation("The Hub", 42.027436, -93.648068, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Hub");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,water,*1,-1,0"));
	}
	
	@Test
	public void testGetResultsTheHubNoBackpackSpaceOneDollarsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(1.0);
		
		location = location.setLocation("The Hub", 42.027436, -93.648068, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Hub");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsTheHubBackpackSpaceNoDollarsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(0.0);
		
		location = location.setLocation("The Hub", 42.027436, -93.648068, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Hub");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsTheHubChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("The Hub", 42.027436, -93.648068, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Hub");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*1,-10") || control.getResults(gw).getEventResult().equals("S,none,0,*.5,-10") || control.getResults(gw).getEventResult().equals("S,none,0,*.25,-10") || control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsTheHubPlentyOfRoomInBackpackChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("The Hub", 42.027436, -93.648068, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Hub");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,0,-10") || control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsTheHubOneBackpackSlotChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("The Hub", 42.027436, -93.648068, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Hub");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,0,-10") || control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsTheHubNoBackpackSlotChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("The Hub", 42.027436, -93.648068, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Hub");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsCampanileChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("The Campanile", 42.025421, -93.646064, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Campanile");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsCampanileChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("The Campanile", 42.025421, -93.646064, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Campanile");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*20") || control.getResults(gw).getEventResult().equals("S,none,0,0,-15"));
	}
	
	@Test
	public void testGetResultsCampanileChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("The Campanile", 42.025421, -93.646064, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Campanile");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*10") || control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsCampanileChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("The Campanile", 42.025421, -93.646064, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("The Campanile");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*5") || control.getResults(gw).getEventResult().equals("S,none,0,0,-15"));
	}
	
	@Test
	public void testGetResultsISUAdmissionsOneBackpackSlotChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("ISU Admissions", 42.025260, -93.649137, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("ISU Admissions");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(results);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,0,-10") || control.getResults(gw).getEventResult().equals("S,supplies,*0,0,-10"));
	}
	
	@Test
	public void testGetResultsISUAdmissionsPlentyBackpackSlotsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("ISU Admissions", 42.025260, -93.649137, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("ISU Admissions");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(results);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,0,-10") || control.getResults(gw).getEventResult().equals("S,supplies,*0,0,-10"));
	}
	
	@Test
	public void testGetResultsISUAdmissionsNoBackpackSlotsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("ISU Admissions", 42.025260, -93.649137, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("ISU Admissions");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(results);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsISUAdmissionsTwoBackpackSlotsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("ISU Admissions", 42.025260, -93.649137, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("ISU Admissions");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(results);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,0,-20") || control.getResults(gw).getEventResult().equals("S,supplies,*0,0,-20") || control.getResults(gw).getEventResult().equals("S,supplies,*2,0,-20"));
	}
	
	@Test
	public void testGetResultsISUAdmissionsPlentyBackpackSlotsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("ISU Admissions", 42.025260, -93.649137, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("ISU Admissions");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(results);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,0,-20") || control.getResults(gw).getEventResult().equals("S,supplies,*0,0,-20") || control.getResults(gw).getEventResult().equals("S,supplies,*2,0,-20"));
	}
	
	@Test
	public void testGetResultsISUAdmissionsOneBackpackSlotsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("ISU Admissions", 42.025260, -93.649137, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("ISU Admissions");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(results);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsISUAdmissionsNoBackpackSlotsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("ISU Admissions", 42.025260, -93.649137, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("ISU Admissions");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(results);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsISUAdmissionsThreeBackpackSlotsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("ISU Admissions", 42.025260, -93.649137, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("ISU Admissions");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(results);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,0,-30") || control.getResults(gw).getEventResult().equals("S,supplies,*0,0,-30") || control.getResults(gw).getEventResult().equals("S,supplies,*2,0,-30") || control.getResults(gw).getEventResult().equals("S,supplies,*3,0,-30"));
	}
	
	@Test
	public void testGetResultsISUAdmissionsPlentyBackpackSlotsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("ISU Admissions", 42.025260, -93.649137, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("ISU Admissions");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(results);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,0,-30") || control.getResults(gw).getEventResult().equals("S,supplies,*0,0,-30") || control.getResults(gw).getEventResult().equals("S,supplies,*2,0,-30") || control.getResults(gw).getEventResult().equals("S,supplies,*3,0,-30"));
	}
	
	@Test
	public void testGetResultsISUAdmissionsTwoBackpackSlotsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("ISU Admissions", 42.025260, -93.649137, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("ISU Admissions");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(results);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsISUAdmissionsNoBackpackSlotsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("ISU Admissions", 42.025260, -93.649137, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("ISU Admissions");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(results);
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsISUAdmissionsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("ISU Admissions", 42.025260, -93.649137, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("ISU Admissions");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10") || control.getResults(gw).getEventResult().equals("S,none,0,0,-15"));
	}
	
	@Test
	public void testGetResultsBeardshearHallPlentyOfMoneyChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.setMoney(10.0);
		
		location = location.setLocation("Beardshear Hall", 42.026224, -93.648429, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Beardshear Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,-2,0"));
	}
	
	@Test
	public void testGetResultsBeardshearHall2DollarsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.setMoney(2.0);
		
		location = location.setLocation("Beardshear Hall", 42.026224, -93.648429, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Beardshear Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,-2,0"));
	}
	
	@Test
	public void testGetResultsBeardshearHall1DollarChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.setMoney(1.0);
		
		location = location.setLocation("Beardshear Hall", 42.026224, -93.648429, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Beardshear Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsBeardshearHallNoMoneyChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.setMoney(0.0);
		
		location = location.setLocation("Beardshear Hall", 42.026224, -93.648429, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Beardshear Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsBeardshearHallChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Beardshear Hall", 42.026224, -93.648429, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Beardshear Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	
	@Test
	public void testGetResultsBeardshearHallChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Beardshear Hall", 42.026224, -93.648429, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Beardshear Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,0") || control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsBeardshearHallChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Beardshear Hall", 42.026224, -93.648429, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Beardshear Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*1,-10") || control.getResults(gw).getEventResult().equals("S,none,0,*.5,-10") || control.getResults(gw).getEventResult().equals("S,none,0,*.25,-10") || control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsLeBaronHallPlentyBackpackItemsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("LeBaron Hall", 42.027878, -93.647177, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("LeBaron Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*10") || control.getResults(gw).getEventResult().equals("S,none,-0,0,-10") || control.getResults(gw).getEventResult().equals("S,none,-1,0,-10") || control.getResults(gw).getEventResult().equals("S,none,-2,0,-10"));
	}
	
	@Test
	public void testGetResultsLeBaronHallTwoBackpackItemsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("LeBaron Hall", 42.027878, -93.647177, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("LeBaron Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*10") || control.getResults(gw).getEventResult().equals("S,none,-0,0,-10") || control.getResults(gw).getEventResult().equals("S,none,-1,0,-10") || control.getResults(gw).getEventResult().equals("S,none,-2,0,-10"));
	}
	
	@Test
	public void testGetResultsLeBaronHallOneBackpackItemsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("LeBaron Hall", 42.027878, -93.647177, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("LeBaron Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*10") || control.getResults(gw).getEventResult().equals("S,none,-0,0,-10") || control.getResults(gw).getEventResult().equals("S,none,-1,0,-10"));
	}
	
	@Test
	public void testGetResultsLeBaronHallNoBackpackItemsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("LeBaron Hall", 42.027878, -93.647177, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("LeBaron Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsLeBaronHallChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("LeBaron Hall", 42.027878, -93.647177, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("LeBaron Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-5"));
	}
	
	@Test
	public void testGetResultsLeBaronHallPlentyOfBackPackItemsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("LeBaron Hall", 42.027878, -93.647177, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("LeBaron Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,-1,0,-15"));
	}
	
	@Test
	public void testGetResultsLeBaronHallOneBackPackItemsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("LeBaron Hall", 42.027878, -93.647177, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("LeBaron Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,-1,0,-15"));
	}
	
	@Test
	public void testGetResultsLeBaronHallNoBackPackItemsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("LeBaron Hall", 42.027878, -93.647177, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("LeBaron Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsLeBaronHallPlentyOfFoodItemsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("LeBaron Hall", 42.027878, -93.647177, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("LeBaron Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,-0,0,*10") || control.getResults(gw).getEventResult().equals("S,food,-1,0,*10") || control.getResults(gw).getEventResult().equals("S,food,-2,0,*10") || control.getResults(gw).getEventResult().equals("S,food,-0,0,-15") || control.getResults(gw).getEventResult().equals("S,food,-1,0,-15") || control.getResults(gw).getEventResult().equals("S,food,-2,0,-15"));
	}
	
	@Test
	public void testGetResultsLeBaronHallTwoFoodItemsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("LeBaron Hall", 42.027878, -93.647177, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("LeBaron Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,-0,0,*10") || control.getResults(gw).getEventResult().equals("S,food,-1,0,*10") || control.getResults(gw).getEventResult().equals("S,food,-2,0,*10") || control.getResults(gw).getEventResult().equals("S,food,-0,0,-15") || control.getResults(gw).getEventResult().equals("S,food,-1,0,-15") || control.getResults(gw).getEventResult().equals("S,food,-2,0,-15"));
	}
	
	@Test
	public void testGetResultsLeBaronHallOneFoodItemsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("LeBaron Hall", 42.027878, -93.647177, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("LeBaron Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,-1,0,*10") || control.getResults(gw).getEventResult().equals("S,food,-1,0,-15"));
	}
	
	@Test
	public void testGetResultsLeBaronHallNoFoodItemsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("LeBaron Hall", 42.027878, -93.647177, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("LeBaron Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetRestultsMacKayChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("MacKay Hall", 42.028511, -93.646515, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("MacKay Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetRestultsMacKayChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("MacKay Hall", 42.028511, -93.646515, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("MacKay Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*10") || control.getResults(gw).getEventResult().equals("S,none,0,0,-15"));
	}
	
	@Test
	public void testGetRestultsMacKayChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("MacKay Hall", 42.028511, -93.646515, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("MacKay Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-5"));
	}
	
	@Test
	public void testGetRestultsMacKayChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("MacKay Hall", 42.028511, -93.646515, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("MacKay Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsKildeeHallChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Kildee Hall", 42.029144, -93.644230, 1);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Kildee Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-5") || control.getResults(gw).getEventResult().equals("S,none,0,0,-20"));
	}
	
	@Test
	public void testGetResultsKildeeHallChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Kildee Hall", 42.029144, -93.644230, 1);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Kildee Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsKildeeHallChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Kildee Hall", 42.029144, -93.644230, 1);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Kildee Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-15"));
	}
	
	@Test
	public void testGetResultsKildeeHallChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Kildee Hall", 42.029144, -93.644230, 1);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Kildee Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsJischeHonorsBuildingPlentyOfSuppliesChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("Jischke Honors Building", 42.027186, -93.644581, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Jischke Honors Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,-3,0,0"));
	}
	
	@Test
	public void testGetResultsJischeHonorsBuildingThreeSuppliesChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("Jischke Honors Building", 42.027186, -93.644581, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Jischke Honors Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,-3,0,0"));
	}
	
	@Test
	public void testGetResultsJischeHonorsBuildingTwoSuppliesChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("Jischke Honors Building", 42.027186, -93.644581, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Jischke Honors Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsJischeHonorsBuildingNoSuppliesChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Jischke Honors Building", 42.027186, -93.644581, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Jischke Honors Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsJischkeHonorsBuildingChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Jischke Honors Building", 42.027186, -93.644581, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Jischke Honors Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsJischeHonorsBuildingPlentyOfBackpackSlotsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("Jischke Honors Building", 42.027186, -93.644581, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Jischke Honors Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,0,-10") || control.getResults(gw).getEventResult().equals("S,supplies,0,0,-10"));
	}
	
	@Test
	public void testGetResultsJischeHonorsBuildingOneBackpackSlotsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("Jischke Honors Building", 42.027186, -93.644581, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Jischke Honors Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,0,-10") || control.getResults(gw).getEventResult().equals("S,supplies,0,0,-10"));
	}
	
	@Test
	public void testGetResultsJischeHonorsBuildingNoBackpackSlotsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("Jischke Honors Building", 42.027186, -93.644581, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Jischke Honors Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsHonorsBackpackSpacePlentyOfMoneyChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(10.0);
		
		location = location.setLocation("Jischke Honors Building", 42.027186, -93.644581, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Jischke Honors Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,-2,0"));
	}
	
	@Test
	public void testGetResultsHonorsFreeBackpackSpaceTwoDollarsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(2.0);
		
		location = location.setLocation("Jischke Honors Building", 42.027186, -93.644581, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Jischke Honors Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,-2,0"));
	}
	
	@Test
	public void testGetResultsHonorsOneBackpackSpaceTwoDollarsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(2.0);
		
		location = location.setLocation("Jischke Honors Building", 42.027186, -93.644581, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Jischke Honors Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,-2,0"));
	}
	
	@Test
	public void testGetResultsHonorsNoBackpackSpaceTwoDollarsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(2.0);
		
		location = location.setLocation("Jischke Honors Building", 42.027186, -93.644581, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Jischke Honors Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsHonorsBackpackSpaceNoDollarsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.setMoney(0.0);
		
		location = location.setLocation("Jischke Honors Building", 42.023816, -93.645945, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Jischke Honors Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testGetResultsEastHallChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("East Hall", 42.026002, -93.643408, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("East Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*10"));
	}
	
	@Test
	public void testGetResultsEastHallChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("East Hall", 42.026002, -93.643408, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("East Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsEastHallChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("East Hall", 42.026002, -93.643408, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("East Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*20"));
	}
	
	@Test
	public void testGetResultsEastHallChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("East Hall", 42.026002, -93.643408, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("East Hall");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-20"));
	}
	
	@Test
	public void testGetResultsEastParkingDeckHallChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("East Parking Deck", 42.025555, -93.642856, 1);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("East Parking Deck");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-5") || control.getResults(gw).getEventResult().equals("S,none,0,0,-20"));
	}
	
	@Test
	public void testGetResultsEastParkingDeckChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("East Parking Deck", 42.025555, -93.642856, 1);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("East Parking Deck");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsEastParkingDeckChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("East Parking Deck", 42.025555, -93.642856, 1);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("East Parking Deck");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-15"));
	}
	
	@Test
	public void testGetResultsEastParkingDeckChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("East Parking Deck", 42.025555, -93.642856, 1);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("East Parking Deck");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsGerdinBusinessBuildingChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Gerdin Business Building", 42.025153, -93.644380, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Gerdin Business Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-5"));
	}
	
	@Test
	public void testGetResultsGerdinBusinessBuildingChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Gerdin Business Building", 42.025153, -93.644380, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Gerdin Business Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,0") || control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsGerdinBusinessBuildingChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Gerdin Business Building", 42.025153, -93.644380, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Gerdin Business Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsGerdinBusinessBuildingChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Gerdin Business Building", 42.025153, -93.644380, 0);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Gerdin Business Building");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-5") || control.getResults(gw).getEventResult().equals("S,none,0,0,-15"));
	}
	
	@Test
	public void testGetResultsKnollChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Knoll", 42.023615, -93.643589, 1);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Knoll");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsKnollChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Knoll", 42.023615, -93.643589, 1);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Knoll");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsKnollChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Knoll", 42.023615, -93.643589, 1);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Knoll");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testGetResultsKnollChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("Knoll", 42.023615, -93.643589, 1);
		event = new Events("", "", "","","", location);
		Events current = event.getEvent("Knoll");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testUpdateAfterEventRemoveOneRandomItem() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,none,-1,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 2);
	}
	
	@Test
	public void testUpdateAfterEventRemoveTwoRandomItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,none,-2,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 1);
	}
	
	@Test
	public void testUpdateAfterEventRemoveThreeRandomItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,none,-3,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 2);
	}
	
	@Test
	public void testUpdateAfterEventRemoveOneFoodItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,food,-1,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 4);
	}
	
	@Test
	public void testUpdateAfterEventRemoveTwoFoodItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,food,-2,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 3);
	}
	
	@Test
	public void testUpdateAfterEventRemoveThreeFoodItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,food,-3,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 2);
	}
	
	@Test
	public void testUpdateAfterEventAddOneFoodItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,food,*1,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 6);
	}
	
	@Test
	public void testUpdateAfterEventAddTwoFoodItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,food,*2,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 7);
	}
	
	@Test
	public void testUpdateAfterEventAddThreeFoodItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,food,*3,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 8);
	}
	
	@Test
	public void testUpdateAfterEventRemoveOneWaterItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,water,-1,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 4);
	}
	
	@Test
	public void testUpdateAfterEventRemoveTwoWaterItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,water,-2,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 3);
	}
	
	@Test
	public void testUpdateAfterEventRemoveThreeWaterItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,water,-3,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 2);
	}
	
	@Test
	public void testUpdateAfterEventAddOneWaterItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,water,*1,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 6);
	}
	
	@Test
	public void testUpdateAfterEventAddTwoWaterItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,water,*2,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 7);
	}
	
	@Test
	public void testUpdateAfterEventAddThreeWaterItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,water,*3,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 8);
	}
	
	@Test
	public void testUpdateAfterEventRemoveOneSuppliesItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,supplies,-1,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 4);
	}
	
	@Test
	public void testUpdateAfterEventRemoveTwoSuppliesItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,supplies,-2,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 3);
	}
	
	@Test
	public void testUpdateAfterEventRemoveThreeSuppliesItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,supplies,-3,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 2);
	}
	
	@Test
	public void testUpdateAfterEventAddOneSuppliesItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,supplies,*1,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 6);
	}
	
	@Test
	public void testUpdateAfterEventAddTwoSuppliesItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,supplies,*2,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 7);
	}
	
	@Test
	public void testUpdateAfterEventAddThreeSuppliesItems() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,supplies,*3,0,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getBackpack().length() == 8);
	}
	
	@Test
	public void testUpdateAfterEventRemoveOneDollarItems() {
		instance = new GameInstance("Ethan", 10);
		instance.setMoney(10.0);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,none,0,-1,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getMoney() == 9.0);
	}
	
	@Test
	public void testUpdateAfterEventRemoveTwoDollarsItems() {
		instance = new GameInstance("Ethan", 10);
		instance.setMoney(10.0);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,none,0,-2,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getMoney() == 8.0);
	}
	
	@Test
	public void testUpdateAfterEventAdd25CentsItems() {
		instance = new GameInstance("Ethan", 10);
		instance.setMoney(10.0);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,none,0,*.25,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getMoney() == 10.25);
	}
	
	@Test
	public void testUpdateAfterEventAdd50CentsItems() {
		instance = new GameInstance("Ethan", 10);
		instance.setMoney(10.0);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,none,0,*.5,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getMoney() == 10.5);
	}
	
	@Test
	public void testUpdateAfterEventAddOneDollarItems() {
		instance = new GameInstance("Ethan", 10);
		instance.setMoney(10.0);
		
		location = location.setLocation("none",0.0,0.0,0);
		event = new Events("","","","","",location);
		String input = "S,none,0,*1,0";
		String username = instance.getUsername();
		event.updateAfterEvent(instance, input);
		gw.setUsername("Ethan");
		gw.setEventResult(input);
		//System.out.println(instance);
		
		when(control.updatePostEvent(gw)).thenReturn(instance);
		assertTrue(control.updatePostEvent(gw).getMoney() == 11.0);
	}
	
	@Test
	public void testRandomEventUntiedShoeChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Untied Shoe");
		event.setDialogOne("Keep walking");
		event.setDialogTwo("Stop and tie it");
		event.setDialogThree("Walk Carefully To Next Stop to Tie it");
		event.setDialogFour("Tie it quickly");
		event.setLocation(location);
		Events current = event.getEvent("United Shoe");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,0") || control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testRandomEventUntiedShoeChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Untied Shoe");
		event.setDialogOne("Keep walking");
		event.setDialogTwo("Stop and tie it");
		event.setDialogThree("Walk Carefully To Next Stop to Tie it");
		event.setDialogFour("Tie it quickly");
		event.setLocation(location);
		Events current = event.getEvent("United Shoe");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testRandomEventUntiedShoeChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Untied Shoe");
		event.setDialogOne("Keep walking");
		event.setDialogTwo("Stop and tie it");
		event.setDialogThree("Walk Carefully To Next Stop to Tie it");
		event.setDialogFour("Tie it quickly");
		event.setLocation(location);
		Events current = event.getEvent("United Shoe");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-15") || control.getResults(gw).getEventResult().equals("S,none,0,0,-5"));
	}
	
	@Test
	public void testRandomEventUntiedShoeChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Untied Shoe");
		event.setDialogOne("Keep walking");
		event.setDialogTwo("Stop and tie it");
		event.setDialogThree("Walk Carefully To Next Stop to Tie it");
		event.setDialogFour("Tie it quickly");
		event.setLocation(location);
		Events current = event.getEvent("United Shoe");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-5"));
	}
	
	@Test
	public void testRandomEventSlowWalkersChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Group of Slow Walkers");
		event.setDialogOne("Try to squeeze between the walkers");
		event.setDialogTwo("Say excuse me and walk around");
		event.setDialogThree("Walk through the grass");
		event.setDialogFour("Try squeezing beside them on the other side of the sidewalk");
		event.setLocation(location);
		Events current = event.getEvent("Group of Slow Walkers");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,0") || control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testRandomEventSlowWalkersChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Group of Slow Walkers");
		event.setDialogOne("Try to squeeze between the walkers");
		event.setDialogTwo("Say excuse me and walk around");
		event.setDialogThree("Walk through the grass");
		event.setDialogFour("Try squeezing beside them on the other side of the sidewalk");
		event.setLocation(location);
		Events current = event.getEvent("Group of Slow Walkers");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-5") || control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testRandomEventSlowWalkersChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Group of Slow Walkers");
		event.setDialogOne("Try to squeeze between the walkers");
		event.setDialogTwo("Say excuse me and walk around");
		event.setDialogThree("Walk through the grass");
		event.setDialogFour("Try squeezing beside them on the other side of the sidewalk");
		event.setLocation(location);
		Events current = event.getEvent("Group of Slow Walkers");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testRandomEventSlowWalkersChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Group of Slow Walkers");
		event.setDialogOne("Try to squeeze between the walkers");
		event.setDialogTwo("Say excuse me and walk around");
		event.setDialogThree("Walk through the grass");
		event.setDialogFour("Try squeezing beside them on the other side of the sidewalk");
		event.setLocation(location);
		Events current = event.getEvent("Group of Slow Walkers");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-5") || control.getResults(gw).getEventResult().equals("S,none,0,0-15"));
	}
	
	@Test
	public void testRandomEvent25CentsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find .25 cents on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find .25 cents on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*.25,-5"));
	}
	
	@Test
	public void testRandomEvent25CentsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find .25 cents on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find .25 cents on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*.25,-5"));
	}
	
	@Test
	public void testRandomEvent25CentsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find .25 cents on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find .25 cents on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*.25,-5"));
	}
	
	@Test
	public void testRandomEvent25CentsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find .25 cents on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find .25 cents on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,0"));
	}
	
	@Test
	public void testRandomEvent50CentsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find .50 cents on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find .50 cents on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*.5,-5"));
	}
	
	@Test
	public void testRandomEvent50CentsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find .50 cents on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find .50 cents on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*.5,-5"));
	}
	
	@Test
	public void testRandomEvent50CentsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find .50 cents on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find .50 cents on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*.5,-5"));
	}
	
	@Test
	public void testRandomEvent50CentsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find .50 cents on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find .50 cents on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,0"));
	}
	
	@Test
	public void testRandomEvent75CentsChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find .75 cents on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find .75 cents on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*.75,-5"));
	}
	
	@Test
	public void testRandomEvent75CentsChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find .75 cents on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find .75 cents on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*.75,-5"));
	}
	
	@Test
	public void testRandomEvent75CentsChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find .75 cents on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find .75 cents on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*.75,-5"));
	}
	
	@Test
	public void testRandomEvent75CentsChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find .75 cents on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find .75 cents on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,0"));
	}
	
	@Test
	public void testRandomEvent1DollarChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find 1 dollar on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find 1 dollar on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*1,-5"));
	}
	
	@Test
	public void testRandomEvent1DollarChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find 1 dollar on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find 1 dollar on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*1,-5"));
	}
	
	@Test
	public void testRandomEvent1DollarChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find 1 dollar on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find 1 dollar on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,*1,-5"));
	}
	
	@Test
	public void testRandomEvent1DollarChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find 1 dollar on the ground");
		event.setDialogOne("Pick up the money");
		event.setDialogTwo("Pick up the money");
		event.setDialogThree("Pick up the money");
		event.setDialogFour("Ignore the money");
		event.setLocation(location);
		Events current = event.getEvent("Find 1 dollar on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,0"));
	}
	
	@Test
	public void testRandomEventSchoolSuppliesBackpackSpaceChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find school supplies on the ground");
		event.setDialogOne("Pick up the school supplies");
		event.setDialogTwo("Pick up the school supplies");
		event.setDialogThree("Pick up the school supplies");
		event.setDialogFour("Ignore the school supplies");
		event.setLocation(location);
		Events current = event.getEvent("Find school supplies on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,0,-5"));
	}
	
	@Test
	public void testRandomEventSchoolSuppliesNoBackpackSpaceChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find school supplies on the ground");
		event.setDialogOne("Pick up the school supplies");
		event.setDialogTwo("Pick up the school supplies");
		event.setDialogThree("Pick up the school supplies");
		event.setDialogFour("Ignore the school supplies");
		event.setLocation(location);
		Events current = event.getEvent("Find school supplies on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testRandomEventSchoolSuppliesBackpackSpaceChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find school supplies on the ground");
		event.setDialogOne("Pick up the school supplies");
		event.setDialogTwo("Pick up the school supplies");
		event.setDialogThree("Pick up the school supplies");
		event.setDialogFour("Ignore the school supplies");
		event.setLocation(location);
		Events current = event.getEvent("Find school supplies on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,0,-5"));
	}
	
	@Test
	public void testRandomEventSchoolSuppliesNoBackpackSpaceChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find school supplies on the ground");
		event.setDialogOne("Pick up the school supplies");
		event.setDialogTwo("Pick up the school supplies");
		event.setDialogThree("Pick up the school supplies");
		event.setDialogFour("Ignore the school supplies");
		event.setLocation(location);
		Events current = event.getEvent("Find school supplies on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testRandomEventSchoolSuppliesBackpackSpaceChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find school supplies on the ground");
		event.setDialogOne("Pick up the school supplies");
		event.setDialogTwo("Pick up the school supplies");
		event.setDialogThree("Pick up the school supplies");
		event.setDialogFour("Ignore the school supplies");
		event.setLocation(location);
		Events current = event.getEvent("Find school supplies on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,*1,0,-5"));
	}
	
	@Test
	public void testRandomEventSchoolSuppliesNoBackpackSpaceChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find school supplies on the ground");
		event.setDialogOne("Pick up the school supplies");
		event.setDialogTwo("Pick up the school supplies");
		event.setDialogThree("Pick up the school supplies");
		event.setDialogFour("Ignore the school supplies");
		event.setLocation(location);
		Events current = event.getEvent("Find school supplies on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testRandomEventSchoolSuppliesChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Find school supplies on the ground");
		event.setDialogOne("Pick up the school supplies");
		event.setDialogTwo("Pick up the school supplies");
		event.setDialogThree("Pick up the school supplies");
		event.setDialogFour("Ignore the school supplies");
		event.setLocation(location);
		Events current = event.getEvent("Find school supplies on the ground");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,0"));
	}
	
	@Test
	public void testRandomEventDogWalkingChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("You see a dog walking");
		event.setDialogOne("You ignore it");
		event.setDialogTwo("You try to pet it");
		event.setDialogThree("Avoid the dog");
		event.setDialogFour("Stop and watch it walk by because its super cute");
		event.setLocation(location);
		Events current = event.getEvent("You see a dog walking");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-5"));
	}
	
	@Test
	public void testRandomEventDogWalkingChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("You see a dog walking");
		event.setDialogOne("You ignore it");
		event.setDialogTwo("You try to pet it");
		event.setDialogThree("Avoid the dog");
		event.setDialogFour("Stop and watch it walk by because its super cute");
		event.setLocation(location);
		Events current = event.getEvent("You see a dog walking");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*10") || control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testRandomEventDogWalkingChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("You see a dog walking");
		event.setDialogOne("You ignore it");
		event.setDialogTwo("You try to pet it");
		event.setDialogThree("Avoid the dog");
		event.setDialogFour("Stop and watch it walk by because its super cute");
		event.setLocation(location);
		Events current = event.getEvent("You see a dog walking");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testRandomEventDogWalkingChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("You see a dog walking");
		event.setDialogOne("You ignore it");
		event.setDialogTwo("You try to pet it");
		event.setDialogThree("Avoid the dog");
		event.setDialogFour("Stop and watch it walk by because its super cute");
		event.setLocation(location);
		Events current = event.getEvent("You see a dog walking");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testRandomEventSteppedInGumChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("You stepped in gum");
		event.setDialogOne("You try to scrape it off on the sidewalk");
		event.setDialogTwo("You try to scrape it off with a pencil");
		event.setDialogThree("You ignore it");
		event.setDialogFour("You walk in the grass to try to get rid of it");
		event.setLocation(location);
		Events current = event.getEvent("You see a dog walking");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testRandomEventSteppedInGumOneSchoolSuppliesChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("You stepped in gum");
		event.setDialogOne("You try to scrape it off on the sidewalk");
		event.setDialogTwo("You try to scrape it off with a pencil");
		event.setDialogThree("You ignore it");
		event.setDialogFour("You walk in the grass to try to get rid of it");
		event.setLocation(location);
		Events current = event.getEvent("You see a dog walking");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,supplies,-1,0,-5"));
	}
	
	@Test
	public void testRandomEventSteppedInGumNoSchoolSuppliesChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("You stepped in gum");
		event.setDialogOne("You try to scrape it off on the sidewalk");
		event.setDialogTwo("You try to scrape it off with a pencil");
		event.setDialogThree("You ignore it");
		event.setDialogFour("You walk in the grass to try to get rid of it");
		event.setLocation(location);
		Events current = event.getEvent("You see a dog walking");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testRandomEventSteppedInGumChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("You stepped in gum");
		event.setDialogOne("You try to scrape it off on the sidewalk");
		event.setDialogTwo("You try to scrape it off with a pencil");
		event.setDialogThree("You ignore it");
		event.setDialogFour("You walk in the grass to try to get rid of it");
		event.setLocation(location);
		Events current = event.getEvent("You see a dog walking");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-15"));
	}
	
	@Test
	public void testRandomEventSteppedInGumChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("You stepped in gum");
		event.setDialogOne("You try to scrape it off on the sidewalk");
		event.setDialogTwo("You try to scrape it off with a pencil");
		event.setDialogThree("You ignore it");
		event.setDialogFour("You walk in the grass to try to get rid of it");
		event.setLocation(location);
		Events current = event.getEvent("You see a dog walking");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-10"));
	}
	
	@Test
	public void testRandomEventGooseChaseFullBackpackChoiceOne() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Goose Chase");
		event.setDialogOne("Run away from them");
		event.setDialogTwo("Throw one bag item at them");
		event.setDialogThree("Calmly walk by them");
		event.setDialogFour("Feed them some food");
		event.setLocation(location);
		Events current = event.getEvent("Goose Chase");
		gw.setUsername("Ethan");
		gw.setEventChoice(1);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 1));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,*10")|| control.getResults(gw).getEventResult().equals("S,none,-1,0,-10")||control.getResults(gw).getEventResult().equals("S,none,-2,0,-10")||control.getResults(gw).getEventResult().equals("S,none,-3,0,-10") || control.getResults(gw).getEventResult().equals("S,none,-0,0,-10"));
	}
	
	@Test
	public void testRandomEventGooseChaseFullBackpackChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.WATER);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		instance.getBackpack().insertObject(BPObject.SCHOOL_SUPPLIES);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Goose Chase");
		event.setDialogOne("Run away from them");
		event.setDialogTwo("Throw one bag item at them");
		event.setDialogThree("Calmly walk by them");
		event.setDialogFour("Feed them some food");
		event.setLocation(location);
		Events current = event.getEvent("Goose Chase");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,-1,0,*15") || control.getResults(gw).getEventResult().equals("S,none,-1,0,-20"));
	}
	
	@Test
	public void testRandomEventGooseChaseNoBackpackChoiceTwo() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Goose Chase");
		event.setDialogOne("Run away from them");
		event.setDialogTwo("Throw one bag item at them");
		event.setDialogThree("Calmly walk by them");
		event.setDialogFour("Feed them some food");
		event.setLocation(location);
		Events current = event.getEvent("Goose Chase");
		gw.setUsername("Ethan");
		gw.setEventChoice(2);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 2));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
	
	@Test
	public void testRandomEventGooseChaseChoiceThree() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Goose Chase");
		event.setDialogOne("Run away from them");
		event.setDialogTwo("Throw one bag item at them");
		event.setDialogThree("Calmly walk by them");
		event.setDialogFour("Feed them some food");
		event.setLocation(location);
		Events current = event.getEvent("Goose Chase");
		gw.setUsername("Ethan");
		gw.setEventChoice(3);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 3));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,none,0,0,-5"));
	}
	
	@Test
	public void testRandomEventGooseChaseThreeFoodChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		instance.getBackpack().insertObject(BPObject.FOOD);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Goose Chase");
		event.setDialogOne("Run away from them");
		event.setDialogTwo("Throw one bag item at them");
		event.setDialogThree("Calmly walk by them");
		event.setDialogFour("Feed them some food");
		event.setLocation(location);
		Events current = event.getEvent("Goose Chase");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("S,food,-3,0,-10") || control.getResults(gw).getEventResult().equals("S,food,-2,0,-10") || control.getResults(gw).getEventResult().equals("S,food,-1,0,-10") || control.getResults(gw).getEventResult().equals("S,food,-0,0,-10"));
	}
	
	@Test
	public void testRandomEventGooseChaseNoFoodChoiceFour() {
		instance = new GameInstance("Ethan", 10);
		
		location = location.setLocation("random", 0.0, 0.0, 0);
		event = new Events("none","","","","",location);
		event.setEventName("Goose Chase");
		event.setDialogOne("Run away from them");
		event.setDialogTwo("Throw one bag item at them");
		event.setDialogThree("Calmly walk by them");
		event.setDialogFour("Feed them some food");
		event.setLocation(location);
		Events current = event.getEvent("Goose Chase");
		gw.setUsername("Ethan");
		gw.setEventChoice(4);
		
		GameWrapper result = new GameWrapper();
		result.setEventResult(event.getResults(instance, 4));
		String userName = instance.getUsername();
		
		//System.out.println(result.getEventResult());
		
		when(control.getResults(gw)).thenReturn(result);
		assertTrue(control.getResults(gw).getEventResult().equals("F,none,0,0,0"));
	}
}
