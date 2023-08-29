import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * This class has 2 public methods and 1 private method
 *
 * @author snangia
 */

public class MorseCodeGUI
{
    private HashMap<String, String> englishToMorseCodeDict = new HashMap<>(), morseCodeToEnglishDict = new HashMap<>();

    {
        //englishToMorseCodeDictionary
        englishToMorseCodeDict.put("A", ".-");
        englishToMorseCodeDict.put("B", "-...");
        englishToMorseCodeDict.put("C", "-.-.");
        englishToMorseCodeDict.put("D", "-..");
        englishToMorseCodeDict.put("E", ".");
        englishToMorseCodeDict.put("F", "..-.");
        englishToMorseCodeDict.put("G", "--.");
        englishToMorseCodeDict.put("H", "....");
        englishToMorseCodeDict.put("I", "..");
        englishToMorseCodeDict.put("J", ".---");
        englishToMorseCodeDict.put("K", "-.-");
        englishToMorseCodeDict.put("L", ".-..");
        englishToMorseCodeDict.put("M", "--");
        englishToMorseCodeDict.put("N", "-.");
        englishToMorseCodeDict.put("O", "---");
        englishToMorseCodeDict.put("P", ".--.");
        englishToMorseCodeDict.put("Q", "--.-");
        englishToMorseCodeDict.put("R", ".-.");
        englishToMorseCodeDict.put("S", "...");
        englishToMorseCodeDict.put("T", "-");
        englishToMorseCodeDict.put("U", "..-");
        englishToMorseCodeDict.put("V", "...-");
        englishToMorseCodeDict.put("W", ".--");
        englishToMorseCodeDict.put("X", "-..-");
        englishToMorseCodeDict.put("Y", "-.--");
        englishToMorseCodeDict.put("Z", "--..");

        englishToMorseCodeDict.put("0", "-----");
        englishToMorseCodeDict.put("1", ".----");
        englishToMorseCodeDict.put("2", "..---");
        englishToMorseCodeDict.put("3", "...--");
        englishToMorseCodeDict.put("4", "....-");
        englishToMorseCodeDict.put("5", ".....");
        englishToMorseCodeDict.put("6", "-....");
        englishToMorseCodeDict.put("7", "--...");
        englishToMorseCodeDict.put("8", "---..");
        englishToMorseCodeDict.put("9", "----.");

        //morseCodeToEnglishDictionary
        morseCodeToEnglishDict.put(".-", "A");
        morseCodeToEnglishDict.put("-...", "B");
        morseCodeToEnglishDict.put("-.-.", "C");
        morseCodeToEnglishDict.put("-..", "D");
        morseCodeToEnglishDict.put(".", "E");
        morseCodeToEnglishDict.put("..-.", "F");
        morseCodeToEnglishDict.put("--.", "G");
        morseCodeToEnglishDict.put("....", "H");
        morseCodeToEnglishDict.put("..", "I");
        morseCodeToEnglishDict.put(".---", "J");
        morseCodeToEnglishDict.put("-.-", "K");
        morseCodeToEnglishDict.put(".-..", "L");
        morseCodeToEnglishDict.put("--", "M");
        morseCodeToEnglishDict.put("-.", "N");
        morseCodeToEnglishDict.put("---", "O");
        morseCodeToEnglishDict.put(".--.", "P");
        morseCodeToEnglishDict.put("--.-", "Q");
        morseCodeToEnglishDict.put(".-.", "R");
        morseCodeToEnglishDict.put("...", "S");
        morseCodeToEnglishDict.put("-", "T");
        morseCodeToEnglishDict.put("..-", "U");
        morseCodeToEnglishDict.put("...-", "V");
        morseCodeToEnglishDict.put(".--", "W");
        morseCodeToEnglishDict.put("-..-", "X");
        morseCodeToEnglishDict.put("-.--", "Y");
        morseCodeToEnglishDict.put("--..", "Z");

        morseCodeToEnglishDict.put("-----", "0");
        morseCodeToEnglishDict.put(".----", "1");
        morseCodeToEnglishDict.put("..---", "2");
        morseCodeToEnglishDict.put("...--", "3");
        morseCodeToEnglishDict.put("....-", "4");
        morseCodeToEnglishDict.put(".....", "5");
        morseCodeToEnglishDict.put("-....", "6");
        morseCodeToEnglishDict.put("--...", "7");
        morseCodeToEnglishDict.put("---..", "8");
        morseCodeToEnglishDict.put("----.", "9");

    }

    public MorseCodeGUI()
    {
        JPanel englishInputPanel = new JPanel();    //panel for the english input and output
        englishInputPanel.setLayout(new BorderLayout());    //border layout
        JTextArea englishInputTextArea = new JTextArea();   //text area where user can input a phrase & where a decoded phrase will appear
        JLabel englishLabel = new JLabel("English");    //heading for this panel
        englishInputPanel.add(englishLabel, BorderLayout.NORTH);    //adding the heading to the top of the panel
        englishInputPanel.add((englishInputTextArea), BorderLayout.CENTER); //adding the text area to the panel

        JPanel morseCodeInputPanel = new JPanel();  //panel for the morse code input and output
        morseCodeInputPanel.setLayout(new BorderLayout());  //border layout
        JTextArea morseCodeInputTextArea = new JTextArea(); //text area where user can input a code & where a coded phrase will appear
        JLabel morseCodeLabel = new JLabel("Morse Code");   //heading for this panel
        morseCodeInputPanel.add(morseCodeLabel, BorderLayout.NORTH);    //adding the heading to the top of the panel
        morseCodeInputPanel.add((morseCodeInputTextArea), BorderLayout.CENTER); //adding the text area to the panel

        //adding both the englishInputPanel and morseCodeInputPanel to a splitPane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, englishInputPanel, morseCodeInputPanel);
        //each of the individual panels will take up half the splitPane
        splitPane.setDividerLocation(250);
        //maintaining the 1:1 ratio even when frame is resized
        splitPane.setResizeWeight(0.5);

        //converts each letter/number to its respective code as it is typed into the english text area
        englishInputTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                morseCodeInputTextArea.setText(englishToMorseCode(englishInputTextArea.getText()));
            }
        });

        //converts each code back to its respective english letter/number as it is typed into the morse code text area
        morseCodeInputTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                englishInputTextArea.setText(morseCodeToEnglish(morseCodeInputTextArea.getText()));
            }
        });

        JFrame frame = new JFrame();    //new frame to contain all elements
        frame.setTitle("Morse Code GUI");   //title of frame
        frame.setLayout(new BorderLayout());    //border layout
        frame.setSize(new Dimension(500, 500)); //size of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(splitPane, BorderLayout.CENTER);  //adding splitPane to frame
    }


    /**
     * This method validates the input into the english text area
     * If input characters are not among A-Z or 0-9 the method will return false
     * @param input String variable to hold the english word/phrase
     * @return boolean true if input is valid, false if input is invalid
     */
    private boolean validInput(String input) {
        char c = ' ';
        for (int i=0; i<input.length(); i++)
        {
            c = input.charAt(i);
            if ((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * This method translates the english input to morse code
     * s1 is an array containing different words in the input
     * s2 is an array containing the characters in each word
     * if input is valid, input will be coded
     * one blank between each morse coded letter and 3 blanks between each morse coded word
     * @param englishInput  String variable to hold the english word/phrase
     * @return String containing the morse coded english input
     */
    public String englishToMorseCode(String englishInput) {
        StringBuffer buffer = new StringBuffer();
        String s1[] = englishInput.split(" ");;
        String s2[];

        for (String item: s1)
        {
            s2 = item.split("");
            for (String item2: s2)
            {
                if (validInput(item2)==true) {
                    buffer.append(englishToMorseCodeDict.get(item2.toUpperCase()));
                    buffer.append(" ");
                }
                else
                {
                    System.out.println("Invalid input");
                }
            }
            buffer.append("   ");
        }
        if (buffer.toString().contains("null"))
        {
            buffer.append("\n");
        }
        return buffer.toString();
    }

    /**
     * This method translates the morse code input back to its english word/phrase
     * s1 is an array containing different morse coded words in the input
     * s2 is an array containing the morse coded characters in each word
     * one blank between each morse coded letter and 3 blanks between each morse coded word
     * @param morseCodeInput  String variable to hold the morse code
     * @return String containing the english word/phrase after the morse code has been decoded
     */
    public String morseCodeToEnglish(String morseCodeInput) {
        StringBuffer buffer = new StringBuffer();
        String s1[] = morseCodeInput.split("   ");
        String s2[];
        for (String item1: s1)
        {
            s2 = item1.split(" ");
            for (String item2: s2)
            {
                buffer.append(morseCodeToEnglishDict.get(item2));
            }
            buffer.append(" ");
        }
        //print out s1,s2 and buffer
        return buffer.toString();
    }
}
