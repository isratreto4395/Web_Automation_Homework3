package tDBank.investingandwealth;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tDBank.homepage.TDBankHomepage;

public class InvestingAndWealthpage extends TDBankHomepage {
    JavascriptExecutor jScript;
    //String individualAndFamilies = "//*[@id=\"drag-id-tabsCarousel0\"]/div/li[1]/div[1]/span/span";
   // String individualAndFamilies = "//*[@id=\"drag-id-tabsCarousel0\"]/div/li[1]/div[1]/span";
    String individualAndFamilies = "#drag-id-tabsCarousel0 > div > li.td-tabs-carousel-tab.td-tabs-carousel-tab-no-borders.slick-slide.slick-current.slick-active > div.td-tabs-carousel-tab-content.icon-link > span > span";
    String investmentManagement = "//*[@id=\"main\"]/section[4]/div/div[2]/div[1]/div/h3/a";
    String ourProcess = "#Tab_2 > div.td-tabs-carousel-tab-content";

    public void investingAndWealthIndividualAndFamiliesAccout() throws InterruptedException {
        investingAndWealthTab();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(individualAndFamilies)).click();
    }

    public void investmentManagementLink() throws InterruptedException {
        investingAndWealthIndividualAndFamiliesAccout();
        driver.findElement(By.xpath(investmentManagement)).click();
    }

    public void investmentOurProcess() throws InterruptedException {
        investmentManagementLink();
        jScript = (JavascriptExecutor) driver;
        jScript.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.cssSelector(ourProcess)).click();
    }


}
