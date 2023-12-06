package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import baseClass.BaseClass;
import org.junit.Assert;

public class EventsPage extends BaseClass {
  
  private By eventsLink = By.xpath("//span[contains(.,'Events')]");
  private By event = By.xpath("//*[@id=\"academy-courses\"]/div/div/div[2]/div[2]/div/div[1]/img");
  
  public EventsPage(WebDriver driver) {
	  this.driver = driver;
  }
  
  public void clickEventsLink(String linkText) {
    WebElement eventsLinkElement = driver.findElement(eventsLink);
    eventsLinkElement.click();
  }
  
  public void clickEvent() {
    WebElement eventElement = driver.findElement(event);
    eventElement.click();
  }
}