package edu.guilford;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class UserPassword 
{
    public static void main( String[] args )
    {
        // instantiate a User object
        User user1 = new User();
        // instantiate a second User object
        User user2 = new User();

        // create a Scanner object to read input from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // user one input:
        // get and set the user's first name, then print it out
        System.out.println( "Please enter your first name: " );
        String firstname = keyboard.next();
        user1.setFirstName(firstname);
        // print out the user's first name
        //System.out.println( "Your first name is: " + user1.getFirstName() );

        // get and set the user's last name, then print it out
        System.out.println( "Please enter your last name: " );
        String lastname = keyboard.next();
        user1.setLastName(lastname);
        // print out the user's last name
        //System.out.println( "Your last name is: " + user1.getLastName() );

        // get and set the user's email, then print it out
        System.out.println( "Please enter your email: " );
        String email = keyboard.next();
        user1.setEmail(email);
        // print out the user's email
        //System.out.println( "Your email is: " + user1.getEmail() );

        // get and set the user's birthyear, then print it out
        System.out.println( "Please enter your birthyear (all four digits, ex: 2001): " );
        int birthyear = keyboard.nextInt();
        user1.setBirthYear(birthyear);
        // print out the user's birthyear
        //System.out.println( "Your birthyear is: " + user1.getBirthYear() );

        // get and set the user's favorite color, then print it out
        System.out.println( "Please enter your favorite color: " );
        String favcolor = keyboard.next();
        user1.setFavColor(favcolor);
        // print out the user's favorite color
        //System.out.println( "Your favorite color is: " + user1.getFavColor() );

        // get and set the user's favorite animal, then print it out
        System.out.println( "Please enter your favorite animal: " );
        String favanimal = keyboard.next();
        user1.setFavAnimal(favanimal);
        // print out the user's favorite animal
        //System.out.println( "Your favorite animal is: " + user1.getFavAnimal() );

        // get and set the user's favorite season, then print it out
        System.out.println( "Please enter your favorite season: " );
        String favseason = keyboard.next();
        user1.setFavSeason(favseason);
        // print out the user's favorite season
        //System.out.println( "Your favorite season is: " + user1.getFavSeason() );

        // call the method to generate a password
        user1.generatePassword();
        System.out.println("\n" + "User 1 password is: " + user1.getPassword());
        
        // for output formatting
        System.out.println("\n" + "Encrypted and Decrypted Passwords:");
        
        // Use the AES encryption algorithm to setKey and encrypt the password from AES.java
        AES AES1 = new AES();
        AES1.setKey("ThisIsASecretKey");
        String strToEncrypt = user1.getPassword();
        String encryptedPassword = AES.encrypt(strToEncrypt, "ThisIsASecretKey");
        System.out.println("Your encrypted password is: " + encryptedPassword);

        // Use the AES decryption algorithm to decrypt the password from AES.java
        String strToDecrypt = encryptedPassword;
        String decryptedPassword = AES.decrypt(strToDecrypt, "ThisIsASecretKey");
        System.out.println("Your decrypted password is: " + decryptedPassword + "\n");

        // user two input:
        // get and set the first name for the second user
        System.out.println( "Please enter your first name: " );
        String firstname2 = keyboard.next();
        user2.setFirstName(firstname2);

        // get and set the last name for the second user
        System.out.println( "Please enter your last name: " );
        String lastname2 = keyboard.next();
        user2.setLastName(lastname2);

        // get and set the email for the second user
        System.out.println( "Please enter your email: " );
        String email2 = keyboard.next();
        user2.setEmail(email2);

        // get and set the birth year for the second user
        System.out.println( "Please enter your birthyear (all four digits, ex: 2001): " );
        int birthyear2 = keyboard.nextInt();
        user2.setBirthYear(birthyear2);

        // get and set the favorite color for the second user
        System.out.println( "Please enter your favorite color: " );
        String favcolor2 = keyboard.next();
        user2.setFavColor(favcolor2);

        // get and set the favorite animal for the second user
        System.out.println( "Please enter your favorite animal: " );
        String favanimal2 = keyboard.next();
        user2.setFavAnimal(favanimal2);

        // get and set the favorite season for the second user
        System.out.println( "Please enter your favorite season: " );
        String favseason2 = keyboard.next();
        user2.setFavSeason(favseason2);

        // close the Scanner object
        keyboard.close();

        // call the method to generate a password for the second user
        user2.generatePassword();
        System.out.println("\n" + "User 2 password is: " + user2.getPassword());

        // for output formatting
        System.out.println("\n" + "Encrypted and Decrypted Passwords:");

        // Use the AES encryption algorithm to setKey and encrypt the password from AES.java
        AES AES2 = new AES();
        AES2.setKey("ThisIsASecretKey");
        String strToEncrypt2 = user2.getPassword();
        String encryptedPassword2 = AES.encrypt(strToEncrypt2, "ThisIsASecretKey");
        System.out.println("Your encrypted password is: " + encryptedPassword2);

        // Use the AES decryption algorithm to decrypt the password from AES.java
        String strToDecrypt2 = encryptedPassword2;
        String decryptedPassword2 = AES.decrypt(strToDecrypt2, "ThisIsASecretKey");
        System.out.println("Your decrypted password is: " + decryptedPassword2 + "\n");
    }
}
