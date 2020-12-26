package froggerGame.models.actors;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javafx.embed.swing.JFXPanel;

/**
 * <h1>MovingActor</h1>
 * <p>
 * This test class tests the methods related to despawning and respawning in {@code DryTurtle} and by inheritance
 * {@code MovingActor}.
 * </p>
 * 
 * @see froggerGame.models.actors.MovingActor
 * @author hfyns3
 *
 */

class DryTurtleTest {
	DryTurtle turtle;
	JFXPanel jfxPanel = new JFXPanel();
	
	/**
	 * Check if {@code getLeftDespawnPos()} returns the correct left despawn position value initialised in 
	 * the constructor call
	 */
	@Test
	public void testGetLeftDespawnPos() {
		DryTurtle turtle = new DryTurtle(300, 300, 400, 656, -1);
		assertEquals(turtle.getLeftDespawnPos(), -75);
	}
	
	/**
	 * Check if {@code setLeftDespawnPos()} correctly modifies the left despawn position value to the new value.
	 */
	
	@Test
	public void testSetLeftDespawnPos() {
		DryTurtle turtle = new DryTurtle(300, 300, 400, 656, -1);
		turtle.setLeftDespawnPos(-40);
		assertEquals(turtle.getLeftDespawnPos(), -40);
	}
	
	/**
	 * Check if {@code getRightDespawnPos()} returns the correct right despawn position value initialised in 
	 * the constructor call
	 */
	
	@Test
	public void testGetRightDespawnPos() {
		DryTurtle turtle = new DryTurtle(300, 300, 400, 656, -1);
		assertEquals(turtle.getRightDespawnPos(), 600);
	}
	
	/**
	 * Check if {@code setRightDespawnPos()} correctly modifies the right despawn position value to the new value.
	 */
	
	@Test
	public void testSetRightDespawnPos() {
		DryTurtle turtle = new DryTurtle(300, 300, 400, 656, -1);
		turtle.setRightDespawnPos(660);
		assertEquals(turtle.getRightDespawnPos(), 660);
	}
}
