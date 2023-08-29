/**
 * This class has 17 public methods
 *
 * @author snangia
 */

public abstract class Game
{
    private String homeTeam;    //string to store name of home team
    private String awayTeam;    //string to store name of away team
    private int score;  //integer to store score
    private int currentPlayPeriod;  //int to store current play period (example: 1st quarter)
    private int periodLength;   //int to store number of rounds in each play period (example: 6 rounds in 1st quarter)
    private int numPeriods; //total number of period (example: total of 4 quarters)
    private String periodName;  //string to store name of period (example quarter, half)

    //super constructor
    public Game() {
        int score = 0;
    }

    /**
     * getter for home team
     * @return name of home team
     */
    public String getHomeTeam() {
        return homeTeam;
    }
    /**
     * setter for home team
     * @param homeTeam
     */
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    /**
     * getter for away team
     * @return awayTeam
     */
    public String getAwayTeam() {
        return awayTeam;
    }
    /**
     * setter for away team
     * @param awayTeam
     */
    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }


    /**
     * getting score for team
     * @return  score
     */
    public int getScore() { return score; }

    /**
     * method to add score
     * @param scoreType
     */
    public void addScore(ScoringMethod scoreType)
    {
       this.score = score + scoreType.getScore();
    }

    /**
     * getter for current period of play
     * @return  currentPlayPeriod
     */
    public int getCurrentPlayPeriod()
    {
        return currentPlayPeriod;
    }
    /**
     * setter for current period of play
     * @param playPeriod
     */
    public void setCurrentPlayPeriod(int playPeriod)
    {
        this.currentPlayPeriod = playPeriod;
    }

    /**
     * getter for length of a period
     * @return  periodLength
     */
    public int getPeriodLength() {
        return periodLength;
    }
    /**
     * setter for length of a period
     * @param periodLength
     */
    public void setPeriodLength(int periodLength)
    {
        this.periodLength = periodLength;
    }

    /**
     * getter for total number of periods
     * @return  numPeriods
     */
    public int getNumPeriods() { return numPeriods; }
    /**
     * setter for total number of periods
     * @param numPeriods
     */
    public void setNumPeriods(int numPeriods) { this.numPeriods = numPeriods; }


    /**
     * getter for name of period
     * @return  periodName
     */
    public String getPeriodName() {
        return periodName;
    }
    /**
     * setter for name of period
     * @param periodName
     */
    public void setPeriodName(String periodName)
    {
        this.periodName = periodName;
    }

    /**
     * method to start the game
     * no parameters
     */
    public void startGame()
    {
    }

    /**
     * method to check if game is over
     * @return true/false
     */
    public boolean isGameOver() {
        if (currentPlayPeriod>numPeriods)
            return true;
        else
            return false;
    }

    /**
     * method to end the current period of play
     */
    public void endCurrentPlay()
    {

    }
}