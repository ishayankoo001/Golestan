package ir.ac.kntu;

/**
 * The class used to hold the grades of the courses of students.
 */
public class Report {
    Student reportStudent;
    Course reportCourse;
    int courseGrade;

    @Override
    public String toString() {
        return "Report{" +
                "Course=" + reportCourse +
                ", courseGrade=" + courseGrade +
                '}';
    }
}
