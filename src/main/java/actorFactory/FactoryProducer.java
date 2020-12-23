package actorFactory;


public class FactoryProducer {
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
