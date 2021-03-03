package amazon.AddingToCart;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddingToCartTest extends AddingToCart {

    @Test
    public void locateSearchElementTest() throws IOException {
        locateSearchElement();
        String expectedText = "LMVERNA Chiffon Hijab Scarf Solid Color Luxurious Soft Hijab Long Scarf Wrap Scarves (Light khaki) at Amazon Women’s Clothing store";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Title does not exit");
    }

    @Test
    public void addingElementToCartTest() throws IOException {
        addingElementToCart();
        String expectedText = "Amazon.com Shopping Cart";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Title does not exit");
    }

}
