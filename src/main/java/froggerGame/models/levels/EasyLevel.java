package froggerGame.models.levels;

import froggerGame.constants.EasyLevelValues;
import froggerGame.models.actors.DryTurtle;
import froggerGame.models.actors.WetTurtle;


public class EasyLevel extends Level {
	public void spawnActors() {
		for (int i = 0; i < EasyLevelValues.LOGS_IMG_VALUES.length; i++) {
			background.add(LogFactory.createActor(EasyLevelValues.LOGS_IMG_VALUES[i], EasyLevelValues.LOGS_IMGSIZE_VALUES[i],
											  EasyLevelValues.LOGS_IMGSIZE_VALUES[i], EasyLevelValues.LOGS_XPOS_VALUES[i], 
											  EasyLevelValues.LOGS_YPOS_VALUES[i], EasyLevelValues.LOGS_SPEED_VALUES[i]));

		}
		
		for (int i = 0; i < EasyLevelValues.DRYTURTLES_IMGSIZE_VALUES.length; i++) {
			background.add(new DryTurtle(EasyLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], EasyLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], EasyLevelValues.DRYTURTLES_XPOS_VALUES[i], EasyLevelValues.DRYTURTLES_YPOS_VALUES[i], EasyLevelValues.DRYTURTLES_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < EasyLevelValues.WETTURTLES_IMGSIZE_VALUES.length; i++) {
			background.add(new WetTurtle(EasyLevelValues.WETTURTLES_IMGSIZE_VALUES[i], EasyLevelValues.WETTURTLES_IMGSIZE_VALUES[i], EasyLevelValues.WETTURTLES_XPOS_VALUES[i], EasyLevelValues.WETTURTLES_YPOS_VALUES[i], EasyLevelValues.WETTURTLES_SPEED_VALUES[i]));
		}
		
		background.add(player); 
		
//		for (int i = 0; i < EasyLevelValues.CARS_IMG_VALUES.length; i++) {
//			background.add(CarFactory.createActor (EasyLevelValues.CARS_IMG_VALUES[i], EasyLevelValues.CARS_IMGSIZE_VALUES[i], EasyLevelValues.CARS_IMGSIZE_VALUES[i],
//											   EasyLevelValues.CARS_XPOS_VALUES[i], EasyLevelValues.CARS_YPOS_VALUES[i], 
//											   EasyLevelValues.CARS_SPEED_VALUES[i]));
//		}
//		
//		for (int i = 0; i < EasyLevelValues.TRUCKS_IMG_VALUES.length; i++) {
//			background.add(TruckFactory.createActor(EasyLevelValues.TRUCKS_IMG_VALUES[i], EasyLevelValues.TRUCKS_IMGSIZE_VALUES[i],
//					   EasyLevelValues.TRUCKS_IMGSIZE_VALUES[i], EasyLevelValues.TRUCKS_XPOS_VALUES[i], EasyLevelValues.TRUCKS_YPOS_VALUES[i],
//					   EasyLevelValues.TRUCKS_SPEED_VALUES[i]));
//		}
		
	}
}
