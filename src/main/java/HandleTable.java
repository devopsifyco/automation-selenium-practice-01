import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HandleTable {
    public void handleWebTablePagination(WebDriver driver){
        driver.get("https://demo.opencart.com/admin/index.php?route=marketplace/modification");

        //Login
        WebElement username=driver.findElement(By.id("input-username"));
        username.clear();
        username.sendKeys("demo");

        WebElement password=driver.findElement(By.id("input-password"));
        password.clear();
        password.sendKeys("demo");

        driver.findElement(By.xpath("//button[text()=' Login']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Sales-->Orders
        driver.findElement(By.xpath("//li[@id='menu-sale']//a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();

        driver.findElement(By.xpath("//ul[@class='collapse show']//a")).click();
        //driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();

        /*
         * * 1. Get total page
         * *
         * * */
        //Total Pages
        String text=driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
        System.out.println(text); //Showing 1 to 20 of 8511 (426 Pages)

        int total_pages = Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
        System.out.println(total_pages);
        int page = 1;
        do {
            WebElement active_Page=driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
            System.out.println("active page:"+ active_Page.getText());
            page++;
            int rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
            System.out.println("rows = "+ rows);
            WebElement orderIDEle, nextPageEle;
            String orderID;
            for(int r =1; r<=rows ;r++){
                String xpathrow = "//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/";
                System.out.println(xpathrow);
                try {
                    orderID = driver.findElement(By.xpath(xpathrow+"td[2]")).getText();
                }catch (StaleElementReferenceException e){
                    orderIDEle =  driver.findElement(By.xpath(xpathrow+"td[2]"));
                    orderID = orderIDEle.getText();
                }
                System.out.println(orderID);
                /*

                    String customerName = driver.findElement(By.xpath(xpathrow+"td[3]")).getText();
                    String status = driver.findElement(By.xpath(xpathrow+"td[4]")).getText();
                    System.out.println(orderID+"  "+customerName+"  "+status);*/
                /*if(status.equals("Pending")) // printing only pending orders
                {
                    System.out.println(orderID+"  "+customerName+"  "+status);
                }*/
            }
            String nextPage = "//ul[@class='pagination']//li//a[text()='"+ page +"']";
            /*String pageno=Integer.toString(p+1);
            String xpath = "//ul[@class='pagination']//li//a[text()='"+pageno+"']";*/
            System.out.println(page + " - xpath = "+ nextPage);
            driver.findElement(By.xpath(nextPage)).click();
            try {
                driver.findElement(By.xpath(nextPage)).click();
            }catch (StaleElementReferenceException e){
                nextPageEle =  driver.findElement(By.xpath(nextPage));
                nextPageEle.click();
            }
        }while (page< total_pages);
    }
}
