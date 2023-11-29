package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import baseClass.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class CoursePage extends BaseClass {
  
  private WebDriver driver;
  
  public CoursePage(WebDriver driver) {
    this.driver = driver;
  }
  
  public void clickontheCourses() throws InterruptedException {
	  Thread.sleep(500);
	  WebElement elementToClick = driver.findElement(By.xpath("(//span[@class='nav-link-title ng-star-inserted'][normalize-space()='Courses 1'])[1]"));
    elementToClick.click();
  }
  
  public void clickOnFirstCourse() throws InterruptedException {
	Thread.sleep(1000);
//    WebElement firstCourse = driver.findElement(By.cssSelector(".course:nth-child(1) .mat-card-image"));
//    firstCourse.click();
	WebElement firstCourse = driver.findElement(By.cssSelector(".course:nth-child(1) .mat-card-image"));
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].scrollIntoView();", firstCourse );
    Thread.sleep(1000);
    firstCourse.click();
  }
  public void clickOnCourseRegistorbutton() throws InterruptedException {
	  Thread.sleep(1000);
	    WebElement elementToClick = driver.findElement(By.xpath("//h3[text()='Register']"));
	    elementToClick.click();
	  }
}