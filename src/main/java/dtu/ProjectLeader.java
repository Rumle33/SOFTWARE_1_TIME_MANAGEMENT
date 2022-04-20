package dtu;

import dtu.Employee;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class ProjectLeader extends Employee {

    private ArrayList<Project> active_projects = new ArrayList<Project>();
    private ArrayList<Activity> active_activities = new ArrayList<Activity>();
    private ArrayList<DevelopmentEmployee> devs_in_assignedProject = new ArrayList<DevelopmentEmployee>();
    protected Project assignedProject; //The project that the given person is project leader on
    protected boolean available;
    protected double hours_worked;

    public ProjectLeader(Project assignedProject, String initials){
        super(initials);
        this.assignedProject = assignedProject;
    }

    @Override
    protected Project createProject(String name) {
        return new Project(name);
    }

    @Override
    protected void registerTimeWorked(double time, Activity activity) {
        this.hours_worked += time;
        activity.addHoursWorked(time);
    }

    @Override
    protected void seekAssistance() {

    }

    @Override
    protected boolean getAvailable() {
        return available;
    }

    @Override
    protected void setAvailable(boolean available) {
        this.available = available;
    }

    protected String getInitials() {
        return super.getInitials();
    }

    public void createActivity(String start_date, String end_date, String activity_name) {
        this.assignedProject.addActivity(new Activity(start_date, end_date,activity_name));
    }

    public void addDevToProject(DevelopmentEmployee dev) {
        this.assignedProject.addDevToProject(dev);
    }

    public void createPersonalActivity(DevelopmentEmployee dev, Activity activity) {
        dev.addActivity(activity);
    }

    public void setTimeEstimate(double estimate, Activity activity) {
        activity.setEstimatedTime(estimate);
    }

    public void setStartDate(String date) {

    }

    public void setEndDate(String date) {

    }

    protected void assignToProject(Project project) {
        this.active_projects.add(project);
    }

    public void assignEmployeeActivity(Activity activity, DevelopmentEmployee employee) {
        if (employee.active_projects.contains(this.assignedProject)){
            employee.active_activities.add(activity);
        }
    }

    public Activity getActivity(int index) {
        return this.active_activities.get(index);
    }

    public int getNumberOfActivities() {
        return this.active_activities.size();
    }
}
