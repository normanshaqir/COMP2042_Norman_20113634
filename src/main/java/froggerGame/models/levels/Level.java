package froggerGame.models.levels;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

import froggerGame.Main;
import froggerGame.actorFactory.AbstractActorFactory;
import froggerGame.actorFactory.FactoryProducer;
import froggerGame.constants.ActorImages;

import froggerGame.highScore.*;
import froggerGame.models.World;
import froggerGame.models.actors.BackgroundImage;
import froggerGame.models.actors.Digit;
import froggerGame.models.actors.End;
import froggerGame.models.actors.Player;

/**
 * <h1>Level</h1>
 * <p>
 * This abstract class serves as the base for other levels to build on. 
 * 
 * Other level classes {@code EasyLevel, MedLevel, HardLevel, InsaneLevel} correspond to different
 * difficulties. Any subclasses of the {@code Level} class has to implement the {@code spawnActors()} method.
 * 
 * The levels subclasses use a class containing constant values to implement the {@code spawnActors()} method.
 * 
 * This class demonstrates the OOP principle of inheritance as well as polymorphism. Code has been abstracted
 * in such a way that future developers can work on this game and create new levels without a hassle.
 * </p>
 * @see froggerGame.constants.EasyLevelValues
 * @see froggerGame.constants.MedLevelValues
 * @see froggerGame.constants.HardLevelValues
 * @see froggerGame.constants.InsaneLevelValues
 * 
 * 
 * @author hfyns3
 *
 */

public abstract class Level { 
	AnimationTimer timer;
	World background = new World();
	Scene scene  = new Scene(background, 600, 800);
	HighScoreManager hm = new HighScoreManager();
	
	/** The {@code Player} class abides by the Singleton design pattern, hence to instantiate an instance of the 
	 * player, the {@code getInstance()} method needs to be called.
	 * 
	 * @see froggerGame.models.actors.Player
	 */
	
	Player player = Player.getInstance();
	
	/** This field contains a {@code LogFactory}, which is created by the {@code FactoryProducer}.
	 *  @see froggerGame.actorFactory
	 */
	
	AbstractActorFactory LogFactory = FactoryProducer.getFactory("LOG");
	
	/** This field contains a {@code CarFactory}, which is created by the {@code FactoryProducer}.
	 *  @see froggerGame.actorFactory
	 */
	
	AbstractActorFactory CarFactory = FactoryProducer.getFactory("CAR");
	
	/** This field contains a {@code TruckFactory}, which is created by the {@code FactoryProducer}.
	 *  @see froggerGame.actorFactory
	 */
	
	AbstractActorFactory TruckFactory = FactoryProducer.getFactory("TRUCK");
	
	public abstract void spawnActors();
	
	/**
	 * Corresponds to the player's AnimationTimer. It is important to note that {@code background.start()}
	 * is not equivalent to {@code start()}. The former will start the animation timer in the level
	 * and the latter starts the AnimationTimer the player uses.
	 */
	public void start() { 
    	createTimer();
        timer.start();
        
    }
	/**
	 * Stops the AnimationTimer used in {@code World}, which connects all actors together
	 * and animates them.
	 * 
	 * @see froggerGame.models.World
	 */
	
	public void stop() { // GAME END (stop animationtimer)
		
		timer.stop();


    }
	
	/**
	 * Creates the timer for the {@code World}, which will be used by
	 * every other actor in the scene besidesthe player.
	 * 
	 * Handles four different cases, when the player's score is to be changed, when the player died
	 * and a life should be deducted, as well as when the game is over -- either by loss or win in the form of
	 * when the player has no lives left or the player has filled all five end holes.
	 */
	
	public void createTimer() { // manages score. need animationtimer to increment score 

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
				if (player.changeScore()) { // calls setNumber function to display score
            		setScore(Player.getPoints());
            	}
				if (player.didPlayerDie()) {
					setLives(player.getLives()-1);
				}
				if (player.getLives() == 0) {

		    		Alert alert = new Alert(AlertType.INFORMATION);
		    		alert.setTitle("GAME OVER!");
		    		handleGameOver(alert);
				}
				
            	if (player.getStop()) { // game over
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		handleGameOver(alert);
            
            	}
            }
        };
    }
	
	/**
	 * There are only two game over flags -- when lives are == 0 and the player fills all five end holes.
	 * When either happen, stop AnimationTimers for both {@code Player} and actors in the world respectively.
	 * 
	 * Then the alert details will be set, showing all 10 high scores read from a permanent binary file.
	 * The player now has the option to click on 'OK' in the alert box. 
	 * When 'OK' is clicked, {@code switchToGameOverScreen} is called, closing 
	 * the alert box and switching the scene to the game over scene.
	 * 
	 * @see froggerGame.highScore
	 * @param alert -- previously constructed alertbox in {@code createTimer}
	 */
	
	public void handleGameOver(Alert alert) {
		stop();
		background.stop();
		
		alert.setHeaderText(hm.getHighscoreString());
		alert.setContentText("Highest Possible Score: 800");
		alert.show();
		switchToGameOverScreen(alert);
	}
	
	/**
	 * Loads the gameOverScreen fxml view file from resources into the stage and switches 
	 * to the game over scene when the alertbox is closed ('OK' button is pressed')
	 * 
	 * @param alert -- previously constructed alertbox in {@code createTimer}
	 */
	
	public void switchToGameOverScreen(Alert alert) {
		Parent GameOverScreenParent = null;
		
		try {
			GameOverScreenParent = FXMLLoader.load(getClass().getResource("/fxml/gameOverScreen.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene root = new Scene(GameOverScreenParent);
		alert.setOnCloseRequest(e -> Main.getStage().setScene(root));	
		
	}
	/**
	 * Changes the real time score shown accordingly to the n value given.
	 * 
	 * @param n -- new score value to include
	 */
	
	public void setScore(int n) { // invokes Digit constructor to create a new image corresponding to current score (VISUAL)
    	int shift = 0;
    	
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 100 - shift, 28));
    		  shift+=30;
    		}
    }
	
	/**
	 * Adds the {@code Digit} object with n determining the number of lives the player has.
	 * @param n -- number of lives
	 */
	
	public void setLives(int n) {
		background.add(new Digit(n, 30, 265, 28));
	}  
	
	/**
	 * Calls createLevel() which handles the creation of the level -- initialises the background image, 
	 * places the {@code End} objects at the end, setting the score and lives display, and adds all actors to the scene.
	 * 
	 * Then, set the scene in the stage passed in the argument and show the scene. 
	 * Finally, start AnimationTimers for {@code World} and {@Player} respectively.
	 * 
	 * @param primaryStage -- the scene will be set in this stage
	 */
	
	public void startGame(Stage primaryStage) {
        createLevel();
		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		start(); 
	}
	
	/**
	 * Handlles the creation of the level.
	 * 
	 * Sets the background image, places the {@code End} objects at the end, 
	 * setting the score and lives display, and adds all actors to the scene.
	 */
	public void createLevel() {
		BackgroundImage gameBackground = new BackgroundImage(ActorImages.IMG_LEVEL_BACKGROUND);
		background.add(gameBackground);
		spawnEnds();
		spawnScoreAndLives();
		spawnActors();
		
	}
	/**
	 * Add five {@code End} objects to the specified x, y coordinates passed to the method in the arguments.
	 * Each (end) hole will be filled with a frog when the player/frog reaches it.
	 * 
	 * @see froggerGame.models.actors.End
	 */
	
	public void spawnEnds() {
		background.add(new End(13,96)); // End represent the boxes at the end of the map
		background.add(new End(141,96));
		background.add(new End(269,96));
		background.add(new End(398,96));
		background.add(new End(528,96));
	}
	
	/**
	 * Adds two {@code Digit} objects which correspond to the player's score and lives.
	 * Modification of these digits will be handled in {@code Player}, 
	 * {@code spawnScoreAndLives()} simply initialises the first image.
	 * 
	 * @see froggerGame.models.actors.Digit
	 * @see froggerGame.models.actors.Player
	 * @see froggerGame.models.actors.End
	 */
	public void spawnScoreAndLives() {
		background.add(new Digit(0, 30, 100, 28)); // Score
        background.add(new Digit(5, 30, 265, 28)); // Lives
	}
}
