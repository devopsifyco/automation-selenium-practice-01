package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage extends Page{
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public WebElement getElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (Exception e){
            System.out.println(locator.toString() + e);
        }
        return null;
    }

    @Override
    public String getPageHeader(By locator) {

        return getElement(locator).getAttribute("alt");
    }
    @Override
    public void enter(By locator, String text) {
        WebElement e =getElement(locator);
        if (e.isDisplayed() && e.isEnabled()){
            e.sendKeys(text);
        }else {
            System.out.println("Not allow editable");
        }
    }

    @Override
    public void click(By locator) {
        WebElement e =getElement(locator);
        if (e.isDisplayed() && e.isEnabled()){
            e.click();
        }else {
            System.out.println("Not allow clickable");
        }
    }
}
