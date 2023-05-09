package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BaseClass {
    private By firstResult = By.cssSelector("._bXVsd_gridColumn_2Jfab:nth-child(1) ._bXVsd_image_1pfbQ");
    public void clickFirstSearchResult() {
        driver.findElement(firstResult).click();
    }
}