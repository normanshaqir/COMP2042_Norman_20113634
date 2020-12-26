package froggerGame.actorFactory;
/**
 * <h1>FactoryProducer</h1>
 * <p>
 * Besides the interface {@code AbstractActorFactory}, this class is an integral part of the
 * factory design pattern. Based on the input it receives, it will create a <A>Factory, where <A> is the 
 * valid input string containing the name of one of the classes.
 * </p>
 * @author hfyns3
 *
 */
public class FactoryProducer {
	/**
	 * This method will return an {@code AbstractActorFactory}, the interface of which is used to
	 * link all the class factories together. With this, the client code need not know what what class the 
	 * factory is (i.e.the factory that creates logs could have been named Lumberjack, but the client code only needs to
	 * request for a factory that produces logs). To the client, the factory returned is just an {@code AbstractActorFactory}.
	 * 
	 * @param actorClass -- string containing a factory name
	 * @return factory -- return a factory or null
	 */
	public static AbstractActorFactory getFactory (String actorClass) {
		switch (actorClass) {
			case "LOG":
				return new LogFactory();

			case "CAR":
				return new CarFactory();

			case "TRUCK":
				return new TruckFactory();

			default:
				return null;
		}
	
	}
}
