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
    private  final By lnkShoppingCart = By.xpath("//li[@id='topcartlink']//a");


    public HomePage(WebDriver driver) { // constructor cần có 1 driver
        // cua no la Basepage
        super(driver);//thừa kế từ cha là Page
    }

    //Hàm này để đi đến trang register trên web nè
    public RegisterPage navigateToRegisterPage()//gọi phương thức này trên lớp homepage để đi đến registry
    //và cho fep tương tác vs các element trên register page
            throws Exception {
        //getElement(lnkRegister).click();
        clickElement(lnkRegister);//ham nay viet ben Basepage
        return getInstance(RegisterPage.class);//tra du lieu ve Registerpage
    }

    public LoginPage navigateToLoginPage() throws Exception {
        clickElement(lnklogin);
        return getInstance(LoginPage.class);
    }

    public ShoppingCartPage navigateToShoppingCartPage() throws Exception {
        clickElement(lnkShoppingCart);
        return getInstance(ShoppingCartPage.class);
    }
    public String getHomePageTitle(){

        return getPageTitle();
    }
}
