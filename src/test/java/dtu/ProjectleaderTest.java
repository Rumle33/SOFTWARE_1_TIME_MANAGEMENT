package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

class ProjectleaderTest {
    DevelopmentEmployee Jens = new DevelopmentEmployee("j");
    Project project = new Project("project");
    ProjectLeader Casper = new ProjectLeader(project,"c");

    public void choose_projectleader(DevelopmentEmployee Jens, ProjectLeader Casper){
        this.Jens = Jens;
        this.Casper = Casper;
        this.project = project;
    }

    @Given("user votes for another user")
    public void userVote(){

        assertTrue(5==5);
    }

    @Given("input is valid")
    public void Inputvalid(){

    }

    @When("user votes")
    public void user_votes(){

    }
    @Then("vote is registered")
    public void VoteRegi(){

    }
}