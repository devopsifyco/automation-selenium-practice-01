package PhuTran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchDog extends SetupChrome {
    @Test
    public void searchDogKeyword() {
        setupchrome(); // Call the method from the parent class to access Google

        // Find the search box and enter the keyword "dog"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("dog");
        searchBox.submit();
    }
}
