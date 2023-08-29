/**
 * This class has 2 public methods
 *
 * @author snangia
 */

public class Basketball implements Game
{
    private ScoringMethod []scoringMethodArr;

    public Basketball()
    {
        scoringMethodArr = new ScoringMethod[6];    //array to store team which earned a score, score earned and name of the scoring type

        scoringMethodArr[0] = new ScoringMethod(getHomeTeam(),3,"3 Pointer");
        scoringMethodArr[1] = new ScoringMethod(getHomeTeam(),2,"2 Pointer");
        scoringMethodArr[2] = new ScoringMethod(getHomeTeam(),1,"Free throw");

        scoringMethodArr[3] = new ScoringMethod(getHomeTeam(),2,"3 Pointer");
        scoringMethodArr[4] = new ScoringMethod(getHomeTeam(),3,"2 Pointer");
        scoringMethodArr[5] = new ScoringMethod(getAwayTeam(),6,"Free throw");

    }

    public ScoringMethod[] getScoringMethodArr() {
        return scoringMethodArr;
    }

    public void setScoringMethodArr(ScoringMethod[] scoringMethodArr) {
        this.scoringMethodArr = scoringMethodArr;
    }
}
