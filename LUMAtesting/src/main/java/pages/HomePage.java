package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class HomePage {
    protected WebDriver driver;

    private By messageBy = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span");

    public HomePage(WebDriver driver, Boolean loggedIn) throws InterruptedException {
        this.driver = driver;
        if(loggedIn){
            Thread.sleep(2500);
            if (!getMessageText().equals("Welcome, test tester!")) {
                throw new IllegalStateException("This is not Home Page of logged in user," +
                        " current page is: " + driver.getCurrentUrl());
            }
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
