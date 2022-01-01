package ir.ac.kntu;

public class Classroom {
    private boolean isOnline;
    private String classNumber;
    private int classCapacity;

    public Classroom(int classCapacity) {
        this.isOnline = true;
        this.classNumber = null;
        this.classCapacity = classCapacity;
    }
    public Classroom(String classNumber, int classCapacity) {
        this.isOnline = false;
        this.classNumber = classNumber;
        this.classCapacity = classCapacity;
    }


    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public int getClassCapacity() {
        return classCapacity;
    }

    public void setClassCapacity(int classCapacity) {
        this.classCapacity = classCapacity;
    }
}
