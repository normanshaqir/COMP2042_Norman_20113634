package actors;

public class Digit extends Actor {
	
	public Digit(int n, int imgSize, int x, int y) { // constructor for images used in score
		super("file:src/main/resources/digits/"+n+".png", imgSize, imgSize, x, y);
		
	}
	
}
