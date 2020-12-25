package froggerGame.models.actors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import froggerGame.constants.ActorImages;

class LogTest {
	Log log;
	JFXPanel jfxPanel = new JFXPanel();
	
	@Test
	void testLog() {
		log = new Log(ActorImages.IMG_LOG_3, 150, 300, 200, -2);
		assertEquals(log.getRightDespawnPos(), 600);
		assertEquals(log.getLeftDespawnPos(), -300);
		assertEquals(log.getRightRespawnPos(), -180);
		assertEquals(log.getLeftRespawnPos(), 700);
	}
	
	@Test
	void testGetSpeed() {
		log = new Log(ActorImages.IMG_LOG_3, 150, 300, 200, -2);
		assertEquals(log.getSpeed(), -2);
	}

	@Test
	void testSetSpeed() {
		log = new Log(ActorImages.IMG_LOG_3, 150, 300, 200, -2);
		log.setSpeed(5);
		assertEquals(log.getSpeed(), 5);
	}

	@Test
	void testGetWidth() {
		log = new Log(ActorImages.IMG_LOG_3, 150, 300, 200, -2);
		assertEquals(log.getWidth(), 150);
	}
}
