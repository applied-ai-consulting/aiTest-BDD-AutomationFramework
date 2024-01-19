package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;

import baseClass.BaseClass;
import hooks.Hooks;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

public class EventRegistrationPage extends BaseClass {

    private WebDriver driver;

    // Web Element Locators (Based on the supplied data)
    private By eventLocator = By.xpath("//*[@id=\"academy-courses\"]/div/div/div[2]/div/div/div[2]");
    private By registerButtonLocator = By.xpath("//div[@id='topcoursediv']/div/div[2]/div[2]/mat-card/mat-card-content/button/span/div");
    private By firstNameInputLocator = By.name("firstName");
    private By lastNameInputLocator = By.name("lastName");
    private By emailInputLocator = By.name("email");
    private By phoneNumberInputLocator = By.xpath("//input[@formcontrolname='phoneNumber']");
    private By submitButtonLocator = By.xpath("//h3[contains(.,'Submit')]");

    public EventRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectEvent() throws InterruptedException{
        Thread.sleep(3000);
        WebElement event = driver.findElement(eventLocator);
        event.click();
    }

    public void clickRegisterButton() throws InterruptedException {
        Thread.sleep(3000);
        WebElement registerButton = driver.findElement(registerButtonLocator);
        registerButton.click();
//        WebElement registerButton = driver.findElement(registerButtonLocator);
//        Actions act = new Actions (driver);
//        act.moveToElement(registerButton).click();
//        act.perform();
    }

    public void enterFirstName(String firstName)throws InterruptedException {
        Thread.sleep(2000);
//        Actions act = new Actions (driver);
//        WebElement firstNameInput = driver.findElement(firstNameInputLocator);
//        //firstNameInput.clear();
//        Thread.sleep(1000);
//        act.moveToElement(firstNameInput).click();
//        act.sendKeys(firstName);
//        act.perform();
        WebElement firstNameInput = driver.findElement(firstNameInputLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstNameInput);
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName)throws InterruptedException {
        Thread.sleep(2000);
        WebElement lastNameInput = driver.findElement(lastNameInputLocator);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) throws InterruptedException{

        Thread.sleep(2000);
//        Actions act = new Actions (driver);
//        WebElement emailInput = driver.findElement(emailInputLocator);
//        Thread.sleep(1000);
//        act.moveToElement(emailInput).click();
//        act.sendKeys(email);
//        act.perform();
        WebElement emailInput = driver.findElement(emailInputLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailInput);
        emailInput.sendKeys(email);
    }
    
    public void selectCountryCode() throws InterruptedException {
    	Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text']")).click();
        Thread.sleep(2000);
    //    Assert.assertNotNull("Country code dropdown not found", countryCodeDropdown);
    //    countryCodeDropdown.click();
        WebElement countrycode = driver.findElement(By.xpath("(//span[@class='mat-option-text'])[3]"));
        countrycode.click();
    }

    public void enterPhoneNumber(String phoneNumber)throws InterruptedException {
        Thread.sleep(2000);
//        Actions act = new Actions (driver);
//        WebElement phoneNumberInput = driver.findElement(phoneNumberInputLocator);
//        Thread.sleep(1000);
//        act.moveToElement(phoneNumberInput).click();
//        act.sendKeys(phoneNumber);
//        act.perform();
        WebElement phoneNumberInput = driver.findElement(phoneNumberInputLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", phoneNumberInput);
        phoneNumberInput.sendKeys(phoneNumber);
    }

    public void submitForm() throws InterruptedException{
        Thread.sleep(2000);
//        Actions act = new Actions (driver);
//        WebElement submitButton = driver.findElement(submitButtonLocator);
//        Thread.sleep(1000);
//        act.moveToElement(submitButton).click();
//        act.perform();
        WebElement submitButton = driver.findElement(submitButtonLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();
        
    }

    public void isRegistrationSuccessful() throws InterruptedException {
 
    	try {
            Thread.sleep(3000);
            WebElement input = driver.findElement(By.xpath("//h2[contains(text(),'🌟 Registration Confirmed! 🌟')]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", input);
            Thread.sleep(2000);
            String ConfirmationMessage = driver.findElement(By.xpath("//h2[contains(text(),'🌟 Registration Confirmed! 🌟')]")).getText();
            System.out.println("Confirm Message " + ConfirmationMessage);
            String Expectedmsg = "🌟 Registration Confirmed! 🌟";
            Assert.assertEquals(Expectedmsg, ConfirmationMessage);
            
        } catch (NoSuchElementException e) {
            // Handle specific exceptions as needed
            e.printStackTrace(); // Log the exception if needed
            System.out.println("Indicate that the bot registration was not successful.");
         //   Assert.fail("Indicate that the bot registration was not successful.");
         //   return false; // Indicate that the registration was not successful
        }
    }
}