/**
 * This class has 2 public methods
 *
 * @author snangia
 */

public class Football implements Game
{
    private ScoringMethod []scoringMethodArr;

    public Football()
    {
        scoringMethodArr = new ScoringMethod[10];   //array to store team which earned a score, score earned and name of the scoring type

        scoringMethodArr[0] = new ScoringMethod(getHomeTeam(),6,"Touchdown");
        scoringMethodArr[1] = new ScoringMethod(getHomeTeam(),4,"Field Goal");
        scoringMethodArr[2] = new ScoringMethod(getHomeTeam(),1,"Extra Point");
        scoringMethodArr[3] = new ScoringMethod(getHomeTeam(),2,"Two-point conversion");
        scoringMethodArr[4] = new ScoringMethod(getHomeTeam(),3,"Safety");

        scoringMethodArr[5] = new ScoringMethod(getAwayTeam(),6,"Touchdown");
        scoringMethodArr[6] = new ScoringMethod(getAwayTeam(),4,"Field Goal");
        scoringMethodArr[7] = new ScoringMethod(getAwayTeam(),1,"Extra Point");
        scoringMethodArr[8] = new ScoringMethod(getAwayTeam(),2,"Two-point conversion");
        scoringMethodArr[9] = new ScoringMethod(getAwayTeam(),3,"Safety");
    }

    public ScoringMethod[] getScoringMethodArr() {
        return scoringMethodArr;
    }

    public void setScoringMethodArr(ScoringMethod[] scoringMethodArr) {
        this.scoringMethodArr = scoringMethodArr;
    }
}

