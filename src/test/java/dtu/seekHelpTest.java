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
//        assertSame(this.Jens.super.class, Employee.class);
    }

    @Given("user has activity assigned")
    public void userHasActivity(){

    }

    @Given("co-worker requested is available")
    public void userRequestedIsAvailable(){

    }

    @Given("user does not have activity assigned")
    public void userDoesNotHaveActivityAssigned(){

    }

    @Given("user requested is not available")
    public void requestedUserNotAvailable(){

    }

    @When("user asks for help")
    public void userAsksForHelp(){

    }

    @Then("co-worker helps with the activity")
    public void userHelpsWithActivity(){

    }

    @Then("user request is denied")
    public void requestDenied(){

    }

}
