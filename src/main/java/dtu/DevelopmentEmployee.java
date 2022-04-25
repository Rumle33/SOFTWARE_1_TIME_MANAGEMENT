package dtu;
import java.util.ArrayList;

public class DevelopmentEmployee extends Employee {

    protected ArrayList<Project> active_projects = new ArrayList<Project>();
    protected ArrayList<Activity> active_activities = new ArrayList<Activity>();
    protected ArrayList<Activity> assisting_activities = new ArrayList<>();
    protected ArrayList<DevelopmentEmployee> DevelopmentE = new ArrayList<DevelopmentEmployee>();
    protected ArrayList<ProjectLeader> ProjectLeader = new ArrayList<ProjectLeader>();
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
    protected void seekAssistance(Employee employee, Project project, Activity activity) {
        if (employee.getAvailable() || employee.getProjects().contains(project) || employee.getActivities().contains(activity)){
            employee.addAssistingActivity(activity);
        }
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

    protected String getInitials(){
        return super.getInitials();
    }

    protected void assignToProject(Project project) {
        this.active_projects.add(project);
    }

    protected void chooseProjectLeader(DevelopmentEmployee dev){
        this.DevelopmentE.remove(true);
        //this.dev.add(new ProjectLeader(ProjectLeader));

    }

    protected void addActivity(Activity activity) {
        this.active_activities.add(activity);
    }

    public Activity getActivity(int index) {
        return this.active_activities.get(index);
    }


}
