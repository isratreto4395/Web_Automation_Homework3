package tDBank.investingandwealth;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tDBank.homepage.TDBankHomepage;

public class InvestingAndWealthpage extends TDBankHomepage {
    WebDriver driver;
    JavascriptExecutor jScript;
    String individualAndFamilies = "//*[@id=\"drag-id-tabsCarousel0\"]/div/li[1]/div[1]/span/span";
    String investmentManagement = "//*[@id=\"main\"]/section[4]/div/div[2]/div[1]/div/h3/a";
    String ourProcess = "#Tab_2 > div.td-tabs-carousel-tab-content";


    @Test
    public void investingAndWealthIndividualAndFamiliesAccout() throws InterruptedException {
        investingAndWealthTab();
        Thread.sleep(2000);
        driver.findElement(By.xpath(individualAndFamilies)).click();
    }

    @Test
    public void investmentManagementLink() throws InterruptedException {
        investingAndWealthIndividualAndFamiliesAccout();
        driver.findElement(By.xpath(investmentManagement)).click();
    }

    @Test
    public void investmentOurProcess() throws InterruptedException {
        investmentManagementLink();
        jScript = (JavascriptExecutor) driver;
        jScript.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.cssSelector(ourProcess)).click();
    }


}
