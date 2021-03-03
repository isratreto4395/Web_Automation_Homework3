package amazon.AddingToCart;

import amazon.homepage.AmazonHomepage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddingToCart extends AmazonHomepage {
    String hijabLocate = "#search > div.s-desktop-width-max.s-desktop-content.sg-row > div.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span:nth-child(4) > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(5) > div > span > div > div > div:nth-child(4) > h2 > a > span";
    String addToCart = "//*[@id=\"add-to-cart-button\"]";
    String cart ="Cart";

    public void locateSearchElement() throws IOException {
        checkSearchBox();
        driver.findElement(By.cssSelector(hijabLocate)).click();
    }

    public void addingElementToCart() throws IOException {
        locateSearchElement();
        driver.findElement(By.xpath(addToCart)).click();

    }

    public void checkingTheCart() throws IOException {
        addingElementToCart();
        driver.findElement(By.linkText(cart)).click();
    }


}


