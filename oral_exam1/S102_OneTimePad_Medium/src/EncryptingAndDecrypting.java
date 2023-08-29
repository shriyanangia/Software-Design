import java.util.Random;
import java.util.Scanner;
//referred to javapointon how to get user input for strings and integer arrays
//referred to educative.io on how to generate random integers

/**
 * This class has 2 public methods
 *
 * @author snangia
 */

public class EncryptingAndDecrypting
{
    //static array to store the alphabet
    final static char alphabet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * This method first converts any character input to uppercase then gives its corresponding index in the array, alphabet
     * @param letter A letter from the alphabet of type char
     * @return The index of the input letter in the alphabet array
     */
    private static int letterToAlphabetIndex(char letter)
    {
        int index = 0;
        char letterToUpper = Character.toUpperCase(letter);
        for (int i=0; i<alphabet.length; i++)
        {
            if (alphabet[i] == letterToUpper)
            {
                index=i;
            }
        }
        return index;
    }

    /**
     * This method converts an index to its corresponding alphabet in the alphabet array
     * @param index An index value
     * @return The letter character for the index value
     */
    private static char alphabetIndexToLetter(int index)
    {
        return alphabet[index];
    }


    /**
     * This method gets the length of an array excluding " " characters
     * @param message A message of String type
     * @return The number of letters in the input string
     */
    private static int numberOfLetters(String message)
    {
        int count = 0;

        for (int i=0; i<message.length(); i++)
        {
            if (message.charAt(i) != ' ')
            {
                count += 1;
            }
        }
        return count;
    }


    /**
     * This method prints out the characters in an array through iteration  . Method has no return value.
     * @param array An input character array
     */
    private static void printArray(char[] array)
    {
        for (int i=0; i<array.length; i++)
        {
            System.out.print(array[i]);
        }
    }

    /**
     * This method prints out the integer keys in the keyArray separated by a ','. Method has no return value
     * @param keyArray An input integer array
     */
    private static void printKeyArray(int[] keyArray)
    {
        for (int i=0; i<keyArray.length; i++)
        {
            System.out.print(keyArray[i]);
            System.out.print(',');
        }
    }

    /**
     * This method encrypts the inputted message and prints out the encrypted message. Method has no return value
     * Method generates random n values(keys) for each letter in the string. The randomly generated keys are used to
     * encrypt the message by shifting each letter forward by its respective n value
     * @param messageToEncrypt A message of String type
     */
    public static void encryption(String messageToEncrypt)
    {
        //making an instance of the class java.util.Random
        Random rand = new Random();
        ///declaring a new character array to store the encrypted message
        char[] encryptedArray = new char[messageToEncrypt.length()];
        //declaring a new integer array to store the n values used to encrypt each letter
        int[] keyArray = new int[numberOfLetters(messageToEncrypt)];
        //variable to store intermediate calculation
        int placeholder = 0;
        //variable to traverse through the keyArray as keyArray has a different length compared to the encrypted array
        int j = 0;

        for (int i=0; i<messageToEncrypt.length(); i++)
        {
            if (messageToEncrypt.charAt(i) != ' ')  //ensuring only letter are getting encrypted
            {
                int indexOfLetter = 0;
                indexOfLetter = letterToAlphabetIndex(messageToEncrypt.charAt(i));  //calling method letterToAlphabetIndex on each letter to get its index value
                int n = rand.nextInt(26) + 1;   //generating a random number in the range 1-26 for each letter in the message
                keyArray[j] = n;    //updating the n value to be stored in the array
                j++;

                if ((indexOfLetter+n) <= 25)    //if upon adding the n value to the index of the letter, a loop around the alphabet array is not required
                {
                    encryptedArray[i] = alphabet[indexOfLetter+n];  //getting the encrypted letter for the given letter in the message
                }
                else    //if after adding the n value to the index of the given letter, loops around the alphabet array are required
                {
                    placeholder = n-(25-indexOfLetter+1);

                    if (placeholder<=25)
                    {
                        encryptedArray[i] = alphabet[placeholder];
                    }
                    else
                    {
                        encryptedArray[i] = alphabet[(placeholder%25)-1];
                    }
                }
            }
            else    //when a ' ' character is present in the message string, a ' ' chacter is added to the encryptedArray as well
            {
                encryptedArray[i] = ' ';
            }
        }

        //printing array of keys
        printKeyArray(keyArray);
        System.out.println("\n");
        //printing array of encrypted letters
        printArray(encryptedArray);
        System.out.println("\n");
    }

    /**
     * This method decrypts a cipher text. Method has no input parameters not a return type.
     * Method gets user input for cipher message, number of n values and value of each n
     * It then decrypts each cipher letter using the n value for that letter by first
     * obtaining the index of each cipher letter, moving its index back by n and putting the new index in the alphabet array to get the original letter
     */
    public static void decryption()
    {
        //creating an instance of the class Scanner
        Scanner message = new Scanner(System.in);
        //output message prompting user to enter the cipher text
        System.out.println("Enter the cipher text to decrypt: ");
        //reading the cipher string and storing it in variable messageToDecrypt
        String messageToDecrypt = message.nextLine();

        int numberOfKeys = 0;   //variable to hold number of n values
        //creating instance of class Scanner
        Scanner sc = new Scanner(System.in);
        //output message prompting user to enter the number of n values they will input
        System.out.print("Enter the number of keys: ");
        //reads in the user input for number of n values and stores it in variable numberOfKeys
        numberOfKeys = sc.nextInt();
        //creating an array of length, numberOfKeys
        int[] keyArray = new int[numberOfKeys];

        //prompting user to enter each n value
        System.out.println("Enter each key value followed by enter: ");
        //loop reads and stores user input in the array, keysArray
        for (int i=0; i<numberOfKeys; i++)
        {
            keyArray[i] = sc.nextInt();
        }

        char[] decryptedArray = new char[messageToDecrypt.length()];
        int indexOfLetter = 0;
        int n = 0;
        int placeholder = 0;
        int j = 0;

        for (int i=0; i<messageToDecrypt.length(); i++)
        {
            if (messageToDecrypt.charAt(i) != ' ')
            {
                indexOfLetter = letterToAlphabetIndex(messageToDecrypt.charAt(i));
                n = keyArray[j];
                j++;

                if ((indexOfLetter-n)>=0 && (indexOfLetter-n) <= 25)
                {
                    decryptedArray[i] = alphabet[indexOfLetter-n];
                }
                else
                {
                    placeholder = ((n-indexOfLetter)%26);
                    decryptedArray[i] = alphabet[25-(placeholder)+1];

                }
            }
            else    //if a ' ' character is encountered in the cipher text
            {
                decryptedArray[i] = ' ';
            }
        }
        //printing out original text
        printArray(decryptedArray);
    }

}
