import java.util.Scanner;

/**
 * This class has 1 public method
 *
 * @author snangia
 */
public class PostNetDecoding
{
    /**
     * This method gets the user input for binary representation that needs to be decoded
     * Frame bars are removed from the binary representation
     * Binary representation is then decoded to give the zip code
     * Method has no input parameters
     * @return The zip code
     */
    public static String digitsRepOfBinary()
    {
        Scanner sc = new Scanner(System.in);    //Creating Scanner object
        System.out.print("Enter Binary Representation: ");
        String binaryRep  = sc.nextLine();    //Reading user input

        String decodedCode = "";    //string to store the zip code

        //array of binary representation of digits
        String[] binaryRepArray = new String [10];
        binaryRepArray [0] = "11000";
        binaryRepArray[1] = "00011";
        binaryRepArray[2] = "00101";
        binaryRepArray[3] = "00110";
        binaryRepArray[4] = "01001";
        binaryRepArray[5] = "01010";
        binaryRepArray[6] = "01100";
        binaryRepArray[7] = "10001";
        binaryRepArray[8] = "10010";
        binaryRepArray[9] = "10100";

        int endIndex = binaryRep.length() - 6;
        String trueBinaryRep = binaryRep.substring(1,endIndex); //binary rep with the frame bars and checksum removed

        //for loop iterates through the trueBinaryRep 5 digits at a time
        //since each group of 5 digits represents the binary for an integer
        //binary number is compared to each element in the binaryRepArray
        //once match is found index of element in binaryRepArray is added to the decodedCode string
        //index = integer value in zip code
        for (int i=0; i<trueBinaryRep.length(); i=i+5)
        {
            String eachDigitSubstring = trueBinaryRep.substring(i,i+5);
            for (int j=0; j<binaryRepArray.length; j++)
            {
                if (binaryRepArray[j].equals(eachDigitSubstring))
                {
                    decodedCode += j;
                }
            }
        }
        return decodedCode;
    }

}
