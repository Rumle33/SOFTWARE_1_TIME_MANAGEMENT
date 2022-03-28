package dtu;

public class Activity {
    private double estimated_Time = 0;
    private String start_Date = "";
    private String end_Date = "";
    private String name = "";

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
}
