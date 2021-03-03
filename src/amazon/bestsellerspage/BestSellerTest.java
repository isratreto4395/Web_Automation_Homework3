package amazon.bestsellerspage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BestSellerTest extends BestSeller {
    @Test
    public void BestSellersInBooksTest() throws InterruptedException, IOException {
        bestSellersInBooks();
        String expectedText = "The Cat in the Hat";
        String actualText = driver.findElement(By.linkText("The Cat in the Hat")).getText();
        Assert.assertEquals(actualText, expectedText, "Book is not found");
    }

    @Test
    public void booksGenreLinkTest() throws InterruptedException, IOException {
        booksGenreLink();
        String expectedText = "The Wedding Game";
        String actualText = driver.findElement(By.linkText("The Wedding Game")).getText();
        Assert.assertEquals(actualText, expectedText, "Book is not found");

    }


}
