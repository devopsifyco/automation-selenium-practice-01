package demowebshop_pages;


import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
        //NO WRITE - only READ
    //Page objects
    private final By lnkRegister = By.linkText("Register");
    private final By lnklogin = By.linkText("Log in");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRegisterLink()
    {
        return getElement(lnkRegister);
    }

    public RegisterPage navigateToRegisterPage() throws Exception {
        //getElement(lnkRegister).click();
        clickElement(lnkRegister);
        return getInstance(RegisterPage.class);
    }

    public LoginPage navigateToLoginPage() throws Exception {
        clickElement(lnklogin);
        return getInstance(LoginPage.class);
    }

    public String getHomePageTitle(){
        return getPageTitle();
    }
}
