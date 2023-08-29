/**
 * This class has 4 public methods
 *
 * @author snangia
 */

public class ScoringMethod {

    private int score;
    private String scoringType;

    // constructor
    public ScoringMethod(String team, int score, String scoringType) {

        //name of the play
        //how many points the play is worth
        this.score = score;
        this.scoringType = scoringType;

    }

    /**
     * getter for scoring type
     * @return  scoringType
     */
    public String getScoringType() {
        return scoringType;
    }

    /**
     * setter for scoring type
     * @param scoringType
     */
    public void setScoringType(String scoringType) {
        this.scoringType = scoringType;
    }

    /**
     * getter for score
     * @return  score
     */
    public int getScore() {
        return score;
    }

    /**
     * setter for score
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }
}








