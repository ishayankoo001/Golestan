package ir.ac.kntu;

/**
 * The main function used to run the Golestan app.
 */
public class Main {
    public static void main(String[] args) {
        App golestan = App.getInstance();
        Student shayan = new Student("shayan", "koohi", "ishayan", "1234", "9929813");
        Course myCourse = new Course("888", "riazi", null);
        App.students.add(shayan);
        App.availableCourses.add(myCourse);
        shayan.getPassedCourses().add(new Report(shayan, myCourse, 20));
        golestan.appAdmin.login();
    }
}