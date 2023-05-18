package PhuTran;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AccessYoutube extends SetupChrome {
    public void accessYoutube() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();

        // Perform additional actions on YouTube page using the 'driver' instance
        // ...

        driver.quit();
    }
}
