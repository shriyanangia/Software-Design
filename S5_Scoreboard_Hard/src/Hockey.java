/**
 * This class has 2 public methods
 *
 * @author snangia
 */
public class Hockey implements Game
{
    private ScoringMethod []scoringMethodArr;   //array to store team which earned a score, score earned and name of the scoring type

    public Hockey()
    {
        scoringMethodArr = new ScoringMethod[10];

        scoringMethodArr[0] = new ScoringMethod(getHomeTeam(),1,"Goal");
        scoringMethodArr[1] = new ScoringMethod(getHomeTeam(),1,"Penalty");
        scoringMethodArr[2] = new ScoringMethod(getAwayTeam(),1,"Goal");
        scoringMethodArr[3] = new ScoringMethod(getAwayTeam(),1,"Penalty");
    }

    public ScoringMethod[] getScoringMethodArr() {
        return scoringMethodArr;
    }

    public void setScoringMethodArr(ScoringMethod[] scoringMethodArr) {
        this.scoringMethodArr = scoringMethodArr;
    }
}
