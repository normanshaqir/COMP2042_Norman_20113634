package froggerGame.models.actors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import froggerGame.constants.ActorImages;
/**
 * <h1>LogTest</h1>
 * <p>This JUnit test class tests methods related to movement within of {@code Log} and by inheritance <@code MovingActor>.</p>
 * @see froggerGame.models.actors.Log
 * @see froggerGame.models.actors.MovingActor
 * @author hfyn3
 *
 */
class LogTest {
	Log log;
	JFXPanel jfxPanel = new JFXPanel();
	
	/**
	 * Check that the despawn and respawn positions respectively are set correctly
	 */
	@Test
	void testLog() {
		log = new Log(ActorImages.IMG_LOG_3, 150, 300, 200, -2);
		assertEquals(log.getRightDespawnPos(), 600);
		assertEquals(log.getLeftDespawnPos(), -300);
		assertEquals(log.getRightRespawnPos(), -180);
		assertEquals(log.getLeftRespawnPos(), 700);
	}
	
	/**
	 * Check if the {@code getSpeed()} method returns the same speed value initialised in the constructor
	 */
	
	@Test
	void testGetSpeed() {
		log = new Log(ActorImages.IMG_LOG_3, 150, 300, 200, -2);
		assertEquals(log.getSpeed(), -2);
	}
	
	/**
	 * Check if the {@code setSpeed(int speed)} method changes the {@code speed} field in {@code Log}
	 */
	
	@Test
	void testSetSpeed() {
		log = new Log(ActorImages.IMG_LOG_3, 150, 300, 200, -2);
		log.setSpeed(5);
		assertEquals(log.getSpeed(), 5);
	}
	
	/**
	 * Check if the {@code getWidth()) method returns the same width value initialised in the constructor
	 */
	@Test
	void testGetWidth() {
		log = new Log(ActorImages.IMG_LOG_3, 150, 300, 200, -2);
		assertEquals(log.getWidth(), 150);
	}
}
