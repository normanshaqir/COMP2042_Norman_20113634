package froggerGame.models.levels;

import froggerGame.constants.MedLevelValues;
import froggerGame.models.actors.Crocodile;
import froggerGame.models.actors.DryTurtle;
import froggerGame.models.actors.WetTurtle;

public class MedLevel extends Level {
	public void spawnActors() {
		for (int i = 0; i < MedLevelValues.LOGS_IMG_VALUES.length; i++) {
			background.add(LogFactory.createActor(MedLevelValues.LOGS_IMG_VALUES[i], MedLevelValues.LOGS_IMGSIZE_VALUES[i],
											  MedLevelValues.LOGS_IMGSIZE_VALUES[i], MedLevelValues.LOGS_XPOS_VALUES[i], 
											  MedLevelValues.LOGS_YPOS_VALUES[i], MedLevelValues.LOGS_SPEED_VALUES[i]));

		}
		
		for (int i = 0; i < MedLevelValues.DRYTURTLES_IMGSIZE_VALUES.length; i++) {
			background.add(new DryTurtle(MedLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], MedLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], 
					MedLevelValues.DRYTURTLES_XPOS_VALUES[i], MedLevelValues.DRYTURTLES_YPOS_VALUES[i], MedLevelValues.DRYTURTLES_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < MedLevelValues.CROCODILES_IMGSIZE_VALUES.length; i++) {
			background.add(new Crocodile(MedLevelValues.CROCODILES_IMGSIZE_VALUES[i], MedLevelValues.CROCODILES_IMGSIZE_VALUES[i], 
					MedLevelValues.CROCODILES_XPOS_VALUES[i], MedLevelValues.CROCODILES_YPOS_VALUES[i], MedLevelValues.CROCODILES_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < MedLevelValues.WETTURTLES_IMGSIZE_VALUES.length; i++) {
			background.add(new WetTurtle(MedLevelValues.WETTURTLES_IMGSIZE_VALUES[i], MedLevelValues.WETTURTLES_IMGSIZE_VALUES[i], MedLevelValues.WETTURTLES_XPOS_VALUES[i], MedLevelValues.WETTURTLES_YPOS_VALUES[i], MedLevelValues.WETTURTLES_SPEED_VALUES[i]));
		}
		
		background.add(player);
		
		for (int i = 0; i < MedLevelValues.CARS_IMG_VALUES.length; i++) {
			background.add(CarFactory.createActor (MedLevelValues.CARS_IMG_VALUES[i], MedLevelValues.CARS_IMGSIZE_VALUES[i], MedLevelValues.CARS_IMGSIZE_VALUES[i],
											   MedLevelValues.CARS_XPOS_VALUES[i], MedLevelValues.CARS_YPOS_VALUES[i], 
											   MedLevelValues.CARS_SPEED_VALUES[i]));
		}
		
		
		for (int i = 0; i < MedLevelValues.TRUCKS_IMG_VALUES.length; i++) {
			background.add(TruckFactory.createActor(MedLevelValues.TRUCKS_IMG_VALUES[i], MedLevelValues.TRUCKS_IMGSIZE_VALUES[i],
					   MedLevelValues.TRUCKS_IMGSIZE_VALUES[i], MedLevelValues.TRUCKS_XPOS_VALUES[i], MedLevelValues.TRUCKS_YPOS_VALUES[i],
					   MedLevelValues.TRUCKS_SPEED_VALUES[i]));
		}
	}
}
