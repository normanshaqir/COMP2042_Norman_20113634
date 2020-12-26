# Meaningful Additions and Changes Made

1. Extensive Javadocs addition
2. Implemented Maven build files
3. Created JUnit tests 
4. Heavily improved code abstraction throughout the program
5. Repackaged all assetss and classes into their own packages, making it more organised.
6. Implemented MVC design pattern
7. Refactored classes and removed redundant comments
8. Added a main menu, an info screen, and name screen.
9. Added various difficulties that the player can choose to play
10. Implemented a permanent high score list containing 10 hihg scores
11. Implemented Abstract Factory design pattern

# Key Refactorings

1. maven project -> buildfiles for easier dependency management
2. Renamed Animal class to Player for clarity 
3. modified image instantiating in Player, Log, Obstacle classes to reduce memory usage
4. implemented singleton design pattern within Player (rudimentary)
5. decluttered existing comments
6. edited background image, fixed background image in game level
7. modified movement animation when near bounds
8. implemented encapsulation (private fields) in Player and Turtles... WIP
9. replaced hard-coded values with method calls increasing abstraction (Replace Parameter with Method Call)
10. Improved code abstraction by including constants for filenames for all images -- hiding details from the main class
11. Implemented Car and Truck class (improving abstraction and reducing coupling)
12. Reused getIntersectingObjects method in getOneIntersectingObject method in Actor class.
13. Replaced some getIntersectingObjects method calls in Actor class with getOneIntersectingObject.
14. Extract Subclass/Pull Up Field/Pull Up Method - Created subclass AnimActor for Actors that are animated, and removed act method from classes that do not use it.
15. Removed redundant method getLeft from Log class
16. Extract Method - Implemented despawnAndRespawnAnimActor method
17. Extract Interface - Renamed Turtle class to DryTurtle and implemented Turtle interface containing animateTurtle method.
18. Removed unused act method in World
19. Extract Method - Grouped chunks of code in Player into methods
20. Implemented Maven build files
21. Implemented prototype Lives mechanic -- awaiting UI design
22. Partial implementation of new class Crocodile mob.
23. Removed duplicate code in conditionals in WetTurtle and Player
23. Decoupled music from Stage
24. Completed Crocodile mob. Partial implementation of Factory design pattern in Level
25. Slight expansion on Factory design pattern amongst Actors
26. Implemented lives in UI, abstracted Levels further
27. IMplemented Javadocs and JUnit testing


# How To Install

1. Download the .zip
2. Extract the .zip and go to SM_assignfrogger
3. Ensure that you are running on Maven v3.6.3, JavaFX 11 a`and
JDK 13.0.2 or higher
4. You can start the game by using the a) command prompt or by using b) eclipse.   
    
    1a) Open the command prompt and change directory to the directory containing the pom.xml
    
    2a) Type the commands 'mvn clean install' and then 'mvn exec:java'
    
    3a) The game will now run.
    ==========================
    
    1b) Go to File > Import > Existing Maven Project. Then locate the project folder and import it and select all resources within the folder.
    
    2b) Let it install. It will throw errors in the meantime, so please wait.
    
    3b) After installation, right click on the project folder (SM_assignfrogger) and go to Run As > Run Configuration. Then right click on Maven Build and create a new Maven Configuration. 
    
    4b) Within the Maven Configuration, simply type 'exec:java' in the goals field.
    
    5b) Then apply and run.
    
    6b) The game will now run.

# Game Screens

![Screenshot:](/READMEassets/mainMenu.png?raw=true "main menu")
![Screenshot:](/READMEassets/infoScreen.png?raw=true "info screen")
![Screenshot:](/READMEassets/userScreen.png?raw=true "user screen")
![Screenshot:](/READMEassets/levelScreen.png?raw=true "level screen")
![Screenshot:](/READMEassets/gameOverScreen.png?raw=true "game over screen")