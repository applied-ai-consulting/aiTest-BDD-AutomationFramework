package stepDefs;

import io.cucumber.java.en.Given;
import java.io.FileInputStream;
import java.util.Properties;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
    registrationPage.isRegistrationSuccessful();
    log.info("🌟 Registration Confirmed! 🌟");
  }
  
  @When("I click on the course image")
  public void clickOnCourseImage() {
    coursePage.clickCourseImage();
    log.info("Clicked on the course image");
  }
  String Username;
	String Password;
	public void enterCredentials(String userType) throws Throwable {
	    int userIndex = Integer.parseInt(System.getenv("USER_INDEX"));
	    System.out.println("UserIndex : " + System.getenv("USER_INDEX"));

	    Properties properties = new Properties();
	    FileInputStream input = new FileInputStream("Userdetails.properties");
	    // Load the properties file
	    properties.load(input);

	    int numberOfUsers = 0;
	    String keyPrefix=null;
	    
	    if (userType.equals("email")) {
	        keyPrefix = "email";
	        while (properties.containsKey(keyPrefix + (numberOfUsers + 1) + ".Useremail")) {
	            numberOfUsers++;
	        }
	    } else {
	        
	    	System.out.println("No User defined");	
			
	    }
	    System.out.println("Number of "+ keyPrefix + " users provided : " + numberOfUsers);

	    //Calculate effective user index
	    int effectiveUserIndex = (userIndex - 1) % numberOfUsers + 1;
	    String userKey = keyPrefix + effectiveUserIndex;
	  //Get the property value
	    Username = properties.getProperty(userKey + ".Useremail");
	    System.out.println("Logged-in User : " + userKey + ".Useremail" + " - " + Username);
	    
	  //  driver.findElement(By.name("email")).sendKeys(Username);
//	    Actions act = new Actions (driver);
//        WebElement emailInput = driver.findElement(By.name("email"));
//        Thread.sleep(1000);
//        act.moveToElement(emailInput).click();
//        act.sendKeys(Username);
//        act.perform();
	    WebElement emailInput = driver.findElement(By.name("email"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailInput);
        emailInput.sendKeys(Username);

	}
	
	@When("I enter email id in the email field")
	public void I_enter_email_id_in_the_email_filed() throws Throwable {
		enterCredentials("email");
		
	}
    @When("I Enter email id in the email field")
	public void I_Enter_email_id_in_the_email_filed() throws Throwable {
		enterCredentials("email");
		
	}

}