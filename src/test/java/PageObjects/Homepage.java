package PageObjects;


import BaseClass.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage extends BaseClass {
    private static final By dashboard_heading = By.xpath("//textarea[@class='gLFyf']");
    private static final By firstSearchResult = By.xpath("//*[text() = 'Introducing ChatGPT']");
    private static final By SearchResultclick = By.className("VuuXrf");
    private static final By clickOnReadChatgpt = By.xpath("//span[contains(text(),'Read about ChatGPT Plus')]");

    public void searchSomethingOnGoogle() throws InterruptedException {
        driver.findElement(dashboard_heading).sendKeys("chatgpt", Keys.ENTER);
        Thread.sleep(5000);
    }

    public void clickOnFirstSearchResult() throws InterruptedException {
        driver.findElement(firstSearchResult).click();
        Thread.sleep(5000);
    }

    public void SearchResultclick() {
        driver.findElement(SearchResultclick).click();
    }

    public void validateUrl() {
        String getCurrenturl = driver.getCurrentUrl();
        System.out.println(getCurrenturl);
        Assert.assertEquals("Title not matching", "Introducing ChatGPT", driver.getTitle());
    }
    public void click_on_Menu_and_validate_it() {
        driver.findElement(clickOnReadChatgpt).click();
        Assert.assertEquals("text not matching",driver.getTitle(),"Introducing ChatGPT Plus");
    }

}
