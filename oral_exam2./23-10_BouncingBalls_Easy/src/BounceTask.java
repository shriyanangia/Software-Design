import java.security.SecureRandom;

/**
 * This class has 2 public methods
 *
 * @author snangia
 */
public class BounceTask implements Runnable
{
    private static final SecureRandom generator = new SecureRandom();
    private final int sleepTime; // random sleep time for thread
    private final BouncePanel taskName;


    // constructor
    public BounceTask() {
        this.taskName = new BouncePanel();

        // pick random sleep time between 0 and 5 seconds
        sleepTime = generator.nextInt(5000); // milliseconds
    }

    /**
     * This method gets the task name
     * @return The task name
     */
    public BouncePanel getTaskName()
    {
        return this.taskName;
    }

    /**
     * This method run contains the code that a thread will execute
     * no return value
     * no input parameters
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(sleepTime); // put thread to sleep
                //accounts for collisions of the ball against the frame borders and changes the ball's direction of movement accordingly
                this.taskName.speedChangeUponCollision();
            }
            catch (InterruptedException exception) {
                exception.printStackTrace();
                Thread.currentThread().interrupt(); // re-interrupt the thread
            }

            // print task name
            System.out.printf("%s done sleeping%n", taskName);
        }

    }

}

