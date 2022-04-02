package dtu;

import java.util.ArrayList;

public class DevelopmentEmployee extends Employee {

    protected ArrayList<Project> active_projects = new ArrayList<Project>();
    protected ArrayList<Activity> active_activities = new ArrayList<Activity>();
    protected ArrayList<DevelopmentEmployee> DevelopmentE = new ArrayList<DevelopmentEmployee>();
    protected ArrayList<ProjectLeader> ProjectLeader = new ArrayList<ProjectLeader>();
    private boolean available;
    private boolean ifChoosenleader;

    public DevelopmentEmployee(String initials) {
        super(initials);
    }

    @Override
    protected void createProject() {

    }

    @Override
    protected void registerTimeWorked(int time) {

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

    public void chooseProjectLeader(boolean ifChoosenleader, ArrayList<DevelopmentEmployee> dev){
        this.ifChoosenleader = ifChoosenleader;
        this.DevelopmentE = dev;







    }

    protected  void voteForProjectleader (DevelopmentEmployee dev){

    }

    protected void registerTimeWorked(){

    }
}
