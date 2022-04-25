package dtu;

import java.util.ArrayList;

abstract public class Employee {
    private String initials;

    public Employee(String initials){
        if (initials.length() == 4){
            this.initials = initials;
        } else {
            System.out.println("Initialer skal være på 4 bogstaver");
        }
    }

    abstract protected Project createProject(String name);

    abstract protected void registerHoursWorked(double hours, Activity activity);

    abstract protected void seekAssistance(Employee employee, Project project, Activity activity);

    abstract protected boolean getAvailable();

    abstract protected void setAvailable(boolean available);

    abstract protected ArrayList<Activity> getActivities();

    abstract protected ArrayList<Project> getProjects();

    abstract protected ArrayList<Activity> getAssistingActivities();

    abstract protected void addAssistingActivity(Activity activity);

    abstract protected void acceptAssistance(Activity activity);

    abstract protected void denyAssistance(Activity activity);

    abstract protected void assignToProject(Project project);

    abstract protected void removeFromProject(Project project);

    protected String getInitials(){
        return this.initials;
    }

}
