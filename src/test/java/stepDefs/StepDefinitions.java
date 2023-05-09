package stepDefs;

import PageObjects.BaseClass;
import PageObjects.HomePage;
import PageObjects.ProductPage;
import PageObjects.SearchResultsPage;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions extends BaseClass {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private ProductPage productPage;
    @Given("^I am on Amazon homepage$")
    public void iAmOnAmazonHomepage() {
//        String chromeDriverPath = "/path/to/chromedriver";
//        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//        driver = new ChromeDriver();
//        homePage = new HomePage(driver);
//        homePage.navigateToHomePage("https://www.amazon.in/");
        homePage.navigateToHomePage("https://www.amazon.in/");
    }
    @Given("^I search for \"(.*)\"$")
    public void iSearchFor(String item) {
        homePage.searchItem(item);
    }
    @Then("^the search results should be displayed$")
    public void theSearchResultsShouldBeDisplayed() {
        // Check that search results are displayed
    }
    @When("^I click on the first search result$")
    public void iClickOnTheFirstSearchResult() {
        searchResultsPage = new SearchResultsPage();
        searchResultsPage.clickFirstSearchResult();
    }
    @When("^I add the item to cart$")
    public void iAddTheItemToCart() {
        productPage = new ProductPage();
        productPage.addItemToCart();
    }
    @Then("^the item should be added to the cart$")
    public void theItemShouldBeAddedToTheCart() {
        productPage = new ProductPage();
        productPage.addItemToCart();
    }
    @When("^I click on an invalid search result$")
    public void iClickOnAnInvalidSearchResult() {
        // Click on an invalid search result
    }
    @Then("^an error message should be displayed$")
    public void anErrorMessageShouldBeDisplayed() {
        // Check that error message is displayed
    }
    @When("^I set the quantity to \"(.*)\"$")
    public void iSetTheQuantityTo(String quantity) {
        productPage.setQuantity(quantity);
    }
    @When("^I set the delivery address to \"(.*)\"$")
    public void iSetTheDeliveryAddressTo(String address) {
        productPage.setDeliveryAddress(address);
    }
    @When("^I set the payment information to \"(.*)\"$")
    public void iSetThePaymentInformationTo(String paymentInfo) {
        productPage.setPaymentInformation(paymentInfo);
    }
    @Then("^the order should be placed successfully$")
    public void theOrderShouldBePlacedSuccessfully() {
        // Check that order is placed successfully
    }
    @After
    public void afterScenario() {
        driver.quit();
    }

    @Given("I am on search results page")
    public void iAmOnSearchResultsPage() {
    }
}
