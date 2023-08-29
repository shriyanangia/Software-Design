import java.util.Scanner;

/**
 * This class has 1 public method
 *
 * @author snangia
 */
public class UpcDecoding
{
    /**
     * This method gets the user input for barcode that needs to be decoded
     * Guard bars are removed from the barcode
     * Barcode is then decoded to give the product code along with its check digit
     * Method has no input parameters
     * @return The product code without the check digit
     */
    public static String barcodeDecoder()
    {
        Scanner sc = new Scanner(System.in);    //Creating Scanner object
        System.out.print("Enter barcode to decode: ");
        String barcode  = sc.nextLine();    //Reading user input

        String decodedBarcode = ""; //string to store the product code to which check digit has been appended

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

        //removes the guard bars from the original barcode to give the trueBarcode
        String trueBarcode = barcode.substring(3,45) + barcode.substring(50,92);

        //for loop iterates through the first half of the trueBarcode 7 digits at a time
        //since each group of 7 digits represents the binary for an integer
        //binary number is compared to each element in the oddBinaryRepArray
        //once match is found index of element in oddBinaryRepArray is added to the decodedBarcode string
        //index = integer value in product code
        for (int i=0; i<trueBarcode.length()/2; i=i+7)
        {
            String eachIntegerSubstring = trueBarcode.substring(i,i+7);
            for (int j=0; j<oddBinaryRepArray.length; j++)
            {
                if (oddBinaryRepArray[j].equals(eachIntegerSubstring))
                {
                    decodedBarcode += j;
                }
            }
        }

        //for loop iterates through the second half of the trueBarcode 7 digits at a time
        //since each group of 7 digits represents the binary for an integer
        //binary number is compared to each element in the evenBinaryRepArray
        //once match is found index of element in evenBinaryRepArray is added to the decodedBarcode string
        //index = integer value in product code
        for (int i=42; i<trueBarcode.length(); i=i+7)
        {
            String eachDigitSubstring = trueBarcode.substring(i,i+7);
            for (int j=0; j<evenBinaryRepArray.length; j++)
            {
                if (evenBinaryRepArray[j].equals(eachDigitSubstring))
                {
                    decodedBarcode += j;
                }
            }
        }

        //returning the product code after removing the check digit
        return decodedBarcode.substring(0,11);
    }
}
