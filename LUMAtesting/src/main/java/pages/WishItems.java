package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WishItems {

    protected WebDriver driver;

    public WishItems(WebDriver driver){
        this.driver = driver;
    }
    By tshirtCardLocator = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[6]/div");
    By wishListLinkLocator=By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[5]/div/a[1]");


    public void getToItemPage(){
        driver.findElement(tshirtCardLocator).click();
    }


    public void addToWishList(){
       getToItemPage();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       driver.findElement(wishListLinkLocator).click();
    }

}
