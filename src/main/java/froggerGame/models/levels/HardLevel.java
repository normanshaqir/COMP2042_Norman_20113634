package froggerGame.models.levels;
import froggerGame.constants.HardLevelValues;
import froggerGame.models.actors.DryTurtle;
import froggerGame.models.actors.WetTurtle;

public class HardLevel extends Level {
	public void spawnActors() {
		for (int i = 0; i < HardLevelValues.LOGS_IMG_VALUES.length; i++) {
			background.add(LogFactory.createActor(HardLevelValues.LOGS_IMG_VALUES[i], HardLevelValues.LOGS_IMGSIZE_VALUES[i],
											  HardLevelValues.LOGS_IMGSIZE_VALUES[i], HardLevelValues.LOGS_XPOS_VALUES[i], 
											  HardLevelValues.LOGS_YPOS_VALUES[i], HardLevelValues.LOGS_SPEED_VALUES[i]));

		}
		
		for (int i = 0; i < HardLevelValues.DRYTURTLES_IMGSIZE_VALUES.length; i++) {
			background.add(new DryTurtle(HardLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], HardLevelValues.DRYTURTLES_IMGSIZE_VALUES[i], HardLevelValues.DRYTURTLES_XPOS_VALUES[i], HardLevelValues.DRYTURTLES_YPOS_VALUES[i], HardLevelValues.DRYTURTLES_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < HardLevelValues.WETTURTLES_IMGSIZE_VALUES.length; i++) {
			background.add(new WetTurtle(HardLevelValues.WETTURTLES_IMGSIZE_VALUES[i], HardLevelValues.WETTURTLES_IMGSIZE_VALUES[i], HardLevelValues.WETTURTLES_XPOS_VALUES[i], HardLevelValues.WETTURTLES_YPOS_VALUES[i], HardLevelValues.WETTURTLES_SPEED_VALUES[i]));
		}
		
		background.add(player);
		
		for (int i = 0; i < HardLevelValues.CARS_IMG_VALUES.length; i++) {
			background.add(CarFactory.createActor (HardLevelValues.CARS_IMG_VALUES[i], HardLevelValues.CARS_IMGSIZE_VALUES[i], HardLevelValues.CARS_IMGSIZE_VALUES[i],
											   HardLevelValues.CARS_XPOS_VALUES[i], HardLevelValues.CARS_YPOS_VALUES[i], 
											   HardLevelValues.CARS_SPEED_VALUES[i]));
		}
		
		
		for (int i = 0; i < HardLevelValues.TRUCKS_IMG_VALUES.length; i++) {
			background.add(TruckFactory.createActor(HardLevelValues.TRUCKS_IMG_VALUES[i], HardLevelValues.TRUCKS_IMGSIZE_VALUES[i],
					   HardLevelValues.TRUCKS_IMGSIZE_VALUES[i], HardLevelValues.TRUCKS_XPOS_VALUES[i], HardLevelValues.TRUCKS_YPOS_VALUES[i],
					   HardLevelValues.TRUCKS_SPEED_VALUES[i]));
		}

		
	}
}
