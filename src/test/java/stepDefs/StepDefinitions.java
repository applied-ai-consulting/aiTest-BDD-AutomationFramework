package stepDefs;

import baseClass.BaseClass;
import pageObjects.Homepage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends BaseClass {
    Homepage homepage = new Homepage();
    @When("Search things")
    public void searchSomethingOnGoogle() throws InterruptedException {
        homepage.searchSomethingOnGoogle();
    }
    @Then("Click on Searched Result")
    public void clickOnSearchedResult() throws InterruptedException {
        homepage.clickOnFirstSearchResult();
    }
}
