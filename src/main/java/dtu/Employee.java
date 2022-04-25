package dtu;

import java.util.ArrayList;

abstract public class Employee {
    private String initials;

    public Employee(String initials){
        this.initials = initials;
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

    protected String getInitials(){
        return this.initials;
    }

}
