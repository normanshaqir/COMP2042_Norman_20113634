package froggerGame.models;

import java.util.ArrayList;

import froggerGame.constants.ActorImages;
import froggerGame.constants.InsaneLevelValues;

public class InsaneLevel extends Level {
	public void spawnActors() {
		BackgroundImage gameBackground = new BackgroundImage(ActorImages.IMG_LEVEL_BACKGROUND);
		background.add(gameBackground);
		
		ArrayList<Actor> ACTORS = new ArrayList<Actor>();

		spawnEnds();

		for (int i = 0; i < InsaneLevelValues.LOGS_IMG_VALUES.length; i++) {
			ACTORS.add(LogFactory.createActor(InsaneLevelValues.LOGS_IMG_VALUES[i], InsaneLevelValues.LOGS_IMGSIZE_VALUES[i],
											  InsaneLevelValues.LOGS_IMGSIZE_VALUES[i], InsaneLevelValues.LOGS_XPOS_VALUES[i], 
											  InsaneLevelValues.LOGS_YPOS_VALUES[i], InsaneLevelValues.LOGS_SPEED_VALUES[i]));

		}
		
		for (int i = 0; i < InsaneLevelValues.DRYTURTLES_IMGSIZE_VALUES.length; i++) {
			ACTORS.add(new DryTurtle(InsaneLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], InsaneLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], InsaneLevelValues.DRYTURTLES_XPOS_VALUES[i], InsaneLevelValues.DRYTURTLES_YPOS_VALUES[i], InsaneLevelValues.DRYTURTLES_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < InsaneLevelValues.WETTURTLES_IMGSIZE_VALUES.length; i++) {
			ACTORS.add(new WetTurtle(InsaneLevelValues.WETTURTLES_IMGSIZE_VALUES[i], InsaneLevelValues.WETTURTLES_IMGSIZE_VALUES[i], InsaneLevelValues.WETTURTLES_XPOS_VALUES[i], InsaneLevelValues.WETTURTLES_YPOS_VALUES[i], InsaneLevelValues.WETTURTLES_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < InsaneLevelValues.CARS_IMG_VALUES.length; i++) {
			ACTORS.add(CarFactory.createActor (InsaneLevelValues.CARS_IMG_VALUES[i], InsaneLevelValues.CARS_IMGSIZE_VALUES[i], InsaneLevelValues.CARS_IMGSIZE_VALUES[i],
											   InsaneLevelValues.CARS_XPOS_VALUES[i], InsaneLevelValues.CARS_YPOS_VALUES[i], 
											   InsaneLevelValues.CARS_SPEED_VALUES[i]));
		}
		
		
		for (int i = 0; i < InsaneLevelValues.TRUCKS_IMG_VALUES.length; i++) {
			ACTORS.add(TruckFactory.createActor(InsaneLevelValues.TRUCKS_IMG_VALUES[i], InsaneLevelValues.TRUCKS_IMGSIZE_VALUES[i],
					   InsaneLevelValues.TRUCKS_IMGSIZE_VALUES[i], InsaneLevelValues.TRUCKS_XPOS_VALUES[i], InsaneLevelValues.TRUCKS_YPOS_VALUES[i],
					   InsaneLevelValues.TRUCKS_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < ACTORS.size(); i++) {
			background.add(ACTORS.get(i));

		}
	
		background.add(player); //TODO: send frog to back with regard to trucks/cars
		background.add(new Digit(0, 30, 360, 25));

		
	}
}
