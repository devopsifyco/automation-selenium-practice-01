import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TooltipExample {
    public static void main (String[] args){
        //get keycode
      /*  for(int i = 0; i < 1000000; ++i) {
            String text = java.awt.event.KeyEvent.getKeyText(i);
            if(!text.contains("Unknown keyCode: "))
            {
                System.out.println("" + i + " -- " + text);
            }
        }*/

        WebDriver driver;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*"); //version browse 111....
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);

        /*driver.get("D:\\Devopsify\\automation-selenium-practice-01\\HTML-example\\tooltip-bootstrap-example.html");
        WebElement e = driver.findElement(By.xpath("//*[@data-placement='left']"));
        System.out.println("Tooltip is "+ e.getAttribute("title"));*/


        driver.get("file:///D:/Devopsify/automation-selenium-practice-01/HTML-example/tooltip-example.html");

        WebElement etooltip = driver.findElement(By.className("tooltip"));


        Actions action = new Actions(driver);
        action.moveToElement(etooltip).perform();

        WebElement e = driver.findElement(By.className("tooltiptext"));
        System.out.println("using action => Tooltip is  "+ e.getText());

/*
        WebElement e = driver.findElement(By.className("tooltiptext"));
        System.out.println("Tooltip is "+ e.getText());  //""
        System.out.println("Tooltip is "+ e.getAttribute("textContent")); //Display tooltip */
    }
}
