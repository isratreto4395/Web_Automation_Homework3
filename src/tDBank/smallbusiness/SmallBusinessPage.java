package tDBank.smallbusiness;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tDBank.homepage.TDBankHomepage;

public class SmallBusinessPage extends TDBankHomepage {
    JavascriptExecutor jScript;
    String checkingAccount = "#drag-id-tabsCarousel0 > div > li.td-tabs-carousel-tab.td-tabs-carousel-tab-no-borders.slick-slide.slick-current.slick-active > div.td-tabs-carousel-tab-content.icon-link > span > span";


    public void smallBuisnessCheckingAccout() throws InterruptedException {
        smallBusinessTab();
        Thread.sleep(2000);
        jScript = (JavascriptExecutor)driver;
        jScript.executeScript("window.scrollBy(0,350)","");
        driver.findElement(By.cssSelector(checkingAccount)).click();
    }
}
