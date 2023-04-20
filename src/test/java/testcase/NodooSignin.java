package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class NodooSignin {
    @Test
    public void NodooSignin(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*"); //version browse 111....
        chromeOptions.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://node-web.chainservices.info/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement Singin = wait.until(webDriver -> driver.findElement(By.cssSelector(".btn-sign-in")));
        Singin.click();

        WebElement Emailtext = driver.findElement(By.xpath("(//input[@placeholder='Enter your email'])[5]"));
        Emailtext.sendKeys("consiu86+2@gmail.com");
        WebElement Password = driver.findElement(By.xpath("(//input[@type='password'])"));
        Password.sendKeys("Lourdes1985*");
        WebElement ButtonSignin = driver.findElement(By.xpath("(//button[@type='submit'])"));
        ButtonSignin.click();
    }
}
