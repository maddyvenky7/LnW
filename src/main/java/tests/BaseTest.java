package tests;

import Base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

import java.io.IOException;

public class BaseTest {

    WebDriver driver;
    BaseClass bc;
    HomePage homePage;
    SearchPage searchPage;
    ProductPage productPage;
    AddToCart addToCart;
    Validation validation;
    @BeforeMethod
    public void setup() throws IOException {
        bc = new BaseClass();
        driver= bc.init_setup();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);
        addToCart = new AddToCart(driver);
        validation = new Validation(driver);
    }

    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
