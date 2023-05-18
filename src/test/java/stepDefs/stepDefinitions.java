package stepDefs;

import BaseClass.BaseClass;
import PageObjects.Homepage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class stepDefinitions extends BaseClass {
    Homepage homepage = new Homepage();
    @When("Search things")
    public void searchSomethingOnGoogle() throws InterruptedException {
        homepage.searchSomethingOnGoogle();
    }
    @Then("Click on Searched Result")
    public void clickOnSearchedResult() throws InterruptedException {
    homepage.clickOnFirstSearchResult();
    }
    @When("click on Text")
    public void click_on_Text() {
       homepage.SearchResultclick();
    }


    @Then("validate current page Title")
    public void validate_current_page_url() {
        homepage.validateUrl();
    }

    @Then("click on Readchatgpt and validate")
    public void click_on_Menu_and_validate_it() {
      homepage.click_on_Menu_and_validate_it();
    }
}
