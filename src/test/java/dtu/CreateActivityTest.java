package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

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
        this.activity = new Activity("01/01/2022", "31/12/2022", "Activity", this.Casper.assignedProject);
        this.Casper.createActivity("01/01/2022", "31/12/2022", "Activity");
    }

    @Then("activity is available in project")
    public void activityAvailableInProject() {
        assertSame(Casper.assignedProject.getActivity("Activity").getName(), this.activity.getName());
    }

    @When("projectleader creates activity for user")
    public void projectleaderCreatesPersonalActivity() {
        this.activity = new Activity("01/01/2022", "31/12/2022", "Activity", this.Casper.assignedProject);
        this.activity.setPersonal(true);
        this.Jens = new DevelopmentEmployee("jens");
        this.Casper.createPersonalActivity(this.Jens, this.activity);
    }

    @Given("activity is vacation or alike")
    public void isVacation() {
        assertTrue(this.Jens.getActivity("Activity", "Project").isPersonal());
    }

    @Then("activity is created and added to employee")
    public void activityAddedToEmployee() {
        assertSame(this.Jens.getActivity("Activity", "Project"), this.activity);
    }

    @Given("activity is not vacation or alike")
    public void isNotVacation() {
        assertFalse(this.activity.isPersonal());
    }

    @Given("user is logged in as developmentemployee")
    public void isDevelopmentEmployee() {
        Project project = new Project("Project");
        this.Jens = new DevelopmentEmployee("jens");
        this.Jens.assignToProject(project);
    }

    @When("personal activity is created")
    public void createPersonalActivity() {
        this.activity = new Activity("01/01/2022", "31/12/2022", "Activity", this.Jens.getProject("Project"));
        this.activity.setPersonal(true);
        this.Jens.addActivity(this.activity);
    }

    @Then("activity is created and added to users activitylist")
    public void activityIsAddedToUsersActivityList() {
        assertSame(this.Jens.getActivity("Activity", "Project"), this.activity);
    }

    @Given("activity with the same name already exists in project")
    public void activityWithSameNameExists() {
        this.Casper.createActivity("01/01/2022", "31/12/2022", "Activity");
    }

    @When("activity with the same name {string} is created")
    public void activityWithSameNameCreated(String name) {
        this.Casper.createActivity("01/01/2022", "31/12/2022", name);
    }

    @Then("activity fails to get created, because activity already exists")
    public void activityIsNotCreatedBecauseActivityAlreadyExists() {
        ArrayList<Activity> activities = new ArrayList<>();
        for(Activity a : this.Casper.assignedProject.getActivities()) {
            if(a.getName().equals("Activity")) {
                activities.add(a);
            }
        }
        assertEquals(activities.size(), 1);
    }
}
