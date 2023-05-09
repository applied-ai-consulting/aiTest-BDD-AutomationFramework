package PageObjects;

import org.openqa.selenium.By;

public class HomePage extends BaseClass {
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    public void navigateToHomePage(String url) {
        driver.get(url);
    }
    public void searchItem(String item) {
        driver.findElement(searchBox).sendKeys(item);
        driver.findElement(searchButton).click();
    }
}
