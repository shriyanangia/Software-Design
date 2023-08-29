import javax.swing.JFrame;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main driver class
 *
 * @author snangia
 */
public class BouncingBallMouseDetails
{
    /**
     * This method will automatically be called when BouncingBallMouseDetails
     * is run.
     *
     * @param args Command line arguments.
     */

    public static void main(String[] args)
    {
        BouncePanel mouseDetailsFrame = new BouncePanel();
        JFrame myJFrame = new JFrame();
        myJFrame.add(mouseDetailsFrame);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJFrame.setSize(600, 600);
        myJFrame.setVisible(true);


        // create and name each runnable
        BounceTask task1 = new BounceTask();

        System.out.println("Starting Executor");

        // create ExecutorService to manage threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        // start the BounceTask
        executorService.execute(task1); // start task1

        // shut down ExecutorService--it decides when to shut down threads
        executorService.shutdown();

        System.out.printf("Tasks started, main ends.%n%n");
    }
}// end class BouncingBallMouseDetails