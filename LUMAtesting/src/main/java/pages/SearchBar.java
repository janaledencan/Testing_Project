package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBar {

    WebDriver driver;
    public SearchBar(WebDriver driver){
        this.driver = driver;
    }

    By searchInput = By.name("q");

    public void Search(String searchTxt){
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(searchTxt);
        driver.findElement(searchInput).submit();

        try{Thread.sleep(2000);}catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
