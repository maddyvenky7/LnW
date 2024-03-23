package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AddToCart {
    private WebDriver driver;

    public AddToCart(WebDriver driver){
        this.driver = driver;
    }

    public String[] Addtocartpage(){
        ProductPage productPage = new ProductPage(driver);
        WebElement cartBTN = driver.findElement(By.id("nav-cart"));
        cartBTN.click();
        WebElement cartValue = driver.findElement(By.xpath("//span[contains(@class, 'sc-price') and contains(@class, 'sc-product-price')]"));
        System.out.println("Cart Value is " + cartValue.getText().trim());
        String cartvaluetext= cartValue.getText().trim();
        WebElement finalAmount = driver.findElement(By.id("sc-subtotal-amount-buybox"));
        System.out.println("Sub total value is "+ finalAmount.getText().trim());
        String subtotalvalue= finalAmount.getText().trim();
        return new String[] {cartvaluetext,subtotalvalue};

    }
    public String[] Addtocartpage_MultipleItems(){
        ProductPage productPage = new ProductPage(driver);
        WebElement cartBTN = driver.findElement(By.id("nav-cart"));
        cartBTN.click();
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
        String KeyboardPrice = prices.get(0).getText().trim();
        String HeadphonePrice = prices.get(1).getText().trim();
        System.out.println("Keyboard price is " + KeyboardPrice);
        System.out.println("Headphone price is " + HeadphonePrice);
        WebElement finalAmount = driver.findElement(By.id("sc-subtotal-amount-buybox"));
        System.out.println("Sub total value is "+ finalAmount.getText().trim());
        String subtotalvalue= finalAmount.getText().trim();
        String Combined_value = HeadphonePrice + KeyboardPrice;
        return new String[] {KeyboardPrice,HeadphonePrice,Combined_value,subtotalvalue};

    }

}
