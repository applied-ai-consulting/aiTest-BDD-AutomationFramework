package hooks;
import baseClass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;
import java.net.URISyntaxException;
public class Hooks extends BaseClass  {
    @Before
    public void beforeScenario() throws IOException, URISyntaxException{
    	beforeEach();
    }
    @After
    public void afterScenario(Scenario scenario) throws IOException {
    	afterEach(scenario);
    }
}