package froggerGame.models;

import java.util.ArrayList;

import froggerGame.constants.ActorImages;
import froggerGame.constants.EasyLevelValues;


public class EasyLevel1 extends Level {
	public void spawnActors() {
		BackgroundImage gameBackground = new BackgroundImage(ActorImages.IMG_LEVEL_BACKGROUND);
		background.add(gameBackground);

		ArrayList<Actor> ACTORS = new ArrayList<Actor>();

		spawnEnds();

		for (int i = 0; i < EasyLevelValues.LOGS_IMG_VALUES.length; i++) {
			ACTORS.add(LogFactory.createActor(EasyLevelValues.LOGS_IMG_VALUES[i], EasyLevelValues.LOGS_IMGSIZE_VALUES[i],
											  EasyLevelValues.LOGS_IMGSIZE_VALUES[i], EasyLevelValues.LOGS_XPOS_VALUES[i], 
											  EasyLevelValues.LOGS_YPOS_VALUES[i], EasyLevelValues.LOGS_SPEED_VALUES[i]));

		}
		
		for (int i = 0; i < EasyLevelValues.DRYTURTLES_IMGSIZE_VALUES.length; i++) {
			ACTORS.add(new DryTurtle(EasyLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], EasyLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], EasyLevelValues.DRYTURTLES_XPOS_VALUES[i], EasyLevelValues.DRYTURTLES_YPOS_VALUES[i], EasyLevelValues.DRYTURTLES_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < EasyLevelValues.WETTURTLES_IMGSIZE_VALUES.length; i++) {
			ACTORS.add(new WetTurtle(EasyLevelValues.WETTURTLES_IMGSIZE_VALUES[i], EasyLevelValues.WETTURTLES_IMGSIZE_VALUES[i], EasyLevelValues.WETTURTLES_XPOS_VALUES[i], EasyLevelValues.WETTURTLES_YPOS_VALUES[i], EasyLevelValues.WETTURTLES_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < EasyLevelValues.CARS_IMG_VALUES.length; i++) {
			ACTORS.add(CarFactory.createActor (EasyLevelValues.CARS_IMG_VALUES[i], EasyLevelValues.CARS_IMGSIZE_VALUES[i], EasyLevelValues.CARS_IMGSIZE_VALUES[i],
											   EasyLevelValues.CARS_XPOS_VALUES[i], EasyLevelValues.CARS_YPOS_VALUES[i], 
											   EasyLevelValues.CARS_SPEED_VALUES[i]));
		}
		
		
		for (int i = 0; i < EasyLevelValues.TRUCKS_IMG_VALUES.length; i++) {
			ACTORS.add(TruckFactory.createActor(EasyLevelValues.TRUCKS_IMG_VALUES[i], EasyLevelValues.TRUCKS_IMGSIZE_VALUES[i],
					   EasyLevelValues.TRUCKS_IMGSIZE_VALUES[i], EasyLevelValues.TRUCKS_XPOS_VALUES[i], EasyLevelValues.TRUCKS_YPOS_VALUES[i],
					   EasyLevelValues.TRUCKS_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < ACTORS.size(); i++) {
			background.add(ACTORS.get(i));

		}
	
		background.add(player); //TODO: send frog to back with regard to trucks/cars
		background.add(new Digit(0, 30, 360, 25));

        background.add(new Digit(5, 30, 450, 45));

		
	}
}
