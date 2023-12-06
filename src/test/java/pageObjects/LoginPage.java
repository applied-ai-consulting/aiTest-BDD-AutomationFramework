package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import baseClass.BaseClass;
import org.junit.Assert;

public class LoginPage extends BaseClass {
  
  private By usernameField = By.id("username");
  private By passwordField = By.id("password");
  private By loginButton = By.id("loginButton");

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
  
  public void enterUsername(String username) {
	    WebElement usernameElement = driver.findElement(usernameField);
	    usernameElement.sendKeys(username);
	  }
	  
	  public void enterPassword(String password) {
	    WebElement passwordElement = driver.findElement(passwordField);
	    passwordElement.sendKeys(password);
	  }
	  
	  public void clickLoginButton() {
	    WebElement loginButtonElement = driver.findElement(loginButton);
	    loginButtonElement.click();
	  }

}