package demowebshop_pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    //Page objects
    private final By lnkRegister = By.linkText("Register");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRegisterLink()
    {
        return getElement(lnkRegister);
    }

    public RegisterPage navigateToPage() throws Exception {
        //getElement(lnkRegister).click();
        clickElement(lnkRegister);
        return getInstance(RegisterPage.class);
    }

    public String getHomePageTitle(){
        return getPageTitle();
    }
}
