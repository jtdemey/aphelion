package core;
import java.util.*;

public class Game {
	
	private MainWindow gameWindow;
	private boolean paused;
	private long tick;
	private Player gamePlayer;
	private List<Location> locations;
	
	public Game(MainWindow w) {
		gameWindow = w;
		paused = true;
		tick = 0;
		gamePlayer = new Player();
		locations = new ArrayList<Location>();
	}
	
/**
	public static void showMainMenu(MainWindow w) {
		w.displayLine("==============================================================================================================");
		w.displayLine("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		w.displayLine("				 Welcome to GAME");
		w.displayLine("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		w.displayLine("==============================================================================================================");
		w.displayLine("");
		w.displayLine("");
		w.displayLine("		'1' >> NEW GAME");
		w.displayLine("");
		w.displayLine("		'2' >> LOAD GAME");
		w.displayLine("");
		w.displayLine("		'3' >> SETTINGS");
		w.displayLine("");
		w.displayLine("		'4' >> QUIT TO DESKTOP");
		for(int i = 0; i < 12; i++) {
			w.displayLine("");
		}
		w.displayLine("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
	}
**/
	private void generateWorld() {
		//Survival horror
		Location loc_car = new Location("Car");
		loc_car.setEnterPhrase("You enter your car.");
		loc_car.setExitPhrase("You get up and leave your car");
			Exit driverDoor = new Exit(loc_mailbox, 12, true, "There's nothing but dense forest for as far as you can see.");
			loc_car.addExit(driverDoor);
		loc_car.setTemperature(45);
		loc_car.setVisibility(80);
			loc_car.addFeature("rearview mirror", "There is nothing behind you but pitch black.  Must be a new moon.");
			loc_car.addFeature("side mirror", "You glance in your side mirrors and see nothing but the white should strip on the road behind you, stretching as far as the eye can see.");
			loc_car.addFeature("clock", "The digital display dimly reads '2:48 AM'.");
			loc_car.addFeature("windshield", "The fog is getting rather thick and visibility is fading.  It doesn't help that there is no moon out.");
	
	}
	
	public void run() {
		
	}
	
	public void tick() {
		tick++;
	}
	public long getTick() {
		return tick;
	}
	public boolean isPaused() {
		return paused;
	}
	public void setTick(long t) {
		tick = t;
	}
	public void pause() {
		paused = true;
	}
	public void unpause() {
		paused = false;
	}
	public MainWindow getWindow() {
		return gameWindow;
	}
}
