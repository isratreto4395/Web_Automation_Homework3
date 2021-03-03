package amazon.homepage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AmazonHomepageTesting extends AmazonHomepage {


    @Test
    public void logoTest(){
        boolean b = driver.findElement(By.id(logoPath)).isDisplayed();
    }

    @Test
    public void AmazonSignIntest() throws IOException, InterruptedException {
        amazonlogIn();
        String expectedText = "Israt's Amazon.com";
        String actualText = driver.findElement(By.id("nav-your-amazon-text")).getText();
        Assert.assertEquals(actualText,expectedText,"Text did not match");
    }

    @Test
    public void selectYourAddressZipCodeTest(){
        selectYourAddressZipCode();
        String expectedText = "Milwaukee 53224";
        String actualText = driver.findElement(By.cssSelector("#glow-ingress-block")).getText();
        Assert.assertEquals(actualText,expectedText,"Zip code did not match");
    }

    @Test
    public void returnOrdersTest() throws IOException, InterruptedException {
        returnsAndOrders();
        String expectedText = "Your Orders";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText,"Text did not match");
    }

    @Test
    public void primeVideoPageTest() throws IOException, InterruptedException {
        primeVideoPage();
        String expectedText = "Amazon.com: Prime Video: Prime Video";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText,"Text did not match");

    }
    @Test
    public void customerServicepageTest() throws IOException, InterruptedException {
        customerServicePage();
        String expectedText = "Amazon.com Help: Help & Customer Service";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText,"Text did not match");
    }

    @Test
    public void primePageTest() throws IOException, InterruptedException {
        primePage();
        String expectedText = "Amazon.com: Amazon Prime";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText,"Text did not match");
    }

    @Test
    public void bestSellersPageTest() throws IOException, InterruptedException {
        bestSellersPage();
        String expectedText = "Amazon.com Best Sellers: The most popular items on Amazon";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText,"Text did not match");

    }

    @Test
    public void conditionsofUsePageTest() throws IOException, InterruptedException {
        conditionsofUsePage();
        String expectedText = "Help & Customer Service";
        String actualText = driver.findElement(By.linkText(expectedText)).getText();
        Assert.assertEquals(actualText,expectedText,"Text did not match");
    }

    @Test
    public void privacyNoticePageTest() throws IOException, InterruptedException {
        privacyNoticePage();
        String expectedText ="Amazon.com Privacy Notice";
        String actualText = driver.findElement(By.cssSelector("body > div.cs-help-v4 > div.cs-help-container > div.cs-help-content > div > div.help-content > h1")).getText();
        Assert.assertEquals(actualText,expectedText,"Text does not exit");

    }

    }
