//Anders

package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class seekHelpTest {

    Project project = new Project("project");
    Activity activity = new Activity("04-04-2022", "05-05-2022", "activity");
    ProjectLeader Casper = new ProjectLeader(project, "C");
    DevelopmentEmployee Jens = new DevelopmentEmployee("J");


    @Given("user is employee")
    public void userIsEmployee(){
        assertTrue(this.Jens instanceof Employee);
    }

    @Given("user has activity assigned")
    public void userHasActivity(){
        this.Jens.active_activities.add(activity);
        assertFalse("Tjekker om listen af aktiviteter er tom",
                this.Jens.active_activities.isEmpty());
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

    @When("user asks for help")
    public void userAsksForHelp(){
        this.Jens.seekAssistance(this.Casper, this.project, this.activity);
    }

    @Then("co-worker helps with the activity")
    public void userHelpsWithActivity(){
        assertTrue(this.Casper.getAssistingActivities().contains(this.activity));
    }

    @Then("user request is denied")
    public void requestDenied(){

    }

}
