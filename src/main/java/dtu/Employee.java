package dtu;

abstract public class Employee {
    private String initials;
    private boolean available;

    public Employee(String initials){
        this.initials = initials;
    }

    abstract protected Project createProject(String name);

    abstract protected void registerHoursWorked(double hours, Activity activity);

    abstract protected void seekAssistance();

    abstract protected boolean getAvailable();

    abstract protected void setAvailable(boolean available);

    protected String getInitials(){
        return this.initials;
    }

}
