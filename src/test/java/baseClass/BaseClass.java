package baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseClass {
    public static WebDriver driver;
    public static Logger log = (Logger) LogManager.getLogger("Test Step");
    public static String browser = System.getenv("BROWSER");
    public static String device_Name = System.getenv("DEVICE_NAME");
    public static void launchBrowser(){
        log.info("Launching " + browser + " Browser");
        if (browser == null) {
            log.info("No Browser configuration found, running test in default chrome browser");
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--window-size=1400,600");
            driver = new ChromeDriver(chromeOptions);
        }
        else if(browser.equalsIgnoreCase("Chrome")){
            log.info("Running test in chrome browser");
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--window-size=1400,600");
            driver = new ChromeDriver(chromeOptions);
        }
        else if (browser.equalsIgnoreCase("Firefox")){
            log.info("Running test in firefox browser");
            WebDriverManager.firefoxdriver().clearDriverCache().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            firefoxOptions.addArguments("--window-size=1400,600");
            driver = new FirefoxDriver(firefoxOptions);
        }
        else if (browser.equalsIgnoreCase("Edge")){
            log.info("Running test in edge browser");
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            options.addArguments("--window-size=1400,600");
            driver = new EdgeDriver(options);
        }
        else if (browser.equalsIgnoreCase("devices")){
            if(device_Name == null){
                device_Name = "iPad Mini";
                WebDriverManager.chromedriver().setup();
                log.info("Running on Default Device , Device name:"+device_Name);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--headless");
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", device_Name);
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                driver = new ChromeDriver(chromeOptions);
            }
            else {
                WebDriverManager.chromedriver().setup();
                log.info("Device name:" + device_Name);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--headless");
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", device_Name);
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                driver = new ChromeDriver(chromeOptions);
            }
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        log.info("Navigating to URL");
        driver.get("https://www.google.com");
    }

    public static void quit(){
        log.info("Quitting browser");
        driver.quit();
    }

    public static WebElement waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
