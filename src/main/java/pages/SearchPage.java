package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductPage SelectProduct() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='aok-relative']"));
        System.out.println("No of products found "+items.size());
        String firstItem = items.get(0).getText();
        items.get(0).click();
        return new ProductPage(driver);
    }
}
