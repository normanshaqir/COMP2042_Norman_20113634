package froggerGame.models.levels;

import froggerGame.constants.InsaneLevelValues;
import froggerGame.models.actors.DryTurtle;
import froggerGame.models.actors.WetTurtle;

public class InsaneLevel extends Level {
	public void spawnActors() {
		for (int i = 0; i < InsaneLevelValues.LOGS_IMG_VALUES.length; i++) {
			background.add(LogFactory.createActor(InsaneLevelValues.LOGS_IMG_VALUES[i], InsaneLevelValues.LOGS_IMGSIZE_VALUES[i],
											  InsaneLevelValues.LOGS_IMGSIZE_VALUES[i], InsaneLevelValues.LOGS_XPOS_VALUES[i], 
											  InsaneLevelValues.LOGS_YPOS_VALUES[i], InsaneLevelValues.LOGS_SPEED_VALUES[i]));

		}
		
		for (int i = 0; i < InsaneLevelValues.DRYTURTLES_IMGSIZE_VALUES.length; i++) {
			background.add(new DryTurtle(InsaneLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], InsaneLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], InsaneLevelValues.DRYTURTLES_XPOS_VALUES[i], InsaneLevelValues.DRYTURTLES_YPOS_VALUES[i], InsaneLevelValues.DRYTURTLES_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < InsaneLevelValues.WETTURTLES_IMGSIZE_VALUES.length; i++) {
			background.add(new WetTurtle(InsaneLevelValues.WETTURTLES_IMGSIZE_VALUES[i], InsaneLevelValues.WETTURTLES_IMGSIZE_VALUES[i], InsaneLevelValues.WETTURTLES_XPOS_VALUES[i], InsaneLevelValues.WETTURTLES_YPOS_VALUES[i], InsaneLevelValues.WETTURTLES_SPEED_VALUES[i]));
		}
		
		background.add(player);
		
		for (int i = 0; i < InsaneLevelValues.CARS_IMG_VALUES.length; i++) {
			background.add(CarFactory.createActor (InsaneLevelValues.CARS_IMG_VALUES[i], InsaneLevelValues.CARS_IMGSIZE_VALUES[i], InsaneLevelValues.CARS_IMGSIZE_VALUES[i],
											   InsaneLevelValues.CARS_XPOS_VALUES[i], InsaneLevelValues.CARS_YPOS_VALUES[i], 
											   InsaneLevelValues.CARS_SPEED_VALUES[i]));
		}
		
		
		for (int i = 0; i < InsaneLevelValues.TRUCKS_IMG_VALUES.length; i++) {
			background.add(TruckFactory.createActor(InsaneLevelValues.TRUCKS_IMG_VALUES[i], InsaneLevelValues.TRUCKS_IMGSIZE_VALUES[i],
					   InsaneLevelValues.TRUCKS_IMGSIZE_VALUES[i], InsaneLevelValues.TRUCKS_XPOS_VALUES[i], InsaneLevelValues.TRUCKS_YPOS_VALUES[i],
					   InsaneLevelValues.TRUCKS_SPEED_VALUES[i]));
		}

		
	}
}
