package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class setWorkhoursTest {

    Project project = new Project("project");
    ProjectLeader Casper = new ProjectLeader(project, "Casp");
    Activity activity = new Activity("04/04/2022", "05/05/2022", "activity", this.Casper.assignedProject);
    DevelopmentEmployee Jens = new DevelopmentEmployee("Jens");
    double hours_worked;
    double invalid_hours_worked;

    @Given("user input is valid - {float}")
    public void userValidInput(Float hours){
        assertSame(hours.getClass(), Float.class);
    }

    @Given("user input is invalid - {string}")
    public void userInvalidInput(String input){
        assertSame(input.getClass(), String.class);
    }

    @When("{string} is inputted")
    public void invalidHoursInputted(String input){
        invalid_hours_worked = activity.getHoursWorked();
        if (input.getClass() == String.class){
            this.Casper.registerHoursWorked(0, activity);
        }
    }

    @When("{string} is inputted - Developmentemployee")
    public void invalidHoursInputtedDevEmployee(String input){
        invalid_hours_worked = activity.getHoursWorked();
        if (input.getClass() == String.class){
            this.Jens.registerHoursWorked(0, activity);
        }
    }

    @When("{float} is inputted")
    public void hoursInputted(Float hours){
        this.hours_worked = activity.getHoursWorked();
        this.Casper.registerHoursWorked(hours, activity);
    }

    @When("{float} is inputted - Developmentemployee")
    public void hoursInputtedDevEmployee(Float hours){
        this.hours_worked = activity.getHoursWorked();
        this.Jens.registerHoursWorked(hours, activity);
    }

    @Then("nothing is not registered")
    public void userInputNotRegistered(){
        assertEquals(this.invalid_hours_worked, 0, 0.0);
    }

    @Then("{float} is registered")
    public void hoursRegistered(Float hours){
        assertEquals(this.hours_worked + hours, this.activity.getHoursWorked(), 0.0);
    }

}
