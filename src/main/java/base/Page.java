package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Page{
    //IMPORTANCE
    protected WebDriver driver;
    WebDriverWait wait;

    //Contructor: khoi tao de chúng dc sử dụng xuyên suốt lớp Page
    public Page(WebDriver driver){
       this.driver = driver;
       this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15)); //explixit wait
    }

    //non-abstract method
    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) throws Exception {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);

        }catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    //abstract methods
    public abstract String getPageTitle();
    public abstract String getPageHeader(By locator,String att);
    public abstract WebElement getElement(By locator);
    public abstract void clickElement(By locator);
    public abstract void enter(By locator, String text);
    public abstract String getValue(By locator);
}
