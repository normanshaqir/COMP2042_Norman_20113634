package models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
 

import java.util.ArrayList;


public class Actor extends ImageView{
	
	public Actor (String filename, int w, int h, int xpos, int ypos) {
		setImage(new Image(filename, w, h, true, true));
		setX(xpos);
		setY(ypos);
	}
	
    public void move(double dx, double dy) { // moves all actors/sprites by getting current coordinates and adding speed. 
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public World getWorld() { // getWorld(), getWidth(), getHeight() look like standard getter functions
        return (World) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){ // method used to return an ArrayList of other actors target actor is colliding with
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) { // method used to return one actor that actor is colliding/intersecting with
        return getIntersectingObjects(cls).get(0);
        
    }
    
    public void manageInput(InputEvent e) { //TODO:
        
    }


}
