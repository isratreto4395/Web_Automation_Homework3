package tDBank.investingandwealth;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvestingAndWealthPageTest extends InvestingAndWealthpage {



    @Test
    public void investingAndWealthIndividualAndFamiliesAccoutTest() throws InterruptedException {
        investingAndWealthIndividualAndFamiliesAccout();
        String expectedText = "Individual & Family Private Wealth & Investment Management | TD Wealth";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Text did not match");

    }

    @Test
    public void investmentAndManagementLinkTest() throws InterruptedException {
        investmentManagementLink();
        String expectedText = "Private Investment Management & Financial Advisors | TD Wealth";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Text did not match");

    }

    @Test
    public void investmentOurProcessTest() throws InterruptedException {
        investmentOurProcess();
        String expectedText = "Private Investment Management & Financial Advisors | TD Wealth";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Text did not match");

    }

}
