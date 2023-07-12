import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class JavaScriptExecutorExample {
    public static void main (String[] args){
        WebDriver driver;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*"); //version browse 111....
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);

        driver.get("D:/Devopsify/automation-selenium-practice-01/HTML-example/registration-form.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement e = driver.findElement(By.name("firstname"));
        WebElement formatdate = driver.findElement(By.id("formatdate"));

        WebElement date= driver.findElement(By.id("from_filter"));
        e.sendKeys("Huyen Testing");

        try {
            Thread.sleep(3000);
            Select Formatlistbox=  new Select(formatdate);
            List<WebElement> optionElementLists = Formatlistbox.getOptions();



            for(WebElement ele:optionElementLists){
                System.out.println(ele.getText() + " - value "+ ele.getAttribute("value"));
            }
            Formatlistbox.selectByValue("d M, y");
            Thread.sleep(3000);
            Formatlistbox.selectByIndex(1);
            Thread.sleep(3000);
            Formatlistbox.selectByVisibleText("ISO 8601 - yy-mm-dd");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }




      //  js.executeScript("document.getElementByID('from_filter').value='07/12/2023';");
       // js.executeScript("document.getElementByName('lastname').innerText='Huyen Testing 2';");
        /*Actions a = new Actions(driver);
        a.moveToElement(date)
                .click()
                .perform();
       // js.executeScript("document.getElementById('from_filter').click();");
        js.executeScript("arguments[0].click();", date);*/

      //  String innerText = js.executeScript(" return document.documentElement.innerText;").toString();
     //   System.out.println(innerText);

       // js.executeScript("alert('Welcome To devopsify - Automation Test');");
        /*js.executeScript("window.location = 'https://devopsify.co/'");
        String h = js.executeScript("return window.innerHeight;").toString();
        String w = js.executeScript( "return window.innerWidth;").toString();
        System.out.println( "h =  " + h );
        System.out.println( "w =  " + w );
        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
      //  js.executeScript("window.scrollBy(document.body.scrollWidth,0)");
        js.executeScript("document.body.style.zoom = '150%'");*/
    }
}
