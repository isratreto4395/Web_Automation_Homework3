package cheapOair;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HomePage {
    WebDriver driver;
    String cheapOairUrl ="https://www.cheapoair.com/";
    String fromAirportlocation = "#from";
    String fromLocation= "Dhaka, Bangladesh";
    //String signin = "//*[@id=\"app\"]/header/div/div/div[2]/div[1]/div/a";
    String signin = "#app > header > div > div > div.flex__body.text-sm-right > div:nth-child(1) > div > a";
    String userName = "email";
    String proceedButton = "btn btn-lg btn-block btn-primary";
    String password = "password";
    String signInButton = "btn btn-block btn-primary btn-lg mb-1";

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
        driver.findElement(By.cssSelector(signin)).click();
        driver.findElement(By.name(userName)).sendKeys(prop.getProperty("emailAddress"));
        driver.findElement(By.className(proceedButton)).click();
        driver.findElement(By.name(password)).sendKeys(prop.getProperty("password"));
        driver.findElement(By.className(signInButton)).click();




    }

    public void checkFromWhereTab() throws InterruptedException {
       driver.findElement(By.cssSelector(fromAirportlocation)).sendKeys(fromLocation);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        HomePage home = new HomePage();
        home.checkFromWhereTab();
    }




































}
