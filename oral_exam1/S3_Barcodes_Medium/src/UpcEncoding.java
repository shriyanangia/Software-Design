import java.util.Scanner;   //in order to read input from keyboard

/**
 * This class has 1 public and 1 private method
 *
 * @author snangia
 */

public class UpcEncoding
{
    /**
     * This method takes in the product code then calculates the check digit value
     * @param productCode The product code to encode
     * @return The check digit value
     */
    private static int calculatingChecksum(String productCode)
    {
        int oddSum = 0; //sum of digits at odd-numbered positions
        int evenSum = 0;    //sum of digits at even-numbered positions
        int total = 0;  //(3*oddSum)+evenSum
        int checkDigit = 0; //the check digit

        //for loop loops across the digits at odd-numbered potions adding them
        for (int i=0; i<productCode.length(); i=i+2)
        {
            oddSum += Character.getNumericValue(productCode.charAt(i));
        }
        //for loop loop across digits at even-numbered positions adding them
        for (int i=1; i<productCode.length(); i=i+2)
        {
            evenSum += Character.getNumericValue(productCode.charAt(i));
        }
        total = (3*oddSum)+evenSum; //calculating total
        checkDigit = 10-(total%10); //subtracting the modulo sum from 10 to get the check digit

        return checkDigit;
    }

    /**
     * This method gets the user input for product code to encode
     * It appends the check digit to the product code then encodes it
     * Guard bars are added to the encoded product code to give the entire barcode
     * Method does not take in any inputs
     * @return The encoded product code as a barcode string
     */
    public static String encodeUPC()
    {
        Scanner sc = new Scanner(System.in);    //Creating Scanner object
        System.out.print("Enter product code: ");
        String productCode  = sc.nextLine();    //Reading user input

        productCode = productCode + String.valueOf(calculatingChecksum(productCode));   //adding check digit to end of product code

        String leftEncodedCode = "";    //string to store the encoded code to the left of the Middle guard
        String rightEncodedCode = "";   //string to store the encoded code to the right of the Middle guard

        //array of odd parity binary numbers for respective integers
        String[] oddBinaryRepArray = new String [10];
        oddBinaryRepArray[0] = "0001101";
        oddBinaryRepArray[1] = "0011001";
        oddBinaryRepArray[2] = "0010011";
        oddBinaryRepArray[3] = "0111101";
        oddBinaryRepArray[4] = "0100011";
        oddBinaryRepArray[5] = "0110001";
        oddBinaryRepArray[6] = "0101111";
        oddBinaryRepArray[7] = "0111011";
        oddBinaryRepArray[8] = "0110111";
        oddBinaryRepArray[9] = "0001011";

       //array of even parity binary numbers for respective integers
        String[] evenBinaryRepArray = new String [10];
        evenBinaryRepArray[0] = "1110010";
        evenBinaryRepArray[1] = "1100110";
        evenBinaryRepArray[2] = "1101100";
        evenBinaryRepArray[3] = "1000010";
        evenBinaryRepArray[4] = "1011100";
        evenBinaryRepArray[5] = "1001110";
        evenBinaryRepArray[6] = "1010000";
        evenBinaryRepArray[7] = "1000100";
        evenBinaryRepArray[8] = "1001000";
        evenBinaryRepArray[9] = "1110100";

        //for loop iterates across first half of product code
        //uses the indexes in the oddBinaryRepArray to code for the numerical values
        for (int i=0; i<productCode.length()/2; i++)
        {
            leftEncodedCode += oddBinaryRepArray[Character.getNumericValue(productCode.charAt(i))];
        }

        //for loop iterates across second half of product code
        //uses the indexes in the evenBinaryRepArray to code for the numerical values
        for (int i=6; i<productCode.length(); i++)
        {
            rightEncodedCode += evenBinaryRepArray[Character.getNumericValue(productCode.charAt(i))];
        }

        //adds the guard bars to the encoded code to give the final encoded barcode
        String encodedCode = "101" + leftEncodedCode + "01010" + rightEncodedCode + "101";

        return encodedCode;
    }

}
