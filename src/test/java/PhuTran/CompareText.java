package PhuTran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class CompareText {
    @Test
    public void Compare(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*"); //version browse 111....
        chromeOptions.addArguments("--disable-notifications");


        // Create a new ChromeDriver instance
        WebDriver driver = new ChromeDriver(chromeOptions);


        // Navigate to google.com.vn
        driver.get("https://www.google.com.vn");
        WebElement message = driver.findElement(By.id("SIvCob"));
        String expectedValue = "Google offered in";
        String actualValue = message.getText();
        try {
            assertEquals(expectedValue, actualValue);


            System.out.println("Expected and actual values are the same: " + actualValue);
        } catch (Exception e) {
            System.out.println("Expected and actual values are different: " + e.getMessage());
        }
    }


    private static void assertEquals(String expectedValue, String actualValue) {
    }
    public void seach (String searchkey){

    }

}


