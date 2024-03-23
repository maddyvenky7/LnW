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
    public void Validationpage_MultipleItems(String firstItemPrice,String firstItemPrice2, String KeyboardPrice, String HeadphonePrice, String Combined_value, String subtotalvalue){
        AddToCart addToCart = new AddToCart(driver);
        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(firstItemPrice,HeadphonePrice,"This price do not match");
        System.out.println("Assertion passed: The cart value matches the Headphone price.");
        Assert.assertEquals(firstItemPrice2,KeyboardPrice,"This price do not match");
        System.out.println("Assertion passed: The cart value matches the KeyboardPrice price.");
        Assert.assertEquals(Combined_value,subtotalvalue,"This price do not match");
        System.out.println("Assertion passed: The subtotal value matches the item price.");
    }

}
