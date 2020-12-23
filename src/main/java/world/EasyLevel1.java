package world;

import actors.Car;
import actors.Crocodile;
import actors.Digit;
import actors.DryTurtle;
import actors.End;
import actors.Log;
import actors.Player;
import actors.Truck;
import actors.WetTurtle;
import constants.ActorImages;
import javafx.stage.Stage;

public class EasyLevel1 extends Level {
	public void spawnActors() {
		BackgroundImage gameBackground = new BackgroundImage("file:src/main/resources/misc/background.png");
		background.add(gameBackground);
		
		background.add(new Log(ActorImages.IMG_LOG_3, 150, 0, 166,  0.75)); 
		background.add(new Log(ActorImages.IMG_LOG_3, 150, 220, 166, 0.75));
		background.add(new Log(ActorImages.IMG_LOG_3, 150, 440, 166,  0.75));

		background.add(new Log(ActorImages.IMG_LOG_1, 300, 0, 276, -2));
		background.add(new Log(ActorImages.IMG_LOG_1, 300, 400, 276, -2));
		
		//background.add(new Log(ActorImages.IMG_LOG_3, 150, 50, 329, 0.75));
		background.add(new Crocodile(138, 138, 50, 329, 0.75));
		background.add(new Log(ActorImages.IMG_LOG_3, 150, 270, 329, 0.75));
		background.add(new Log(ActorImages.IMG_LOG_3, 150, 490, 329, 0.75));
		
		background.add(new DryTurtle(130, 130, 500, 376, -1));
		background.add(new DryTurtle(130, 130, 300, 376, -1)); // create two turtles that never submerge (dry turtles)
		
		background.add(new WetTurtle(130, 130, 700, 376, -1));
		background.add(new WetTurtle(130, 130, 600, 217, -1)); 
		background.add(new WetTurtle(130, 130, 400, 217, -1));
		background.add(new WetTurtle(130, 130, 200, 217, -1)); // create four turtles that submerge (wet turtles)

		background.add(new End(13,96)); // End represent the boxes at the end of the map
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		
		player = Player.getInstance();
		background.add(player);
		
		background.add(new Car(ActorImages.IMG_CAR_LEFT_1, 50, 50, 500, 496, -5));
		
		background.add(new Truck(ActorImages.IMG_TRUCK_RIGHT_1, 120, 120,  0, 657, 1));
		background.add(new Truck(ActorImages.IMG_TRUCK_RIGHT_1, 120, 120, 300, 657, 1));
		background.add(new Truck(ActorImages.IMG_TRUCK_RIGHT_1, 120, 120, 600, 657, 1));
		
		background.add(new Car(ActorImages.IMG_CAR_LEFT_1, 50, 50,  100, 605, -1));
		background.add(new Car(ActorImages.IMG_CAR_LEFT_1, 50, 50, 250, 605, -1));
		background.add(new Car(ActorImages.IMG_CAR_LEFT_1, 50, 50, 400, 605, -1));
		background.add(new Car(ActorImages.IMG_CAR_LEFT_1, 50, 50,550, 605, -1));
		
		background.add(new Truck(ActorImages.IMG_TRUCK_RIGHT_2, 200, 200, 0, 548, 1));
		background.add(new Truck(ActorImages.IMG_TRUCK_RIGHT_2, 200, 200, 500, 548, 1));
		
		background.add(new Digit(0, 30, 360, 25));
		
	}
	
	public void startGame(Stage primaryStage) {
		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		start();
	}
}
