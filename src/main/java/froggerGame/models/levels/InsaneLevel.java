package froggerGame.models.levels;

import froggerGame.constants.InsaneLevelValues;
import froggerGame.models.actors.DryTurtle;
import froggerGame.models.actors.WetTurtle;

/**
 * <h1>InsaneLevel</h1>
 * <p>
 * This class extends the abstract class {@code Level}, implementing the superclass abstract method {@code spawnActors()}. 
 * The system prommotes the usage of polymorphism, as well as inheritance as the {@code InsaneLevel} class simply implements
 * spawn actors; afterwards it can be treated as a {@class Level} class and call all of the methods within {@class Level}
 * </p>
 * 
 * @see froggerGame.models.levels.level
 * 
 * @author hfyns3
 *
 */

public class InsaneLevel extends Level {
	public void spawnActors() {
		/**
		 * Spawns actors based on the constant values stored in the class {@code InsaneLevelValues}. The constants can be modified
		 * in the mentioned class previously, hiding the details from the client code. It also allows for the reduction of duplicate code,
		 * as with the {@AbstractActorFactory} design pattern, can create multiple actors and add them to the scene with the use
		 * of a for loop; in comparison to the previous method of implementation, which was to add each actor individually.
		 */
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
