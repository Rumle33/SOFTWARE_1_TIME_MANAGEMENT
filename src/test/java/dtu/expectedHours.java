package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class expectedHours {

    Project project = new Project("project");
    ProjectLeader Casper = new ProjectLeader(project, "C");
    DevelopmentEmployee Jens = new DevelopmentEmployee("J");
    Activity activity = new Activity("04-04-2022", "05-05-2022", "activity");

    @When("user assigns expected workhours {float}")
    public void assignHours(Float hours){
        this.Casper.setTimeEstimate(hours, activity);
    }

    @Then("{float} workhours are added on activity")
    public void hoursAdded(Float hours){
        assertEquals(activity.getEstimatedTime(), hours, 0.0);
    }

}
