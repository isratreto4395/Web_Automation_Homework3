package tDBank.homepage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TDBankHomepageTesting extends TDBankHomepage {

    @Test
    public void pageTitleTest() {
        String expectedText = "TD Personal Banking, Loans, Cards & More | TD Bank";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Page Title not match");
    }


    @Test
    public void getOfferTest() {
        getOffer();
        String expectedText = "For new Customers only. Offer ends March 31, 2021.1";
        String actualText = driver.findElement(By.xpath("//*[@id=\"checking-anchor\"]/div/div/div/p[1]")).getText();
        Assert.assertEquals(actualText, expectedText, "Text did not match");
    }

    @Test
    public void homeEquityTest() {
        homeEquity();
        String expectedText = "Home Equity Lines of Credit and Loans";
        //String actualText = driver.findElement(By.xpath("//*[@id=\"main\"]/section[3]/div/div")).getText();
        String actualText = driver.findElement(By.className("td-col td-col-xs-12 td-col-sm-10 td-col-sm-offset-1")).getText();
        Assert.assertEquals(actualText, expectedText, "The text did not match");

    }

    @Test
    public void smallBusinessTabTest() {
        smallBusinessTab();
        String expectedText = "Small Business Banking by TD Bank";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Text did not match");
    }

    @Test
      public void investingAndWealthTabTest() {
        investingAndWealthTab();
        String expectedText = "Wealth & Investment Management And Financial Planning | TD Wealth";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Text did not match");
    }

    @Test
    public void commercialPageTabTest() {
        commercialPageTab();
        String expectedText = "TD Commercial Business Banking";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Text did not match");
    }
}
