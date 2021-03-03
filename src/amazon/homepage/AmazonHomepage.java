package amazon.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AmazonHomepage {

    WebDriver driver;
    JavascriptExecutor jscript;
    String amazonUrl="https://www.amazon.com/";
    String logoPath = "nav-logo-sprites";
    String signinAccountLocator = "//*[@id=\"nav-link-accountList\"]";
    String userName = "email";
    String continueButton = "//*[@id=\"continue\"]";
    String password = "password";
    String signInSubmit ="signInSubmit";
    String selectYourAddressLocator = "nav-global-location-popover-link";
    String zipCodeBox = "GLUXZipUpdateInput";
    String zipCode = "53224";
    String applyButton = "//*[@id=\"GLUXZipUpdate\"]/span/input";
    String doneButton = "//*[@id=\"a-popover-3\"]/div/div[2]/span/span/span/button";
    String returnsAndOrdersLocator = "nav-orders";
    String customerServiceTab = "#nav-xshop > a:nth-child(4)";
    String prime = "#nav-xshop > a:nth-child(5)";
    String primeTab ="#nav-xshop > a:nth-child(3)";
    String bestSellers = "#nav-xshop > a:nth-child(6)";
    String conditionsOfUse = "#navFooter > div.navFooterLine.navFooterLinkLine.navFooterPadItemLine.navFooterCopyright > ul > li.nav_first > a";
    String privacyNotice = "#navFooter > div.navFooterLine.navFooterLinkLine.navFooterPadItemLine.navFooterCopyright > ul > li:nth-child(2) > a";

    @BeforeMethod
    public void setUp() throws InterruptedException {
        String chromeDriverPath = "BrowserDriver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(amazonUrl);
        Thread.sleep(5000);
    }

    public void logo(){
        driver.findElement(By.id(logoPath)).isDisplayed();
    }

    public static Properties loadProperties() throws IOException {
        String filePath = "../Homework3/Properties/secret.properties";
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(filePath);
        properties.load(inputStream);
        return properties;
    }

    public void amazonlogIn() throws IOException, InterruptedException {
        Properties prop = loadProperties();
        driver.findElement(By.xpath(signinAccountLocator)).click();
        driver.findElement(By.name(userName)).sendKeys(prop.getProperty("Email"));
        driver.findElement(By.xpath(continueButton)).click();
        driver.findElement(By.name(password)).sendKeys(prop.getProperty("password1"));
        driver.findElement(By.id(signInSubmit)).click();


    }
    @Test
    public void selectYourAddressZipCode(){
        driver.findElement(By.id(selectYourAddressLocator)).click();
        driver.findElement(By.id(zipCodeBox)).sendKeys(zipCode);
        driver.findElement(By.xpath(applyButton)).click();
        driver.findElement(By.xpath(doneButton)).click();
    }

    @Test
    public void returnsAndOrders() throws IOException, InterruptedException {
        amazonlogIn();
        driver.findElement(By.id(returnsAndOrdersLocator)).click();
    }

    @Test
    public void primeVideoPage() throws IOException, InterruptedException {
        amazonlogIn();
        driver.findElement(By.cssSelector(primeTab)).click();
    }

    @Test
    public void customerServicePage() throws IOException, InterruptedException {
        amazonlogIn();
        driver.findElement(By.cssSelector(customerServiceTab)).click();
    }


    @Test
    public void primePage() throws IOException, InterruptedException {
        amazonlogIn();
        driver.findElement(By.cssSelector(prime)).click();
    }

    @Test
    public void bestSellersPage() throws IOException, InterruptedException {
        amazonlogIn();
        driver.findElement(By.cssSelector(bestSellers)).click();
    }

    @Test
    public void conditionsofUsePage() throws IOException, InterruptedException {
        amazonlogIn();
        jscript = (JavascriptExecutor)driver;
        jscript.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        driver.findElement(By.cssSelector(conditionsOfUse)).click();
    }

    @Test
    public void privacyNoticePage() throws IOException, InterruptedException {
        amazonlogIn();
        //jscript = (JavascriptExecutor)driver;
        //jscript.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        driver.findElement(By.cssSelector(privacyNotice)).click();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }


}
