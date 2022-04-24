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

    public String getName() {
        return name;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public Activity getActivity(int index) {
        return this.activities.get(index);
    }

    public void addDevToProject(DevelopmentEmployee dev) {
        this.devs_in_project.add(dev);
    }

    public void Make_devE_Projectleader(DevelopmentEmployee dev) {
        String ca = dev.getInitials();
        if(devs_in_project.contains(dev)){
            devs_in_project.remove(dev);
        }
        this.projectleader = new ProjectLeader(this, ca);

    }
}
