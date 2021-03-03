package tDBank.commercial;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tDBank.homepage.TDBankHomepage;

public class CommercialPage extends TDBankHomepage {
    String assetBasedLending = "//*[@id=\"drag-id-tabsCarousel0\"]/div/li[4]/div[1]/span/span";

    public void commercialAssetBasedLending() throws InterruptedException {
        commercialPageTab();

        JavascriptExecutor jScript = (JavascriptExecutor)driver;
        jScript.executeScript("window.scrollBy(0,350)","");
        Thread.sleep(2000);
        driver.findElement(By.xpath(assetBasedLending)).click();
    }
}
