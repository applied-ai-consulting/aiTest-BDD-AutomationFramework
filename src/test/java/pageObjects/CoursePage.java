package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import baseClass.BaseClass;
import org.junit.Assert;

public class CoursePage extends BaseClass {
  
  private WebDriver driver;
  
  public CoursePage(WebDriver driver) {
    this.driver = driver;
  }
  
  public void clickOnElement(String element) {
    WebElement elementToClick = driver.findElement(By.xpath(element));
    elementToClick.click();
  }
  
  public void clickOnFirstCourse() {
    WebElement firstCourse = driver.findElement(By.cssSelector(".course:nth-child(1) .mat-card-image"));
    firstCourse.click();
  }
}