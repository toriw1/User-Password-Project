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
        //instantiate a User object
        User user1 = new User();

        // create a Scanner object to read input from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // get and set the user's first name, then print it out
        System.out.println( "Please enter your first name: " );
        String firstname = keyboard.next();
        user1.setFirstName(firstname);
        // print out the user's first name
        System.out.println( "Your first name is: " + user1.getFirstName() );

        // get and set the user's last name, then print it out
        System.out.println( "Please enter your last name: " );
        String lastname = keyboard.next();
        user1.setLastName(lastname);
        // print out the user's last name
        System.out.println( "Your last name is: " + user1.getLastName() );

        // get and set the user's email, then print it out
        System.out.println( "Please enter your email: " );
        String email = keyboard.next();
        user1.setEmail(email);
        // print out the user's email
        System.out.println( "Your email is: " + user1.getEmail() );

        // get and set the user's birthyear, then print it out
        System.out.println( "Please enter your birthyear (all four digits, ex: 2001): " );
        int birthyear = keyboard.nextInt();
        user1.setBirthYear(birthyear);
        // print out the user's birthyear
        System.out.println( "Your birthyear is: " + user1.getBirthYear() );

        // get and set the user's favorite color, then print it out
        System.out.println( "Please enter your favorite color: " );
        String favcolor = keyboard.next();
        user1.setFavColor(favcolor);
        // print out the user's favorite color
        System.out.println( "Your favorite color is: " + user1.getFavColor() );

        // get and set the user's favorite animal, then print it out
        System.out.println( "Please enter your favorite animal: " );
        String favanimal = keyboard.next();
        user1.setFavAnimal(favanimal);
        // print out the user's favorite animal
        System.out.println( "Your favorite animal is: " + user1.getFavAnimal() );

        // get and set the user's favorite season, then print it out
        System.out.println( "Please enter your favorite season: " );
        String favseason = keyboard.next();
        user1.setFavSeason(favseason);
        // print out the user's favorite season
        System.out.println( "Your favorite season is: " + user1.getFavSeason() );

        // close the Scanner object
        keyboard.close();

        // call the method to generate a password
        user1.generatePassword();
        System.out.println("Your password is: " + user1.getPassword());
        
        // Use the AES encryption algorithm to setKey and encrypt the password from AES.java
        AES AES1 = new AES();
        AES1.setKey("ThisIsASecretKey");
        String strToEncrypt = user1.getPassword();
        String encryptedString = AES.encrypt(strToEncrypt, "ThisIsASecretKey");
        String encryptedString1 = AES.encrypt(strToEncrypt, "ThisIsASecretKey");
        System.out.println("Encrypted password: " + encryptedString);
        String encryptedPassword = AES.encrypt(user1.getPassword(),"ThisIsASecretKey");
        System.out.println("Your encrypted password is: " + encryptedPassword);
    }
}
