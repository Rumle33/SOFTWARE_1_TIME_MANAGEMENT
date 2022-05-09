package dtu;
import io.cucumber.java.bs.A;

import java.util.ArrayList;

public class DevelopmentEmployee extends Employee {

    private ArrayList<Activity> assisting_activities = new ArrayList<>();
    private boolean available;
    protected double hours_worked;


    public DevelopmentEmployee(String initials) {
        super(initials);
    }

    @Override
    protected void createProject(String name) {
        boolean sameName = false;
        for(Project p : this.getProjects()) {
            if(p.getName().equals(name)) {
                sameName = true;
                break;
            }
        }
        if(sameName) {
            System.out.println("This project already exists");
        }
        else {
            this.active_projects.add(new Project(name));
        }
    }

    @Override
    protected void registerHoursWorked(double hours, Activity activity) {
        this.hours_worked += hours;
        activity.addHoursWorked(hours);
    }

    @Override
    protected boolean getAvailable() {
        return this.available;
    }

    @Override
    protected void setAvailable(boolean available){
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
            if (this.active_activities.size() < 20 ){
                if (this.active_projects.contains(activity.getProject())){
                    this.active_activities.add(activity);
                    this.assisting_activities.remove(activity);
                } else {
                    System.out.println("Du er ikke i projektet, som aktiviteten findes i");
                }
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

    @Override
    protected void assignToProject(Project project) {
        this.active_projects.add(project);
    }

    @Override
    protected void removeFromProject(Project project) {
        this.active_projects.remove(project);
    }

    protected String getInitials(){
        return super.getInitials();
    }

    protected void addActivity(Activity activity) {
        this.active_activities.add(activity);
    }

    protected void removeFromActivity(Activity activity) {
        this.active_activities.remove(activity);
    }

}
