package ir.ac.kntu;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * Student class holds the data of students and has methods that are used by students.
 */
public class Student extends Person {
    Scanner s = new Scanner(System.in);
    private final int maximumNumberOfUnits = 20;
    private ArrayList<ClassProgram> registeredPrograms = new ArrayList<>();
    private ArrayList<Report> passedCourses = new ArrayList<>();
    private String studentSemester;

    public int getStudentDebt() {
        return studentDebt;
    }

    public int calculateStudentDebt() {
        return this.studentDebt;
    }

    public int calculateStudentDebt(int offPercentage) {
        return this.studentDebt * offPercentage / 100;
    }

    public void setStudentDebt(int studentDebt) {
        this.studentDebt = studentDebt;
    }

    private int studentDebt;

    public Student(String firstName, String lastName, String userName, String password, String personalNumber) {
        super(firstName, lastName, userName, password, personalNumber);
        this.studentSemester = personalNumber.substring(0, 2);
    }


    public ArrayList<Report> getPassedCourses() {
        return passedCourses;
    }

    /**
     * Checks if the student can take a given program.
     *
     * @param a
     * @return
     */
    public boolean canPickProgram(ClassProgram a) {
        for (ClassProgram x : registeredPrograms) {
            if ((!(x.programInterferenceCheck(a))) &&
                    (!(x.getProgramSchedule().doSchedulesInterfere(a.getProgramSchedule())))) {
                return false;
            }

        }
        return true;
    }

    /**
     * lets the student log in to the app.
     *
     * @param loginStd
     */

    public static void login(Student loginStd) {
        if (loginStd != null) {
            loginStd.studentControlPanel();
        }
    }

    /**
     * Main control panel of the student
     */

    public void studentControlPanel() {
        int operation;
        System.out.println("0: Show my classes");
        System.out.println("1: Show schedule by day");
        System.out.println("2: Show grades");
        System.out.println("3: Send message to admin");
        System.out.println("4: Order food");
        System.out.println("5: Add progarm");
        System.out.println("9: Exit");
        operation = s.nextInt();
        s.nextLine();
        switch (operation) {
            case 0:
                System.out.println(registeredPrograms.toString());
                App.adminEnterApp();
                break;
            case 1:
                showStudentSchedule();
                break;
            case 2:
                showStudentGrades();
                break;
            case 3:
                sendMessageToAdmin();
                break;
            case 4:
                goToFoodHandlingSystem();
                break;
            case 5:
                Admin.addToProgram();
                break;
            case 9:
                break;
        }
    }

    public void showStudentSchedule() {
        System.out.println("S");
        for (ClassProgram s : registeredPrograms) {
            if (s.getProgramSchedule().getDayOfWeek().contains(0)) {
                System.out.println(s.toString());
            }
        }
        System.out.println("S");
        for (ClassProgram s : registeredPrograms) {
            if (s.getProgramSchedule().getDayOfWeek().contains(1)) {
                System.out.println(s.toString());
            }
        }
        System.out.println("M");
        for (ClassProgram s : registeredPrograms) {
            if (s.getProgramSchedule().getDayOfWeek().contains(2)) {
                System.out.println(s.toString());
            }
        }
        System.out.println("T");
        for (ClassProgram s : registeredPrograms) {
            if (s.getProgramSchedule().getDayOfWeek().contains(3)) {
                System.out.println(s.toString());
            }
        }
        System.out.println("W");
        for (ClassProgram s : registeredPrograms) {
            if (s.getProgramSchedule().getDayOfWeek().contains(4)) {
                System.out.println(s.toString());
            }
        }
        System.out.println("T");
        for (ClassProgram s : registeredPrograms) {
            if (s.getProgramSchedule().getDayOfWeek().contains(5)) {
                System.out.println(s.toString());
            }
        }
        System.out.println("F");
        for (ClassProgram s : registeredPrograms) {
            if (s.getProgramSchedule().getDayOfWeek().contains(6)) {
                System.out.println(s.toString());
            }
        }
        this.studentControlPanel();


    }

    public void showStudentGrades() {

    }

    public void sendMessageToAdmin() {
        try {
            File myObj = new File("Messages.txt");
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("Messages.txt");
            System.out.println("Enter your message:");
            String msg = s.nextLine();
            myWriter.write(this.toString() + ": " + msg);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public int getMaximumNumberOfUnits() {
        return maximumNumberOfUnits;
    }

    public ArrayList<ClassProgram> getRegisteredPrograms() {
        return registeredPrograms;
    }

    public void setRegisteredPrograms(ArrayList<ClassProgram> registeredPrograms) {
        this.registeredPrograms = registeredPrograms;
    }

    public void setPassedCourses(ArrayList<Report> passedCourses) {
        this.passedCourses = passedCourses;
    }

    public String getStudentSemester() {
        return studentSemester;
    }

    public void setStudentSemester(String studentSemester) {
        this.studentSemester = studentSemester;
    }

    public void goToFoodHandlingSystem() {
        setStudentDebt(getStudentDebt() + FoodHandling.welcomePage());
    }
}
