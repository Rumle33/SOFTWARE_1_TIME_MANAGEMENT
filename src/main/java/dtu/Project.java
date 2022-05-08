package dtu;
import io.cucumber.java.bs.A;

import java.util.ArrayList;

public class Project {
    private ProjectLeader projectleader = null;
    private String name = "";
    protected ArrayList<Activity> activities = new ArrayList<Activity>();
    protected ArrayList<DevelopmentEmployee> devsInProject = new ArrayList<DevelopmentEmployee>();

    public Project(String name) {
        this.name = name;
    }

    public ProjectLeader getProjectLeader() {
        return projectleader;
    }

    public void setProjectleader(ProjectLeader Proj){
        if(this.projectleader== null){
            this.projectleader = Proj;
        }
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

    public Activity getActivity(String name) {
        ArrayList<Activity> activities = new ArrayList<>();
        for(Activity a : this.activities) {
            if(a.getName().equals(name)) {
                activities.add(a);
            }
        }
        if(activities.size() == 1) {
            return activities.get(0);
        }
        else {
            System.out.println("There are multiple activities with this name");
            return null;
        }
    }

    public ArrayList<Activity> getActivities(){
        return this.activities;
    }

    public void addDevToProject(DevelopmentEmployee dev) {
        this.devsInProject.add(dev);
    }

    public void makeDevProjectleader(DevelopmentEmployee dev, Project project) throws Exception {
        String Initials = dev.getInitials();
        if (project.getProjectLeader() == null) {
            this.projectleader = new ProjectLeader(this, Initials);
            if (devsInProject.contains(dev)) {
                devsInProject.remove(dev);

            } else {
                throw new Exception("Projectleader with the same name already exist ");
            }

        }
    }

    public ArrayList<DevelopmentEmployee> getDevsInProjects(){
        return this.devsInProject;
    }

    public void setDevsInProject(ArrayList<DevelopmentEmployee> devs){
        this.devsInProject = devs;
    }
}
