
/**
 * Main driver class to test different functionality included in the classes
 * Command line interface that allows the user to select the game type a interactively keep track of the score of the game
 * @author snangia
 */

import java.util.Scanner;

public class ScoreboardDriver
{

    /**
     * This method will automatically be called when ScoreboardDriver is run.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args)
    {
        while (isGameOver()==false) {
            Scanner sc1 = new Scanner(System.in);    //Creating Scanner object
            System.out.print("Select the type of game: \n 1. Football \n 2.Basketball \n 3.Soccer \n 4.Hockey \n Enter choice: ");
            int gameChoice = sc1.nextInt();

            Scanner sc2 = new Scanner(System.in);    //Creating Scanner object
            System.out.print("Enter Home Team: ");
            String homeTeam = sc2.nextLine();

            Scanner sc3 = new Scanner(System.in);    //Creating Scanner object
            System.out.print("Enter Away Team: ");
            String awayTeam = sc3.nextLine();

            if (gameChoice == 1)
            {
                Game game = new Football();
                game.setHomeTeam(homeTeam);
                game.setAwayTeam(awayTeam);
                System.out.println(homeTeam + " - " + game.getScore());
                System.out.println(awayTeam + " - " + game.getScore());
                System.out.println("Current " + game.getPeriodName() + ": " +  game.getCurrentPlayPeriod());
            }
            else if (gameChoice == 2)
            {
                Game game = new Basketball();
                game.setHomeTeam(homeTeam);
                game.setAwayTeam(awayTeam);
            }
            else if (gameChoice == 3)
            {
                Game game = new Soccer();
                game.setHomeTeam(homeTeam);
                game.setAwayTeam(awayTeam);
            }
            else if (gameChoice == 4) {
                Game game = new Hockey();
                game.setHomeTeam(homeTeam);
                game.setAwayTeam(awayTeam);
            }




        }
    }
}
