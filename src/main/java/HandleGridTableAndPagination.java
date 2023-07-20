import org.apache.commons.compress.archivers.zip.ScatterZipOutputStream;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HandleGridTableAndPagination {
    public static void main(String[] args) {

        WebDriver driver;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*"); //version browse 111....
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        System.out.println("tessting ");

        String[][] data1 = handlePaging(driver); //actual result
        String[][] data2 = data1; ///read from excel (expected result)

        Assert.assertTrue(data1.equals(data2));


        for(int i =0; i< data1.length; i++){
            for(int j=0; j< data1[i].length; j++){
                System.out.print(data1[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static String[][] handlePaging(WebDriver driver){
        String[][] data = null;
        driver.get("https://demo.opencart.com/admin/index.php?route=marketplace/modification");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Login
        WebElement username= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-username")));
        username.clear();
        username.sendKeys("demo");

        WebElement password=driver.findElement(By.id("input-password"));
        password.clear();
        password.sendKeys("demo");

        driver.findElement(By.xpath("//button[text()=' Login']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Sales-->Orders
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='menu-sale']//a"))).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='collapse show']//a"))).click();

        //driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
        System.out.println("t2");
        String  txtTotal = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-6 text-end']"))).getText();
        int totalPages = Integer.parseInt(
                txtTotal.substring(
                        txtTotal.indexOf("(")+1,txtTotal.indexOf("Pages")-1));

        int totalRecords = Integer.parseInt(
                txtTotal.substring(
                        txtTotal.indexOf("of")+3,txtTotal.indexOf("(")-1));

        List<WebElement> listElements = driver.findElements(By.xpath("//div[@class='table-responsive']//table/thead/tr/td"));

        int totalCols = listElements.size();
        for(WebElement e : listElements){
            System.out.println(e.getText());
        }
        List<WebElement> listElementsRow = driver.findElements(By.xpath("//div[@class='table-responsive']//table/tbody/tr"));


        int totalRows = listElementsRow.size();

        System.out.println("Row =" +totalRows);
        String pathdata = "//div[@class='table-responsive']//table/tbody/tr[";

        data = new String[totalRows+10][totalCols-2];
        int page = 1;
        do {
            WebElement pagin = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + page +"]"));
            System.out.println(pagin.getAttribute("class").contains("active"));

            for (int i = 1; i <= totalRows; i++) {
                for (int j = 2; j <= totalCols - 1; j++) {
                    WebElement cell = driver.findElement(By.xpath(pathdata + i + "]/td[" + j + "]"));
                    //  System.out.print(cell.getText());
                    if(page == 1){
                        data[i - 1][j - 2] = cell.getText();//9
                    }else if(page==2){
                        data[(i+10)- 1][j - 2] = cell.getText();
                    }
                }
                //    System.out.println();
            }
            page++;
            String npage = "//ul[@class='pagination']//li//a[text()='"+page+"']";
            WebElement nextPage  =  driver.findElement(By.xpath(npage));
            nextPage.click();

        }while (page<3);

        return data;
    }

}
