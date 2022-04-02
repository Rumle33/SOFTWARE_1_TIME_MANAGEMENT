package dtu;

import java.util.ArrayList;

abstract public class Employee {
    private String initials;
    private boolean available;

    public Employee(String initials){
        this.initials = initials;
    }

    abstract protected void createProject();

    abstract protected void registerTimeWorked(int time);

    abstract protected void seekAssistance();

    abstract protected boolean getAvailable();

    abstract protected void setAvailable(boolean available);

    protected String getInitials(){
        return this.initials;
    }

}
