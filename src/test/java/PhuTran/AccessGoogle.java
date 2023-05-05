package PhuTran;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AccessGoogle {
    @Test
    public void AccessGoogle(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*"); //version browse 111....
        chromeOptions.addArguments("--disable-notifications");
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.get("https://www.google.com.vn/imghp?hl=en&authuser=0&ogbl");
        chromeDriver.manage().window().maximize();
    }
}
