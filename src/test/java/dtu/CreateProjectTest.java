// Hákun

package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

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
    @Given("user is developmentemployee")
    public void userIsDevelopmentEmployee(){
        assertSame(this.Jens.getClass(), DevelopmentEmployee.class);
    }

    @When("developmentemployee creates project")
    public void devCreatesProject() {
        this.Jens.createProject("Project");
    }

    @Then("project is added to developmentemployees projectlist")
    public void projectAddedToDevelopmentemployee() {
        this.Jens.assignToProject(project);
    }

    // isProjectleader() is in CreateActivityTest.java

    @When("projectleader creates project")
    public void projectleaderCreatesProject() {
        this.Casper.createProject("Project");
    }

    @Then("project is added to projectleaders projectlist")
    public void projectAddedToProjectleader() {
        this.Casper.assignToProject(project);
    }

    @Given("project with the same name already exists")
    public void projectWithTheSameNameExists() {
        this.Casper.createProject("Project");
    }

    @Given("dev has a project with the same name")
    public void devHasProjectWithSameName() {
        this.Jens.createProject("Project");
    }

    @When("project with the same name {string} is created")
    public void projectWithTheSameNameIsCreated(String name) {
        this.Casper.createProject(name);
    }

    @When("project with the same name {string} is created by dev")
    public void projectWithTheSameNameIsCreatedByDev(String name) {
        this.Jens.createProject(name);
    }

    @Then("project fails to get created, because project already exists")
    public void projectFailsBecauseProjectAlreadyExists() {
        ArrayList<Project> projects = new ArrayList<>();
        for(Project p : this.Casper.getProjects()) {
            if(p.getName().equals("Project")) {
                projects.add(p);
            }
        }
        assertEquals(projects.size(), 1);
    }

    @Then("project fails to get created, because dev already has project")
    public void projectFailsBecauseDevHasProject() {
        ArrayList<Project> projects = new ArrayList<>();
        for(Project p : this.Jens.getProjects()) {
            if(p.getName().equals("Project")) {
                projects.add(p);
            }
        }
        assertEquals(projects.size(), 1);
    }
}
