import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class HandleDatepicker {
    public static void handleDatePicker(WebDriver driver) {

        String year = "2022";
        String month = "May";
        String dateFrom = "25";
        String dateTo = "26";
        if (Integer.parseInt(dateTo) < Integer.parseInt(dateFrom)) {
            System.out.println("dateto < Datefrom");
        } else {
            driver.get("D:\\Devopsify\\automation-selenium-practice-01\\HTML-example\\datepickerExample.html");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //Open datepicker of Date from
            driver.findElement(By.name("from")).click();

            //select tag
            Select datepickerFrom_month = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
            datepickerFrom_month.selectByVisibleText(month);

            Select datepickerFrom_year = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
            datepickerFrom_year.selectByVisibleText(year);

            //table get day
            List<WebElement> allDatesFrom = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

            for (WebElement ele : allDatesFrom) {
                if (ele.isEnabled() && ele.isDisplayed() && dateFrom.equalsIgnoreCase(ele.getText())) {
                    ele.click();
                    break;
                }
            }

            //Open datepicker of Date to
            driver.findElement(By.name("to")).click();

            Select datepickerTo_month = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
            datepickerTo_month.selectByVisibleText(month);

            Select datepickerTo_year = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
            datepickerTo_year.selectByVisibleText(year);

            List<WebElement> allDatesTo = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

            for (WebElement ele : allDatesTo) {
                // System.out.println(ele.isEnabled());

                if (dateTo.equalsIgnoreCase(ele.getText())) {
                    System.out.println(ele.getText());
                    System.out.println("attribute " + ele.getAttribute("class"));
                    /*
                    String[] s = ele.getAttribute("class").split(" ");

                    System.out.println(s[2]);
                    if ("ui-state-disabled".equals(s[2])) {
                        System.out.println(" it is disable");
                    }*/

                    ele.click();
                    break;
                }
            }

     /*   Select dropdownlist = new Select(driver.findElement(By.id("formatdate")));
        dropdownlist.selectByVisibleText("Short - d M, y");


        // Using JavascriptExecutor to get value
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object dateFromResult = js.executeScript("return document.getElementById('from').value;");
        Object dateToResult =js.executeScript("return document.getElementById('to').value;");

        System.out.println("Date from = " + dateFromResult );
        System.out.println("Date to = " +dateToResult);

        System.out.println("get attribute : " + driver.findElement(By.name("from")).getAttribute("baseURI"));

        if (dateFromResult.equals("25 May, 22") & dateToResult.equals("30 May, 22")){
            System.out.println("Test case run pass");
        }else{
            System.out.println("Test case run fail");
        }*/
        }
    }
}
