package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefs","Hooks"},
        monochrome = true,
//        plugin = { "pretty", "html:target/html-reports" ,"json:target/cucumber", "junit:target/Cucumber.xml"},

        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","junit:target/XMLReport.xml"},
        tags = "@Test"
)

public class testrunner {
//com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter x = new ExtentCucumberAdapter("testrunner");

}