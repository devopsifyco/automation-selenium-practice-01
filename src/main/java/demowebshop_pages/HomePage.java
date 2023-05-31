package demowebshop_pages;


import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
        //NO WRITE - only READ
    //Page objects
    private final By lnkRegister = By.linkText("Register");//khai báo biến instant lnkRegister kiều By
    //biền này lưu trữ locator cho Register trên web, khai báo nó trong lớp homepage nên nó cho phép
    //các phương thức trong lớp này dễ dàng lương tác với element Register
    private final By lnklogin = By.linkText("Log in");


    public HomePage(WebDriver driver) { //constructor, gọi hàm của lớp cha-Basepage
        super(driver);//để chắc rằng biến driver trong lớp Basepage cho parameter driver này
    }

    public WebElement getRegisterLink()
    {
        return getElement(lnkRegister);
    }
    //Hàm này để đi đến trang register trên web nè
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
