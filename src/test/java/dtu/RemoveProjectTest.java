package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class RemoveProjectTest {
    private DevelopmentEmployee Jens;
    private ProjectLeader Casper;
    private Project project;

    public RemoveProjectTest() {
        this.Jens = new DevelopmentEmployee("jens");
        this.project = new Project("Project");
        this.Casper = new ProjectLeader(this.project, "casp");
    }

    @Given("projectleader has project assigned")
    public void projectleaderHasProjectAssigned() {
        assertNotSame(this.Casper.assignedProject, null);
    }

    @Given("developmentemployee is assigned to project")
    public void devsAreAssigned() {
        this.Casper.addDevToProject(this.Jens);
        assertNotEquals(this.Jens.active_projects.size(), 0);
    }

    @When("project is removed")
    public void projectRemoved() {
        this.Casper.removeProject();
    }

    @Then("project is removed from all users assigned, and no longer available")
    public void projectIsRemovedAndUnavailable() {
        assertSame(this.Casper.assignedProject, null);
        assertEquals(this.Jens.active_projects.size(), 0);
    }
}
