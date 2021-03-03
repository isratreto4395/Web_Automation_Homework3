package tDBank.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TDBankHomepage {
    public WebDriver driver;
    Select dropDown;
    JavascriptExecutor jScript;
    String tdBankurl = "https://tdbank.com";
    String adChoicesAndPersonalizationXButton = "//*[@id=\"ensCall\"]/span[2]";
    String getofferButton = "//*[@id=\"login-body-content-cloned\"]/div/div/a";
    String homeEquityButton = "//*[@id=\"drag-id-tabsCarousel0\"]/div/li[4]/div[1]/span";
    String selectAStateDropdown = "//*[@id=\"state\"]";
    String state = "New Jersey";
    String selectCityDropdown = "//*[@id=\"city\"]";
    String city = "Deptford";
    //String setMyLocationButton = "//*[@id=\"scrollbarid_486\"]/div/div/div/div/p[3]/button";
    String setMyLocationButtonSelector = "#drag-id-tabsCarousel0 > div > li:nth-child(2) > div.td-tabs-carousel-tab-content.icon-link > span";
    String smallBusinesstabLocator = "body > div.td-header-nav-top-message > div.td_rq_header-nav.td-header-nav > header.td-header-desktop > div.td-utility-toggle > div > div.td-section-left > div > ul > li:nth-child(2)";
    String commercialTabLocator = "Commercial";
    String investingAndHealthLocator = "Investing & Wealth";


    @BeforeMethod
    public void setUp() throws InterruptedException {
        String chromeDriverPath = "BrowserDriver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(tdBankurl);
        driver.findElement(By.xpath(adChoicesAndPersonalizationXButton)).click();
        Thread.sleep(5000);
    }

    public void getOffer() {
        driver.findElement(By.xpath(getofferButton)).click();
    }

    public void homeEquity() {
        jScript = (JavascriptExecutor) driver;
        jScript.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.xpath(homeEquityButton)).click();
        dropDown = new Select(driver.findElement(By.xpath(selectAStateDropdown)));
        dropDown.selectByVisibleText(state);
        dropDown = new Select(driver.findElement(By.xpath(selectCityDropdown)));
        dropDown.selectByVisibleText(city);
        driver.findElement(By.cssSelector(setMyLocationButtonSelector)).click();

    }

    public void smallBusinessTab() {
        driver.findElement(By.cssSelector(smallBusinesstabLocator)).click();
    }

    public void investingAndWealthTab() {
        driver.findElement(By.linkText(investingAndHealthLocator)).click();
    }

    public void commercialPageTab() {
        driver.findElement(By.linkText(commercialTabLocator)).click();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();


    }


}


