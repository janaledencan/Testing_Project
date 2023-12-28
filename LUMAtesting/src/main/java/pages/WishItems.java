package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WishItems {

    protected WebDriver driver;
    public WishItems(WebDriver driver){
        this.driver = driver;
    }
    By tshirtCardLocator = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[6]");
    By btnHeartLocator = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[6]/div/div/div[3]/div/div[2]/a[1]");
    By wishListLinkLocator=By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[5]/div/a[1]");

    public void getToItemPage(){
        driver.findElement(tshirtCardLocator).click();
    }

    public void addToWishListWithHeart(){

        hoverElement(driver.findElement(tshirtCardLocator));
        driver.findElement(btnHeartLocator).click();
    }

    public void addToWishListWithLink(){

       getToItemPage();
       driver.findElement(wishListLinkLocator).click();
    }

    public void hoverElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
}
