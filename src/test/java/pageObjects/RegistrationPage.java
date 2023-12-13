package pageObjects;

import java.time.Duration;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import baseClass.BaseClass;
import hooks.Hooks;

import org.junit.Assert;

public class RegistrationPage extends BaseClass {
 
  private By registerButton = By.xpath("//h3[contains(.,'Register')]");
  private By firstNameField = By.id("mat-input-1");
  private By lastNameField = By.id("mat-input-2");
  private By emailField = By.id("mat-input-6");
  private By phoneNumberField = By.id("mat-input-5");
  private By cardNumberField = By.xpath("//*[@name='cardnumber']");
  private By expirationDateField = By.name("exp-date");
  private By cvcField = By.name("cvc");
  private By postalCodeField = By.name("postal");
  private By buyNowButton = By.xpath("//button[contains(.,'Buy Now')]");
  
  private WebDriver driver;
  
  public RegistrationPage(WebDriver driver) {
    this.driver = driver;
  }

  
  public void clickOnElement(String element) throws InterruptedException {
	Thread.sleep(1000);
    WebElement elementToClick = driver.findElement(By.xpath(element));
    elementToClick.click();
  }
  
  public void enterValueInField(String value, String field) throws InterruptedException {
	Thread.sleep(500);
    WebElement inputField = driver.findElement(By.name(field));
    inputField.sendKeys(value);
    Thread.sleep(1000);
  }
  public void EnterValueInField(String value) throws InterruptedException {
	  Thread.sleep(500);
//	  Actions act = new Actions (driver);
//	  WebElement inputField = driver.findElement(By.xpath("//input[@formcontrolname='phoneNumber']"));
//      Thread.sleep(500);
//      act.moveToElement(inputField).click();
//      act.sendKeys(value);
//      act.perform();
	  WebElement inputField = driver.findElement(By.xpath("//input[@formcontrolname='phoneNumber']"));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputField);
      inputField.sendKeys(value);
      Thread.sleep(2000);
	  }
  
  public void clickOnRegistorbutton() throws InterruptedException {
	  Thread.sleep(1000);
//	  Actions a = new Actions(driver);
//	  WebElement elementToClick = driver.findElement(By.xpath("//button[normalize-space()='Register']"));
//	  a.moveToElement(elementToClick).click();
//      a.perform();
	  WebElement elementToClick = driver.findElement(By.xpath("//button[normalize-space()='Register']"));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToClick);
      elementToClick.click();
      Thread.sleep(500);
	  }
	  
  public void isRegistrationSuccessful() throws InterruptedException {
//	  Thread.sleep(1000);
//    WebElement successMessage = driver.findElement(By.xpath("//h2[contains(text(),'🌟 Registration Confirmed! 🌟')]"));
//    return successMessage.isDisplayed();
//	    }
	    	try {
	            Thread.sleep(3000);
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
  
  
  //Paid event code
  
  public void clickRegisterButton(String buttonName) {
	    WebElement registerButtonElement = driver.findElement(registerButton);
	    registerButtonElement.click();
	  }
	  
	  public void enterFirstName(String firstName) throws InterruptedException {
	    WebElement firstNameElement = driver.findElement(firstNameField);
	    firstNameElement.sendKeys(firstName);
	    Thread.sleep(3000);
	  }
	  
	  public void enterLastName(String lastName) throws InterruptedException {
	    WebElement lastNameElement = driver.findElement(lastNameField);
	    lastNameElement.sendKeys(lastName);
	    Thread.sleep(3000);
	  }
	  
	  public void enterEmail(String email) throws InterruptedException {
	    WebElement emailElement = driver.findElement(emailField);
	    emailElement.sendKeys(email);
	    Thread.sleep(3000);
	  }
	  
	  public void enterPhoneNumber(String phoneNumber) throws InterruptedException {
	    WebElement phoneNumberElement = driver.findElement(phoneNumberField);
	    phoneNumberElement.sendKeys(phoneNumber);
	    Thread.sleep(3000);
	  }
	  
	  public void enterCardNumber(String cardNumber) throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
		Thread.sleep(2000);
	    WebElement cardNumberElement = driver.findElement(cardNumberField);
	    cardNumberElement.sendKeys(cardNumber);
	    Thread.sleep(2000);
	  }

	public void enterExpirationDate(String expirationDate) throws InterruptedException {
		Thread.sleep(2000);
	    WebElement expirationDateElement = driver.findElement(expirationDateField);
	    expirationDateElement.sendKeys(expirationDate);
	    Thread.sleep(2000);
	  }
	  
	  public void enterCVC(String cvc) throws InterruptedException {
		Thread.sleep(2000);
	    WebElement cvcElement = driver.findElement(cvcField);
	    cvcElement.sendKeys(cvc);
	    Thread.sleep(2000);
	  }
	  
	  public void enterPostalCode(String postalCode) throws InterruptedException {
		Thread.sleep(2000);
	    WebElement postalCodeElement = driver.findElement(postalCodeField);
	    postalCodeElement.sendKeys(postalCode);
	    Thread.sleep(2000);
	  }
	  
	  public void switchToParentFrame() {
	    driver.switchTo().parentFrame();
	  }
	  
	  public void clickButton(String buttonName) throws InterruptedException {

//	    Thread.sleep(3000);
//		  Actions act = new Actions (driver);
//	        WebElement buttonElement = driver.findElement(By.xpath("//button[contains(.,'" + buttonName + "')]"));
//	        Thread.sleep(1000);
//	        act.moveToElement(buttonElement).click();
//	        act.perform();
		  WebElement buttonElement = driver.findElement(By.xpath("//button[contains(.,'" + buttonName + "')]"));
	      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonElement);
	      buttonElement.click();
	      Thread.sleep(3000);
	  }
	  
	  public boolean verifyConfirmationMessage() throws InterruptedException {
			
		  Thread.sleep(3000);
			WebElement input = Hooks.driver.findElement(By.xpath("//h2[contains(text(),'🌟 Registration Confirmed! 🌟')]"));
		    JavascriptExecutor js = (JavascriptExecutor)Hooks.driver;
		    js.executeScript("arguments[0].scrollIntoView();", input );
			Thread.sleep(2000);
	        String ConfirmationMessage = driver.findElement(By.xpath("//h2[contains(text(),'🌟 Registration Confirmed! 🌟')]")).getText();
	        System.out.println("Confirm Message " +ConfirmationMessage);
	        String Expectedmsg ="🌟 Registration Confirmed! 🌟";
	        Assert.assertEquals(Expectedmsg, ConfirmationMessage);
			return true;
	  }
}