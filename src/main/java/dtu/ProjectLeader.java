package dtu;

import dtu.Employee;

import java.util.ArrayList;

public class ProjectLeader extends Employee {

    private ArrayList<Project> active_projects = new ArrayList<Project>();
    private ArrayList<Activity> active_activities = new ArrayList<Activity>();
    protected Project assignedProject; //The project that the given person is project leader on
    protected boolean available;

    public ProjectLeader(Project assignedProject, String initials){
        super(initials);
        this.assignedProject = assignedProject;
    }

    @Override
    protected Project createProject(String name) {
        Project project = new Project(name);
        return project;
    }

    @Override
    protected void registerTimeWorked(int time) {

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

    protected String getInitials(){
        return super.getInitials();
    }

    public void createActivity(String start_date, String end_date, String activity_name){
        this.assignedProject.activities.add(new Activity(start_date, end_date,activity_name));
    }

    public void setTimeEstimate(double estimate){

    }

    public void setStartDate(String date){

    }

    public void setEndDate(String date){

    }

    public void assignEmployeeActivity(Activity activity, DevelopmentEmployee employee){
        if (employee.active_projects.contains(this.assignedProject)){
            employee.active_activities.add(activity);
        }
    }
}
