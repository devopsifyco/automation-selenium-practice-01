package demowebshop_pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By header = By.tagName("h1");
    private final By tbxEmail = By.id("Email");
    private final By tbxPassword = By.id("Password");
    private final By btnLogin = By.className("button-1 login-button");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getLoginPageTitle(){
        return getPageTitle();
    }

    public void login(String sEmail, String sPassword)
    {
        enter(tbxEmail, sEmail);
        enter(tbxPassword, sPassword);
        clickElement(btnLogin);
    }
}
