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
    public void AmazonSignIntest() throws IOException {
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
    public void returnOrdersTest() throws IOException{
        returnsAndOrders();
        String expectedText = "Your Orders";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText,"Text did not match");
    }

    @Test
    public void primeVideoPageTest() throws IOException {
        primeVideoPage();
        String expectedText = "Amazon.com: Prime Video: Prime Video";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText,"Text did not match");

    }
    @Test
    public void customerServicepageTest() throws IOException {
        customerServicePage();
        String expectedText = "Amazon.com Help: Help & Customer Service";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText,"Text did not match");
    }

    @Test
    public void primePageTest() throws IOException{
        primePage();
        String expectedText = "Amazon.com: Amazon Prime";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText,"Text did not match");
    }

    @Test
    public void bestSellersPageTest() throws IOException {
        bestSellersPage();
        String expectedText = "Amazon.com Best Sellers: The most popular items on Amazon";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText,"Text did not match");

    }

    @Test
    public void conditionsofUsePageTest() throws IOException {
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

    @Test
    public void interestBasedAdsTest() throws IOException {
        interestBasedAds();
        String expectedText = "Security and Privacy";
        String actualText = driver.findElement(By.cssSelector("body > div.cs-help-v4 > div.cs-help-container > div.cs-help-sidebar > div.cs-help-sidebar-module.topic-sidebar > div:nth-child(2) > h3")).getText();
        Assert.assertEquals(actualText,expectedText,"Text was not found");
    }

    @Test
    public void careersPageTest() throws IOException {
        careersPage();
        String expectedText = "Find jobs";
        String actualText = driver.findElement(By.cssSelector("#home-search > h1")).getText();
        Assert.assertEquals(actualText,expectedText,"Text was not found");
    }

    @Test
    public void testCheckSearchBox() throws IOException {
        checkSearchBox();
        String expectedText="LMVERNA";
        String actualText=driver.findElement(By.linkText("LMVERNA")).getText();
        Assert.assertEquals(actualText,expectedText,"Product does not match");
    }



    }
