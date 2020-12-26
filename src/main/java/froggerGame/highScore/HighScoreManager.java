package froggerGame.highScore;

import java.util.*;
import java.io.*;
/**
 * <h1>HighScoreManager</h1>
 * <p>
 * This class is used to manage the high scores stored in the binary file (.dat), which contain 10 high scores.
 * The file is read and the scores are sorted through upon execution, and the new high score value is inputted 
 * with the usage of {@code setName} and {@code addScore(name, score)}.
 * 
 * The list of high scores are printed out at the end of the game on the alertbox as well as in the gameOverScreen.
 * 
 * It should be noted that the high scores are <b>permanent</b> as they are stored in a file.
 * </p>
 *
 */
public class HighScoreManager {

    private ArrayList<Score> scores;
    
    private static String username;

    
    private static final String HIGHSCORE_FILE = "src/main/java/froggerGame/highScore/scores.dat";
    /**
     * Will only store 10 scores in the file.
     */
    private static final int max = 10;

    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public HighScoreManager() {
        //initialising the scores-arraylist
        scores = new ArrayList<Score>();
        
    }
    /**
     * This method is used in order to take in and store the user input value from the userScreen view.
     * @param username
     */
    public static void setName(String username) {
    	HighScoreManager.username = username;
    }
    /**
     * The score file is loaded in and sorted through.
     * @return
     */
    public ArrayList<Score> getScores() {
        loadScoreFile();
        sort();
        return scores;
        
    }
    /** Create a ScoreComparator and use it alongside 
     * Collections to sort through the scores from the file.
     */
    private void sort() {
        ScoreComparator comparator = new ScoreComparator();
        Collections.sort(scores, comparator);
        
    }
    /**
     * Adds a score into the score file using the string value set in the username field, which was previously
     * taken from the name input box in the userScreen.
     * @param name
     * @param score
     */
    public void addScore(String name, int score) {
        loadScoreFile();
        scores.add(new Score(HighScoreManager.username, score));
        updateScoreFile();
        
    }
    /**
     * Loads the score file
     */
    public void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[Load] FNF Error: " + e.getMessage());
            
        } catch (IOException e) {
            System.out.println("[Load] IO Error: " + e.getMessage());
            
        } catch (ClassNotFoundException e) {
            System.out.println("[Load] CNF Error: " + e.getMessage());
            
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                    
                }
            } catch (IOException e) {
                System.out.println("[Load] IO Error: " + e.getMessage());
                
            }
        }
    }
    /**
     * Updates the high scores in the score file
     */
    public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
            
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ", the program will try and make a new file");
            
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
            
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                    
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
                
            }
        }
    }
    /** 
     * Gets the high score string to print (all 10 high scores)
     * @return
     */
    public String getHighscoreString() {
        String highscoreString = "";
        ArrayList<Score> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        
        if (x > max) {
            x = max;
        }
        while (i < x) {
        	String name = scores.get(i).getName();
        	int score = scores.get(i).getScore();
        	int lengthOfName = name.length()+1;
            highscoreString += String.format("%1$-" + 4 + "s", (i+1)+".") + String.format("%1$-" + lengthOfName + "s", name) + String.format("%1$-" + 4 + "s", score) + "\n";
            i++;
        }
		return highscoreString;
        
    }
}