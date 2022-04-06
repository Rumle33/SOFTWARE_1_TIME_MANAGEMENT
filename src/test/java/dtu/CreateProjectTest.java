package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class CreateProjectTest {
    private DevelopmentEmployee Jens = null;
    private ProjectLeader Casper = null;
    private Project project = null;

    public CreateProjectTest() {
        this.Jens = new DevelopmentEmployee("jens");
        this.Casper = new ProjectLeader(project, "casp");
    }

    @Given("user is logged in as projectleader")
    public void isProjectleader() {
        assertTrue(Casper instanceof ProjectLeader);
    }

    @When("project is created, Casper")
    public void createProjectCasper() {
        project = Casper.createProject("Project");
    }

    @Then("project is added to users projectlist, Casper")
    public void projectCreatedCasper() {
        Casper.assignToProject(project);
    }

    @Given("user is logged in as developmentemployee")
    public void isDevelopmentEmployee() {
        assertTrue(Jens instanceof DevelopmentEmployee);
    }

    @When("project is created, Jens")
    public void createProjectJens() {
        project = Jens.createProject("Project");
    }

    @Then("project is added to users projectlist, Jens")
    public void projectCreatedJens() {
        Jens.assignToProject(project);
    }
}
