package demowebshop_pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    //Page objects
    //private final By lnkRegister = By.linkText("Register");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public String getRegisterPageTitle(){
        return getPageTitle();
    }
}
