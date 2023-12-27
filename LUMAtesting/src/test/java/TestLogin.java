import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Login;


public class TestLogin {

    public WebDriver driver;
    public String testURL = "https://magento.softwaretestingboard.com/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jana\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void testLogin() throws InterruptedException {
        Login signInPage = new Login(driver);
        //Thread.sleep(5000);
        HomePage homePage = signInPage.loginAs("najjaciTester@mail.com", "Test123!+");
        Assert.assertEquals(homePage.getMessageText(),"Welcome, test tester!");
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }

}
