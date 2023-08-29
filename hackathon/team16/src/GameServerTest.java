import javax.swing.JFrame;
/**
 * Main driver class that tests GameServer.java
 *
 *
 */

public class GameServerTest
{
    /**
     * This method will automatically be called when GameServerTest is run.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args)
    {
        GameServer application = new GameServer(); // create server
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runServer(); // run server application
    }
}
