package dtu;
import java.util.ArrayList;

public class DevelopmentEmployee extends Employee {

    private ArrayList<Project> active_projects = new ArrayList<Project>();
    private ArrayList<Activity> active_activities = new ArrayList<Activity>();
    private ArrayList<Activity> assisting_activities = new ArrayList<>();
    private boolean available;
    protected double hours_worked;


    public DevelopmentEmployee(String initials) {
        super(initials);
    }

    @Override
    protected Project createProject(String name) {
        Project project = new Project(name);
        return project;
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

    protected Project getProject(int index) {
        return this.active_projects.get(index);
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
            if (this.active_activities.size() <= 20 || this.active_projects.contains(activity.getProject())){
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

    protected String getInitials(){
        return super.getInitials();
    }

    @Override
    protected void assignToProject(Project project) {
        this.active_projects.add(project);
    }

    @Override
    protected void removeFromProject(Project project) {
        this.active_projects.remove(project);
    }

    protected void addActivity(Activity activity) {
        this.active_activities.add(activity);
    }

    public Activity getActivity(int index) {
        return this.active_activities.get(index);
    }


}
