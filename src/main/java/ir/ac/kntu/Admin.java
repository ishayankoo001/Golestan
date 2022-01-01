package ir.ac.kntu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The admin class controls the students, programs and available courses
 * and is able to remove and add students to the mentioned programs as well
 * It has several methods which are described accordingly.
 */
public class Admin {
    Scanner s = new Scanner(System.in);
    static Scanner h = new Scanner(System.in);
    private String userName = "admin";
    private String password = "admin";
    private App golestan = App.getInstance();

    public Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * The login method is a void method as it does not need input parameters,
     * it gets input from user and if the input for admin credentials is correct, it
     * lets the admin in by calling adminEnterApp method.
     */
    public void login() {

        golestan.adminEnterApp();


    }

    /**
     * @return returns the username
     */

    public String getUserName() {
        return userName;
    }

    /**
     * All getter and setter methods are used to either return the value or let the user determine the value.
     *
     * @return returns the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method is used to remove an attendee from a given program,
     * it finds the student with the given id and checks if the student has the
     * program in their schedule, and if they do, it removes them.
     */
    public static void showAdminMessages(){
        try {
            File myObj = new File("Messages.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        App.adminControlPanel();

    }
    public static void removeFromProgram() {
        System.out.println("Enter program Id:");
        String prgId = h.nextLine();
        System.out.println("Enter student Id:");
        String idToRemove = h.nextLine();
        int index = -1;
        for (ClassProgram c : App.availablePrograms) {
            if (c.getProgramId().equals(prgId)) {
                index = App.availablePrograms.indexOf(c);
            }
        }
        if (index != -1) {
            for (Student s : App.students) {
                if (s.getPersonalNumber().equals(idToRemove)) {
                    App.availablePrograms.get(index).getProgramAttendees().remove(s);
                }

            }
        } else {
            System.out.println("Program not found");
        }

    }

    /**
     * This method is used to add a student to a program,
     * it checks to make sure the student has the right to be in the class.
     */

    public static void addToProgram() {
        System.out.println("Enter program Id:");
        String prgId = h.nextLine();
        System.out.println("Enter student Id:");
        String idToAdd = h.nextLine();
        int index = -1;
        for (ClassProgram c : App.availablePrograms) {
            if (c.getProgramId().equals(prgId)) {
                index = App.availablePrograms.indexOf(c);
            }
        }
        for (Student s : App.students) {
            if (s.getPersonalNumber().equals(idToAdd)) {
                if (Integer.parseInt(s.getStudentSemester()) == (App.availablePrograms.get(index).getSemester())) {
                    for (ClassProgram m : s.getRegisteredPrograms()) {
                        if (m.ProgramInterferenceCheck(App.availablePrograms.get(index))) {
                            System.out.println("Program interfers with one of your current programs");
                            index = -1;
                        }
                    }
                    for (ClassProgram m : s.getRegisteredPrograms()) {
                        if (index != -1) {
                            if (App.availablePrograms.get(index).getProgramCourse().requirementCheck(s)) {
                                System.out.println("You have not passed the required courses");
                                index = -1;
                            }
                        }
                    }


                    if (index != -1) {
                        App.availablePrograms.get(index).getProgramAttendees().add(s);
                        ArrayList<ClassProgram> temp = new ArrayList<>();
                        temp = (s.getRegisteredPrograms());
                        temp.add(App.availablePrograms.get(index));
                        s.setRegisteredPrograms(temp);
                    }
                } else {
                    System.out.println("Program is not for your semester");
                }
            }

        }
        App.adminEnterApp();
    }

    /**
     * This method adds an student to the list of all students, it takes inputs and gives them to student constructor.
     */
    public void addStudent() {
        String fName;
        String lName;
        String uName;
        String pass;
        String stdId;
        System.out.println("Enter student name:");
        fName = s.nextLine();
        System.out.println("Enter student last name:");
        lName = s.nextLine();
        System.out.println("Enter student username:");
        uName = s.nextLine();
        System.out.println("Enter student password:");
        pass = s.nextLine();
        System.out.println("Enter student id:");
        stdId = s.nextLine();
        golestan.students.add(new Student(fName, lName, uName, pass, stdId));
        App.adminControlPanel();
    }

    /**
     * this method is used to make a program based on a course that is added earlier,
     * Users input the time and course and the id for the program and the program will be
     * added to the list of available programs in the app.
     */

    public void addCourseProgram() {
        Professor prof = new Professor("John", "Appleseed", "John", "1234", "100100");
        String name;
        String time;
        String day;
        String classroom;
        int capacity;
        int semes;
        System.out.println("Is class online ?(Y/N):");
        classroom = s.nextLine();
        System.out.println("Enter class capacity: ");
        capacity = s.nextInt();
        s.nextLine();
        if (classroom.equals("N")) {
            System.out.println("Enter class number: ");
            classroom = s.nextLine();
        }
        Classroom cr;
        if (classroom.equals("Y")) {
            cr = new Classroom(capacity);
        } else {
            cr = new Classroom(classroom, capacity);
        }
        System.out.println("Enter course name:");
        name = s.nextLine();
        System.out.println("Enter Class time");
        time = s.nextLine();
        System.out.println("Enter days of the week seperated by comma:");
        day = s.nextLine();
        System.out.println("Enter semester:");
        semes = s.nextInt();
        s.nextLine();
        System.out.println("Enter program id:");
        String prgId = s.nextLine();
        String[] daysArray = day.split(",");
        ArrayList<Integer> daysArrayList = new ArrayList<>();
        for (String s : daysArray) {
            daysArrayList.add(Integer.parseInt(s));
        }
        Schedule prgSchedule = new Schedule(daysArrayList, time);
        Course prgCourse = new Course(null, null, null);
        for (Course s : golestan.availableCourses) {
            if (s.getCourseName().equals(name)) {
                prgCourse = s;
            }
        }
        golestan.availablePrograms.add(new ClassProgram(prgCourse, prgId, prgSchedule, semes, prof, cr));
        App.adminControlPanel();
    }

    /**
     * this method is used to create a new course and also takes the course requirement name as input from user
     * and converts the name to Course by searching through all courses and finding the course with matching name.
     */

    public void addCourse() {
        System.out.println("Enter Course name:");
        String cname = s.nextLine();
        System.out.println("Enter Course Id:");
        String cId = s.nextLine();
        System.out.println("Enter required Course name seperated with comma");
        String cName = s.nextLine();
        String[] splitted = cname.split(",");
        ArrayList<Course> requirements = new ArrayList<>();
        for (String s : splitted) {
            for (Course c : golestan.availableCourses) {
                if (c.getCourseName().equals(s)) {
                    requirements.add(c);
                }
            }
        }
        golestan.availableCourses.add(new Course(cId, cName, requirements));
        App.adminControlPanel();
    }

}
