package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Google extends BaseTest{

    @Test
    public void navGoogle1(){
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(),"Google");
    }

    @Parameters("Search")
    @Test
    public void search(String sSearch){
        WebElement eSearch = driver.findElement(By.name("q"));
        eSearch.sendKeys(sSearch);
        eSearch.sendKeys(Keys.ENTER);
        System.out.println("test search");
        /*Assert.assertEquals(driver.getTitle(),"Google");*/
    }
}
