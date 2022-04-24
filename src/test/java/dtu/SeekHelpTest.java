package dtu;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SeekHelpTest {
    private DevelopmentEmployee Jens;
    private DevelopmentEmployee Bo;
    private Activity activity;

    public SeekHelpTest() {
         this.Jens = new DevelopmentEmployee("jens");
         this.Bo = new DevelopmentEmployee("bo");
         this.activity = new Activity("01/01-2022", "31/12-2022", "activity");
//         for(int i = 0; i < 6; i++) {
//             this.Jens.addDevToList(new DevelopmentEmployee("person" + i));
//             if(i > 0 && i < 5) {
//                 this.Jens.getDevs().get(i).setAvailable(true);
//             }
//             else {
//                 this.Jens.getDevs().get(i).setAvailable(false);
//             }
//             System.out.println(this.Jens.getDevs().get(i).getInitials());
//         }
    }

    @Given("user has activity assigned")
    public void userHasActivityAssigned() {
        this.Jens.addActivity(this.activity);
//        assertTrue(this.Jens.getActivities().size() != 0);
    }

    @When("user asks for help")
    public void asksForHelp() {

    }

    @Given("user requested is available")
    public void isUserRequestedAvailable() {
        this.Jens.seekAssistance(this.activity);
    }

    @Given("user requested is part of the same project")
    public void userIsInSameProject() {

    }

    @Given("user requested accepts request to help")
    public void userAccepts() {

    }

    @Then("user asked for help, helps with the activity")
    public void userAskedHelps() {

    }
}
