package dtu;

import java.util.InputMismatchException;

public class Activity {
    private double estimated_Time = 0;
    private double hours_worked;
    private String start_Date = "";
    private String end_Date = "";
    private String name = "";
    private boolean isPersonal = false;

    public Activity(String start_Date, String end_Date, String name) {
        this.start_Date = start_Date;
        this.end_Date = end_Date;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public double getEstimatedTime() {
        return estimated_Time;
    }

    public void setEstimatedTime(double estimated_Time) {
        this.estimated_Time = estimated_Time;
    }

    public String getStartDate() {
        return start_Date;
    }

    public void setStartDate(String start_Date) {
        this.start_Date = start_Date;
    }

    public String getEndDate() {
        return end_Date;
    }

    public void setEndDate(String end_Date) {
        this.end_Date = end_Date;
    }

    public void addHoursWorked(double hours) throws InputMismatchException {
        try {
            hours_worked += hours;
        } catch (InputMismatchException e){
            System.out.println("Exeption: " + e);
        }
    }

    public double getHoursWorked(){
        return hours_worked;
    }

    public boolean isPersonal() {
        return this.isPersonal;
    }

    public void setPersonal(boolean personal) {
        this.isPersonal = personal;
    }
}
