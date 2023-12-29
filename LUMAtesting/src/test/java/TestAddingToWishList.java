import factory.BrowserFactory;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Login;
import pages.WishItems;
import java.time.Duration;
import java.util.Objects;

public class TestAddingToWishList {
    public WebDriver driver;
    public String testURL = "https://magento.softwaretestingboard.com/";
    public String testURLmenTshirt = "https://magento.softwaretestingboard.com/men/tops-men.html";

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
    public void testAddToWishListWithLink() throws InterruptedException {
        driver.manage().window().maximize();
        Login signInPage = new Login(driver);
        HomePage homePage = signInPage.loginAs("najjaciTester@mail.com", "Test123!+");
        if(Objects.equals(homePage.getMessageText(), "Click “Write for us” link in the footer to submit a guest post")) {
            Assert.assertEquals(homePage.getMessageText(),"Click “Write for us” link in the footer to submit a guest post");
        }else if(Objects.equals(homePage.getMessageText(), "Welcome, test tester!")) {
            Assert.assertEquals(homePage.getMessageText(), "Welcome, test tester!");
        }

        driver.navigate().to(testURLmenTshirt);

        WishItems wishPage = new WishItems(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wishPage.addToWishList();
    }

    @AfterMethod
    public void teardownTest() {
        DriverFactory.getInstance().closeBrowser();
    }
}
