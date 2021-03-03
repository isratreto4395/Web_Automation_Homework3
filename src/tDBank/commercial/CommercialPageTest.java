package tDBank.commercial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CommercialPageTest extends CommercialPage {

    @Test
    public void commercialTabTest() throws InterruptedException {
        commercialPageTab();
        String expectedText = "TD Asset Based Lending & Secured Loans For Retail, Manufacturing & More";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText, "Text did not match");

    }
}
