package factory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private DriverFactory() {}
    private static final DriverFactory instance  = new DriverFactory();
    public static DriverFactory getInstance() {
        return instance;
    }


    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    public void closeBrowser() {
        driver.get().quit();
        driver.remove();
    }
}