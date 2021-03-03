package tDBank.smallbusiness;


import org.testng.Assert;
import org.testng.annotations.Test;

public class SmallBusinessPageTest extends SmallBusinessPage {
    @Test
    public void smallBuisnessCheckingAccoutTest() throws InterruptedException {
        smallBuisnessCheckingAccout();
        String expectedText = "Open A Small Business Checking Account Online | TD Bank";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText, "Text did not match");

    }


}
