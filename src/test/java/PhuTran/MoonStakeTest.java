package PhuTran;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MoonStakeTest extends BaseTest{
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*"); // version browse 111....
        chromeOptions.addArguments("--disable-notifications");


        driver = new ChromeDriver(chromeOptions);
    }

    @Override
    public void runTest() {
        driver.get("https://wallet.moonstake.io/sign-in");
        driver.findElement(By.id("Email")).sendKeys("phutran@blockchainlabs.asia");
        driver.findElement(By.id("AccountPassword")).sendKeys("Lourdes1985*");
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        try {
            Thread.sleep(5000); // Wait for 5 seconds for the popup to appear
            WebElement skipButton = driver.findElement(By.xpath("//button[text()='Skip for now']"));
            skipButton.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void main(){
        MoonStakeTest m = new MoonStakeTest();
        m.runTest();

    }
}
/*
public class MoonStakeTest extends BaseTest {
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*"); // version browse 111....
        chromeOptions.addArguments("--disable-notifications");


        driver = new ChromeDriver(chromeOptions);
    }


    public void runTest() {
        driver.get("https://wallet.moonstake.io/sign-in");
        driver.findElement(By.id("Email")).sendKeys("phutran@blockchainlabs.asia");
        driver.findElement(By.id("AccountPassword")).sendKeys("Lourdes1985*");


        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        try {
            Thread.sleep(5000); // Wait for 5 seconds for the popup to appear
            WebElement skipButton = driver.findElement(By.xpath("//button[text()='Skip for now']"));
            skipButton.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        MoonStakeTest test = new MoonStakeTest();
        test.executeTest();
    }
}

*/
