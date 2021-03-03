package tDBank.smallbusiness;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tDBank.homepage.TDBankHomepage;

public class SmallBusinessPage extends TDBankHomepage {
    WebDriver driver;
    JavascriptExecutor jScript;
    //String checkingAccount = "//*[@id=\"drag-id-tabsCarousel0\"]/div/li[1]/div[1]/span";
    String checkingAccount = "#main > section.td_rq_icon_link_carousel.td-product-service-icon-links > div.td-tabs-carousel-container-icon-link-only.visible-xs.td-row > div > ul > li:nth-child(1) > div > a > span > span";

    @Test
    public void smallBuisnessCheckingAccout() throws InterruptedException {
        smallBusinessTab();
        Thread.sleep(2000);
        jScript = (JavascriptExecutor)driver;
        jScript.executeScript("window.scrollBy(0,350)","");
        driver.findElement(By.xpath(checkingAccount)).click();
    }
}
