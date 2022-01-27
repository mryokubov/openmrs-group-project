package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class BrowserDriver {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        String browser = ConfigReader.getProperty("browser").toLowerCase();
        int implWaitTime = Integer.parseInt(ConfigReader.getProperty("implicitWait"));

        switch(browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(cOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.addArguments("--disable-notifications");
                driver = new FirefoxDriver(fOptions);
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;

        }

        if(driver !=null){
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(implWaitTime));
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
        return driver;
    }
    public static void quitBrowser(){
        if (driver != null){
            driver.quit();
        }
    }
}
