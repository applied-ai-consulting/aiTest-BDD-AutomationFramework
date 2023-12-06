package pageObjects;


import baseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage extends BaseClass {

	private WebDriver driver;

    // Web Element Locators (Supplied data converted to a placeholder for context)
    private By loginButtonLocator = By.id("loginButtonId");
    private By usernameLocator = By.id("usernameInputId");
    private By passwordLocator = By.id("passwordInputId");
    private By eventsSectionLocator = By.xpath("//a[contains(.,'Events')]");

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        driver.get("https://loadtesting.wajooba.xyz");
    }

    public void enterCredentials(String username, String password) {
        WebElement usernameInput = driver.findElement(usernameLocator);
        WebElement passwordInput = driver.findElement(passwordLocator);

        usernameInput.clear();
        usernameInput.sendKeys(username);

        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public boolean isOnHomepage() {
        // This assumes there is an element that can be checked to confirm the user is on the home page
        // Replace with the correct element or condition to validate the homepage
        WebElement homeElement = driver.findElement(By.id("homePageElementId"));
        return homeElement.isDisplayed();
    }

    public EventRegistrationPage navigateToEventsSection()throws InterruptedException {
        Thread.sleep(5000);
        WebElement eventsSection = driver.findElement(eventsSectionLocator);
        eventsSection.click();
        return new EventRegistrationPage(driver);
    }
}
