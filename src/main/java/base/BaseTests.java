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
import org.testng.Reporter; //testNG report
import org.testng.annotations.*;
import utils.ReadPropertiesFile;


import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTests {
    protected static final Logger LOGGER = Logger.getLogger(BaseTests.class.getName());
    static {
        LOGGER.setLevel(Level.OFF);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        LOGGER.addHandler(consoleHandler);
    }
    WebDriver driver;
    protected static Page page;
    private String sbrowser,sURL, sEnv, sPwd;

    @DataProvider (name ="accountlist")
    public Object[][] userData(){
        return new Object[][] {{"Phu","Tran","consiu123@gmail.com","123@QWa4"},{"Ngo","Tran","ngo123@gmail.com","123@QWa4"}, {"huyen","Tran","huyen23@gmail.com","123@QWa4"}};
    }

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) throws IOException {
/*  READ CONFIG.PROPERTIES FILE */
        //System.out.println("start");

        String path = System.getProperty("user.dir")+"/src/main/resources/property-files/config.properties";
        FileInputStream sConfigFile = new FileInputStream(path);
        ReadPropertiesFile r = new ReadPropertiesFile(sConfigFile);

      //  sbrowser =  r.readPropertiesValue("browser");
        sbrowser = browser; //from parameter TestNG

        sURL = r.readPropertiesValue("url"); //"https://demowebshop.tricentis.com/
        sEnv = r.readPropertiesValue("env");
        sPwd = r.readPropertiesValue("password");
/*end*/
        LOGGER.info("Start launching browser "+ sbrowser);
        switch (sbrowser.toLowerCase()) {
            case "safari":
                SafariOptions safariOptions = new SafariOptions();
                driver = new SafariDriver(safariOptions);
                break;
            case "firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
            case "edge": {
                // System.setProperty("webdriver.edge.driver", path + "msedgedriver.exe");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");
                // For use with EdgeDriver:
                driver = new EdgeDriver(edgeOptions);
                break;
            }
          /*  case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*"); //version browse 111....
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);

            }*/

            default: {
               // LOGGER.warning("Browser is not correct name");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*"); //version browse 111....
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
            }

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ZERO);
            Reporter.log("Launching browser and navigate to page "+ sURL); ////log to Test report
            driver.get(sURL);

            // Create object page with driver
            page = new BasePage(driver);
            //System.out.println(r.decodeString(sPwd));
            LOGGER.log(Level.CONFIG,"Password is " + r.decodeString(sPwd));

        }
    }

   @AfterMethod
    public String takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String pathDesFile =  ("/target/screenshots/"+testResult.getName()+ formater.format(calendar.getTime())+".png" );
       // String pathFile = null;
        if (testResult.getStatus() == ITestResult.FAILURE) {
            page.takeFullScreenshot(pathDesFile);
        }
        return pathDesFile;
    }

    @AfterClass
    public void tearDownClass(){
      //   driver.close();
        /*System.out.println("tear down class");*/
        Reporter.log("The driver has been closed.", true);
    }

    @AfterSuite
    public void tearDown(){
   //      driver.quit();
        /*System.out.println("tear down");*/
        Reporter.log("The drivers has been closed all.", true);

    }
}
