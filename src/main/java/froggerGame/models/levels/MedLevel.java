package froggerGame.models.levels;

import froggerGame.constants.MedLevelValues;
import froggerGame.models.actors.Crocodile;
import froggerGame.models.actors.DryTurtle;
import froggerGame.models.actors.WetTurtle;

/**
 * <h1>MedLevel</h1>
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

public class MedLevel extends Level {
	public void spawnActors() {
		/**
		 * Spawns actors based on the constant values stored in the class {@code MedLevelValues}. The constants can be modified
		 * in the mentioned class previously, hiding the details from the client code. It also allows for the reduction of duplicate code,
		 * as with the {@AbstractActorFactory} design pattern, can create multiple actors and add them to the scene with the use
		 * of a for loop; in comparison to the previous method of implementation, which was to add each actor individually.
		 */
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
