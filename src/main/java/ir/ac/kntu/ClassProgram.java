package ir.ac.kntu;

import java.util.ArrayList;

/**
 * this is the class that handles Program datas.
 */
public class ClassProgram {
    private Course programCourse;
    private Classroom programClassroom;
    private String programId;
    private Schedule programSchedule;
    private ArrayList<Student> programAttendees = new ArrayList<>();
    private int semester;
    private Professor programProfessor;

    /**
     * The constructor class.
     * @param programCourse the course of the program
     * @param programId the id of the program
     * @param programSchedule the schedule of the program
     * @param semester the semester which is accepted for the program
     * @param programProfessor the professor that teaches the course of the program
     */
    public ClassProgram(Course programCourse, String programId, Schedule programSchedule, int semester, Professor programProfessor, Classroom programClassroom) {
        this.programCourse = programCourse;
        this.programId = programId;
        this.programSchedule = programSchedule;
        this.semester = semester;
        this.programProfessor = programProfessor;
        this.programClassroom = programClassroom;
    }

    @Override
    public String toString() {
        return "ClassProgram{" +
                "programCourse=" + programCourse +
                ", programId='" + programId + '\'' +
                ", programSchedule=" + programSchedule +
                '}';
    }

    /**
     * This method takes a Program as input and checks wheter the schedule of that program interferes with the current program.
     * @param a program to check
     * @return returns false if the programs interfere
     */
    boolean ProgramInterferenceCheck(ClassProgram a) {
        if (this.programSchedule.doSchedulesInterfere(a.programSchedule)) {
            return true;
        }
        return false;
    }

    public Course getProgramCourse() {
        return programCourse;
    }

    public void setProgramCourse(Course programCourse) {
        this.programCourse = programCourse;
    }

    public Schedule getProgramSchedule() {
        return programSchedule;
    }

    public void setProgramSchedule(Schedule programSchedule) {
        this.programSchedule = programSchedule;
    }

    public ArrayList<Student> getProgramAttendees() {
        return programAttendees;
    }

    public void setProgramAttendees(ArrayList<Student> programAttendees) {
        this.programAttendees = programAttendees;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }
}
