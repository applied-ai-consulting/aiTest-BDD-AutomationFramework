package pageObjects;


import baseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Homepage extends BaseClass {
    private static final By google_SearchBox = By.xpath("//textarea[@class='gLFyf']");
    private static final By firstSearchResult = By.xpath("//*[text() = 'Introducing ChatGPT']");

    public void searchSomethingOnGoogle() throws InterruptedException {
        log.info("Searching Something on google");
        driver.findElement(google_SearchBox).sendKeys("chatgpt", Keys.ENTER);
    }

    public void clickOnFirstSearchResult() throws InterruptedException {
        log.info("clicking on first result from Search results");
        driver.findElement(firstSearchResult).click();
    }
}
