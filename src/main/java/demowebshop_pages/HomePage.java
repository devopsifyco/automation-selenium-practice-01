package demowebshop_pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    //Page objects
    private final By lnkRegister = By.linkText("Register");

    //title: Demo Web Shop. Register

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRegisterLink()
    {
        return getElement(lnkRegister);
    }

    public void navigateToPage(){
        //getElement(lnkRegister).click();
        clickElement(lnkRegister);
    }

    public String getHomePageTitle(){
        return getPageTitle();
    }
}
