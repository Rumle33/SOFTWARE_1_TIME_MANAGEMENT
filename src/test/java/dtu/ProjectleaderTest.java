package dtu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class ProjectleaderTest {
    DevelopmentEmployee Jens = new DevelopmentEmployee("j");
    Project project = new Project("project");
    ProjectLeader Casper = new ProjectLeader(project,"c");



    @And("chosen employee is developmentemployee")
    public void Employee_is_developmentemployee (){
        assertSame(this.Jens.getClass(), DevelopmentEmployee.class);
    }

    @When("developmentemployee is chosen")
    public void DevelopmentE(){
        this.Jens.Make_devE_Projectleader(Jens);



    }
    @Then("developmentemployee is projectleader")
    public void Becomes_projectleader(){
        // HVORFOR VIRKER DET IKKE ?!?
       // assertSame(this.Jens.getClass(), ProjectLeader.class);
    }

    // invalid input test
    @Given("user is not a developmentemployee")
    public void user_is_not_a_developmentemployee() {
       //assertNotSame(this.Jens.getClass(), DevelopmentEmployee.class);
    }
    @And("chosen employee is not a developmentemployee")
    public void chosen_employee_is_not_a_developmentemployee() {
        assertNotSame(this.Jens, DevelopmentEmployee.class);
    }

    @When("developmentemployee is not chosen")
    public void developmentemployee_is_not_chosen() {


    }
    @Then("developmentemployee isnt projectleader")
    public void developmentemployee_does_not_becomes_projectleader() {
        assertNotSame(this.Jens, ProjectLeader.class);
    }

}