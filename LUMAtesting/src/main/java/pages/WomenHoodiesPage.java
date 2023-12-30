package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class WomenHoodiesPage {

    protected WebDriver driver;

    public WomenHoodiesPage(WebDriver driver){
        this.driver = driver;
    }
    By hoodieLocator = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[1]/div/div/strong/a" );
    By quantityLocator = By.id("qty");
    By clothesSize = By.id("option-label-size-143-item-168");
    By color = By.id("option-label-color-93-item-53"); //By.xpath("//*[@id=\"option-label-color-93-item-57\"]");
    By btnAddToCart = By.id("product-addtocart-button");

    public void getToItemPage(){
        driver.findElement(hoodieLocator).click();
    }

    public void clickElements(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(clothesSize).click();
        driver.findElement(color).click();
        typeQuantity("2");
        driver.findElement(btnAddToCart).click();
    }

    public void typeQuantity(String quantity) {
        driver.findElement(quantityLocator).sendKeys(quantity);
    }
}
