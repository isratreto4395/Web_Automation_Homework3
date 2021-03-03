package amazon.bestsellerspage;

import amazon.homepage.AmazonHomepage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.IOException;

public class BestSeller extends AmazonHomepage {
    String books = "See more Best Sellers in Books";
    String genre = "Romance";

    public void bestSellersInBooks() throws InterruptedException, IOException {
        bestSellersPage();
        jscript = (JavascriptExecutor) driver;
        jscript.executeScript("window.scrollBy(0,750)", "");
        Thread.sleep(5000);
        driver.findElement(By.linkText(books)).click();

    }

    public void booksGenreLink() throws InterruptedException, IOException {
        bestSellersInBooks();
        jscript = (JavascriptExecutor) driver;
        jscript.executeScript("window.scrollBy(0,450)","");
        Thread.sleep(5000);
        driver.findElement(By.linkText(genre)).click();
    }
}
