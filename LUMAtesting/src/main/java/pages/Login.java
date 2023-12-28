package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private final WebDriver driver;
    public Login(WebDriver driver){
        this.driver = driver;
        getToLoginPage();

        // Check that we're on the right page.
        if (!"Customer Login".equals(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).getText())) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    By signInLocator = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
    By emailLocator = By.name("login[username]");
    By passwordLocator = By.name("login[password]");
    By loginButtonLocator = By.name("send");

    public void getToLoginPage(){
       driver.findElement(signInLocator).click();
    }


    public Login typeEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
        return this;
    }

    public Login typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public HomePage submitLogin() throws InterruptedException {
        driver.findElement(loginButtonLocator).submit();
        return new HomePage(driver, true);
    }


    public Login submitLoginExpectingFailure() {
        driver.findElement(loginButtonLocator).submit();
        return new Login(driver);
    }

    public HomePage loginAs(String email, String password) throws InterruptedException {
        typeEmail(email);
        typePassword(password);
        return submitLogin();
    }
}

