package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import baseClass.BaseClass;
import java.time.Duration;
import org.junit.Assert;

public class RegistrationConfirmationStepDefs extends BaseClass {
  
  private LoginPage loginPage;
  private EventsPage eventsPage;
  private RegistrationPage registrationPage;
  
  public RegistrationConfirmationStepDefs() {
    loginPage = new LoginPage(driver);
    eventsPage = new EventsPage(driver);
    registrationPage = new RegistrationPage(driver);
  }
  
  @Given("I enter my username and password")
  public void enterUsernameAndPassword() {
    loginPage.enterUsername("username");
    loginPage.enterPassword("password");
    log.info("Entered username and password");
  }
  
  @Given("I click on the login button")
  public void clickLoginButton() {
    loginPage.clickLoginButton();
    log.info("Clicked on the login button");
  }
  
  @When("I click on the {string} link")
  public void clickEventsLink(String linkText) {
    eventsPage.clickEventsLink(linkText);
    log.info("Clicked on the " + linkText + " link");
  }
  
  @When("I click on the event")
  public void clickEvent() {
    eventsPage.clickEvent();
    log.info("Clicked on the event");
  }
  
  @When("I click on the {string} button")
  public void clickontheRegisterButton(String buttonName) {
    registrationPage.clickRegisterButton(buttonName);
    log.info("Clicked on the " + buttonName + " button");
  }
  
  @When("I enter my first name as {string}")
  public void enterFirstName(String firstName) {
    registrationPage.enterFirstName(firstName);
    log.info("Entered first name as " + firstName);
  }
  
  @When("I enter my last name as {string}")
  public void enterLastName(String lastName) {
    registrationPage.enterLastName(lastName);
    log.info("Entered last name as " + lastName);
  }
  
  @When("I enter my email as {string}")
  public void enterEmail(String email) {
    registrationPage.enterEmail(email);
    log.info("Entered email as " + email);
  }
  
  @When("I enter my phone number as {string}")
  public void enterPhoneNumber(String phoneNumber) throws InterruptedException {
    registrationPage.enterPhoneNumber(phoneNumber);
    log.info("Entered phone number as " + phoneNumber);
  }
  
  @When("I enter my card number as {string}")
  public void enterCardNumber(String cardNumber) throws InterruptedException {
    registrationPage.enterCardNumber(cardNumber);
    log.info("Entered card number as " + cardNumber);
  }
  
  @When("I enter the expiration date as {string}")
  public void enterExpirationDate(String expirationDate) throws InterruptedException {
    registrationPage.enterExpirationDate(expirationDate);
    log.info("Entered expiration date as " + expirationDate);
  }
  
  @When("I enter the CVC as {string}")
  public void enterCVC(String cvc) throws InterruptedException {
    registrationPage.enterCVC(cvc);
    log.info("Entered CVC as " + cvc);
  }
  
  @When("I enter the postal code as {string}")
  public void enterPostalCode(String postalCode) throws InterruptedException {
    registrationPage.enterPostalCode(postalCode);
    log.info("Entered postal code as " + postalCode);
  }
  
  @When("I switch to the parent frame")
  public void switchToParentFrame() {
    registrationPage.switchToParentFrame();
    log.info("Switched to parent frame");
  }
  
  @When("I Click on the {string} button")
  public void clickontheButton(String buttonName) throws InterruptedException {
    registrationPage.clickButton(buttonName);
    log.info("Clicked on the " + buttonName + " button");
  }
  
  @Then("I should see the registration confirmation message")
  public void i_should_see_the_registration_confirmation_message() throws InterruptedException {
	  Assert.assertTrue(registrationPage.verifyConfirmationMessage());
      log.info("🌟 Registration Confirmed! 🌟");
  }
}