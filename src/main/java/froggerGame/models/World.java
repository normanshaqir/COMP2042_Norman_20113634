package froggerGame.models;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;


import froggerGame.models.actors.*;
/**
 * <h1>World</h1>
 * <p>
 * The {@code World} class is the most fundamental class in the Frogger game. It sets the scene for actors
 * to be added to, as well as manage the AnimationTimer, of which actors beside the {@code Player} are linked to.
 * 
 * When the AnimationTimer starts, all actors start moving/animating. When it stops, all actors stop acting. 
 * </p>
 * 
 * @see froggerGame.models.levels
 * @author hfyns3
 * 
 *
 */
public class World extends Pane {
    private AnimationTimer timer;
    /**
     * When the constructor is invoked, add listeners that listen for key presses and in turn key releases. This detects
     * the key presses made by the player alongside every other {@code Actor} in the scene. This is evident from 
     * the {@code getObject()} method call, which passes the argument {@code Actor.class} to the method.
     */
    public World() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() { // seems to be detection of key presses and releases, and handling of those events

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }
    /**
     * Creates an AnimationTimer and links it with a list containing all moving actors in the scene.
     * It then calls {@code act(now)} on all actors in the list, where now is time in nanoseconds.
     */
    
    public void createTimer() { 
        timer = new AnimationTimer() { 
            @Override
            public void handle(long now) {
                List<MovingActor> actors = getObjects(MovingActor.class);
                
                for (MovingActor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }
    
    /**
     * Starts the AnimationTimer previously created in {@code createTimer()}.
     *  In other words, all actors will start moving and animate after this method is called.
     */
    
    public void start() {
    	createTimer(); 
        timer.start();
    }
    
    /**
     * Stops the AnimationTimer. All actors (besides the player) stop moving.
     */
    
    public void stop() {
        timer.stop();
    }
    
    /**
     * Adds an actor object.
     * @param actor -- name of actor object to be added
     */
    
    public void add(Actor actor) { 
        getChildren().add(actor);
    }
    
    /**
     * Removes an actor object.
     * @param actor -- name of actor object to be removed
     */
    
    public void remove(Actor actor) { 
        getChildren().remove(actor);
    }
    
    /**
     * Returns an ArrayList containing class A
     * @param <A> -- any class that extends actor
     * @param cls -- the name of the class that extends actor
     * @return someArray -- containing all nodes of class A
     */
    
    public <A extends Actor> List<A> getObjects(Class<A> cls) { // get an ArrayList of objects of the same class
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }
}
