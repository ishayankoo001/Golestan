package ir.ac.kntu;

/**
 * The main function used to run the Golestan app.
 */
public class Main {
    public static void main(String[] args) {
        App golestan = App.getInstance();
        App.students.add(new Student("shayan", "koohi", "ishayan", "1234", "9929813"));
        App.availableCourses.add(new Course("888", "riazi", null));
        golestan.appAdmin.login();

    }
}