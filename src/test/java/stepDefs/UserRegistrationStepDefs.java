package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import baseClass.BaseClass;
import java.time.Duration;
import org.junit.Assert;

public class UserRegistrationStepDefs extends BaseClass {
  
 // private WebDriver driver;
  private LoginPage loginPage;
  private CoursePage coursePage;
  private RegistrationPage registrationPage;
  
  public UserRegistrationStepDefs() {
    //driver = getDriver();
    loginPage = new LoginPage(driver);
    coursePage = new CoursePage(driver);
    registrationPage = new RegistrationPage(driver);
  }
  
  @Given("I am on the login page")
  public void iAmOnLoginPage() {
    loginPage.navigateToLoginPage();
    log.info("Navigated to the login page");
  }
  
  @Given("I have logged in successfully")
  public void iHaveLoggedInSuccessfully() {
    loginPage.login("username", "password");
    log.info("Logged in successfully");
  }
  
  @When("I click on the Courses")
  public void iclickontheCourses() throws InterruptedException {
    coursePage.clickontheCourses();
    log.info("Clicked on the Courses");
  }
  
  @When("I click on the first course")
  public void iClickOnFirstCourse() throws InterruptedException {
    coursePage.clickOnFirstCourse();
    log.info("Clicked on the first course");
  }
  
  @When("I click on Course Register button")
  public void iClickOnCourseRegister() throws InterruptedException {
	  coursePage.clickOnCourseRegistorbutton();
	    log.info("Clicked on the Register");
  }
  
  @When("I enter {string} in the {string} field")
  public void iEnterValueInTheField(String value, String field) throws InterruptedException {
    registrationPage.enterValueInField(value, field);
    log.info("Entered " + value + " in the " + field + " field");
  }
  
  @When("I Enter {string} in the phonenumber field")
  public void ienterValueinthephonenumberfield(String value) throws InterruptedException {
    registrationPage.EnterValueInField(value);
    log.info("Entered " + value + " in the phonenumber field");
  }
  
  @When("I click on Register")
  public void iClickOnRegister() throws InterruptedException {
	  registrationPage.clickOnRegistorbutton();
	    log.info("Clicked on the Register");
  }
  
  @Then("I should be successfully registered for the course")
  public void iShouldBeSuccessfullyRegistered() throws InterruptedException {
    Assert.assertTrue(registrationPage.isRegistrationSuccessful());
    log.info("ðŸŒŸ Registration Confirmed! ðŸŒŸ");
  }
}