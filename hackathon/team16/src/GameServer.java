// Fig. 28.3: Server.java
// Server portion of a client/server stream-socket connection.
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 */

public class GameServer extends JFrame
{

    private JTextField enterField; // inputs message from user
    private JTextArea displayArea; // display information to user
    private ServerSocket server; // server socket
    private  SockServer[] sockServer;
    private int counter = 1; // counter of number of connections
    private int numClients=0;
    private ExecutorService executor;

    // set up GUI
    public GameServer()
    {
        super("Server");

        enterField = new JTextField(); // create enterField
        enterField.setEditable(false);

        sockServer = new SockServer[10];
        executor = Executors.newFixedThreadPool(10);

        enterField.addActionListener(
                new ActionListener()
                {
                    // send message to client
                    public void actionPerformed(ActionEvent event)
                    {
                        for (int i=0; i<counter; i++)
                        {
                            if (sockServer[i].isAlive()) {
                                sockServer[i].sendData(event.getActionCommand());
                            }
                        }
                        enterField.setText("");
                    }
                }
        );

        add(enterField, BorderLayout.NORTH);

        displayArea = new JTextArea(); // create displayArea
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(300, 150); // set size of window
        setVisible(true); // show window
    }

    /**
     * This method sets up and runs the server
     * no return value
     */
    public void runServer()
    {
        try // set up server to receive connections; process connections
        {
            server = new ServerSocket(12345, 100); // create ServerSocket

            while (true)
            {
                try
                {
                    sockServer[counter] = new SockServer(counter);
                    sockServer[counter].waitForConnection();
                    numClients++;

                    executor.execute(sockServer[counter]);


                }
                catch (EOFException eofException)
                {
                    displayMessage("\nServer terminated connection");
                }
                finally
                {
                    ++counter;
                }
            }
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }

    /**
     * This method manipulates the displayArea in the event-dispatch thread
     * @param messageToDisplay
     * no return value
     */
    private void displayMessage(final String messageToDisplay)
    {
        SwingUtilities.invokeLater(
                new Runnable()
                {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay); // append message
                    }
                }
        );
    }

    /**
     * This method manipulates enterField in the event-dispatch thread
     * @param editable
     * no return value
     */
    private void setTextFieldEditable(final boolean editable)
    {
        SwingUtilities.invokeLater(
                new Runnable()
                {
                    public void run() // sets enterField's editability
                    {
                        enterField.setEditable(editable);
                    }
                }
        );
    }



    private class SockServer implements Runnable
    {
        private ObjectOutputStream output; // output stream to client
        private ObjectInputStream input; // input stream from client
        private Socket connection; // connection to client
        private int currentID;
        private boolean alive;

        public SockServer(int counterIn)
        {
            currentID = counterIn;
        }

        /**
         * This method sets up and runs the server
         * no return value
         */
        public void run()
        {
            try {
                getStreams();
                processConnection();
                numClients++;
                alive = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            closeConnection();
        }


        /**
         * This method waits for connection to arrive, then displays connection info
         * @throws IOException
         * no return value
         */
        private void waitForConnection() throws IOException
        {
            displayMessage("Waiting for connection\n");
            connection = server.accept(); // allow server to accept connection
            displayMessage("Connection " + counter + " received from: " + connection.getInetAddress().getHostName());
        }

        /**
         * This method gets streams to send and receive data
         * @throws IOException
         * no return value
         */
        private void getStreams() throws IOException
        {
            // set up output stream for objects
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush(); // flush output buffer to send header information

            // set up input stream for objects
            input = new ObjectInputStream(connection.getInputStream());

            displayMessage("\nGot I/O streams\n");
        }

        /**
         * This method checks if server is alive
         * @return boolean
         */
        public boolean isAlive()
        {
            return alive;
        }

        /**
         * This method processes connection with client
         * @throws IOException
         * no return value
         */
        private void processConnection() throws IOException
        {
            String message = "Connection successful";
            sendData(message); // send connection successful message

            // enable enterField so server user can send messages
            setTextFieldEditable(true);

            do // process messages sent from client
            {
                try // read message and display it
                {
                    message = (String) input.readObject(); // read new message
                    displayMessage("\n" + message); // display message
                }
                catch (ClassNotFoundException classNotFoundException)
                {
                    displayMessage("\nUnknown object type received");
                }

            } while (!message.equals("CLIENT>>> TERMINATE"));
            alive = false;
        }

        /**
         * This method closes streams and socket
         * no return value
         */
        private void closeConnection()
        {
            displayMessage("\nTerminating connection\n");
            setTextFieldEditable(false); // disable enterField

            try
            {
                output.close(); // close output stream
                input.close(); // close input stream
                connection.close(); // close socket
            }
            catch (IOException ioException)
            {
                ioException.printStackTrace();
            }
        }

        /**
         * This method sends messages to client
         * @param message
         * no return value
         */
        private void sendData(String message)
        {
            try // send object to client
            {
                output.writeObject("SERVER>>> " + message);
                output.flush(); // flush output to client
                displayMessage("\nSERVER>>> " + message);
            }
            catch (IOException ioException)
            {
                displayArea.append("\nError writing object");
            }
        }
    }

}
