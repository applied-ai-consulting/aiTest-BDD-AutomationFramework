package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;

    public static void launchBrowser(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
       chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1400,600");

        driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }

    public static void quit(){
    driver.quit();
    }
}
