package edu.guilford;

public class User {
    //attributes
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int birthyear;
    private String favcolor;
    private String favanimal;
    private String favseason;
    
    //constructors
    public User() {
    }

    public User(String firstName, String lastName, String password, String email, int birthyear, String favcolor, String favanimal, String favseason) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.birthyear = birthyear;
        this.favcolor = favcolor;
        this.favanimal = favanimal;
        this.favseason = favseason;
    }

    //getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBirthYear() {
        return birthyear;
    }

    public void setBirthYear(int birthyear) {
        this.birthyear = birthyear;
    }

    public String getFavColor() {
        return favcolor;
    }

    public void setFavColor(String favcolor) {
        this.favcolor = favcolor;
    }

    public String getFavAnimal() {
        return favanimal;
    }

    public void setFavAnimal(String favanimal) {
        this.favanimal = favanimal;
    }

    public String getFavSeason() {
        return favseason;
    }

    public void setFavSeason(String favseason) {
        this.favseason = favseason;
    }

    //methods
    // generate a password for the user based on their first name, last name, birth year, favorite color, animal, and season
    public void generatePassword() {
        // get the first two letters of the user's first name and convert the first letter to uppercase
        String firstLetters = firstName.substring(0, 1).toUpperCase() + firstName.substring(1, 2);
        // get the first two letters of the user's last name and convert the second letter to uppercase
        String lastLetters = lastName.substring(0, 1) + lastName.substring(1,2).toUpperCase();
        // get the last two digits of the user's birth year
        String birthYear = Integer.toString(birthyear);
        String lastTwoDigits = birthYear.substring(2, 4);
        // convert the second and third characters of the user's favorite color to uppercase but include the full string in the password
        String upperCaseColor = favcolor.substring(0, 1) + favcolor.substring(1,3).toUpperCase() + favcolor.substring(3);
        // convert the first character of the user's favorite animal to uppercase but include the full string in the password
        String upperCaseAnimal = favanimal.substring(0, 1).toUpperCase() + favanimal.substring(1);
        // convert the first character of the user's favorite season to uppercase but include the first three characters in the password
        String upperCaseSeason = favseason.substring(0, 1).toUpperCase() + favseason.substring(1, 3);
        // concatenate the first letter of the user's first name,birth year, favorite color, animal, season, and last name to create the password
        password = firstLetters + lastTwoDigits + "?" + upperCaseColor + upperCaseAnimal + "!" + upperCaseSeason + lastLetters;
    }
}
