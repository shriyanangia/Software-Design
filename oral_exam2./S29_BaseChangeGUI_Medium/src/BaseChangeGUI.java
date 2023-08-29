import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * This class has 2 public methods and 2 private methods
 *
 * @author snangia
 */

public class BaseChangeGUI
{
    private HashMap<String, String> base16To10Dict = new HashMap<>() , base10To16Dict = new HashMap<>();;
    {
        base16To10Dict.put("0", "0");
        base16To10Dict.put("1", "1");
        base16To10Dict.put("2", "2");
        base16To10Dict.put("3", "3");
        base16To10Dict.put("4", "4");
        base16To10Dict.put("5", "5");
        base16To10Dict.put("6", "6");
        base16To10Dict.put("7", "7");
        base16To10Dict.put("8", "8");
        base16To10Dict.put("9", "9");
        base16To10Dict.put("A", "10");
        base16To10Dict.put("B", "11");
        base16To10Dict.put("C", "12");
        base16To10Dict.put("D", "13");
        base16To10Dict.put("E", "14");
        base16To10Dict.put("F", "15");


        base10To16Dict.put("0", "0");
        base10To16Dict.put("1", "1");
        base10To16Dict.put("2", "2");
        base10To16Dict.put("3", "3");
        base10To16Dict.put("4", "4");
        base10To16Dict.put("5", "5");
        base10To16Dict.put("6", "6");
        base10To16Dict.put("7", "7");
        base10To16Dict.put("8", "8");
        base10To16Dict.put("9", "9");
        base10To16Dict.put("10", "A");
        base10To16Dict.put("11", "B");
        base10To16Dict.put("12", "C");
        base10To16Dict.put("13", "D");
        base10To16Dict.put("14", "E");
        base10To16Dict.put("15", "F");
    }

    public BaseChangeGUI()
    {
        JPanel base10InputPanel = new JPanel();    //panel for the base 10 input and output
        base10InputPanel.setLayout(new BorderLayout());    //border layout
        JTextArea base10TextArea = new JTextArea();   //text area where user can input and get the result in base 10
        JLabel base10Label = new JLabel("Base 10 Input/Output");    //heading for this panel
        base10InputPanel.add(base10Label, BorderLayout.NORTH);    //adding the heading to the top of the panel
        base10InputPanel.add((base10TextArea), BorderLayout.CENTER); //adding the text area to the panel

        JPanel base16InputPanel = new JPanel();  //panel for the base 16 input and output
        base16InputPanel.setLayout(new BorderLayout());  //border layout
        JTextArea base16TextArea = new JTextArea(); //text area where user can input and get the result in base 16
        JLabel base16Label = new JLabel("Base 16 Inout/Output");   //heading for this panel
        base16InputPanel.add(base16Label, BorderLayout.NORTH);    //adding the heading to the top of the panel
        base16InputPanel.add((base16TextArea), BorderLayout.CENTER); //adding the text area to the panel

        //adding both the base10InputPanel and base16InputPanel to a splitPane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, base10InputPanel, base16InputPanel);
        //each of the individual panels will take up half the splitPane
        splitPane.setDividerLocation(250);
        //maintaining the 1:1 ratio even when frame is resized
        splitPane.setResizeWeight(0.5);

        //converts each letter/number to its respective code as it is typed into the base10 text area
        base10TextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                base16TextArea.setText(base10To16(base10TextArea.getText()));
            }
        });

        //converts each code back to its respective english letter/number as it is typed into the base16 text area
        base16TextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                base10TextArea.setText(base16To10(base16TextArea.getText()));
            }
        });

        JFrame frame = new JFrame();    //new frame to contain all elements
        frame.setTitle("Base Change GUI");   //title of frame
        frame.setLayout(new BorderLayout());    //border layout
        frame.setSize(new Dimension(500, 500)); //size of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(splitPane, BorderLayout.CENTER);  //adding splitPane to frame
    }

    /**
     * This method converts a base 10 input to base 16
     * @param base10Input String variable to hold the input
     * @return String base16
     */
    public String base10To16(String base10Input) {
        StringBuilder tempString = new StringBuilder();
        StringBuffer finalBuffer = new StringBuffer();
        int inputDigit = Integer.parseInt(base10Input);
        int quotient = -1;
        int remainder = 0;

        if (validBase10Input(base10Input))
        {
            for (int i=0; i<base10Input.length(); i++)
            {

            }
            while (quotient != 0)
            {
                quotient = inputDigit/16;
                remainder = inputDigit%16;
                inputDigit = quotient;

                tempString.append(base10To16Dict.get(remainder));
            }

            tempString.reverse();
            //print out s1,s2 and buffer
            return tempString.toString();
        }
        else
        {
            return ("Invalid input");
        }
    }

    /**
     * This method converts a base 16 input to base 10
     * @param base16Input String variable to hold the input
     * @return String base10
     */
    public String base16To10(String base16Input) {
        //StringBuilder tempString = new StringBuilder();
        int base10int = 0;

        if (validBase16Input(base16Input)==true)
        {
            for (int i = 0; i < base16Input.length(); i++)
            {
                String currDigitStr = base16To10Dict.get(base16Input.charAt(i));
                int currDigitInt = Integer.parseInt(currDigitStr);
                base10int += currDigitInt * Math.pow(16, base16Input.length() - i - 1);
            }
        }
        else
        {
            return("Invalid input");
        }
        Integer result = base10int;

        return result.toString();
    }

    /**
     * This method validates the input into the base10 text area
     * If input characters are not among 0-9 the method will return false
     * @param input String variable to hold the base10 input
     * @return boolean true if input is valid, false if input is invalid
     */
    private boolean validBase10Input(String input)
    {
        char c = ' ';
        for (int i=0; i<input.length(); i++)
        {
            c = input.charAt(i);
            if (c>='0' && c<='9')
            {
                return true;
            }
        }
        return false;
    }

    /**
     * This method validates the input into the base16 text area
     * If input characters are not among A-F or 0-9 the method will return false
     * @param input String variable to hold the english word/phrase
     * @return boolean true if input is valid, false if input is invalid
     */
    private boolean validBase16Input(String input) {
        char c = ' ';
        for (int i=0; i<input.length(); i++)
        {
            c = input.charAt(i);
            if ((c>='a' && c<='f') || (c>='A' && c<='F') || (c>='0' && c<='9'))
            {
                return true;
            }
        }
        return false;
    }
}
