package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{

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
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            //Wait for element to be appeared
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

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
    public void clickElement(By locator) {
        WebElement e = getElement(locator);
        if (e.isDisplayed() && e.isEnabled()){
            e.click();
        }else {
            System.out.println("Not allow clickable");
        }
    }
}
