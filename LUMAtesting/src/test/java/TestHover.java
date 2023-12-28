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

public class TestHover {

    public WebDriver driver;
    public String testURL = "https://magento.softwaretestingboard.com/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", System.getenv("ChromeDriverTest"));
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void testHoverElement() throws InterruptedException {
        HomePage page = new HomePage(driver,false);
        Thread.sleep(5000);
        WebElement mainElement = driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]"));  //Women
        WebElement subElement = driver.findElement(By.xpath("//*[@id=\"ui-id-9\"]"));  //Tops
        WebElement hoodies =  driver.findElement(By.xpath("//*[@id=\"ui-id-12\"]/span"));

        page.hoverElement(mainElement);
        page.hoverElement(subElement);
        page.clickElement(hoodies);
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }

}
