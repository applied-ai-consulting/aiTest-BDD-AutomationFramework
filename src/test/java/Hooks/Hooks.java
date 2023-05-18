package Hooks;

import BaseClass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Hooks extends BaseClass  {

    @Before
    public void beforeScenario(){
        BaseClass.launchBrowser();
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            //BaseClass.quit();
        }
        BaseClass.quit();
    }
}