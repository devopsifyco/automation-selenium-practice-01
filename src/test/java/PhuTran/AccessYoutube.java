package PhuTran;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AccessYoutube {
    @Test
    public void AccessNodo(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*"); //version browse 111....
        chromeOptions.addArguments("--disable-notifications");
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.get("https://www.youtube.com/");
        chromeDriver.manage().window().maximize();
    }
}
