package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class NodooSignin extends BaseTest{

    @Test
    public void NodooSignin(){
        ChromeOptions chromeOptions = new ChromeOptions();//khoi tao doi tuong chrome option de dinh cau hih cac tuy chon cua trinh duyet
        chromeOptions.addArguments("--remote-allow-origins=*"); //version browse 111....
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);//khoi tao doi tong chrome driver de co the thao tac tren trinh duyet
        driver.manage().window().maximize();
        driver.get("https://node-web.chainservices.info/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement Singin = wait.until(webDriver -> driver.findElement(By.cssSelector(".btn-sign-in")));
        Singin.click();

        WebElement Emailtext = driver.findElement(By.xpath("(//input[@placeholder='Enter your email'])[5]"));
        Emailtext.sendKeys("consiu86+222@gmail.com");
        WebElement Password = driver.findElement(By.xpath("(//input[@type='password'])"));
        Password.sendKeys("Lourdes1985*");
        WebElement ButtonSignin = driver.findElement(By.xpath("(//button[@type='submit'])"));
        ButtonSignin.click();

        WebElement errormessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-content")));
        String expectedresult = "We couldn’t find an account matching the username and password you entered. Please check your username and password and try again.";
        String actualresult = errormessage.getText();
        Assert.assertEquals(actualresult, expectedresult);
        /*WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-content")));
        String expectedErrorMessage = "We couldn’t find an account matching the username and password you entered. Please check your username and password and try again.";
        String actualErrorMessage = errorMessage.getText().trim();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);*/
    }

}
