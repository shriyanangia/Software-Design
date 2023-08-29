import java.util.Scanner;

/**
 * This class has 2 public and 2 private methods
 *
 * @author snangia
 */

public class PostNetEncoding
{
    /**
     * This method takes in the zip code then returns the binary representation of the zip code
     * @param zipCode The zip code to encode
     * @return The binary representation of the zip code as a String
     */
    private static String binaryRepOfDigits(String zipCode)
    {
        String encodedCode = "";

        String[] binaryRepArray = new String [10];
        binaryRepArray[0] = "11000";
        binaryRepArray[1] = "00011";
        binaryRepArray[2] = "00101";
        binaryRepArray[3] = "00110";
        binaryRepArray[4] = "01001";
        binaryRepArray[5] = "01010";
        binaryRepArray[6] = "01100";
        binaryRepArray[7] = "10001";
        binaryRepArray[8] = "10010";
        binaryRepArray[9] = "10100";

        for (int i=0; i<zipCode.length(); i++)
        {
            encodedCode += binaryRepArray[Character.getNumericValue(zipCode.charAt(i))];

        }
        return encodedCode;
    }

    /**
     * This method takes in the zip code then calculates the check digit value
     * @param zipCode The zip code
     * @return The check digit value
     */
    private static int calculatingChecksum(String zipCode)
    {
        int sumOfCode = 0;
        int checkDigit = 0;
        for (int i=0; i<zipCode.length(); i++)
        {
            sumOfCode += Character.getNumericValue(zipCode.charAt(i));
        }
       checkDigit = 10-(sumOfCode%10);
        return checkDigit;
    }

    /**
     * This method gets the user input for zip code to encode
     * It appends the check digit to the zip code then calls the binaryRepOfDigits method to encode it
     * Frame bars are added to the encoded zip code to give the entire encoded code
     * Method does not take in any inputs
     * @return The encoded zip code as a String of binary representation of digits
     */
    public static String encodePostNet()
    {
        int checkSum = 0;
        String numberToEncode = "";
        String encodedCode = "";

        Scanner sc = new Scanner(System.in);    //Creating Scanner object
        System.out.print("Enter Zip: ");
        String zipCode  = sc.nextLine();    //Reading user input

        checkSum = calculatingChecksum(zipCode);
        numberToEncode = zipCode + String.valueOf(checkSum);
        encodedCode = "1" + binaryRepOfDigits(numberToEncode) + "1";

        return encodedCode;
    }

    /**
     * This method represents the encoded zip code using '|' and '.'
     * @param encodedCode The encoded zip code
     * @return A representation using '|' and '.'
     */
    public static String barcodeRepresentation(String encodedCode)
    {
        String barcodeRep = "";

        for (int i=0; i<encodedCode.length(); i++)
        {
            if (encodedCode.charAt(i)=='1')
            {
                barcodeRep += "|";
            }
            else
            {
                barcodeRep += ".";
            }
        }
        return barcodeRep;
    }

}
