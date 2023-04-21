package edu.guilford;

/**
 *
 * @author bousabacw
 */

// these are the imports needed to use the AES encryption
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

// this is the AES class that you need to use the AES encryption
public class AES {

    // these are the attributes needed to use the AES encryption
    // these attributes are used in the encrypt and decrypt methods
    // the secretKey and key attributes are used in the setKey method
    // the purpose of byte[] key is to store the key in bytes
    private static SecretKeySpec secretKey;
    private static byte[] key;

    // this is the setKey method that is used in the encrypt and decrypt methods
    // this method takes a string as a parameter and converts it to a byte array
    // the byte array is then used to create a secret key
    public static void setKey(String myKey) {
        MessageDigest sha = null;
        // this try catch block is used to catch any exceptions that may occur
        // the try block is used to convert the string to a byte array
        try {
            // this line of code converts the string to a byte array
            key = myKey.getBytes("UTF-8");
            // this line of code creates a message digest object
            sha = MessageDigest.getInstance("SHA-1");
            // this line of code updates the message digest object with the byte array
            key = sha.digest(key);
            // this line of code truncates the byte array to 16 bytes
            key = Arrays.copyOf(key, 16);
            // this line of code creates a secret key from the byte array
            secretKey = new SecretKeySpec(key, "AES");
        // this catch block is used to catch any exceptions that may occur
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // this is the encrypt method that takes a string and a secret key as parameters
    // this method uses the AES encryption to encrypt the string
    public static String encrypt(String strToEncrypt, String secret) {
        try {
            // this line of code calls the setKey method and passes the secret key as a parameter
            setKey(secret);
            // this line of code creates a cipher object
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // this line of code initializes the cipher object
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // this line of code encrypts the string and returns the encrypted string
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        // this catch block is used to catch any exceptions that may occur    
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    // this is the decrypt method that takes a string and a secret key as parameters
    // this method uses the AES encryption to decrypt the string
    public static String decrypt(String strToDecrypt, String secret) {
        try {
            // this line of code is used to set the key that is used to decrypt the user's password
            setKey(secret);
            // this line of code creates a cipher object for decryption
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            // this line of code initializes the cipher object
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            // this line of code decrypts the string and returns the decrypted string
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        // this catch block is used to catch any exceptions that may occur    
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
