//Anders

package dtu;

import io.cucumber.java.da.Givet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class seekHelpTest {

    Project project = new Project("project");
    ProjectLeader Casper = new ProjectLeader(project, "C");
    Activity activity = new Activity("04-04-2022", "05-05-2022", "activity", this.Casper.assignedProject);
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

    @Given("co-worker requested is assigned to same project")
    public void userIsInSameProject(){
        this.Casper.assignToProject(project);
        this.Jens.assignToProject(project);
        assertTrue(this.Jens.getProjects().contains(project) || this.Casper.getProjects().contains(project));
    }

    @Given("co-worker requested is not assigned to same project")
    public void userIsNotInSameProject(){
        this.Jens.removeFromProject(project);
        assertFalse(this.Jens.getProjects().contains(project) || this.Casper.getProjects().contains(project));
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

}
