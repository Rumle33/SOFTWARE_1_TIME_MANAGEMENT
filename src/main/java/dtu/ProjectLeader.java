//Anders

package dtu;

//import java.lang.invoke.DelegatingMethodHandle$Holder;
import java.util.ArrayList;

public class ProjectLeader extends Employee {

    private ArrayList<Activity> assisting_activities = new ArrayList<>();
    protected Project assignedProject; //The project that the given person is project leader on
    protected boolean available;
    protected double hours_worked;

    public ProjectLeader(Project assignedProject, String initials){
        super(initials);
        this.assignedProject = assignedProject;
    }

    // meotde der tager en string til at at lave et projekt
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
    // metode fjernet dev fra projekt
    protected void removeProject() {
        ArrayList<DevelopmentEmployee> devsInProject = this.assignedProject.devsInProject;
        for(DevelopmentEmployee dev : devsInProject) {
            dev.removeFromProject(this.assignedProject);
        }
        devsInProject.clear();
        this.removeFromProject(this.assignedProject);
    }
    // metode til at registerer antal timer arbejdet
    @Override
    protected void registerHoursWorked(double time, Activity activity) {
        this.hours_worked += time;
        activity.addHoursWorked(time);
    }

    @Override
    protected boolean getAvailable() {
        return this.available;
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
                && !employee.getActivities().contains(activity)){
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
    // metode der afviser assistance
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
    
    // metode til at fjerne et projekt 
    @Override
    protected void removeFromProject(Project project) {
        this.assignedProject = null;
        project.removeProjectLeader();
        this.active_projects.remove(project);
    }

    protected String getInitials() {
        return super.getInitials();
    }

    public void createActivity(String start_date, String end_date, String activity_name) {
        boolean sameName = false;
        for(Activity a : this.assignedProject.getActivities()) {
            if(a.getName().equals(activity_name)) {
                sameName = true;
                break;
            }
        }
        if(sameName) {
            System.out.println("This activity already exists");
        }
        else {
            this.assignedProject.addActivity(new Activity(start_date, end_date,activity_name, this.assignedProject));
        }
    }

    public void removeActivity(String name) {
        Activity activity = this.assignedProject.getActivity(name);
        if(activity != null) {
            ArrayList<DevelopmentEmployee> devsOnActivity = activity.getDevs();
            for(DevelopmentEmployee dev : devsOnActivity) {
                dev.removeFromActivity(activity);
            }
            devsOnActivity.clear();
            this.assignedProject.removeActivity(activity);
        }
        else {
            System.out.println("This activity does not exist in this project");
        }
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

    public void assignEmployeeActivity(Activity activity, DevelopmentEmployee employee) {
        if (employee.getProjects().contains(this.assignedProject)){
            employee.addActivity(activity);
            activity.addDev(employee);
        }
    }

    public void addActivity(Activity activity) {
        this.active_activities.add(activity);
    }
}
