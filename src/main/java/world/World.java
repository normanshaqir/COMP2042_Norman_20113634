package world;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import actors.Actor;
import actors.MovingActor;


public class World extends Pane {
    private AnimationTimer timer;
    
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

    public void createTimer() { // called in World start() method, in MyStage
        timer = new AnimationTimer() { // creates a List containing all Actors and calls act method
            @Override
            public void handle(long now) {
                List<MovingActor> actors = getObjects(MovingActor.class);
                
                for (MovingActor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

    public void start() {
    	createTimer(); 
        timer.start(); // starts AnimationTimer for all actors in the game e.g. background.start()
    }

    public void stop() {
        timer.stop();
    }
    
    public void add(Actor actor) { // adds actor (from sprites to background image)
        getChildren().add(actor);
    }

    public void remove(Actor actor) { // removes actor (garbage collection?)
        getChildren().remove(actor);
    }

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
