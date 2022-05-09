//Anders

package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class seekHelpTest {

    Project project = new Project("project");
    ProjectLeader Casper = new ProjectLeader(project, "Casp");
    Activity activity = new Activity("04/04/2022", "05/05/2022", "activity", this.Casper.assignedProject);
    DevelopmentEmployee Jens = new DevelopmentEmployee("Jesp");

    @Given("user is employee")
    public void userIsEmployee(){
        assertTrue(this.Jens instanceof Employee);
    }

    @Given("user has activity assigned")
    public void userHasActivity(){
        this.Jens.addActivity(activity);
        assertFalse("Tjekker om listen af aktiviteter er tom",
                this.Jens.getActivities().isEmpty());
    }

    @Given("co-worker requested is available")
    public void userRequestedIsAvailable(){
        this.Casper.setAvailable(true);
        assertTrue(this.Casper.getAvailable());
    }

    @Given("user does not have activity assigned")
    public void userDoesNotHaveActivityAssigned(){
        assertTrue(this.Jens.getActivities().isEmpty());
    }

    @Given("user requested is not available")
    public void requestedUserNotAvailable(){
        assertFalse(this.Casper.getAvailable());
    }

    @Given("co-worker requested is assigned to same project")
    public void userIsInSameProject(){
        this.Casper.assignToProject(project);
        this.Jens.assignToProject(project);
        assertTrue(this.Jens.getProjects().contains(project) && this.Casper.getProjects().contains(project));
    }

    @Given("co-worker requested is not assigned to same project")
    public void userIsNotInSameProject(){
        this.Jens.removeFromProject(project);
        assertFalse(this.Jens.getProjects().contains(project) && this.Casper.getProjects().contains(project));
    }

    @Given("projectleader has activity assigned")
    public void projectleaderHasActivityAssigned() {
        this.Casper.addActivity(this.activity);
        assertFalse("Tjekker om listen af aktiviteter er tom",
                this.Casper.getActivities().isEmpty());
    }

    @Given("developmentemployee requested is available")
    public void devRequestedIsAvailable() {
        this.Jens.setAvailable(true);
        assertTrue(this.Jens.getAvailable());
    }

    @When("user asks for help")
    public void userAsksForHelp(){
        this.Jens.seekAssistance(this.Casper, this.project, this.activity);
    }

    @When("co-worker requested accepts")
    public void coworkerAccepts(){
        this.Casper.acceptAssistance(this.activity);
    }

    @When("co-worker requested denies")
    public void coworkerDenies(){
        this.Casper.denyAssistance(this.activity);
    }

    @When("projectleader asks for help")
    public void projectleaderAsksForHelp() {
        this.Casper.seekAssistance(this.Jens, this.project, this.activity);
    }

    @When("developmentemployee requested accepts")
    public void devAccepts() {
        this.Jens.acceptAssistance(this.activity);
    }

    @When("developmentemployee requested denies")
    public void devDenies() {
        this.Jens.denyAssistance(this.activity);
    }

    @Then("co-worker is not put on the requested activity")
    public void coworkerNotOnActivity(){
        assertFalse(this.Casper.getActivities().contains(this.activity));
    }

    @Then("co-worker helps with the activity")
    public void userHelpsWithActivity(){
        assertTrue(this.Casper.getActivities().contains(this.activity));
    }

    @Then("co-worker is not requested")
    public void requestDenied(){
        assertFalse(this.Casper.getAssistingActivities().contains(this.activity));
    }

    @Then("developmentemployee is not requested")
    public void projectleadersRequestDenied(){
        assertFalse(this.Jens.getAssistingActivities().contains(this.activity));
    }

    @Then("developmentemployee helps with the activity")
    public void devIsPutOnActivity() {
        assertTrue(this.Jens.getActivities().contains(this.activity));
    }

    @Then("developmentemployee is not put on activity")
    public void devIsNotPutOnActivity() {
        assertFalse(this.Jens.getActivities().contains(this.activity));
    }
}