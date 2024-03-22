package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validation {
    private WebDriver driver;

    public Validation(WebDriver driver){
        this.driver = driver;
    }

    public void Validationpage(String firstItemPrice, String cartvaluetext, String subtotalvalue){
        AddToCart addToCart = new AddToCart(driver);
        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(firstItemPrice,cartvaluetext,"This price do not match");
        System.out.println("Assertion passed: The cart value matches the item price.");
        Assert.assertEquals(firstItemPrice,subtotalvalue,"This price do not match");
        System.out.println("Assertion passed: The subtotal value matches the item price.");
    }

}
