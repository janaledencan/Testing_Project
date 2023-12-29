import factory.BrowserFactory;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchBar;

import java.time.Duration;

public class TestSearchBar {

    private static WebDriver driver;
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
    public void search(){
        SearchBar searchBar = new SearchBar(driver);
        searchBar.Search("pants");
    }

    @AfterMethod
    public void teardownTest() {
        DriverFactory.getInstance().closeBrowser();
    }

}
