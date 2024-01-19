package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import baseClass.BaseClass;
import org.junit.Assert;

public class RegistrationPage extends BaseClass {
  
  private WebDriver driver;
  
  public RegistrationPage(WebDriver driver) {
    this.driver = driver;
  }
  
  public void clickOnElement(String element) {
    WebElement elementToClick = driver.findElement(By.xpath(element));
    elementToClick.click();
  }
  
  public void enterValueInField(String value, String field) {
    WebElement inputField = driver.findElement(By.id(field));
    inputField.sendKeys(value);
  }
  
  public boolean isRegistrationSuccessful() {
    WebElement successMessage = driver.findElement(By.xpath("//div[contains(.,'Registration successful')]"));
    return successMessage.isDisplayed();
  }
}