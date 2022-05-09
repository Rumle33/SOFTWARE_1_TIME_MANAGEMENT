// Hákun

package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class RemoveActivityTest {
    private DevelopmentEmployee Jens;
    private ProjectLeader Casper;
    private Project project;
    private Activity activity;

    public RemoveActivityTest() {
        this.Jens = new DevelopmentEmployee("jens");
        this.project = new Project("Project");
        this.Casper = new ProjectLeader(this.project, "casp");
        this.activity = new Activity("01/01/2022", "31/12/2022", "Activity", this.project);
    }

    @Given("developmentemployee is assigned to activity")
    public void devIsAssignedToActivity() {
        this.Casper.addDevToProject(this.Jens);
        this.Casper.createActivity("01/01/2022", "31/12/2022", "Activity");
        this.Casper.assignEmployeeActivity(this.Casper.assignedProject.getActivity("Activity"), this.Jens);
        assertNotEquals(this.Jens.active_activities.size(), 0);
    }

    @When("projectleader removes activity")
    public void projectleaderRemovesActivity() {
        this.Casper.removeActivity("Activity");
    }

    @Then("activity is removed from all users assigned, and no longer available")
    public void activityRemovedAndUnavailable() {
        assertEquals(this.Jens.active_activities.size(), 0);
        assertEquals(this.Casper.assignedProject.getActivities().size(), 0);
    }

    @Given("activity with the same name does not exist in project")
    public void noActivityWithThatName() {
        this.Casper.createActivity("01/01/2022", "01/01/2022", "Not activity");
        this.activity = new Activity("01/01/2022", "01/01/2022", "Not activity", new Project("test"));
    }

    @Then("nothing changed")
    public void noChanges() {
        assertEquals(this.Casper.assignedProject.getActivity("Not activity").getName(), this.activity.getName());
    }
}
