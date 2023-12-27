package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    protected WebDriver driver;

    private By messageBy = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span");

    public HomePage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(5000);
        if (!getMessageText().equals("Welcome, test tester!")) {
            throw new IllegalStateException("This is not Home Page of logged in user," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    public String getMessageText() {
        return driver.findElement(messageBy).getText();
    }

    public HomePage manageProfile() throws InterruptedException {
        return new HomePage(driver);
    }

}
