package ir.ac.kntu;

import java.util.Scanner;

/**
 * The person class is extended by classes student and professor, it holds the data that is mutual between them.
 */
public class Person {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String personalNumber;


    public Person(String firstName, String lastName, String userName, String password, String personalNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.personalNumber = personalNumber;
    }


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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }


}
