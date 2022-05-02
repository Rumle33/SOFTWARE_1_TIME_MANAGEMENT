package dtu;
import java.util.ArrayList;

public class Project {
    private ProjectLeader projectleader = null;
    private String name = "";
    protected ArrayList<Activity> activities = new ArrayList<Activity>();
    protected ArrayList<DevelopmentEmployee> devs_in_project = new ArrayList<DevelopmentEmployee>();

    public Project(String name) {
        this.name = name;
    }

    public ProjectLeader getProjectLeader() {
        return projectleader;
    }

    public void removeProjectLeader(){
        this.projectleader = null;
    }

    public String getName() {
        return name;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public Activity getActivity(int index) {
        return this.activities.get(index);
    }

    public ArrayList<Activity> getActivities(){
        return this.activities;
    }

    public void addDevToProject(DevelopmentEmployee dev) {
        this.devs_in_project.add(dev);
    }

    public void makeDevProjectleader(DevelopmentEmployee dev, Project project) throws Exception {
        String Initials = dev.getInitials();
        if (project.getProjectLeader() == null) {
            this.projectleader = new ProjectLeader(this, Initials);
            if (devs_in_project.contains(dev)) {
                devs_in_project.remove(dev);

            } else {
                throw new Exception("Projectleader with the same name already exist ");
            }

        }
    }

    public ArrayList<DevelopmentEmployee> getDevsInProjects(){
        return this.devs_in_project;
    }
}
