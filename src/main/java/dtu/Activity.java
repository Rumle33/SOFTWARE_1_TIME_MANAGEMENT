package dtu;

import java.util.Date;
import java.util.Calendar;
import java.util.InputMismatchException;

public class Activity {
    private double estimated_Time = 0;
    private double hours_worked;
    private String start_Date = "";
    private String end_Date = "";
    private String name = "";
    private boolean isPersonal = false;
    private Project assigned_project;

    public Activity(String start_Date, String end_Date, String name, Project assigned_project) {
        this.start_Date = start_Date;
        this.end_Date = end_Date;
        this.name = name;
        this.assigned_project = assigned_project;
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

    public void setStartDate(String start_Date) throws InputMismatchException {
        try {
            if(!start_Date.contains("/")) {
                System.out.println("Input is invalid");
            }
            else {
                String[] dateArr = start_Date.split("/");
                Calendar curDate = Calendar.getInstance();

                int day = Integer.parseInt(dateArr[0]);
                int month = Integer.parseInt(dateArr[1]) - 1;
                int year = Integer.parseInt(dateArr[2]);

                if(month > -1 && month < 12 && year >= curDate.get(Calendar.YEAR)) {
                    Calendar date = Calendar.getInstance();
                    date.set(year, month, 1);
                    if(day > 0 && day <= date.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                        date.set(year, month, day);
                        this.start_Date = start_Date;

                        System.out.println("Year: " + date.get(Calendar.YEAR) + ", Month: " + date.get(Calendar.MONTH) + ", Day: " + date.get(Calendar.DATE));
                    }
                    else {
                        System.out.println("The day is outside the range of this month");
                    }
                }
                else {
                    System.out.println("The day is outside the range of this month");
                }
            }
        }
        catch(InputMismatchException e) {
            System.out.println("Exception " + e);
        }
    }

    public String getEndDate() {
        return end_Date;
    }

    public void setEndDate(String end_Date) {
        try {
            if(!end_Date.contains("/")) {
                System.out.println("Input is invalid");
            }
            else {
                String[] dateArr = end_Date.split("/");
                Calendar curDate = Calendar.getInstance();

                int day = Integer.parseInt(dateArr[0]);
                int month = Integer.parseInt(dateArr[1]) - 1;
                int year = Integer.parseInt(dateArr[2]);

                if(month > -1 && month < 12 && year >= curDate.get(Calendar.YEAR)) {
                    Calendar date = Calendar.getInstance();
                    date.set(year, month, 1);
                    if(day > 0 && day <= date.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                        date.set(year, month, day);

                        Calendar startDate = Calendar.getInstance();
                        String[] startDateArr = this.start_Date.split("/");
                        startDate.set(Integer.parseInt(startDateArr[0]), Integer.parseInt(startDateArr[1]), Integer.parseInt(startDateArr[2]));

                        if(date.after(startDate)) {
                            System.out.println("Deadline cannot be earlier than start");
                        }
                        else {
                            this.end_Date = end_Date;
                            System.out.println("Year: " + date.get(Calendar.YEAR) + ", Month: " + date.get(Calendar.MONTH) + ", Day: " + date.get(Calendar.DATE));
                        }
                    }
                    else {
                        System.out.println("The day is outside the range of this month");
                    }
                }
                else {
                    System.out.println("Input is invalid");
                }
            }
        }
        catch(InputMismatchException e) {
            System.out.println("Exception " + e);
        }
    }

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
