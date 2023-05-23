package PhuTran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GooglePage extends SetupChrome {
    /*@BeforeMethod*/
    @Test (priority = 1)
    public void AccessGoogle (){
        setup();
        driver.get("https://www.google.com.vn/");
        driver.manage().window().maximize();
    }
    /*@AfterMethod
    public void tearDown(){
        driver.quit();
    }*/
    @Test (priority = 2)
    @Parameters ({"keyword"})
    public void SearchDog (String keyword){
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys(keyword);
        /*earchbox.submit();*/
    }
    @Test (priority = 3)
    public void GotoGmail (){
        WebElement gmail = driver.findElement(By.linkText("Gmail"));
        gmail.click();
    }
}
