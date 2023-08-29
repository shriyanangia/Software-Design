
import javax.swing.JFrame;
/**
 * Main driver class that tests GameClient.java
 *
 *
 */

public class GameClientTest
{
    public static void main(String[] args)
    {
        /**
         * This method will automatically be called when GameClient is run.
         *
         * @param args Command line arguments.
         */
        GameClient application; // declare client application

        // if no command line args
        if (args.length == 0)
            application = new GameClient("127.0.0.1"); // connect to localhost
        else
            application = new GameClient(args[0]); // use args to connect

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runClient(); // run client application
    }
}
