package froggerGame.models.actors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
/**
 * <h1>PlayerTest</h1>
 * <p>This test class aims to verify the validity of the {@code Player} class's methods handling 
 * its points and lives mechanics</p>
 * 
 * @see froggerGame.models.actors.Actor
 * 
 * @author hfyns3
 *
 */

class PlayerTest {
	Player player;
	JFXPanel jfxPanel = new JFXPanel();
	
	/**
	 * Check if upon initialisation that the player's points are set to 0.
	 */
	
	@Test
	void testGetPoints() {
		player = Player.getInstance();
		assertEquals(player.getPoints(), 0);

	}
	
	/**
	 * Check if player's lives are set to 5 at the very start after player initialisation
	 */
	
	@Test
	void testGetLives() {
		player = Player.getInstance();
		assertEquals(player.getLives(), 5);
		
	}
	
	/**
	 * Check that after calling {@code respawnPlayer()} that the player's lives are decremented by one
	 * and thhat the player is sent back to its spawn point
	 */
	
	@Test
	void testRespawnPlayer() {
		player = Player.getInstance();
		player.respawnPlayer();
		assertEquals(300, player.getX());
		assertEquals(4, player.getLives());
	}

}
