import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HandleCheckbox {
    public void checkboxes(WebDriver driver){
        //checkbox.html");

        // 1) Select specific check box
        driver.findElement(By.xpath("//input[@id='monday']")).click();

        // 2) select all the checkboxes
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
        System.out.println("Number of checkbox - "+  checkboxes.size());

        //3. Using for...each loop to check Monday and Friday; uncheck Tuesday
        for(WebElement checkbox:checkboxes)
        {
            String  checkboxname = checkbox.getAttribute("id");
            if (!(checkbox.isSelected()) & (checkbox.isEnabled())){
                if(checkboxname.equals("monday") || checkboxname.equals("friday") )
                {
                    checkbox.click();
                    System.out.println( "checked on " + checkboxname);
                }
            }
            else if(checkboxname.equals("tuesday") & (checkbox.isSelected())){
                checkbox.click();
                System.out.println("unchecked on "+ checkboxname);
            }
        }
    }
}
