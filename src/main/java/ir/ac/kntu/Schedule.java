package ir.ac.kntu;

import java.util.ArrayList;

/**
 * The schedule class holds the time and day of the programs,
 * it has some useful methods too.
 */
public class Schedule {
    private ArrayList<Integer> dayOfWeek = new ArrayList<>();
    private int startHour;
    private int startMin;
    private int endHour;
    private int endMin;

    public Schedule(ArrayList<Integer> dayOfWeek, String startTime) {
        this.dayOfWeek = dayOfWeek;
        this.startHour = Integer.parseInt(startTime.split(":")[0]);
        this.startMin = Integer.parseInt(startTime.split(":")[1]);
        this.endHour = startHour + 1;
        this.endMin = (startMin + 30) % 60;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "dayOfWeek=" + dayOfWeek +
                ", startHour=" + startHour +
                ", startMin=" + startMin +
                '}';
    }

    /**
     * Checks if two schedules interfere
     * @param s the schedule to check
     * @return returns true if the schedules interfere
     */

    public boolean doSchedulesInterfere(Schedule s) {
        boolean shouldContinue = false;
        for (int m : this.dayOfWeek) {
            for (int n : s.dayOfWeek) {
                if (m == n) {
                    shouldContinue = true;
                }
            }
        }
        if (!shouldContinue) {
            return false;
        }
        int x;
        int y;
        if (this.endMin >= 30) {
            x = this.startHour - 1;
            y = this.startMin - 30;
        } else {
            x = this.startHour - 2;
            y = 60 - (Math.abs(this.startMin - 30));
        }
        if (s.startHour >= x && s.startHour <= this.endHour) {
            if (s.startHour == x) {
                if (s.startMin <= y) {
                    return false;
                }
            }
            if (s.startHour == this.endHour) {
                if (s.startMin <= this.endMin) {
                    return false;
                }
            }
            return true;

        }
        return false;
    }


    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        if (startHour >= 0 && startHour <= 23) {
            this.startHour = startHour;
        }
    }

    public int getStartMin() {
        return startMin;
    }

    public void setStartMin(int startMin) {
        if (startMin >= 0 && startMin <= 59) {
            this.startMin = startMin;
        }
    }

    public int getEndHour() {
        return endHour;
    }

    public int getEndMin() {
        return endMin;
    }


    public ArrayList<Integer> getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(ArrayList<Integer> dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
