package dtu;

import jdk.internal.icu.text.UnicodeSet;

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

    protected void chooseProjectLeader(boolean ifChoosenleader, DevelopmentEmployee dev){
        DevelopmentE.add(dev);
        this.DevelopmentE.remove(true);

        //this.dev.add(new ProjectLeader(ProjectLeader));

    }

    protected  void voteForProjectleader (DevelopmentEmployee dev){
       // dev.add(ProjectLeader);
    }

    protected void registerTimeWorked(){

    }
}
