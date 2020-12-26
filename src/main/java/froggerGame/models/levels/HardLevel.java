package froggerGame.models.levels;

import froggerGame.constants.HardLevelValues;
import froggerGame.models.actors.DryTurtle;
import froggerGame.models.actors.WetTurtle;

/**
 * <h1>HardLevel</h1>
 * <p>
 * This class extends the abstract class {@code Level}, implementing the superclass abstract method {@code spawnActors()}. 
 * The system prommotes the usage of polymorphism, as well as inheritance as the {@code HardLevel} class simply implements
 * spawn actors; afterwards it can be treated as a {@class Level} class and call all of the methods within {@class Level}
 * </p>
 * @see froggerGame.models.levels.level
 * 
 * @author hfyns3
 *
 */

public class HardLevel extends Level {
	/**
	 * Spawns actors based on the constant values stored in the class {@code HardLevelValues}. The constants can be modified
	 * in the mentioned class previously, hiding the details from the client code. It also allows for the reduction of duplicate code,
	 * as with the {@AbstractActorFactory} design pattern, can create multiple actors and add them to the scene with the use
	 * of a for loop; in comparison to the previous method of implementation, which was to add each actor individually.
	 */
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
