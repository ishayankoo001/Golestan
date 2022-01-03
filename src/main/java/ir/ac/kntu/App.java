package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The App class is the main thing the user is dealing with,
 * It handles inputs and send the users outputs accordingly.
 */
public class App {
    static Admin appAdmin = new Admin("admin", "admin");
    static Scanner s = new Scanner(System.in);
    private static App golestan = new App();

    private App() {
    }

    public static App getInstance() {
        return golestan;
    }

    static ArrayList<ClassProgram> availablePrograms = new ArrayList<>();
    static ArrayList<Course> availableCourses = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Professor> professors = new ArrayList<>();

    /**
     * This method is called when the admin enters their password and username correctly.
     */
    protected static void adminEnterApp() {
        int operation = -1;
        String username;
        String password;
        System.out.println("Welcome to golestan !");
        System.out.println("Enter your username: ");
        username = s.nextLine();
        System.out.println("Enter your password");
        password = s.nextLine();
        for (Student s : students) {
            if (s.getUserName().equals(username)) {
                operation = -2;
                if (s.getPassword().equals(password)) {
                    operation = 1;
                } else {
                    System.out.println("Wrong password");
                }
            }
        }
        if (appAdmin.getUserName().equals(username)) {
            operation = -2;
            if (appAdmin.getPassword().equals(password)) {
                operation = 0;
            } else {
                System.out.println("Wrong password");
            }
        }

        switch (operation) {
            case 0:
                adminControlPanel();
                break;
            case 1:
                Student.login(findStudent(username));
                break;
            case 2:
                break;
            case -1:
                System.out.println("Username not found");
                break;
            case -2:
                break;

        }
    }

    /**
     * This method shows the main control panel for the admin, and handles the things that admin can do,
     * it passes the admin through the wanted methods based on the option they choose.
     */
    public static void adminControlPanel() {
        int operation;
        System.out.println("0: Add new student");
        System.out.println("1: Add new Course");
        System.out.println("2: Add new Program");
        System.out.println("3: Add student to program");
        System.out.println("4: Remove student from program");
        System.out.println("5: Show messages.");
        System.out.println("9: Exit");
        operation = s.nextInt();
        s.nextLine();
        switch (operation) {
            case 0:
                appAdmin.addStudent();
                break;
            case 1:
                appAdmin.addCourse();
                break;
            case 2:
                appAdmin.addCourseProgram();
                break;
            case 3:
                Admin.addToProgram();
                break;
            case 4:
                Admin.removeFromProgram();
                break;
            case 5:
                Admin.showAdminMessages();
                break;
            case 9:
                adminEnterApp();
                break;
        }

    }

    /**
     * this method is used to find the student given their username and passes the user to Student class if the given username is correct.
     *
     * @return returns the student with matching username to student class in order for student to login.
     */

    public static Student findStudent(String o) {
        String usrname = o;
        for (Student s : students) {
            if (s.getUserName().equals(usrname)) {
                return s;
            }
        }
        return null;

    }

    /**
     * This method is similar to findStudent.
     *
     * @return
     */
    public static Professor findProf() {
        System.out.println("Enter your username:");
        String usrname = s.nextLine();
        for (Professor p : professors) {
            if (p.getUserName().equals(usrname)) {
                return p;
            }
        }
        System.out.println("Username not found");
        return null;

    }
}
