package dtu;
import dtu.Employee;

import java.util.ArrayList;

public class ProjectLeader extends Employee {

    private ArrayList<Project> active_projects = new ArrayList<Project>();
    private ArrayList<Activity> active_activities = new ArrayList<Activity>();
    private ArrayList<Activity> assisting_activities = new ArrayList<>();
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
    protected void registerHoursWorked(double time, Activity activity) {
        this.hours_worked += time;
        activity.addHoursWorked(time);
    }

    @Override
    protected void seekAssistance(Employee employee, Project project, Activity activity) {

    }

    @Override
    protected boolean getAvailable() {
        return available;
    }

    @Override
    protected void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    protected ArrayList<Activity> getActivities() {
        return this.active_activities;
    }

    @Override
    protected ArrayList<Project> getProjects() {
        return this.active_projects;
    }

    @Override
    protected ArrayList<Activity> getAssistingActivities() {
        return this.assisting_activities;
    }

    @Override
    protected void addAssistingActivity(Activity activity) {
        this.assisting_activities.add(activity);
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
