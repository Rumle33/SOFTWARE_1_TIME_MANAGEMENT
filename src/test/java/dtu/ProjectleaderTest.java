package dtu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class ProjectleaderTest {
    DevelopmentEmployee Jens = new DevelopmentEmployee("jens");
    DevelopmentEmployee Casper = new DevelopmentEmployee("Casp");
    Project project = new Project("project");

    @And("chosen employee is developmentemployee")
    public void Employee_is_developmentemployee (){
        assertSame(this.Jens.getClass(), DevelopmentEmployee.class);
        this.project.addDevToProject(Jens);
    }

    @When("developmentemployee is chosen")
    public void DevelopmentE() throws Exception {
        this.project.makeDevProjectleader( Jens, project);

    }
    @Then("developmentemployee is projectleader")
    public void Becomes_projectleader(){
        assertSame(this.project.getProjectLeader().getClass(), ProjectLeader.class);

    }

    @And("employee has same initials")
    public void same_intitials(){
        assertEquals(this.project.getProjectLeader().getInitials(), this.Jens.getInitials());

    }

    // invalid input test
    @Given("user is not a developmentemployee")
    public void user_is_not_a_developmentemployee() {
        assertNotSame(this.Casper, DevelopmentEmployee.class);
    }

    @And("chosen employee is not a developmentemployee")
    public void chosen_employee_is_not_a_developmentemployee() {
        assertNotSame(this.Casper, DevelopmentEmployee.class);
    }

    @Then("developmentemployee isnt projectleader")
    public void developmentemployee_does_not_becomes_projectleader() {
        assertNotSame(this.Casper, ProjectLeader.class);

    }

}