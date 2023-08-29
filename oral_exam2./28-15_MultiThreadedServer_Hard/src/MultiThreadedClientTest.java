import javax.swing.JFrame;
/**
 * Main driver class that tests MultiThreadedClient.java
 *
 * @author snangia
 */

public class MultiThreadedClientTest
{
    public static void main(String[] args)
    {
        /**
         * This method will automatically be called when MultiThreadedClientTest is run.
         *
         * @param args Command line arguments.
         */
        MultiThreadedClient application; // declare client application

        // if no command line args
        if (args.length == 0)
            application = new MultiThreadedClient("127.0.0.1"); // connect to localhost
        else
            application = new MultiThreadedClient(args[0]); // use args to connect

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runClient(); // run client application
    }
}
