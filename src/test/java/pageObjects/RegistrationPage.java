package pageObjects;

import java.time.Duration;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import baseClass.BaseClass;
import org.junit.Assert;

public class RegistrationPage extends BaseClass {
  
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
  }
  public void EnterValueInField(String value) throws InterruptedException {
	  Thread.sleep(500);
	  Actions act = new Actions (driver);
	  WebElement inputField = driver.findElement(By.xpath("//input[@formcontrolname='phoneNumber']"));
      Thread.sleep(500);
      act.moveToElement(inputField).click();
      act.sendKeys(value);
      act.perform();
	  }
  
  public void clickOnRegistorbutton() throws InterruptedException {
	  Thread.sleep(1000);
	  Actions a = new Actions(driver);
	  WebElement elementToClick = driver.findElement(By.xpath("//button[normalize-space()='Register']"));
	  a.moveToElement(elementToClick).click();
      a.perform();
      Thread.sleep(500);
	  }
	  
  public boolean isRegistrationSuccessful() throws InterruptedException {
	  Thread.sleep(1000);
    WebElement successMessage = driver.findElement(By.xpath("//h2[contains(text(),'ðŸŒŸ Registration Confirmed! ðŸŒŸ')]"));
    return successMessage.isDisplayed();
  }
}