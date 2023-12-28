package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WomenHoodiesPage {

    protected WebDriver driver;

    public WomenHoodiesPage(WebDriver driver){
        this.driver = driver;
    }
    By hoodieLocator = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[1]/div/div/strong/a" );
    By quantityLocator = By.name("qty");
    By clothesSize = By.xpath("//*[@id=\"option-label-size-143-item-168\"]");
    By color =By.xpath("//*[@id=\"option-label-color-93-item-57\"]");
    By btnAddToCart = By.xpath("//*[@id=\"product-addtocart-button\"]");

    public void getToItemPage(){
        driver.findElement(hoodieLocator).click();
    }

    public void clickElements() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(clothesSize).click();
        driver.findElement(color).click();
        typeQuantity("2");
        driver.findElement(btnAddToCart).click();
    }

    public void typeQuantity(String quantity) {
        driver.findElement(quantityLocator).sendKeys(quantity);
    }
}
