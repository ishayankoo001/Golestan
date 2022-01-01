package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Professor class is very similar to student class but it does not have some of the properties.
 */
public class Professor extends Person {
    ArrayList<ClassProgram> takenPrograms = new ArrayList<>();

    public Professor(String firstName, String lastName, String userName, String password, String personalNumber) {
        super(firstName, lastName, userName, password, personalNumber);
    }

    /**
     * Lets the professor log in
     * @param loginProf the Professor that is trying to log in
     */
    public static void login(Professor loginProf) {
        if (loginProf != null) {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter your password");
            String enteredPassword = s.nextLine();
            if (enteredPassword.equals(loginProf.getPassword())) {
                loginProf.profControlPanel();
            } else {
                System.out.println("Wrong Password");
            }
        }
    }

    /**
     * The main control panel for the professor, which refers professor to needed methods accordingly.
     */
    public void profControlPanel() {
        Scanner s = new Scanner(System.in);
        int operation;
        System.out.println("0: Show my classes");
        System.out.println("9: Exit");
        operation = s.nextInt();
        switch (operation) {
            case 0:
                System.out.println(takenPrograms.toString());
                App.adminEnterApp();
                break;
            case 9:
                break;
        }
    }
}
