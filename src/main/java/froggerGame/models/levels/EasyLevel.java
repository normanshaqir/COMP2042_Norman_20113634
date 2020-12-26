package froggerGame.models.levels;

import froggerGame.constants.EasyLevelValues;
import froggerGame.models.actors.DryTurtle;
import froggerGame.models.actors.WetTurtle;

/**
 * <h1>EasyLevel</h1>
 * <p>
 * This class extends the abstract class {@code Level}, implementing the superclass abstract method {@code spawnActors()}. 
 * The system prommotes the usage of polymorphism, as well as inheritance as the {@code HardLevel} class simply implements
 * spawn actors; afterwards it can be treated as a {@class Level} class and call all of the methods within {@class Level}
 * </p>
 * 
 * @see froggerGame.models.levels.level
 * 
 * @author hfyns3
 *
 */

public class EasyLevel extends Level {
	/**
	 * Spawns actors based on the constant values stored in the class {@code EasyLevelValues}. The constants can be modified
	 * in the mentioned class previously, hiding the details from the client code. It also allows for the reduction of duplicate code,
	 * as with the {@AbstractActorFactory} design pattern, can create multiple actors and add them to the scene with the use
	 * of a for loop; in comparison to the previous method of implementation, which was to add each actor individually.
	 */
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
		
		for (int i = 0; i < EasyLevelValues.CARS_IMG_VALUES.length; i++) {
			background.add(CarFactory.createActor (EasyLevelValues.CARS_IMG_VALUES[i], EasyLevelValues.CARS_IMGSIZE_VALUES[i], EasyLevelValues.CARS_IMGSIZE_VALUES[i],
											   EasyLevelValues.CARS_XPOS_VALUES[i], EasyLevelValues.CARS_YPOS_VALUES[i], 
											   EasyLevelValues.CARS_SPEED_VALUES[i]));
		}
		
		for (int i = 0; i < EasyLevelValues.TRUCKS_IMG_VALUES.length; i++) {
			background.add(TruckFactory.createActor(EasyLevelValues.TRUCKS_IMG_VALUES[i], EasyLevelValues.TRUCKS_IMGSIZE_VALUES[i],
					   EasyLevelValues.TRUCKS_IMGSIZE_VALUES[i], EasyLevelValues.TRUCKS_XPOS_VALUES[i], EasyLevelValues.TRUCKS_YPOS_VALUES[i],
					   EasyLevelValues.TRUCKS_SPEED_VALUES[i]));
		}
		
	}
}
