package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String sbrowser) {
        System.out.println("start");
        switch (sbrowser.toLowerCase()) {
            case "safari":
                SafariOptions safariOptions = new SafariOptions();
                driver = new SafariDriver(safariOptions);
                break;
            case "firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-notifications");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
            case "edge": {
                // System.setProperty("webdriver.edge.driver", path + "msedgedriver.exe");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");
                // For use with EdgeDriver:
                driver = new EdgeDriver(edgeOptions);
            }

            default: {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*"); //version browse 111....
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
            }

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        }
    }

    @AfterClass
    public void tearDownClass(){
        driver.close();
        System.out.println("tear down class");
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
        System.out.println("tear down");
    }

}
