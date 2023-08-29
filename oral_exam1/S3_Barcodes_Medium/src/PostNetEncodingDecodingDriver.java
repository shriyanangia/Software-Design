/**
 * Main driver class that tests PostNetEncoding.java and PostNetDecoding.java
 *
 * @author snangia
 */
public class PostNetEncodingDecodingDriver
{
    /**
     * This method will automatically be called when PostNetEncodingDecodingDriver is run.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args)
    {
        //calls the encodePostNet method
        String encodedCode = PostNetEncoding.encodePostNet();
        //prints out the encoded zip code
        System.out.println(encodedCode);

        //calls the barcodeRepresentation method
        String barRep = PostNetEncoding.barcodeRepresentation(encodedCode);
        //prints out the barcode representation
        System.out.println(barRep);

        //calls the digitsRepOfBinary method
        String decodedCode = PostNetDecoding.digitsRepOfBinary();
        //prints out the original zip code
        System.out.println(decodedCode);
    }
}
