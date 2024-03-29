package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage {

    protected WebDriver driver;
    private By messageBy = By.className("logged-in"); //By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span");


    public HomePage(WebDriver driver, Boolean loggedIn) throws InterruptedException {
        this.driver = driver;
        if(loggedIn) {
            Thread.sleep(5000);
        }
    }

    public String getMessageText() {
        return driver.findElement(messageBy).getText();
    }

    public void hoverElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void clickElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.click(element).build().perform();
    }

}
