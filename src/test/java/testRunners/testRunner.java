package testRunners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefs","Hooks"},
        monochrome = true,
//        strict = true,
        plugin = { "pretty", "html:target/html-reports" },
        tags = "@Test"
)
public class testRunner {

}