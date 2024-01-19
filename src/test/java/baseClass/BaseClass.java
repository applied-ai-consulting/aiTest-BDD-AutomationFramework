package baseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.filters.RequestFilter;
import net.lightbody.bmp.filters.ResponseFilter;
import net.lightbody.bmp.proxy.CaptureType;
import net.lightbody.bmp.util.HttpMessageContents;
import net.lightbody.bmp.util.HttpMessageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static String browser = System.getenv("BROWSER");
    public static Har har;
    public static BrowserMobProxy myProxy;
    public static String device_Name = System.getenv("DEVICE_NAME");
    public static Logger log = (Logger) LogManager.getLogger("Test Step");
    
	public static void beforeEach() throws IOException, URISyntaxException {
    	//
    
    
    
        log.info("Launching " + browser + " Browser");
        if (browser == null) {
            log.info("No Browser configuration found, running test in default chrome browser");
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(chromeOptions);
        }
        else if(browser.equalsIgnoreCase("Chrome")){
            log.info("Running test in chrome browser");
            myProxy=new BrowserMobProxyServer();
			
			myProxy.start(0);
			
			//2. Set SSL and HTTP proxy in SeleniumProxy
			Proxy seleniumProxy=new Proxy();
			seleniumProxy.setHttpProxy("localhost:" +myProxy.getPort());
			seleniumProxy.setSslProxy("localhost:" +myProxy.getPort());
			
			//3. Add Capability for PROXY in DesiredCapabilities
			DesiredCapabilities capability=new DesiredCapabilities();
			capability.setCapability(CapabilityType.PROXY, seleniumProxy);
			capability.acceptInsecureCerts();
			capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			
			//4. Set captureTypes
			EnumSet <CaptureType> captureTypes=CaptureType.getAllContentCaptureTypes();
			captureTypes.addAll(CaptureType.getCookieCaptureTypes());
			captureTypes.addAll(CaptureType.getHeaderCaptureTypes());
			captureTypes.addAll(CaptureType.getRequestCaptureTypes());
			captureTypes.addAll(CaptureType.getResponseCaptureTypes());
			
			//5. setHarCaptureTypes with above captureTypes
			myProxy.setHarCaptureTypes(captureTypes);
			
//			//6. HAR name
			myProxy.newHar("MyHAR");
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--window-size=1400,600");
            chromeOptions.merge(capability);
			driver = new ChromeDriver(chromeOptions);
			System.out.println("Driver Capabilities===> \n" +((RemoteWebDriver)driver).getCapabilities().asMap().toString());
        }
        else if (browser.equalsIgnoreCase("Firefox")){
            log.info("Running test in firefox browser");
            myProxy=new BrowserMobProxyServer();
			
			myProxy.start(0);
			Proxy seleniumProxy=new Proxy();
			//6. HAR name
			myProxy.newHar("MyHAR");
			WebDriverManager.firefoxdriver().clearDriverCache().setup();
			myProxy.addRequestFilter(new RequestFilter() {
				   @Override
				    public HttpResponse filterRequest(HttpRequest request, HttpMessageContents contents, HttpMessageInfo messageInfo) {
				        // capture the request headers
				        Map<String, String> headers = (Map<String, String>) request.headers();
				        System.out.println("Request Headers: " + headers);
				        System.out.println("Request Headers");
				        return null;
				    }
				});
			myProxy.addResponseFilter(new ResponseFilter() {
				@Override
			    public void filterResponse(HttpResponse response, HttpMessageContents contents, HttpMessageInfo messageInfo) {
			        // capture the response headers
			        Map<String, String> headers = (Map<String, String>) response.headers();
			        System.out.println("Response Headers: " + headers);
			        System.out.println("Response Headers");

			        // capture the response body
			        String body = contents.getTextContents();
			        System.out.println("Response Body: " + body);
			    }
			});
			// get the Selenium proxy object
			Proxy seleniumProxy1 = ClientUtil.createSeleniumProxy(myProxy);
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setProxy(seleniumProxy1);
			// create a new FirefoxDriver using the FirefoxOptions
			firefoxOptions.addArguments("--no-sandbox");
			firefoxOptions.addArguments("--disable-dev-shm-usage");
			firefoxOptions.addArguments("--headless");
			firefoxOptions.addArguments("--window-size=1400,600");
            driver = new FirefoxDriver(firefoxOptions);
        }
        else if (browser.equalsIgnoreCase("Edge")){
            log.info("Running test in edge browser");
            myProxy=new BrowserMobProxyServer();
			
			myProxy.start(0);
			
			//2. Set SSL and HTTP proxy in SeleniumProxy
			//Proxy seleniumProxy2=new Proxy();
			Proxy seleniumProxy2 = ClientUtil.createSeleniumProxy(myProxy);
            WebDriverManager.edgedriver().setup();
            //ChromeOptions edgeOptions = new ChromeOptions();
            EdgeOptions options = new EdgeOptions();
            options.setCapability(CapabilityType.PROXY, seleniumProxy2);
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			//6. HAR name
			myProxy.newHar("MyHAR");
            List<String> args = Arrays.asList("--no-sandbox", "--disable-dev-shm-usage", "--window-size=1400,600");
			Map<String, Object> map = new HashMap<>();
			map.put("args", args);
			options.setCapability("ms:edgeOptions", map);
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
        long timeoutSeconds = 120;
        Duration waitDuration = Duration.ofSeconds(120); // Replace with your desired wait duration
        long waitSeconds = waitDuration.getSeconds();

        driver.manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);// Replace with your desired timeout
        driver.manage().timeouts().pageLoadTimeout(timeoutSeconds, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        //driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        log.info("Navigating to URL");
      //  driver.get("https://www.google.com");
    }

    
	public void afterEach(Scenario scenario) throws IOException {
				Status status = scenario.getStatus();
				String scenario_name = scenario.getName();
				String new_scenario_name = scenario_name.replaceAll("\\s", "");
				System.out.println("scenario name="+scenario_name);
				System.out.println("scenario name="+new_scenario_name);
	            System.out.println("scenario status:"+status);
		if (scenario.isFailed()) {
            har=myProxy.getHar();
            int num = (int)(Math.random() * 500 + 1);
            System.out.println("random number="+num);
			//File myHARFile=new File(System.getProperty("user.dir")+"/target/reports/"+browser+"HAR"+num+".har");
//			File myHARFile=new File(System.getProperty("user.dir")+"/target/reports/HARFolder/Failed"+new_scenario_name+".har");
			File HARFolder=new File(System.getProperty("user.dir")+"/target/HARFolder");
			//har.writeTo(HARFolder);
			if (!HARFolder.exists()) {
				boolean created = HARFolder.mkdirs();
	            if (created) {
	                System.out.println("Folder created successfully.");
	                File myHARFile=new File(System.getProperty("user.dir")+"/target/HARFolder/Failed"+scenario_name+".har");
	                har.writeTo(myHARFile);
	            } else {
	                System.out.println("Failed to create folder.");
	            }
			}else {
	            System.out.println("Folder already exists.");
	            File myHARFile=new File(System.getProperty("user.dir")+"/target/HARFolder/Failed"+scenario_name+".har");
	            har.writeTo(myHARFile);
	        }
			System.out.println("==> HAR details has been successfully written in the file when scenario failed.....");
			
			try {
				
				//scenario.write("Current Page URL is " + driver.getCurrentUrl());

				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", scenario.getName());
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots
						.getMessage());
			}
			//driver.quit();
		}
		
		else if (status.PASSED != null) 
		{
			har=myProxy.getHar();
			int num = (int)(Math.random() * 100 + 1);
            System.out.println("random number="+num);
			//File myHARFile=new File(System.getProperty("user.dir")+"/target/reports/"+browser+"HAR"+num+".har");
			File HARFolder=new File(System.getProperty("user.dir")+"/target/HARFolder");
			//File myHARFile=new File(System.getProperty("user.dir")+"/HARFolder/googleHAR.har");
//			har.writeTo(myHARFile);
			if (!HARFolder.exists()) {
				boolean created = HARFolder.mkdirs();
	            if (created) {
	                System.out.println("Folder created successfully.");
	                File myHARFile=new File(System.getProperty("user.dir")+"/target/HARFolder/Passed"+scenario_name+".har");
	                har.writeTo(myHARFile);
	            } else {
	                System.out.println("Failed to create folder.");
	            }
			}else {
	            System.out.println("Folder already exists.");
	            File myHARFile=new File(System.getProperty("user.dir")+"/target/HARFolder/Passed"+scenario_name+".har");
	            har.writeTo(myHARFile);
	        }
			
		
			
			System.out.println("==> HAR details has been successfully written in the file.....");
			try {
				

				
				//scenario.write("Current Page URL is " + driver.getCurrentUrl());
				//scenario.write("test case is pass successfuly  Screenshot is attached below");
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", scenario.getName());
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots
						.getMessage());
			}
		
			
//		driver.quit();

	}
		driver.quit();
	}

//    public static WebElement waitForVisibility(By locator) {
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
////        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
}