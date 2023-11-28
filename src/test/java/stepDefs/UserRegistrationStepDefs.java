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
  
  private WebDriver driver;
  private LoginPage loginPage;
  private CoursePage coursePage;
  private RegistrationPage registrationPage;
  
  public UserRegistrationStepDefs() {
    driver = getDriver();
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
  
  @When("I click on {string}")
  public void iClickOn(String element) {
    coursePage.clickOnElement(element);
    log.info("Clicked on " + element);
  }
  
  @When("I click on the first course")
  public void iClickOnFirstCourse() {
    coursePage.clickOnFirstCourse();
    log.info("Clicked on the first course");
  }
  
  @When("I click on {string}")
  public void iClickOnRegister(String element) {
    registrationPage.clickOnElement(element);
    log.info("Clicked on " + element);
  }
  
  @When("I enter {string} in the {string} field")
  public void iEnterValueInTheField(String value, String field) {
    registrationPage.enterValueInField(value, field);
    log.info("Entered " + value + " in the " + field + " field");
  }
  
  @Then("I should be successfully registered for the course")
  public void iShouldBeSuccessfullyRegistered() {
    Assert.assertTrue(registrationPage.isRegistrationSuccessful());
    log.info("Registration is successful");
  }
}