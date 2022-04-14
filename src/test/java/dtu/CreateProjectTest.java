package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class CreateProjectTest {
    private DevelopmentEmployee Jens;
    private ProjectLeader Casper;
    private Project project = null;

    public CreateProjectTest() {
        this.Jens = new DevelopmentEmployee("jens");
        this.Casper = new ProjectLeader(new Project("Test"), "casp");
    }

    // isDevelopmentEmployee() is in CreateActivityTest.java

    @When("developmentemployee creates project")
    public void devCreatesProject() {
        this.project = this.Jens.createProject("Project");
    }

    @Then("project is added to developmentemployees projectlist")
    public void projectAddedToDevelopmentemployee() {
        this.Jens.assignToProject(project);
    }

    // isProjectleader() is in CreateActivityTest.java

    @When("projectleader creates project")
    public void projectleaderCreatesProject() {
        this.project = this.Casper.createProject("Project");
    }

    @Then("project is added to projectleaders projectlist")
    public void projectAddedToProjectleader() {
        this.Casper.assignToProject(project);
    }
}
