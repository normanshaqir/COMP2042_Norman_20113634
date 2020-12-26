package froggerGame.highScore;

import java.io.Serializable;

/**
 * <h1>Score</h1>
 * <p>
 * Ths class serves to merge a String value and an int value into one {@code Score} object.
 * </p>
 *
 */

public class Score implements Serializable {
    private int score;
    private String name;

   /**
    * Return integer score value
    * @return score -- integer score value
    */
    
    public int getScore() {
        return score;
    }
    
    /**
     * Return String name value
     * @return name -- String name value
     */
    public String getName() {
        return name;
    }

    /**
     * This constructor assigns the parameters name and score to the respective fields in this class.
     * Exception handling is included in the form of:
     * <li>
     *  <ul>A score should not exceed more than 800, if it does, set it to 800.</ul>
     *  <ul>A score should not be negative, if it does, set it to 0.</ul>
     * </li>
     * @param name -- name of player for this score
     * @param score -- value of points player scored
     */
    
    public Score(String name, int score) {    
    	
        if (score > 800) {
        	this.score = 800;
        } else if (score < 0) {
        	this.score = 0;
        } else {
        	this.score = score;
        }
       
        this.name = name;
    }
}