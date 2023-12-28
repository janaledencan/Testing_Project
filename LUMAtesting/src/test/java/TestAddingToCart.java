import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Login;
import pages.WomenHoodiesPage;

import java.time.Duration;

public class TestAddingToCart {

    public WebDriver driver;
    public String testURL = "https://magento.softwaretestingboard.com/women/tops-women/hoodies-and-sweatshirts-women.html";

    @BeforeMethod
    public void setupTest() {
        String chromeDriverPath = System.getenv("ChromeDriverTest");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void testAddToCart() throws InterruptedException {
        driver.manage().window().maximize();
        WomenHoodiesPage hoodiesPage = new WomenHoodiesPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        hoodiesPage.getToItemPage();
        hoodiesPage.clickElements();
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }

}
