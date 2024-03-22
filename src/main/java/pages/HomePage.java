package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private WebDriver driver;
   // WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));

    private By SearchBox = By.id("twotabsearchtextbox");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String Homepagetitle(){
        return driver.getTitle();
    }

    public SearchPage Search(String item){
       // Actions actions = new Actions(driver);
        driver.findElement(SearchBox).sendKeys(item,Keys.ENTER);
        return new SearchPage(driver);
    }
}
