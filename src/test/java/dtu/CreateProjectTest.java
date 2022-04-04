package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class CreateProjectTest {
    private DevelopmentEmployee Jens = null;
    private Project project = null;

    public CreateProjectTest() {
        this.Jens = new DevelopmentEmployee("jens");
    }

//    @Given("user is logged in as projectleader")
//    public void isProjectleader() {
//        assertTrue(Jesper instanceof ProjectLeader);
//    }
//
//    @When("project is created")
//    public void createProject(Project project) {
//        this.project = project;
//    }
//
//    @Then("project is created and available") {
//        public void projectCreatedAndAvailable() {
//
//        }
//    }

    @Given("user is logged in as developmentemployee")
    public void isDevelopmentEmployee() {
        assertTrue(Jens instanceof DevelopmentEmployee);
    }

    @When("project is created")
    public void createProject() {
        project = Jens.createProject("Project");
    }

    @Then("project is added to users projectlist")
    public void projectCreated() {
        Jens.assignToProject(project);
    }
}
