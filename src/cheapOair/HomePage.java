package cheapOair;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HomePage {
    WebDriver driver;
    String cheapOairUrl = "https://www.cheapoair.com/";
    //String signin = "//*[@id=\"app\"]/header/div/div/div[2]/div[1]/div/a";
    String signinLocatorcss = "#app > header > div > div > div.flex__body.text-sm-right > div:nth-child(1) > div > a";
    String signinLocatorcss1 = "#app > header > div > div > div.flex__body.text-sm-right > div:nth-child(1) > div > li";

    String signInLocatorclassnam = "utility__link dropdown-toggle ml-0";
    String signInLocatorclassname = "navigation__login dropdown navigation__item";
    String signInLocatorxpath = "//*[@id=\"app\"]/header/div/div/div[2]/div[1]/div/li/a";
    String userName = "email";
    String proceedButton = "btn btn-lg btn-block btn-primary";
    String password = "password";
    String signInButton = "btn btn-block btn-primary btn-lg mb-1";
    String fromAirportlocation = "from0";
    String fromLocationClearBox = "#panel-1 > div > div:nth-child(4) > div.col-12.col-md-12.col-lg-8 > div > div.col-12.col-md-8.col-lg-8 > div > div.col-12.col-sm-6.widget__input-from.position-relative > div.widget__input.is-active > a";
    String fromLocation = "Dhaka";
    String toAirportlocation = "to0";
    String toLocationClearBox = "#panel-1 > div > div:nth-child(4) > div.col-12.col-md-12.col-lg-8 > div > div.col-12.col-md-8.col-lg-8 > div > div.col-12.col-sm-6.widget__input-to > div > a > svg";
    String toLocation = "JFK";
    String fromDateLocator = "cal0";
    String calendarHeader = "calendar__header";
    String rightArrowNavigation = "calendar-nav__next icon  rightNav";
    String fromDate = "16 August";
    String toDateLocator = "cal1";
    String toMonth = "";
    String toDate = "18 December 2021";


    @BeforeMethod
    public void setUp() throws InterruptedException {
        String chromeDriverPath = "BrowserDriver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(cheapOairUrl);
        Thread.sleep(5000);
    }

    public static Properties loadProperties() throws IOException {
        String filePath = "/Users/israt/IdeaProjects/Homework3/Properties/secret.properties";
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(filePath);
        properties.load(inputStream);
        return properties;
    }

    @Test
    public void cheapOairlogIn() throws IOException {
        Properties prop = loadProperties();
        driver.findElement(By.cssSelector(signinLocatorcss1)).click();
        //driver.findElement(By.className(signInLocatorclassnam)).click();
        //driver.findElement(By.className(signInLocatorclassname)).click();
        //driver.findElement(By.xpath(signInLocatorxpath)).click();

        driver.findElement(By.name(userName)).sendKeys(prop.getProperty("emailAddress"));
        driver.findElement(By.className(proceedButton)).click();
        driver.findElement(By.name(password)).sendKeys(prop.getProperty("password"));
        driver.findElement(By.className(signInButton)).click();


    }

    @Test
    public void FlightsTab() throws InterruptedException {
        //Thread.sleep(5000);
        driver.findElement(By.cssSelector(fromLocationClearBox)).click();
        //driver.findElement(By.id(fromAirportlocation)).clear();
        driver.findElement(By.id(fromAirportlocation)).sendKeys(fromLocation);
        //driver.findElement(By.id(fromAirportlocation)).click();
        driver.findElement(By.id(fromAirportlocation)).sendKeys(Keys.TAB);
        driver.findElement(By.id(toAirportlocation)).sendKeys(toLocation);
        //driver.findElement(By.id(toAirportlocation)).click();
        driver.findElement(By.id(toAirportlocation)).sendKeys(Keys.ENTER);

        //driver.findElement(By.id(fromDateLocator)).sendKeys("10202021");
        //driver.findElement(By.id(toDateLocator)).sendKeys("11202021");
        //driver.findElement(By.xpath("//*[@id=\"cal0\"]")) //*[@id="cal0"]
        driver.findElement(By.id(fromDateLocator)).click();
        driver.findElement(By.xpath("//a[@aria-label ='August 20']")).click();
        //driver.findElement(By.xpath("//*[@aria-label = '17 October 2021")).click();


//        while (true) {
//            String text = driver.findElement(By.className(calendarHeader)).getText();//click on the calendar header
//            if (text.equals(fromMonth)) {//if the calendar header is the same as the month i am looking for then i want to break out of the loop
//                break;
//            } else {
//                //if it is not a match then click on the arrow mark and it will go through the loop until it finds my expected month and yr
//                driver.findElement(By.className(rightArrowNavigation)).click();
//            }
//
//        }


    }

    @Test
    public void flightsTab() {
        driver.findElement(By.cssSelector(fromLocationClearBox)).click();
        driver.findElement(By.id(fromAirportlocation)).sendKeys(fromLocation);
        driver.findElement(By.id(fromAirportlocation)).sendKeys(Keys.TAB);
        driver.findElement(By.id(toAirportlocation)).sendKeys(toLocation);
        driver.findElement(By.id(toAirportlocation)).sendKeys(Keys.TAB);
        JavascriptExecutor jscript = (JavascriptExecutor) driver;
        WebElement fromDateLocate = driver.findElement(By.id(fromDateLocator));
        fromDateLocate.click();
        jscript.executeScript("arguments[0].setAttribute('value','" + fromDate + "');", fromDateLocate);
        fromDateLocate.sendKeys(Keys.ENTER);
        WebElement toDateLocate = driver.findElement(By.id(toDateLocator));
        toDateLocate.click();
        jscript.executeScript("arguments[0].setAttribute('value','" + toDate + "');", toDateLocate);


    }

    @Test
    public void flightsTab2() {
        driver.findElement(By.cssSelector(fromLocationClearBox)).click();
        driver.findElement(By.id(fromAirportlocation)).sendKeys(fromLocation);
        driver.findElement(By.id(fromAirportlocation)).sendKeys(Keys.TAB);
        driver.findElement(By.id(toAirportlocation)).sendKeys(toLocation);
        driver.findElement(By.id(toAirportlocation)).sendKeys(Keys.TAB);
        //((JavascriptExecutor)driver).executeScript ("document.getElementById('cal0').removeAttribute('readonly',0);"); // Enables the from date box
        WebElement fromDateLocate = driver.findElement(By.id(fromDateLocator));
        fromDateLocate.sendKeys(fromDate);
        //((JavascriptExecutor)driver).executeScript ("document.getElementById('cal1').removeAttribute('readonly',0);"); // Enables the from date box
        WebElement toDateLocate = driver.findElement(By.id(toDateLocator));
        toDateLocate.sendKeys(toDate);





    }


    //@AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


}
