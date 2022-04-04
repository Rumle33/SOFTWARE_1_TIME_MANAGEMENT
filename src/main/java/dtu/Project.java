package dtu;
import java.util.ArrayList;

public class Project {
    private ProjectLeader projectleader = null;
    private String name = "";
    protected ArrayList<Activity> activities = new ArrayList<Activity>();

    public Project(String name) {
        this.name = name;
    }

    public ProjectLeader getProjectLeader() {
        return projectleader;
    }

    public String getName() {
        return name;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }
}
