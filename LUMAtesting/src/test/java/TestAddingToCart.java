import factory.BrowserFactory;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WomenHoodiesPage;
import java.time.Duration;

public class TestAddingToCart {

    public WebDriver driver;
    public String testURL = "https://magento.softwaretestingboard.com/women/tops-women/hoodies-and-sweatshirts-women.html";

    BrowserFactory bFactory = new BrowserFactory();

    @BeforeMethod
    public void setupTest() {
        DriverFactory.getInstance().setDriver(bFactory.createBrowserInstance(BrowserSelection.selectedBrowser));
        driver = DriverFactory.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to(testURL);
    }

    @Test
    public void testAddToCart(){
        driver.manage().window().maximize();
        WomenHoodiesPage hoodiesPage = new WomenHoodiesPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        hoodiesPage.getToItemPage();
        hoodiesPage.clickElements();
    }

    @AfterMethod
    public void teardownTest() {
        DriverFactory.getInstance().closeBrowser();
    }

}
