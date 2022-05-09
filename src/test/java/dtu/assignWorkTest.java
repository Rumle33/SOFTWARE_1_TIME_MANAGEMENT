//Anders

package dtu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;


public class assignWorkTest {

    private DevelopmentEmployee Jens = new DevelopmentEmployee("Jens");
    private Project project = new Project("project");
    private ProjectLeader Casper = new ProjectLeader(project,"Casp");
    private Activity activity = new Activity("29/03/2022", "20/06/2022", "activity", project);
    private ErrorMessageHolder errorMessageHolder;

    //Constructor
    public assignWorkTest(){
        errorMessageHolder= new ErrorMessageHolder();
    }


    @Given("user is projectleader")
    public void userProjectleader(){
        assertSame(this.Casper.getClass(), ProjectLeader.class);
    }

    @Given("co-worker is assigned to same project as leader")
    public void isAssignedToProject(){
        this.Jens.assignToProject(project);
        assertTrue(this.Jens.getProjects().contains(this.Casper.assignedProject));
    }

    @Given("co-worker is available")
    public void isAvailable(){
        this.Jens.setAvailable(true);
        assertTrue(this.Jens.getAvailable());
    }

    @Given("co-worker is not assigned to project")
    public void notassigned(){
        assertFalse(Jens.getActivities().contains(activity));
    }

    @Given("co-worker is not available")
    public void workerNotAvailable(){
        this.Jens.setAvailable(false);
        assertFalse(this.Jens.getAvailable());
    }

    @Given("user is not projectleader")
    public void userNotProjectLeader(){
        assertNotSame(this.Jens.getClass(), ProjectLeader.class);
    }

    @When("co-worker is assigned to activity")
    public void assignToActivity(){
        this.Casper.assignEmployeeActivity(activity, Jens);
    }

    @Then("the co-worker is assigned")
    public void assigned(){
        assertTrue(Jens.getActivities().contains(activity));
    }

    //Denne her metode lader til ikke at tjekke om det givne besked er den rigtige, men bare om der er noget (Overflødigt)
    @Then("print error message {string}")
    public void printError(String errorMessage){
        errorMessageHolder.setErrorMessage(errorMessage);
        assertEquals("Checks if the errormessage is the same", errorMessage, errorMessageHolder.getErrorMessage());
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
