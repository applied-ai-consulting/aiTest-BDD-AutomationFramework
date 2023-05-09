package stepDefs;

import PageObjects.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class stepDefinitions2 extends BaseClass {

    @When("Search things")
    public void click_on_url() {
      driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("chatgpt", Keys.ENTER);
    }


    @Then("validate TEXT")
    public void validate_TEXT() {
 String TEXT = driver.findElement(By.className("VuuXrf")).getText();
        Assert.assertEquals("not matching","OpenAI",TEXT);

    }

    @When("click on Text")
    public void click_on_Text() {
  driver.findElement(By.className("VuuXrf")).click();
    }


    @Then("validate current page Title")
    public void validate_current_page_url() {
        String getCurrenturl = driver.getCurrentUrl();
        System.out.println(getCurrenturl);
        Assert.assertEquals("Title not matching","Introducing ChatGPT",driver.getTitle());
    }

    @Then("click on OpenAI and validate it")
    public void click_on_Menu_and_validate_it() {
         driver.findElement(By.xpath("//a[@class='ui-link relative z-10 w-//*[name()='svg']")).click();
        Assert.assertEquals("OpenAI",driver.getTitle(),"OpenAI");
    }
}
