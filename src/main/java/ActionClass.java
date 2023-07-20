import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ActionClass {
    public static void actionClassExample (WebDriver driver){
        driver.get("https://devopsify.co/");

        Actions action = new Actions(driver);

        WebElement searchTxt = driver.findElement(By.className("jeg_search_input"));

        int x=  searchTxt.getLocation().getX();
        int y =  searchTxt.getLocation().getY();

        action.moveToElement(searchTxt)
                .click()
                .sendKeys("selenium locator")
                .perform();

        action.keyDown(Keys.CONTROL)
                .sendKeys("A") //Select all (CTRL+A)
                .sendKeys("C") // CTRL+C
                .keyUp(Keys.CONTROL)
                .perform();

        action.sendKeys("javascript Executor").perform();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        action.moveToElement(searchTxt)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.DELETE)
                .keyUp(Keys.DELETE)
                .keyDown(Keys.CONTROL)
                .sendKeys("V")
                .keyUp(Keys.CONTROL)
                // .keyDown(Keys.ENTER)
                .perform();

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            System.out.println("testing");
            robot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(3000);


            robot.mouseMove(x,y);
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        } catch (AWTException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

/*
        WebElement testNav = driver.findElement(By.xpath("//div[@class='jeg_mainmenu_wrap']/ul/li[3]"));
        WebElement operationNav = driver.findElement(By.xpath("//div[@class='jeg_mainmenu_wrap']/ul/li[5]"));
        action.moveToElement(operationNav)
                .pause(Duration.ofSeconds(10))
                .moveToElement(testNav)
                .perform();
*/

    /*    WebElement e = driver.findElement(By.linkText("Selenium Locator: CSS Selector"));
        e.click();*/

        // driver.quit();
    }
}
