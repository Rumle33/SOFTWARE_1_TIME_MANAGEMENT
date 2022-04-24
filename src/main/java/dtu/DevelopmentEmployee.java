package dtu;
import java.util.ArrayList;

public class DevelopmentEmployee extends Employee {

    protected ArrayList<Project> active_projects = new ArrayList<Project>();
    protected ArrayList<Activity> active_activities = new ArrayList<Activity>();
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
    protected void seekAssistance() {

    }

    @Override
    protected boolean getAvailable() {
        return this.available;
    }

    @Override
    protected void setAvailable(boolean available){
        this.available = available;
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
