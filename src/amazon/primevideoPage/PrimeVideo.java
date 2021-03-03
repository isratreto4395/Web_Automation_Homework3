package amazon.primevideoPage;

import amazon.homepage.AmazonHomepage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class PrimeVideo extends AmazonHomepage {
    String gemniMovie = "//*[@id=\"aiv-cl-main-middle\"]/div/div[3]/div/div[3]/div/div[2]/div/div/ul/li[1]/div[1]";
    String storeTab = "Store";
    String backToTopTab = "Back to top";

    public void amazonOriginals() throws IOException {
        primeVideoPage();
        jscript = (JavascriptExecutor) driver;
        jscript.executeScript("window.scrollBy(0,550)", "");
        driver.findElement(By.xpath(gemniMovie)).click();
    }

    public void seeMoreVideo() throws IOException, InterruptedException {
        primeVideoPage();
        jscript = (JavascriptExecutor) driver;
        jscript.executeScript("window.scrollBy(0,550)", "");
        Thread.sleep(5000);
        driver.findElement(By.linkText("See more")).click();
    }

    public void storeInPrimeVideo() throws IOException {
        primeVideoPage();
        driver.findElement(By.linkText(storeTab)).click();

    }

    public void backToPrimeVideo() throws IOException, InterruptedException {
        primeVideoPage();
        jscript = (JavascriptExecutor) driver;
        jscript.executeScript("window.scrollBy(0,750)", "");
        Thread.sleep(5000);
        driver.findElement(By.linkText(backToTopTab)).click();

    }


}
