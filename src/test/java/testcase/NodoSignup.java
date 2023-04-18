package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class NodoSignup {

    @Test
    public void testNodoSignup() {
        ChromeOptions chromeoption = new ChromeOptions();
        chromeoption.addArguments("--remote-allow-origins=*"); //version browse 111....
        chromeoption.addArguments("--disable-notifications");

        ChromeDriver driver = new ChromeDriver(chromeoption);
        driver.get("https://node-web.chainservices.info/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement Signup = wait.until(webDriver -> driver.findElement(By.className("btn-sign-up")));
        Signup.click();

        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='ant-input'])[5]")));
        Email.sendKeys("consiu86+2@gmail.com");
        WebElement Submit = driver.findElement(By.xpath("(//button[@type='submit'])"));
        Submit.click();

    }
}
