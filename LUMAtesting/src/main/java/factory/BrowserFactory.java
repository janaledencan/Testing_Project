package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    public WebDriver createBrowserInstance(String browser)  {

        WebDriver driver = null;

        if(browser.equalsIgnoreCase("Chrome")) {

            String chromeDriverPath = System.getenv("ChromeDriverTest");
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);

        }else if (browser.equalsIgnoreCase("Firefox")) {

            String geckoDriverPath = System.getenv("FirefoxDriverTest");
            System.setProperty("webdriver.gecko.driver", geckoDriverPath);
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            driver = new FirefoxDriver(options);

        }
        return driver;
    }
}
