package cheapOair;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends HomePage {

    @Test
    public void testPageTitle(){
        String expectedText = "Cheap Airline Tickets, Hotels & Car Rentals | CheapOair";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText,"Page Title not match");
    }

    @Test
    public void checkFromWhereTabTest() throws InterruptedException {
        //checkFromWhereTab();
        String expectedText = "Dhaka, Bangladesh";
        String actualText = driver.findElement(By.cssSelector("#from")).getText();
        Assert.assertEquals(actualText,expectedText,"Cannot input in the from box");

    }
}
