package amazon.primevideoPage;

import amazon.homepage.AmazonHomepage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PrimeVideo extends AmazonHomepage {
    WebDriver driver;
    JavascriptExecutor jscript;

    public void amazonOriginals() throws IOException, InterruptedException {
        primeVideoPage();
    }


}
