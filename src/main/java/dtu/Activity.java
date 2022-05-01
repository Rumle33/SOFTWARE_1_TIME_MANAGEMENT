package dtu;

import java.util.Date;
import java.util.Calendar;
import java.util.InputMismatchException;

public class Activity {
    private double estimated_Time = 0;
    private double hours_worked;
    private String start_date = "";
    private String end_date = "";
    private String name = "";
    private boolean isPersonal = false;
    private Project assigned_project;


    //Constructor
    public Activity(String start_date, String end_date, String name, Project assigned_project) {
        String start_temp = this.setDate(start_date);
        if (start_temp != null){
            this.start_date = start_temp;
        }
        String end_temp = this.setDate(end_date);
        if (end_temp != null){
            this.end_date = end_temp;
        }
        this.name = name;
        this.assigned_project = assigned_project;
    }

    // Time estimate setter & getter

    public void setEstimatedTime(double estimated_Time) {
        this.estimated_Time = estimated_Time;
    }

    public double getEstimatedTime() {
        return estimated_Time;
    }

    // Date setters & getters

    // Check date validity
    public String setDate(String input_date) throws InputMismatchException{
        try {
            if(!start_date.contains("/")) {
                System.out.println("Input is invalid");
            }
            else {
                String[] dateArr = start_date.split("/");
                Calendar curDate = Calendar.getInstance();

                int day = Integer.parseInt(dateArr[0]);
                int month = Integer.parseInt(dateArr[1]) - 1;
                int year = Integer.parseInt(dateArr[2]);

                if(month > -1 && month < 12 && year >= curDate.get(Calendar.YEAR)) {
                    Calendar date = Calendar.getInstance();
                    date.set(year, month, 1);
                    if(day > 0 && day <= date.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                        date.set(year, month, day);

                        System.out.println("Year: " + date.get(Calendar.YEAR) + ", Month: " + date.get(Calendar.MONTH) + ", Day: " + date.get(Calendar.DATE));
                        return input_date;
                    }
                    else {
                        System.out.println("The day is outside the range of this month");

                    }
                }
                else {
                    System.out.println("The day is outside the range of this month");
                }
            }
            return null;
        }
        catch(InputMismatchException e) {
            System.out.println("Exception " + e);
            return null;
        }
    }

    public void setStartDate(String start_date) {
        String start_temp = this.setDate(start_date);
        if (start_temp != null){
            this.start_date = start_temp;
        }
    }

    public void setEndDate(String end_date) {
        String start_temp = this.setDate(start_date);
        if (start_temp != null){
            this.start_date = start_temp;
        }
    }

    public String getStartDate() {
        return start_date;
    }

    public String getEndDate() {
        return end_date;
    }

    // Workhours add & getter

    public void addHoursWorked(double hours) throws InputMismatchException {
        try {
            hours_worked += hours;
        } catch (InputMismatchException e){
            System.out.println("Exception: " + e);
        }
    }

    public double getHoursWorked(){
        return hours_worked;
    }

    //Other getters & setters

    public String getName() {
        return this.name;
    }

    public boolean isPersonal() {
        return this.isPersonal;
    }

    public void setPersonal(boolean personal) {
        this.isPersonal = personal;
    }

    public Project getProject(){
        return this.assigned_project;
    }
}
