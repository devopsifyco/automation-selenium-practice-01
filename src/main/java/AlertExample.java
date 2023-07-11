import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class AlertExample {
    public static void main (String[] args){


        WebDriver driver;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*"); //version browse 111....
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);


        driver.get("D:\\Devopsify\\automation-selenium-practice-01\\HTML-example\\alert-example.html");

        driver.findElement(By.name("alert")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.name("confirm")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();


        driver.findElement(By.name("prompt")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().sendKeys("testing");
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_TAB);
            r.keyRelease(KeyEvent.VK_TAB);
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
   //     driver.switchTo().alert().accept();

    }
}
