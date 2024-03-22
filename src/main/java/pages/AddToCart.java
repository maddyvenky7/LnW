package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCart {
    private WebDriver driver;

    public AddToCart(WebDriver driver){
        this.driver = driver;
    }

    public String[] Addtocartpage(){
        ProductPage productPage = new ProductPage(driver);
        WebElement cartValue = driver.findElement(By.xpath("//span[contains(@class, 'sc-price') and contains(@class, 'sc-product-price')]"));
        System.out.println("Cart Value is " + cartValue.getText().trim());
        String cartvaluetext= cartValue.getText().trim();
        WebElement finalAmount = driver.findElement(By.id("sc-subtotal-amount-buybox"));
        System.out.println("Sub total value is "+ finalAmount.getText().trim());
        String subtotalvalue= finalAmount.getText().trim();
        return new String[] {cartvaluetext,subtotalvalue};

    }

}
