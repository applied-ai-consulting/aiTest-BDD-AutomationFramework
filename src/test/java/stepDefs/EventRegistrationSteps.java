package stepDefs;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pageObjects.EventRegistrationPage;
import pageObjects.Homepage;
import baseClass.BaseClass;
import org.junit.Assert;

public class EventRegistrationSteps extends BaseClass {

    private Homepage homePage;
    private EventRegistrationPage eventRegistrationPage;

    @Given("^User is on the Wajooba login page$")
    public void user_is_on_the_wajooba_login_page() {
        homePage = new Homepage(driver);
        homePage.navigateToLoginPage();
        log.info("Navigated to Wajooba login page");
    }

    @When("^User enters valid username and password$")
    public void user_enters_valid_username_and_password() {
        homePage.enterCredentials("user", "password");
        log.info("Entered valid username and password");
    }

    @When("^User clicks on the login button$")
    public void user_clicks_on_the_login_button() {
        homePage.clickLogin();
        log.info("Clicked on the login button");
    }

    @Then("^User should be redirected to the homepage successfully$")
    public void user_should_be_redirected_to_the_homepage_successfully() {
        Assert.assertTrue("User is not on the homepage", homePage.isOnHomepage());
        log.info("User redirected to the homepage successfully");
    }

    @When("^User navigates to the events section$")
    public void user_navigates_to_the_events_section() throws InterruptedException {
        eventRegistrationPage = homePage.navigateToEventsSection();
        log.info("User navigated to the events section");
    }

    @When("^User selects an event$")
    public void user_selects_an_event() throws InterruptedException {
        eventRegistrationPage.selectEvent();
        log.info("User selected an event");
    }

    @When("^User clicks on the register button for the selected event$")
    public void user_clicks_on_the_register_button_for_the_selected_event() throws InterruptedException {
        eventRegistrationPage.clickRegisterButton();
        log.info("User clicked on the register button for the selected event");
    }

    @When("^User fills in the first name \"([^\"]*)\"$")
    public void user_fills_in_the_first_name(String firstName) throws InterruptedException{
        eventRegistrationPage.enterFirstName(firstName);
        log.info("User filled in the first name");
    }

    @When("^User fills in the last name \"([^\"]*)\"$")
    public void user_fills_in_the_last_name(String lastName) throws InterruptedException{
        eventRegistrationPage.enterLastName(lastName);
        log.info("User filled in the last name");
    }

    @When("^User fills in the email \"([^\"]*)\"$")
    public void user_fills_in_the_email(String email) throws InterruptedException{
        eventRegistrationPage.enterEmail(email);
        log.info("User filled in the email");
    }
    
    @When("the user selects the country code from the dropdown")
    public void the_user_selects_the_country_code_from_the_dropdown() throws InterruptedException {
    	EventRegistrationPage eventRegistrationPage = new EventRegistrationPage(driver);
    	eventRegistrationPage.selectCountryCode();
        log.info("Selected the country code: " + "+91 India");
    }

    @When("^User fills in the phone number \"([^\"]*)\"$")
    public void user_fills_in_the_phone_number(String phoneNumber) throws InterruptedException{
        eventRegistrationPage.enterPhoneNumber(phoneNumber);
        log.info("User filled in the phone number");
    }

    @When("^User submits the registration form$")
    public void user_submits_the_registration_form() throws InterruptedException{
        eventRegistrationPage.submitForm();
        log.info("User submitted the registration form");
    }

    @Then("^User should see a confirmation of successful event registration$")
    public void user_should_see_a_confirmation_of_successful_event_registration() throws InterruptedException {
         eventRegistrationPage.isRegistrationSuccessful();
        log.info("🌟 Registration Confirmed! 🌟");
    }
    }