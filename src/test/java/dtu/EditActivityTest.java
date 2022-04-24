package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class EditActivityTest {
    private ProjectLeader Casper;
    private Activity activity;
    private String input_startDate;
    private String input_endDate;

    public EditActivityTest() {
        Project project = new Project("Project");
        this.Casper = new ProjectLeader(project, "Casp");
        this.activity = new Activity("01/01-2022", "31/12-2022", "Activity");
    }

//    @Given("user assigns start and deadline for activity")
//    public void userAssignsStartAndDeadline() {
//
//    }

    @Given("input is valid - startDate {string} endDate {string}")
    public void inputValid(String startDate, String endDate) {
        this.input_startDate = startDate;
        this.input_endDate = endDate;
    }

    @When("the start and deadline of the activity is set")
    public void startAndDeadlineIsSet() {
        this.Casper.setStartDate(this.input_startDate, this.activity);
        this.Casper.setEndDate(this.input_endDate, this.activity);
    }

    @Then("the activity registers start and deadline")
    public void startAndDeadlineRegisters() {
        assertEquals(this.activity.getStartDate(), this.input_startDate);
        assertEquals(this.activity.getEndDate(), this.input_endDate);
    }
}
