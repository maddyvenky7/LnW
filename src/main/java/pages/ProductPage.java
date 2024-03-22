package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }
    public void WindowHandler(){
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentid = it.next();
        String childid = it.next();
        driver.switchTo().window(childid);
    }

    public String ProductItem() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> pricetag = driver.findElements(By.xpath("//*[@id='corePriceDisplay_desktop_feature_div']/div[1]/span[3]/span[2]/span[2]"));
        String firstItemPrice = pricetag.get(0).getText().trim()+".00";
        System.out.println("The price of the first item is: " + firstItemPrice);
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//input[@id='add-to-cart-button']"));

        // Check the number of Add to Cart buttons found
        if (addToCartButtons.size() > 1) {
            // If there are two or more buttons, click the second one
            addToCartButtons.get(1).click();
        } else if (addToCartButtons.size() == 1) {
            // If there is only one button, click the first one
            addToCartButtons.get(0).click();
        } else {
            // Handle the case where no buttons are found
            System.out.println("No Add to Cart button found");
        }
        Thread.sleep(2000);
        try {
            WebElement button = driver.findElement(By.xpath("//input[@type='submit' and @aria-labelledby='attachSiNoCoverage-announce']"));
            if (button.isDisplayed()) {
                button.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("The element is not present or visible.");
        }
        Thread.sleep(4000);
        try {
            WebElement windowClose = driver.findElement(By.xpath("//a[@id='attach-close_sideSheet-link']"));
            windowClose.click();
        } catch (NoSuchElementException e) {
            System.out.println("The close button was not found on the web page.");
        }
        WebElement cartBTN = driver.findElement(By.id("nav-cart"));
        cartBTN.click();
        return firstItemPrice;
    }


}
