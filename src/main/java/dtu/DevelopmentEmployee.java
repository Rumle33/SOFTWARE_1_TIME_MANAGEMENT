//Christian

package dtu;

import java.util.ArrayList;

public class DevelopmentEmployee extends Employee {

    private ArrayList<Activity> assisting_activities = new ArrayList<>();
    private boolean available;
    protected double hours_worked;


    public DevelopmentEmployee(String initials) {
        super(initials);
    }


    //metode til at lave projekt
    @Override
    protected void createProject(String name) {
        boolean sameName = false;
        for(Project p : this.getProjects()) { //Tjek for samme navn
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
    // metode til at registrer hvor meget man har arbejdet
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

    // metode til at søge assistance i det pågældene projekt
    @Override
    protected void seekAssistance(Employee employee, Project project, Activity activity) {
        if (employee.getAvailable() && (employee.getProjects().contains(project) && this.active_projects.contains(project))
                && !employee.getActivities().contains(activity)){
            employee.addAssistingActivity(activity);
        }
    }
    // metode til at acceptere assistance i det pågældene projekt
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
// metode til at afvise assistance
    @Override
    protected void denyAssistance(Activity activity) {
        try{
            this.assisting_activities.remove(activity);
        } catch (Exception e){
            System.out.println("Aktiviteten du forsøger fjerne fra dine anmodninger, findes ikke i dine anmodninger" + e);
        }
    }

    // metode assigner projekt
    @Override
    protected void assignToProject(Project project) {
        this.active_projects.add(project);
    }

    // metode til at fjerne project
    @Override
    protected void removeFromProject(Project project) {
        this.active_projects.remove(project);
    }

    protected String getInitials(){
        return super.getInitials();
    }
    // laver activity
    protected void addActivity(Activity activity) {
        this.active_activities.add(activity);
    }
// fjerner aktivitet
    protected void removeFromActivity(Activity activity) {
        this.active_activities.remove(activity);
    }

}
