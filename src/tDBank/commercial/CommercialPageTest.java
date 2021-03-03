package tDBank.commercial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CommercialPageTest extends CommercialPage {

    @Test
    public void commercialAssetBasedLendingTest() throws InterruptedException {
        commercialAssetBasedLending();
        String expectedText = "TD Asset Based Lending & Secured Loans For Retail, Manufacturing & More";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText, "Text did not match");

    }
}
