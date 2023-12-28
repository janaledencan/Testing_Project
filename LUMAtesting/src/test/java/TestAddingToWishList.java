import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Login;
import pages.WishItems;
import pages.WomenHoodiesPage;

import java.time.Duration;

public class TestAddingToWishList {
    public WebDriver driver;
    public String testURL = "https://magento.softwaretestingboard.com/";
    public String testURLmenTshirt = "https://magento.softwaretestingboard.com/men/tops-men.html";


    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", System.getenv("ChromeDriverTest"));
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void testAddToWishListWithHeart() throws InterruptedException {
        driver.manage().window().maximize();
        Login signInPage = new Login(driver);
        HomePage homePage = signInPage.loginAs("najjaciTester@mail.com", "Test123!+");
        Assert.assertEquals(homePage.getMessageText(),"Welcome, test tester!");

        driver.navigate().to(testURLmenTshirt);

        WishItems wishPage = new WishItems(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wishPage.addToWishListWithHeart();

    }

    @Test
    public void testAddToWishListWithLink() throws InterruptedException {
        driver.manage().window().maximize();
        Login signInPage = new Login(driver);
        HomePage homePage = signInPage.loginAs("najjaciTester@mail.com", "Test123!+");
        Assert.assertEquals(homePage.getMessageText(),"Welcome, test tester!");

        driver.navigate().to(testURLmenTshirt);

        WishItems wishPage = new WishItems(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wishPage.addToWishListWithLink();
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
