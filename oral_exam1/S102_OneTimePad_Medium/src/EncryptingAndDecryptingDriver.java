/**
 * Main driver class that tests EncryptingAndDecrypting.java
 *
 * @author snangia
 */

public class EncryptingAndDecryptingDriver
{
    /**
     * This method will automatically be called when EncryptingAndDecryptingDriver
     * is run.
     *
     * @param args Command line arguments.
     */

    public static void main(String[] args)
    {
        //calls the encryption method on input string
        EncryptingAndDecrypting.encryption("MEET ME AT THREE");
        //calls the decryption method
        EncryptingAndDecrypting.decryption();
    }

}
