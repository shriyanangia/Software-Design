/**
 * Main driver class that tests UpcEncoding.java
 *
 * @author snangia
 */

public class UpcEncodingDecodingDriver
{
    /**
     * This method will automatically be called when UpcEncodingDriver is run.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args)
    {
        //calls the encodeUPC method
        String encodedCode = UpcEncoding.encodeUPC();
        //prints out the barcode
        System.out.println(encodedCode);

        //calls the barcodeDecoder method
        String decodedBarcode = UpcDecoding.barcodeDecoder();
        //prints out the original product code
        System.out.println(decodedBarcode);
    }
}

// 01254667375
// 10100011010011001001001101100010100011010111101010101000010001001000010100010010011101011100101