package dtu;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class assignWorkTest {

    private DevelopmentEmployee Jens = new DevelopmentEmployee("j");
    private Project project = new Project("project");
    private ProjectLeader Casper = new ProjectLeader(project,"c");
    private Activity activity = new Activity("29-03-2022", "20-06-2022", "activity");


    public assignWorkTest(DevelopmentEmployee Jens, ProjectLeader Casper, Project project, Activity activity){
        this.Jens = Jens;
        this.Casper = Casper;
        this.project = project;
        this.activity = activity;
        this.Jens.setAvailable(true);
    }

//    @Given("user is projectleader")
//    public void userProjectleader(){
//        assertSame(this.Casper.getClass(), ProjectLeader.class);
//    }

    @Given("co-worker is assigned to same project as leader")
    public void isAssignedToProject(){
        this.Jens.assignToProject(project);
        assertTrue(this.Jens.active_projects.contains(this.Casper.assignedProject));
    }

    @Given("co-worker is available")
    public void isAvailable(){
        assertTrue(this.Jens.getAvailable());
    }

    @When("co-worker is assigned to activity")
    public void assignToActivity(){
        this.Casper.assignEmployeeActivity(activity, Jens);
    }

    @Then("the co-worker is assigned")
    public void assigned(){
        assertTrue(Jens.active_activities.contains(activity));
    }


    /*
     * Note that the constructor is apparently never called, but there are no null
     * pointer exceptions regarding that libraryApp is not set. When creating the
     * BookSteps object, the Cucumber libraries are using that constructor with an
     * object of class LibraryApp as the default.
     *
     * This also holds for all other step classes that have a similar constructor.
     * In this case, the <b>same</b> object of class LibraryApp is used as an
     * argument. This provides an easy way of sharing the same object, in this case
     * the object of class LibraryApp and the errorMessage Holder, among all step classes.
     *
     * This principle is called <em>dependency injection</em>. More information can
     * be found in the "Cucumber for Java" book available online from the DTU Library.
     */




}
