package dtu;

import java.util.ArrayList;

abstract class Employee {
    private String initials;
    private ArrayList<Project> active_projects = new ArrayList<Project>;
    private ArrayList<Activity> active_activities = new ArrayList<Activity>;

    abstract protected void createProject();

    abstract protected void registerTimeWorked(int time);

    abstract protected void seekAssistance();

    abstract protected boolean isAvailable();

}
