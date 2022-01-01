package ir.ac.kntu;

import java.util.ArrayList;

/**
 * Course class holds the data related to the courses
 */
public class Course {
    private String courseId;
    private String courseName;
    ArrayList<Course> requiredCourses = new ArrayList<>();

    /**
     * the constructor
     * @param courseId id of course
     * @param courseName name of course
     * @param requiredCourses the required courses you need to pass in order to be able to take this course.
     */

    public Course(String courseId, String courseName, ArrayList<Course> requiredCourses) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.requiredCourses = requiredCourses;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                '}';
    }

    /**
     * takes a student as input and checks if they are able to pick this course.
     * @param a the student
     * @return returns true if the student has passed all the required courses.
     */

    public boolean requirementCheck(Student a) {
        for (Course x : requiredCourses) {
            if (!(a.getPassedCourses().contains(x))) {
                return false;
            }
        }
        return true;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public ArrayList<Course> getRequiredCourses() {
        return requiredCourses;
    }

    public void setRequiredCourses(ArrayList<Course> requiredCourses) {
        this.requiredCourses = requiredCourses;
    }
}
