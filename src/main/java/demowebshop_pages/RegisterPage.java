package demowebshop_pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    //Page objects
    private final By header = By.tagName("h1");
    private final By cbxMale = By.id("gender-male");
    private final By cbxFeMale = By.id("gender-female");
    private final By txtFirstName = By.id("FirstName");
    private final By txtLastName = By.id("LastName");
    private final By txtEmail = By.id("Email");
    private final By txtPassword = By.id("Password");
    private final By txtConfirmPassword = By.id("ConfirmPassword");
    private final By btnSubmit = By.id("register-button");

    private final By validateError= By.xpath("//*[@class='validation-summary-errors']//ul/li");
    private final By validateSucc = By.className("result");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public String getRegisterPageTitle(){
        return getPageTitle();
    }

    public void registerInfor(String sFirstName, String sLastName, String sMail, String sPwd){
        clickElement(cbxMale);
        enter(txtFirstName,sFirstName);
        enter(txtLastName,sLastName);
        enter(txtEmail,sMail);
        enter(txtPassword, sPwd);
        enter(txtConfirmPassword, sPwd);
        clickElement(btnSubmit);
    }
    public String getValiationError(){
        return getValue(validateError);
    }

    public String getValidationSuccMessage(){
        return getValue(validateSucc);
    }


}
