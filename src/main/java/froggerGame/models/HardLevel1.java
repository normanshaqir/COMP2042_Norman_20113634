package froggerGame.models;

import java.util.ArrayList;

import froggerGame.constants.ActorImages;
import froggerGame.constants.HardLevelValues;

public class HardLevel1 extends Level {
	public void spawnActors() {
		BackgroundImage gameBackground = new BackgroundImage(ActorImages.IMG_LEVEL_BACKGROUND);
		background.add(gameBackground);
		
		ArrayList<Actor> ACTORS = new ArrayList<Actor>();

		spawnEnds();

		for (int i = 0; i < HardLevelValues.LOGS_IMG_VALUES.length; i++) {
			ACTORS.add(LogFactory.createActor(HardLevelValues.LOGS_IMG_VALUES[i], HardLevelValues.LOGS_IMGSIZE_VALUES[i],
											  HardLevelValues.LOGS_IMGSIZE_VALUES[i], HardLevelValues.LOGS_XPOS_VALUES[i], 
											  HardLevelValues.LOGS_YPOS_VALUES[i], HardLevelValues.LOGS_SPEED_VALUES[i]));

		}
		
		for (int i = 0; i < HardLevelValues.DRYTURTLES_IMGSIZE_VALUES.length; i++) {
			ACTORS.add(new DryTurtle(HardLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], HardLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], HardLevelValues.DRYTURTLES_XPOS_VALUES[i], HardLevelValues.DRYTURTLES_YPOS_VALUES[i], HardLevelValues.DRYTURTLES_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < HardLevelValues.WETTURTLES_IMGSIZE_VALUES.length; i++) {
			ACTORS.add(new WetTurtle(HardLevelValues.WETTURTLES_IMGSIZE_VALUES[i], HardLevelValues.WETTURTLES_IMGSIZE_VALUES[i], HardLevelValues.WETTURTLES_XPOS_VALUES[i], HardLevelValues.WETTURTLES_YPOS_VALUES[i], HardLevelValues.WETTURTLES_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < HardLevelValues.CARS_IMG_VALUES.length; i++) {
			ACTORS.add(CarFactory.createActor (HardLevelValues.CARS_IMG_VALUES[i], HardLevelValues.CARS_IMGSIZE_VALUES[i], HardLevelValues.CARS_IMGSIZE_VALUES[i],
											   HardLevelValues.CARS_XPOS_VALUES[i], HardLevelValues.CARS_YPOS_VALUES[i], 
											   HardLevelValues.CARS_SPEED_VALUES[i]));
		}
		
		
		for (int i = 0; i < HardLevelValues.TRUCKS_IMG_VALUES.length; i++) {
			ACTORS.add(TruckFactory.createActor(HardLevelValues.TRUCKS_IMG_VALUES[i], HardLevelValues.TRUCKS_IMGSIZE_VALUES[i],
					   HardLevelValues.TRUCKS_IMGSIZE_VALUES[i], HardLevelValues.TRUCKS_XPOS_VALUES[i], HardLevelValues.TRUCKS_YPOS_VALUES[i],
					   HardLevelValues.TRUCKS_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < ACTORS.size(); i++) {
			background.add(ACTORS.get(i));

		}
	
		background.add(player); //TODO: send frog to back with regard to trucks/cars
		background.add(new Digit(0, 30, 360, 25));

		
	}
}
