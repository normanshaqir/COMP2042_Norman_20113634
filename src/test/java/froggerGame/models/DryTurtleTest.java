package froggerGame.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javafx.embed.swing.JFXPanel;

class DryTurtleTest {
	DryTurtle turtle;
	JFXPanel jfxPanel = new JFXPanel();
	
	@Test
	public void testDryTurtle() {
		DryTurtle turtle = new DryTurtle(300, 300, 400, 656, -1);
	}

	@Test
	public void testGetLeftDespawnPos() {
		DryTurtle turtle = new DryTurtle(300, 300, 400, 656, -1);
		assertEquals(turtle.getLeftDespawnPos(), -75);
	}

	@Test
	public void testSetLeftDespawnPos() {
		DryTurtle turtle = new DryTurtle(300, 300, 400, 656, -1);
		turtle.setLeftDespawnPos(-40);
		assertEquals(turtle.getLeftDespawnPos(), -40);
	}

	@Test
	public void testGetRightDespawnPos() {
		DryTurtle turtle = new DryTurtle(300, 300, 400, 656, -1);
		assertEquals(turtle.getRightDespawnPos(), 600);
	}

	@Test
	public void testSetRightDespawnPos() {
		DryTurtle turtle = new DryTurtle(300, 300, 400, 656, -1);
		turtle.setRightDespawnPos(660);
		assertEquals(turtle.getRightDespawnPos(), 660);
	}
}
