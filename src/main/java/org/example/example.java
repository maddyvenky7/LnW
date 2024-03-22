package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class example {

    public static void main(String[] args) throws InterruptedException {
      System.setProperty("webdriver.chrome.driver","/Users/maddyvenky/Downloads/chromedriver-mac-arm64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.amazon.in/");

        driver.getTitle();
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        Actions action = new Actions(driver);

        action.sendKeys(searchbox, "Monitor").sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);

        List<WebElement> items = driver.findElements(By.xpath("//div[@class='aok-relative']"));
        System.out.println(items.size());
        String firstItem = items.get(0).getText();

       items.get(0).click();
       Set<String> windows = driver.getWindowHandles();
       Iterator<String> it = windows.iterator();
       String parentid = it.next();
       String childid = it.next();
       driver.switchTo().window(childid);
        List<WebElement> pricetag = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        String firstItemPrice = pricetag.get(0).getText().trim()+".00";
        System.out.println("The price of the first item is: " + firstItemPrice);

       WebElement addtocartBTN = driver.findElement(By.id("add-to-cart-button"));
        addtocartBTN.click();
        Thread.sleep(4000);


        try {
            WebElement windowClose = driver.findElement(By.xpath("//a[@id='attach-close_sideSheet-link']"));
            windowClose.click();
        } catch (NoSuchElementException e) {
            System.out.println("The close button was not found on the web page.");
        }
        WebElement cartBTN = driver.findElement(By.id("nav-cart"));
        cartBTN.click();
        //span[contains(@class, 'sc-price') and contains(@class, 'sc-white-space-nowrap') and contains(@class, 'sc-product-price')]
        WebElement cartValue = driver.findElement(By.xpath("//span[contains(@class, 'sc-price') and contains(@class, 'sc-product-price')]"));
        System.out.println("Cart Value is " + cartValue.getText().trim());
        String cartvaluetext= cartValue.getText().trim();
        WebElement finalAmount = driver.findElement(By.id("sc-subtotal-amount-buybox"));
        System.out.println("Sub total value is "+ finalAmount.getText().trim());
        String subtotalvalue= finalAmount.getText().trim();
        Assert.assertEquals(firstItemPrice,cartvaluetext,"This price do not match");
        System.out.println("Assertion passed: The cart value matches the item price.");
        Assert.assertEquals(firstItemPrice,subtotalvalue,"This price do not match");
        System.out.println("Assertion passed: The subtotal value matches the item price.");

        driver.quit();


    }
}
