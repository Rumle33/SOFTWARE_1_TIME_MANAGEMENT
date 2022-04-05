package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

import static org.junit.Assert.*;

public class setWorkhoursTest {

    Project project = new Project("project");
    ProjectLeader Casper = new ProjectLeader(project, "C");
    DevelopmentEmployee Jens = new DevelopmentEmployee("J");
    Activity activity = new Activity("04-04-2022", "05-05-2022", "activity");
    double valid_input = 2.5;
    String invalid_input = "to komma fem";
    double activity_hours_before;


    @Given("user input is {float} - hours worked")
    public void inputHours(){
        assertEquals(valid_input, (double) valid_input, 0.0);
    }

    @When("workhours are inputted")
    public void hoursInputted(){
        activity_hours_before = activity.getHoursWorked();
        this.Casper.registerTimeWorked(valid_input, activity);
    }

    @Then("workhours are registered")
    public void hoursRegistered(){
        assertEquals(activity.getHoursWorked(), activity_hours_before + valid_input, 0.0);
    }

    @Given("user input is {string} - hours worked")
    public void inputHoursInvalid(){
        assertNotEquals(invalid_input.getClass(), double.class);
    }

//    @When("wrong workhours are inputted")
//    @Test(expected = IllegalArgumentException.class)
//    public void wrongHoursInputted(){
//        activity_hours_before = activity.getHoursWorked(); //Ved sgu ikke lige med det her
////        assertThrows(this.Casper.registerTimeWorked(invalid_input, activity));
//
//    }

//    @Then("workhours are not registered")
//    public void hoursNotRegistered(){
//        assertEquals(activity.getHoursWorked(), activity_hours_before + valid_input, 0.0);
//    }

//    @Given("user is developmentemployee")
//    public void userIsDevelopmentEmployee(){
//        assertSame(this.Jens.getClass(), DevelopmentEmployee.class);
//    }
//
//    @Given("user is projectleader")
//    public void userIsProjectLeader(){
//        assertSame(this.Casper.getClass(), ProjectLeader.class);
//    }

}
