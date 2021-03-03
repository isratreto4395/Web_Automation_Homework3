package amazon.primevideoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PrimeVideoTest extends PrimeVideo {

    @Test
    public void amazonOriginalsTest() throws IOException {
        amazonOriginals();
        String expectedText = "Watch Gemini Man | Prime Video";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText, "Text cannot be found");

    }

    @Test
    public void storeInPrimeVideoTest() throws IOException, InterruptedException {
        storeInPrimeVideo();
        String expectedText = "Amazon.com: Prime Video: Prime Video";
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText,expectedText, "Title does not match");
    }

}
