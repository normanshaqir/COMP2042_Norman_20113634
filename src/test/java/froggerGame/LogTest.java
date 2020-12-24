package froggerGame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import froggerGame.constants.ActorImages;
import froggerGame.models.Log;

class LogTest {

	@Test
	public void testDespawnAndRespawnAnimActor() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetSpeed() {
		Log log = new Log(ActorImages.IMG_LOG_1, 150, 300, 500, -1); // TODO
		assertEquals(-1, log.getSpeed());
	}

	@Test
	public void testSetSpeed() {
		Log log = new Log(ActorImages.IMG_LOG_1, 150, 300, 500, -1); // TODO
		log.setSpeed(30);
		assertEquals(30, log.getSpeed());
	}

	@Test
	public void testGetWidth() {
		Log log = new Log(ActorImages.IMG_LOG_1, 150, 300, 500, -1); // TODO
		assertEquals(150, log.getWidth());
	}

	@Test
	public void testGetHeight() {
		Log log = new Log(ActorImages.IMG_LOG_1, 150, 300, 500, -1); // TODO
		assertEquals(300, log.getHeight());
	}

}
