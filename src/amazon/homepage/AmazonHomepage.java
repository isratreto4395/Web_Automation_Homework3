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

    public WebDriver driver;
    public JavascriptExecutor jscript;
    String amazonUrl="https://www.amazon.com/";
    String logoPath = "nav-logo-sprites";
    String signinAccountLocator = "//*[@id=\"nav-link-accountList\"]";
    String userName = "email";
    String continueButton = "//*[@id=\"continue\"]";
    String password = "password";
    String signInSubmit ="signInSubmit";
    String selectYourAddressLocator = "nav-global-location-popover-link";
    //String zipCodeBox = "GLUXZipUpdateInput";
    //String zipCodeBox="GLUXZipInputSection";
    //String zipCodeBox = "GLUX_Full_Width a-declarative";
    //String zipCodeBox = "#GLUXZipUpdateInput";
    //String zipCodeBox = "//*[@id=\"GLUXZipUpdateInput\"]";
    //String zipCodeBox = "a-column a-span8";
    String zipCodeBox = "#GLUXZipInputSection > div.a-column.a-span8";
    String zipCode = "53224";
    String applyButton = "//*[@id=\"GLUXZipUpdate\"]/span/input";
    String doneButton = "//*[@id=\"a-popover-3\"]/div/div[2]/span/span/span/button";
    String returnsAndOrdersLocator = "nav-orders";
    String customerServiceTab = "Customer Service";
    String prime = "Prime";
    String primeTab ="Prime Video";
    String bestSellers = "Best Sellers";
    String conditionsOfUse = "#navFooter > div.navFooterLine.navFooterLinkLine.navFooterPadItemLine.navFooterCopyright > ul > li.nav_first > a";
    String privacyNotice = "#navFooter > div.navFooterLine.navFooterLinkLine.navFooterPadItemLine.navFooterCopyright > ul > li:nth-child(2) > a";
    String interestBasedAds = "#navFooter > div.navFooterLine.navFooterLinkLine.navFooterPadItemLine.navFooterCopyright > ul > li:nth-child(3) > a";
    String careers = "Careers";
    String searchBoxLocator="twotabsearchtextbox";
    String searchButtonLocator="nav-search-submit-button";
    String productName = "hijab";

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

    public void amazonlogIn() throws IOException {
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
        //driver.findElement(By.cssSelector("*[class='GLUX_Full_Width a-declarative']")).click();
        //driver.findElement(By.cssSelector("*[id='GLUXZipInputSection']")).click();
       // driver.findElement(By.cssSelector("*[id='GLUXZipInputSection']")).sendKeys(zipCode);
        driver.findElement(By.cssSelector("*[id='GLUXZipUpdateInput']")).sendKeys(zipCode);
        driver.findElement(By.xpath(applyButton)).click();
        driver.findElement(By.xpath(doneButton)).click();
    }

    public void returnsAndOrders() throws IOException {
        amazonlogIn();
        driver.findElement(By.id(returnsAndOrdersLocator)).click();
    }

    public void primeVideoPage() throws IOException {
        amazonlogIn();
        driver.findElement(By.linkText(primeTab)).click();
    }

    public void customerServicePage() throws IOException {
        amazonlogIn();
        driver.findElement(By.linkText(customerServiceTab)).click();
    }

    public void primePage() throws IOException{
        amazonlogIn();
        driver.findElement(By.cssSelector(prime)).click();
    }

    public void bestSellersPage() throws IOException{
        amazonlogIn();
        driver.findElement(By.linkText(bestSellers)).click();
    }

    public void conditionsofUsePage() throws IOException {
        amazonlogIn();
        jscript = (JavascriptExecutor)driver;
        jscript.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        driver.findElement(By.cssSelector(conditionsOfUse)).click();
    }

    public void privacyNoticePage() throws IOException{
        amazonlogIn();
        //jscript = (JavascriptExecutor)driver;
        //jscript.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        driver.findElement(By.cssSelector(privacyNotice)).click();
    }

    public void interestBasedAds() throws IOException {
        amazonlogIn();
        driver.findElement(By.cssSelector(interestBasedAds)).click();
    }

    public void careersPage() throws IOException{
        amazonlogIn();
        driver.findElement(By.linkText(careers)).click();

    }

    public void checkSearchBox() throws IOException {
        amazonlogIn();
        driver.findElement(By.id(searchBoxLocator)).sendKeys(productName);
        driver.findElement(By.id(searchButtonLocator)).click();
    }

    //@AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
