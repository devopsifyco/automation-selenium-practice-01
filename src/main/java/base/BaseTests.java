package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ReadPropertiesFile;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class BaseTests {
    WebDriver driver;
    protected static Page page;
    private String sbrowser,sURL, sEnv, sPwd;


   //Parameters("browser")
    @BeforeClass
    public void setUp() throws IOException {
/*  READ CONFIG.PROPERTIES FILE */
        System.out.println("start");
        String path = System.getProperty("user.dir")+"/src/main/resources/propertyfiles/config.properties";
        FileInputStream sConfigFile = new FileInputStream(path);
        ReadPropertiesFile r = new ReadPropertiesFile(sConfigFile);

        sbrowser =  r.readPropertiesValue("browser");

        sURL = r.readPropertiesValue("url"); //"https://demowebshop.tricentis.com/
        sEnv = r.readPropertiesValue("env");
        sPwd = r.readPropertiesValue("password");
/*end*/

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

            driver.get(sURL);

            // Create object page with driver
            page = new BasePage(driver);
            System.out.println(r.decodeString(sPwd));

        }
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            page.takeFullScreenshot();
        }
    }

    @AfterClass
    public void tearDownClass(){
   //     driver.close();
        System.out.println("tear down class");
    }

    @AfterSuite
    public void tearDown(){
     //   driver.quit();
        System.out.println("tear down");
    }
}
