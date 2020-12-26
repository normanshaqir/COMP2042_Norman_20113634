package froggerGame.actorFactory;

import froggerGame.models.actors.Actor;

/**
 * <h1>AbstractActorFactory</h1>
 * <p>
 * This interface which is used by {@code CarFactory, LogFactory, TruckFactory} to implement the abstract factory
 * design pattern. With the abstract factory design pattern, the client clode ({@code Level}) does not need to know
 * the process behind the creation of the objects. 
 * 
 * The details are hidden from the client, decreasing coupling between classes, as well as applying 
 * the Single Responsibility Principle. In future implementations, new actors/mobs can also be added without
 * having to rewrite the preexisting code, achieving the Open/Closed principle.
 * </p>
 * @see froggerGame.actorFactory.CarFactory
 * 
 * @author hfyns3
 * 
 *
 */

public interface AbstractActorFactory {
	/**
	 * All classes that implement the {@code AbstractActorFactory} class must implement this method.
	 * This method has the usual paramaters used to create an Actor object, and in turn will return an Actor object.
	 * 
	 * As Car/Log/Truck extend {@code MovingActor} which extends {@code Actor}, polymorphism is used here, allowing for
	 * simplicity of code, as well as increasing the abstraction of the code.
	 * @param w -- width of the object
	 * @param h -- height of the object
	 * @param xpos -- set x-coordinate of the object
	 * @param ypos -- set y-coordinate of the object
	 * @param s -- speed of the object
	 * @return actor -- an actor object produced by the input arguments
	 */
	Actor createActor(String name, int w, int h, int xpos, int ypos, double speed);
	
}
