package froggerGame.highScore;

import java.io.Serializable;

public class Score implements Serializable {
    private int score;
    private String name;

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

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