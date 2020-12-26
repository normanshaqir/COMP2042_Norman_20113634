package froggerGame.models.actors;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
 

import java.util.ArrayList;

import froggerGame.models.World;

/**
* <h1>Actor</h1>
* <p> 
* The actor class serves as the building block for all actors in the game space. 
* Its more relevant subclass {@code MovingActor} and interface {@code AnimatedActor} 
* extend the functionality of the Actor to include movement as well as animation.
* </p>
* @author hfyns3
*/

public class Actor extends ImageView {
	/**
	 * Creates an Actor object.
	 * @param filename - location of an image file
	 * @param w -- width of the object
	 * @param h -- height of the object
	 * @param xpos -- set x-coordinate of the object
	 * @param ypos -- set y-coordinate of the object
    */
    
	public Actor (String filename, int w, int h, int xpos, int ypos) {
		setImage(new Image(filename, w, h, true, true));
		setX(xpos);
		setY(ypos);
	}
	
	/**
	 * @return (World) getParent -- the parent of this node
	 */
	
    public World getWorld() { // getWorld(), getWidth(), getHeight() look like standard getter functions
        return (World) getParent();
    }
    
    /**
     * Returns the width of the {@code Actor} node previously invoked in the constructor
     * @return width
     */
    
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }
    
    /**
     * Returns the height of the {@code Actor} node previously invoked in the constructor
     * @return height
     */
    
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }
    
	/**
	 * 
	 * @param <A> -- any class that is a subclass of Actor
	 * @param cls -- any class that is a subclass of Actor
	 * 
	 * @return someArray -- ArrayList containing all {@code cls} objects 
	 */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){ // method used to return an ArrayList of other actors target actor is colliding with
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    /**
     * @see getIntersectingObjects
     * @param <A> -- any class that is a subclass of Actor
	 * @param cls -- any class that is a subclass of Actor
	 * 
     * @return the first element in the ArrayList provided by getIntersectingObjects
     */
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) { // method used to return one actor that actor is colliding/intersecting with
        return getIntersectingObjects(cls).get(0);
        
    }



}
