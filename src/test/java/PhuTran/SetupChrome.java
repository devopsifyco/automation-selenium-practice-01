package PhuTran;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SetupChrome {
    WebDriver driver;
    @Test
    public void setup (){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*"); //version browse 111....
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
    }
}
