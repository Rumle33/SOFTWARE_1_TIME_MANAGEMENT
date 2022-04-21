package dtu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertSame;

public class ProjectleaderTest {
    DevelopmentEmployee Jens = new DevelopmentEmployee("j");
    Project project = new Project("project");
    ProjectLeader Casper = new ProjectLeader(project,"c");



    @And("chosen employee is developmentemployee")
    public void Employee_is_developmentemployee (){
        assertSame(Casper, Jens);
    }

    @When("developmentemployee is chosen")
    public void DevelopmentE(){


    }
    @Then("developmentemployee becomes projectleader")
    public void Becomes_projectleader(){

    }
}