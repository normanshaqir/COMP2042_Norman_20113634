package froggerGame.models;

import java.util.ArrayList;

import froggerGame.constants.ActorImages;
import froggerGame.constants.MedLevelValues;

public class MedLevel1 extends Level {
	public void spawnActors() {
		BackgroundImage gameBackground = new BackgroundImage(ActorImages.IMG_LEVEL_BACKGROUND);
		background.add(gameBackground);
		
		ArrayList<Actor> ACTORS = new ArrayList<Actor>();

		spawnEnds();

		for (int i = 0; i < MedLevelValues.LOGS_IMG_VALUES.length; i++) {
			ACTORS.add(LogFactory.createActor(MedLevelValues.LOGS_IMG_VALUES[i], MedLevelValues.LOGS_IMGSIZE_VALUES[i],
											  MedLevelValues.LOGS_IMGSIZE_VALUES[i], MedLevelValues.LOGS_XPOS_VALUES[i], 
											  MedLevelValues.LOGS_YPOS_VALUES[i], MedLevelValues.LOGS_SPEED_VALUES[i]));

		}
		
		for (int i = 0; i < MedLevelValues.DRYTURTLES_IMGSIZE_VALUES.length; i++) {
			ACTORS.add(new DryTurtle(MedLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], MedLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], MedLevelValues.DRYTURTLES_XPOS_VALUES[i], MedLevelValues.DRYTURTLES_YPOS_VALUES[i], MedLevelValues.DRYTURTLES_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < MedLevelValues.WETTURTLES_IMGSIZE_VALUES.length; i++) {
			ACTORS.add(new WetTurtle(MedLevelValues.WETTURTLES_IMGSIZE_VALUES[i], MedLevelValues.WETTURTLES_IMGSIZE_VALUES[i], MedLevelValues.WETTURTLES_XPOS_VALUES[i], MedLevelValues.WETTURTLES_YPOS_VALUES[i], MedLevelValues.WETTURTLES_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < MedLevelValues.CARS_IMG_VALUES.length; i++) {
			ACTORS.add(CarFactory.createActor (MedLevelValues.CARS_IMG_VALUES[i], MedLevelValues.CARS_IMGSIZE_VALUES[i], MedLevelValues.CARS_IMGSIZE_VALUES[i],
											   MedLevelValues.CARS_XPOS_VALUES[i], MedLevelValues.CARS_YPOS_VALUES[i], 
											   MedLevelValues.CARS_SPEED_VALUES[i]));
		}
		
		
		for (int i = 0; i < MedLevelValues.TRUCKS_IMG_VALUES.length; i++) {
			ACTORS.add(TruckFactory.createActor(MedLevelValues.TRUCKS_IMG_VALUES[i], MedLevelValues.TRUCKS_IMGSIZE_VALUES[i],
					   MedLevelValues.TRUCKS_IMGSIZE_VALUES[i], MedLevelValues.TRUCKS_XPOS_VALUES[i], MedLevelValues.TRUCKS_YPOS_VALUES[i],
					   MedLevelValues.TRUCKS_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < ACTORS.size(); i++) {
			background.add(ACTORS.get(i));

		}
	
		background.add(player); //TODO: send frog to back with regard to trucks/cars
		background.add(new Digit(0, 30, 360, 25));

		
	}
}
