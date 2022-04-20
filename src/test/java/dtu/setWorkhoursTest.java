package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class setWorkhoursTest {

    Project project = new Project("project");
    ProjectLeader Casper = new ProjectLeader(project, "C");
    DevelopmentEmployee Jens = new DevelopmentEmployee("J");
    Activity activity = new Activity("04-04-2022", "05-05-2022", "activity");
    double activity_hours_before;
    private InputMismatchException ExceptionThrowable;


    @Given("user input is {float} - hours worked")
    public void inputHours(Float hours){
        assertEquals(hours, (double) hours, 0.0);
    }

    @When("{float} is inputted - Projectleader")
    public void hoursInputted(Float hours){
        activity_hours_before = activity.getHoursWorked();
        this.Casper.registerTimeWorked(hours, activity);
    }

    @When("{float} is inputted - Developmentemployee")
    public void hoursInputtedDev(Float hours){
        activity_hours_before = activity.getHoursWorked();
        this.Jens.registerTimeWorked(hours, activity);
    }

    @Then("{float} hours are registered")
    public void hoursRegistered(Float hours){
        assertEquals(activity.getHoursWorked(), activity_hours_before + hours, 0.0);
    }

    @Given("user input is {string} - hours worked")
    public void inputHoursInvalid(String invalid_input){
        assertNotEquals(invalid_input.getClass(), double.class);
    }

    @When("{string} is inputted")
    @Test(expected = IllegalArgumentException.class)
    public void wrongHoursInputted(String invalid_input){
        activity_hours_before = activity.getHoursWorked(); //Ved sgu ikke lige med det her
//        assertThrows(ExceptionThrowable, this.Casper.registerTimeWorked(invalid_input, activity));

    }

    @Given("user is developmentemployee")
    public void userIsDevelopmentEmployee(){
        assertSame(this.Jens.getClass(), DevelopmentEmployee.class);
    }
}
