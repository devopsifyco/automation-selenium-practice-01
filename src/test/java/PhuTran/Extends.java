package PhuTran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Extends {
    private WebDriver driver; // Declare the driver variable at the class level

    @BeforeClass
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void Compare() {
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

    @AfterClass
    public void tearDown() {
        driver.quit(); // Close the browser after the test is finished
    }

    private static void assertEquals(String expectedValue, String actualValue) {
        // Implement your assertion logic here
    }

    public void search(String searchKey) {
        // Find the search box and enter the search key (in this case, "dog")
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchKey);

        // Submit the search
        searchBox.submit();
    }
}
