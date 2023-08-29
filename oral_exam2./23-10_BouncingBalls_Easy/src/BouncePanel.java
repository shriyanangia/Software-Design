import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class has 1 internal private class, 2 private methods and 2 public methods
 *
 * @author snangia
 */
public class BouncePanel extends JPanel
{
    private final JLabel statusBar; // displays event information
    private int x = 0;  //x coordinate of ball
    private int y = 0;  //y coordinate of ball
    private int dx = this.speed;    //speed of ball in x axis
    private int dy = this.speed;    //speed of ball in y axis
    private final int speed = 5;
    private final int diameter = 50;    //diameter of ball
    // create ExecutorService to manage threads
    private ExecutorService executorService = Executors.newCachedThreadPool();



    // BouncePanel constructor sets up GUI and
    // registers mouse event handlers
    public BouncePanel()
    {

        statusBar = new JLabel("Mouse outside JPanel");
        add(statusBar, BorderLayout.SOUTH); // add label to JFrame

        // create and register listener for mouse and mouse motion events
        MouseHandler handler = new MouseHandler();
        this.addMouseListener(handler);
        this.addMouseMotionListener(handler);
    }

    /**
     * This class has 7 public methods
     * @author snangia
     */
    private class MouseHandler implements MouseListener,
            MouseMotionListener
    {
        // MouseListener event handlers
        /**
         * This method handles the event when mouse released immediately after press
         * @param event An event of MouseEvent
         * no return value
         */
        @Override
        public void mouseClicked(MouseEvent event)
        {
            x = event.getX();
            y = event.getY();
            BounceTask task1 = new BounceTask();
            // start the BounceTask
            executorService.execute(task1); // start task1

            statusBar.setText(String.format("Clicked at [%d, %d]",
                    event.getX(), event.getY()));

        }

        //override method mousePressed
        /**
         * This method handles the event when mouse pressed
         * @param event An event of MouseEvent
         * no return value
         */
        @Override
        public void mousePressed(MouseEvent event)
        {
        }

        /**
         * This method handles the event when mouse released
         * @param event An event of MouseEvent
         * no return value
         */
        @Override
        public void mouseReleased(MouseEvent event)
        {
            statusBar.setText(String.format("Released at [%d, %d]",
                    event.getX(), event.getY()));
        }

        /**
         * This method handles the event when mouse enters area
         * @param event An event of MouseEvent
         * no return value
         */
        @Override
        public void mouseEntered(MouseEvent event)
        {
        }

        /**
         * This method handles the event when mouse exits area
         * @param event An event of MouseEvent
         * no return value
         */
        @Override
        public void mouseExited(MouseEvent event)
        {
        }

        // MouseMotionListener event handlers
        /**
         * This method handles the event when user drags mouse with button pressed
         * @param event An event of MouseEvent
         * no return value
         */
        @Override
        public void mouseDragged(MouseEvent event)
        {
            statusBar.setText(String.format("Dragged at [%d, %d]",
                    event.getX(), event.getY()));
        }

        /**
         * This method handles the event when user moves mouse
         * @param event An event of MouseEvent
         * no return value
         */
        @Override
        public void mouseMoved(MouseEvent event)
        {
        }
    } // end inner class MouseHandler

    /**
     * This method sets the colour and shape of the ball
     * @param g An object variable of type Graphics
     * no return value
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(this.x, this.y, this.diameter, this.diameter);
    }


    /**
     * This method determines whether the circle hit left/right of the window
     * no input parameters
     * @return boolean true if ball collides, false if ball does not collide
     */
    private boolean hitRightOrLeftEdge()
    {
        return (((this.x + diameter) >= this.getWidth()) || (this.x <= 0));
    }

    /**
     * This method determines whether the circle hit top/bottom of the window
     * no input parameters
     * @return boolean true if ball collides, false if ball does not collide
     */
    private boolean hitTopOrBottom()
    {
        return ((this.y <= 0) || ((this.y + this.diameter) >= this.getHeight()));
    }

    /**
     * This method changes the direction of movement of the ball in the x and y directions when it collides with any of the borders
     * no input parameters
     * no return value
     */
    public void speedChangeUponCollision()
    {
        this.x = x+dx;
        this.y = y+dy;
        if (this.hitRightOrLeftEdge()) {
            this.dx *= -1;
        }

        if (this.hitTopOrBottom()) {
            this.dy *= -1;
        }
                this.repaint();


    }
}


