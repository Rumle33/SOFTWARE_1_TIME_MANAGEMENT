package dtu;

import java.util.ArrayList;

abstract public class Employee {
    ArrayList<Project> active_projects = new ArrayList<Project>();
    ArrayList<Activity> active_activities = new ArrayList<Activity>();
    private String initials;

    public Employee(String initials){
        if (initials.length() == 4){
            this.initials = initials;
        } else {
            System.out.println("Initialer skal være på 4 bogstaver");
        }
    }

    abstract protected void createProject(String name);

    abstract protected void registerHoursWorked(double hours, Activity activity);

    abstract protected void seekAssistance(Employee employee, Project project, Activity activity);

    abstract protected boolean getAvailable();

    abstract protected void setAvailable(boolean available);

    abstract protected ArrayList<Activity> getActivities();

    protected Activity getActivity(String name, String projectName) {
        ArrayList<Activity> activities = new ArrayList<>();
        for(Activity a : this.active_activities) {
            if(a.getName().equals(name) && a.getProject().getName().equals(projectName)) {
                activities.add(a);
            }
        }
        if(activities.size() == 1) {
            return activities.get(0);
        }
        else if(activities.size() == 0) {
            System.out.println("There are no activities with this name");
            return null;
        }
        else {
            System.out.println("There are multiple activities with this name");
            return null;
        }
    }

    abstract protected ArrayList<Project> getProjects();

    protected Project getProject(String name) {
        ArrayList<Project> projects = new ArrayList<>();
        for(Project p : this.active_projects) {
            if(p.getName().equals(name)) {
                projects.add(p);
            }
        }
        if(projects.size() == 1) {
            return projects.get(0);
        }
        else if(projects.size() == 0) {
            System.out.println("There are no projects with this name");
            return null;
        }
        else {
            System.out.println("There are multiple projects with this name");
            return null;
        }
    }

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
