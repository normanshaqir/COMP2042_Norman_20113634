package froggerGame.highScore;

import java.util.Comparator;
/**
 * <h1>ScoreComparator</h1>
 * <p>
 * Implements the Comparator interface, which enables comparing between scores and in turn sorting of the
 * scores by descending order.
 * </p>
 * 
 *
 */

public class ScoreComparator implements Comparator<Score> {

		/**
		 * This method compares between two scores and returns an integer value indicating whether
		 * a score is greater or lesser than another.
		 * 
		 * By default the {@code compare} method in Comparator sorts values by ascending order.
		 * In order to sort it by descending order, the return values {@code -1, 0, 1} are flipped.
		 * 
		 * @param score1 -- {@code Score} object storing String value name and int value score
		 * @param score2 -- {@code Score} object storing String value name and int value score
		 */
        public int compare(Score score1, Score score2) {
        	
            int sc1 = score1.getScore();
            int sc2 = score2.getScore();

            if (sc1 > sc2) {
                return -1;
                
            } else if (sc1 < sc2) {
                return 1;
                
            } else {
                return 0;
                
            }
        }
}