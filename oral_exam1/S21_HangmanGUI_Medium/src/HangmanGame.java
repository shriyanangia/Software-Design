// Got the hangman graphic measurements from
// stackoverflow.com/questions/20407078/hangman-graphics

/**
 * This class has 4 public methods
 *
 * @author snangia
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HangmanGame extends JFrame {

    private int numIncorrectGuesses = 0;
    private String inputWordToGuess = null;
    private String correctlyGuessedLetters = "";
    private String incorrectlyGuessedLetters = "Letters not in word: ";
    private JPanel hangmanPanel;    //panel to hold the hangman drawing
    private JPanel wordGuessPanel;  //panel to input word to guess and guesses
    private JLabel instruction = new JLabel("Type in word to be guessed");  //displays uneditable text
    private JLabel guessedPartOfWord;  //displays uneditable text
    private JLabel incorrectLetters = new JLabel(); //displays uneditable text
    private JTextField guessLetterTextField = new JTextField(10);  //receives input from the user
    private BufferedImage hangmanImage = new BufferedImage(200, 200, BufferedImage.TYPE_4BYTE_ABGR_PRE);

    public HangmanGame() {


        wordGuessPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        wordGuessPanel.add(instruction, c);

        wordGuessPanel = new JPanel(new GridBagLayout());
        GridBagConstraints d = new GridBagConstraints();
        wordGuessPanel.add(guessLetterTextField, d);


        add(wordGuessPanel);


        /**
         * This method is called when a letter is correctly guessed
         * Method has no input parameters
         */
        public void correctGuess() {
            for (int i = 0; i < inputWordToGuess.length(); i++) {

            }
        }

        /**
         * This method adds the correctly guessed letter to the correctlyGuessedLetters string
         * Method has no return values
         * @parem letterGuessed
         */
        public void addToGuessedPartOfWord(String letterGuessed)
        {

        }


        /**
         * This method is called when a letter is incorrectly guessed
         * Based on the number of incorrect guesses thus far, the hangman figure is drawn
         * Method has no input parameters
         */

        public void incorrectGuess() {

            numIncorrectGuesses++;
            incorrectLetters.setText(incorrectlyGuessedLetters);

            Graphics2D g = (Graphics2D) hangmanImage.getGraphics();
            g.setColor(Color.BLACK);

            switch (numIncorrectGuesses) {
                case 1: // Head
                    g.drawOval(25, 30, 50, 50);
                    break;
                case 2: // Body
                    g.drawLine(50, 80, 50, 180);
                    break;
                case 3: // Right Arm
                    g.drawLine(50, 100, 90, 150);
                    break;
                case 4: // Left Arm
                    g.drawLine(10,150,50,100);
                    break;
                case 5: // Right Leg
                    g.drawLine(50, 180,70,250);
                    break;
                case 6: // Left Leg
                    g.drawLine(30,250,50,180);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "You Lost!");
                    break;
            }
            g.dispose();
        }

        /**
         * This method is called to draw the initial base of the hangman figure
         * @parem image of type BufferedImage
         */
        public static void hangmanBase(BufferedImage image) {
            Graphics2D g = (Graphics2D) image.getGraphics();
            g.setColor(Color.BLACK);

            g.drawLine(50, 30, 50, 10);
            g.drawLine(50, 10, 130, 10);
            g.drawLine(130, 10, 130, 300);
            g.drawLine(20, 300, 150, 300);

            g.dispose();
        }

}
