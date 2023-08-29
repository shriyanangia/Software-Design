
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * The class  has 1 public method and 7 private methods
 *
 * @author snangia
 */

public class MultiThreadedClient extends JFrame
{
    private JTextField enterField; // enters information from user
    private JTextArea displayArea; // display information to user
    private ObjectOutputStream output; // output stream to server
    private ObjectInputStream input; // input stream from server
    private String message = ""; // message from server
    private String chatServer; // host server for this application
    private Socket client; // socket to communicate with server

    // initialize chatServer and set up GUI
    public MultiThreadedClient(String host)
    {
        super("Client");

        chatServer = host; // set server to which this client connects

        enterField = new JTextField(); // create enterField
        enterField.setEditable(false);
        enterField.addActionListener(
                new ActionListener()
                {
                    // send message to server
                    public void actionPerformed(ActionEvent event)
                    {
                        sendData(event.getActionCommand());
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
     * This method connect to server and process messages from server
     * @return bno return value
     */
    public void runClient()
    {
        try // connect to server, get streams, process connection
        {
            connectToServer(); // create a Socket to make connection
            getStreams(); // get the input and output streams
            processConnection(); // process connection
        }
        catch (EOFException eofException)
        {
            displayMessage("\nClient terminated connection");
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
        finally
        {
            closeConnection(); // close connection
        }
    }

    /**
     * This method connects to the server
     * @return no return value
     */
    private void connectToServer() throws IOException
    {
        displayMessage("Attempting connection\n");

        // create Socket to make connection to server
        client = new Socket(InetAddress.getByName(chatServer), 12345);

        // display connection information
        displayMessage("Connected to: " +
                client.getInetAddress().getHostName());
    }


    /**
     * This method gets streams to send and receive data
     * @return no return value
     */
    private void getStreams() throws IOException
    {
        // set up output stream for objects
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(client.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }

    /**
     * This method processes the connection with server
     * @return no return value
     */
    private void processConnection() throws IOException
    {
        // enable enterField so client user can send messages
        setTextFieldEditable(true);

        do // process messages sent from server
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

        } while (!message.equals("SERVER>>> TERMINATE"));
    }


    /**
     * This method closes streams and socket
     * @return no return value
     */
    private void closeConnection()
    {
        displayMessage("\nClosing connection");
        setTextFieldEditable(false); // disable enterField

        try
        {
            output.close(); // close output stream
            input.close(); // close input stream
            client.close(); // close socket
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }

    /**
     * This method sends messages to the server
     * @param message
     * @return no return value
     */
    private void sendData(String message)
    {
        try // send object to server
        {
            output.writeObject("CLIENT>>> " + message);
            output.flush(); // flush data to output
            displayMessage("\nCLIENT>>> " + message);
        }
        catch (IOException ioException)
        {
            displayArea.append("\nError writing object");
        }
    }

    /**
     * This method manipulates the displayArea in the event-dispatch thread
     * @param messageToDisplay
     * @return no return value
     */
    private void displayMessage(final String messageToDisplay)
    {
        SwingUtilities.invokeLater(
                new Runnable()
                {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay);
                    }
                }
        );
    }

    /**
     * This method  manipulates the enterField in the event-dispatch thread
     * @param editable
     * @return no return value
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
}
