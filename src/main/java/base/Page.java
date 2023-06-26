package base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Page{
    protected static final Logger LOGGER = Logger.getLogger(Page.class.getName());

    //IMPORTANCE
    protected WebDriver driver;//nhung đứa thừa kế sẽ thấy dc driver này
    WebDriverWait wait;

    //Contructor: khoi tao de chúng dc sử dụng xuyên suốt lớp Page
        public Page(WebDriver driver){//truyển webdriver vô nên các con của nó sẽ có key super

        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15)); //explixit wait


    }

    protected Page() {
    }

    //non-abstract method
    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);

        }catch (Exception e){
            //System.out.println(e.getMessage());
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
        return null;
    }


    //abstract methods
    public abstract String getPageTitle();
    public abstract String getPageHeader(By locator,String att);
    public abstract WebElement getElement(By locator);
    public abstract List<WebElement> getLstElement(By locator);
    public abstract void clickElement(By locator);
    public abstract void enter(By locator, String text);
    public abstract String getValue(By locator);
    public abstract String getAttributeValue(WebElement e,String attribute);
    public abstract void takeFullScreenshot(String pathDesFile) throws IOException;
    public abstract void takeWebElementScreenshot(WebElement element, String pathDesFile) throws IOException;
    public abstract boolean imageComparision(WebElement ele, File expFile) throws IOException ;
}
