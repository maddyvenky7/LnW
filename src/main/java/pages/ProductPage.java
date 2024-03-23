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
        if (windows.size() > 1) {
            String childid1 = it.next();
            driver.switchTo().window(childid1);

            if (windows.size() > 2) {
                // Switch to the third window
                String childid2 = it.next();
                driver.switchTo().window(childid2);
            }
        }
    }

    public String ProductItem() throws InterruptedException {
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.xpath("//div[@id='titleSection']"));
        String ProductTitle = product.getText();
        System.out.println("Product Name "+ProductTitle);
        List<WebElement> pricetag = driver.findElements(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']//span[contains(@class, 'a-price') and contains(@class, 'a-price-whole')]"));
        String firstItemPrice = pricetag.get(0).getText().trim()+".00";
        System.out.println("The price of the first item is: " + firstItemPrice);
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//input[@id='add-to-cart-button']"));

        if (addToCartButtons.size() > 1) {
            addToCartButtons.get(1).click();
        } else if (addToCartButtons.size() == 1) {
            addToCartButtons.get(0).click();
        } else {
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
        return firstItemPrice;
    }

    public String ProductMultipleItems() throws InterruptedException {
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.xpath("//div[@id='titleSection']"));
        String ProductTitle = product.getText();
        System.out.println("Product Name "+ProductTitle);
        List<WebElement> pricetag = driver.findElements(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']//span[contains(@class, 'a-price') and contains(@class, 'a-price-whole')]"));
        String firstItemPrice2 = pricetag.get(0).getText().trim()+".00";
        System.out.println("The price of the first item is: " + firstItemPrice2);
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//input[@id='add-to-cart-button']"));

        if (addToCartButtons.size() > 1) {
            addToCartButtons.get(1).click();
        } else if (addToCartButtons.size() == 1) {
            addToCartButtons.get(0).click();
        } else {
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
        return firstItemPrice2;
    }



}
