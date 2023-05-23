package PhuTran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GithubPage extends GooglePage{
    @Test
    public void accesspage(){
        setup();
        driver.get("https://github.com/devopsifyco/automation-selenium-practice-01");
    }
}
