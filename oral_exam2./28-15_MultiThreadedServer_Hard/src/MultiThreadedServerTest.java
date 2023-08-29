import javax.swing.JFrame;
/**
 * Main driver class that tests MultiThreadedServer.java
 *
 * @author snangia
 */

public class MultiThreadedServerTest
{
    /**
     * This method will automatically be called when MultiThreadedServerTest is run.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args)
    {
        MultiThreadedServer application = new MultiThreadedServer(); // create server
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runServer(); // run server application
    }
}
