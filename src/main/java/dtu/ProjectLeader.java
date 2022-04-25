package dtu;
import dtu.Employee;

import java.util.ArrayList;

public class ProjectLeader extends Employee {

    private ArrayList<Project> active_projects = new ArrayList<Project>();
    private ArrayList<Activity> active_activities = new ArrayList<Activity>();
    private ArrayList<Activity> assisting_activities = new ArrayList<>();
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

    @Override
    protected void seekAssistance(Employee employee, Project project, Activity activity) {
        if (employee.getAvailable() && (employee.getProjects().contains(project) && this.active_projects.contains(project))
                && employee.getActivities().contains(activity)){
            employee.addAssistingActivity(activity);
        }
    }

    @Override
    protected void acceptAssistance(Activity activity) {
        try{
            if (this.active_activities.size() <= 20){
                this.active_activities.add(activity);
                this.assisting_activities.remove(activity);
            } else {
                System.out.println("For mange aktive aktiviteter");
            }
        } catch (Exception e){
            System.out.println("Aktiviteten du forsøger at assistere på, findes ikke i dine anmodninger" + e);
        }
    }

    @Override
    protected void denyAssistance(Activity activity) {
        try{
             this.assisting_activities.remove(activity);
        } catch (Exception e){
            System.out.println("Aktiviteten du forsøger fjerne fra dine anmodninger, findes ikke i dine anmodninger" + e);
        }
    }

    protected String getInitials() {
        return super.getInitials();
    }

    public void createActivity(String start_date, String end_date, String activity_name) {
        this.assignedProject.addActivity(new Activity(start_date, end_date,activity_name, this.assignedProject));
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

    public void setStartDate(String date, Activity activity) {
        activity.setStartDate(date);
    }

    public void setEndDate(String date, Activity activity) {
        activity.setEndDate(date);
    }

    @Override
    protected void assignToProject(Project project) {
        this.active_projects.add(project);
    }

    @Override
    protected void removeFromProject(Project project) {
        this.assignedProject = null;
        project.removeProjectLeader();
        this.active_projects.remove(project);
    }


    public void assignEmployeeActivity(Activity activity, DevelopmentEmployee employee) {
        if (employee.getProjects().contains(this.assignedProject)){
            employee.getActivities().add(activity);
        }
    }

    public Activity getActivity(int index) {
        return this.active_activities.get(index);
    }

    public int getNumberOfActivities() {
        return this.active_activities.size();
    }

}
