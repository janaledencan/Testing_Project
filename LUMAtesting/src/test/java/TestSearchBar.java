import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Login;
import pages.SearchBar;

public class TestSearchBar {

    private static WebDriver driver;
    public String testURL = "https://magento.softwaretestingboard.com/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jana\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }


    @Test
    public void search() throws InterruptedException {
        SearchBar searchBar = new SearchBar(driver);
        //Thread.sleep(5000);
        searchBar.Search("pants");
    }

    
    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
