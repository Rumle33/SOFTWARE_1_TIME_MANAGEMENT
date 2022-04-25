package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class CreateActivityTest {
    private Activity activity;
    private DevelopmentEmployee Jens;
    private ProjectLeader Casper;

    public CreateActivityTest() {
    }

    @Given("user is logged in as projectleader")
    public void isProjectleader() {
        Project project = new Project("Project");
        this.Casper = new ProjectLeader(project,"casp");
    }

    @When("activity is created and added to project")
    public void createAndAddActivity() {
        this.activity = new Activity("01-01-2022", "31-12-2022", "Activity", this.Casper.assignedProject);
        this.Casper.createActivity("01-01-2022", "31-12-2022", "Activity");
    }

    @Given("activity is not vacation or alike")
    public void isNotVacation() {
        assertFalse(Casper.assignedProject.getActivity(0).isPersonal());
    }

    @Then("activity is available in project")
    public void activityAvailableInProject() {
        assertSame(Casper.assignedProject.getActivity(0).getName(), this.activity.getName());
    }

    @When("activity is created")
    public void createPersonalActivity() {
        this.activity = new Activity("01-01-2022", "31-12-2022", "Activity", this.Casper.assignedProject);
        this.activity.setPersonal(true);
        this.Jens = new DevelopmentEmployee("jens");
        this.Casper.createPersonalActivity(this.Jens, this.activity);
    }

    @Given("activity is vacation or alike")
    public void isVacation() {
        assertTrue(this.Jens.getActivity(0).isPersonal());
    }

    @Then("activity is created and added to employee")
    public void activityAddedToEmployee() {
        assertSame(this.Jens.getActivity(0), this.activity);
    }

//    @Given("user is logged in as developmentemployee")
//    public void isDevelopmentemployeeTest1() {
//        this.Jens = new DevelopmentEmployee("jens");
//    }
//
//    @When("activity is created")
//    public void createActivityTest1() {
//        this.activity = new Activity("01/01-2022", "31/12-2022", "Activity");
//    }
//
//    @Given("activity is not vacation or alike")
//    public void isVacationTest1() {
//        assertFalse(this.activity.isPersonal());
//    }
//
//    @Then("activity fails to get created")
//    public void activityIsNotCreated() {
//        System.out.println("User is not authorized to create activity");
//    }
//
    @Given("user is logged in as developmentemployee")
    public void isDevelopmentEmployee() {
        Project project = new Project("Project");
        this.Jens = new DevelopmentEmployee("jens");
        this.Jens.assignToProject(project);
    }

    @When("personal activity is created")
    public void createActivityTest2() {
        this.activity = new Activity("01-01-2022", "31-12-2022", "Activity", this.Jens.getProject(0));
        this.activity.setPersonal(true);
        this.Jens.addActivity(this.activity);
    }

    @Then("activity is created and added to users activitylist")
    public void activityIsAddedToUsersActivityList() {
        assertSame(this.Jens.getActivity(0), this.activity);
    }
}
