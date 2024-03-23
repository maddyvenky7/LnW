package tests;

import org.testng.annotations.Test;

public class Scenarios extends BaseTest{
    @Test(priority = 1)
    public void Monitor() throws InterruptedException {
        String Title = homePage.Homepagetitle();
        System.out.println("Title is "+ Title);
        homePage.Search("Monitor");
        searchPage.SelectProduct();
        productPage.WindowHandler();
        productPage.ProductItem();
        addToCart.Addtocartpage();
        validation.Validationpage("","","");
    }
    @Test(priority = 2)
    public void Laptop() throws InterruptedException {
        String Title = homePage.Homepagetitle();
        System.out.println("Title is "+ Title);
        homePage.Search("Laptop");
        searchPage.SelectProduct();
        productPage.WindowHandler();
        productPage.ProductItem();
        addToCart.Addtocartpage();
        validation.Validationpage("","","");
    }
    @Test(priority = 2)
    public void TwoItems() throws InterruptedException {
        String Title = homePage.Homepagetitle();
        System.out.println("Title is "+ Title);
        homePage.Search("Headphones");
        searchPage.SelectProduct();
        productPage.WindowHandler();
        productPage.ProductItem();
        homePage.Search("Keyboard");
        searchPage.SelectProduct();
        productPage.WindowHandler();
        productPage.ProductMultipleItems();
        addToCart.Addtocartpage_MultipleItems();
        validation.Validationpage_MultipleItems("","","","","","");
    }

}
