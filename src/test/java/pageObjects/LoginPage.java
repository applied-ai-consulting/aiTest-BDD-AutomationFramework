package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import baseClass.BaseClass;
import org.junit.Assert;

public class LoginPage extends BaseClass {
  
  private WebDriver driver;
  
  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }
  
  public void navigateToLoginPage() {
    driver.get("https://loadtesting.wajooba.xyz");
  }
  
  public void login(String username, String password) {
    WebElement usernameField = driver.findElement(By.id("username"));
    usernameField.sendKeys(username);
    
    WebElement passwordField = driver.findElement(By.id("password"));
    passwordField.sendKeys(password);
    
    WebElement loginButton = driver.findElement(By.xpath("//button[contains(.,'Login')]"));
    loginButton.click();
  }
}