import factory.BrowserFactory;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import java.time.Duration;

public class TestHover {

    public WebDriver driver;
    public String testURL = "https://magento.softwaretestingboard.com/";

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
    public void testHoverElement() throws InterruptedException {
        HomePage page = new HomePage(driver,false);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement mainElement = driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]"));  //Women
        WebElement subElement = driver.findElement(By.xpath("//*[@id=\"ui-id-9\"]"));  //Tops
        WebElement hoodies =  driver.findElement(By.xpath("//*[@id=\"ui-id-12\"]/span"));

        page.hoverElement(mainElement);
        page.hoverElement(subElement);
        page.clickElement(hoodies);
    }

    @AfterMethod
    public void teardownTest() {
        DriverFactory.getInstance().closeBrowser();
    }
}
