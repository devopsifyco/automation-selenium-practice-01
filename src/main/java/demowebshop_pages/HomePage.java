package demowebshop_pages;


import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class HomePage extends BasePage {
    //NO WRITE - only READ
    //Page objects
    private final By logo = By.xpath("//*[@class= 'header-logo']//a/img");
    private final By lnkAll = By.className("header-links-wrapper");
    private final By lnkRegister = By.linkText("Register");//khai báo biến instant lnkRegister kiều By
    //biền này lưu trữ locator cho Register trên web, khai báo nó trong lớp homepage nên nó cho phép
    //các phương thức trong lớp này dễ dàng lương tác với element Register
    private final By lnklogin = By.linkText("Log in");

    private final By lnkShoppingCart = By.xpath("//li[@id='topcartlink']//a/span[1]");
    private final By quantityShoppingCart = By.xpath("//li[@id='topcartlink']//a/span[2]");
    private final By lnkWishList = By.xpath("//a[@class='ico-wishlist']/span[1]");
    private final By quantityWishList = By.className("wishlist-qty");

    public HomePage(WebDriver driver) { //constructor, gọi hàm của lớp cha-Basepage
        super(driver);//để chắc rằng biến driver trong lớp Basepage cho parameter driver này
    }

    public WebElement getRegisterLink()
    {
        return getElement(lnkRegister);
    }
    //Hàm này để đi đến trang register trên web nè
    public RegisterPage navigateToRegisterPage() throws Exception {


      // takeWebElementScreenshot(getElement(lnkRegister));
        clickElement(lnkRegister);
        return getInstance(RegisterPage.class);
    }

    public LoginPage navigateToLoginPage() throws Exception {
        clickElement(lnklogin);
        return getInstance(LoginPage.class);
    }

    public ShoppingCartPage navigateToShoppingCartPage() throws Exception {
        /* Takescreenshot for logo and all links*/

       // takeWebElementScreenshot(getElement(lnkAll));

        //System.out.println("screenshot element");
        LOGGER.log(Level.INFO,"screenshot element");
        clickElement(lnkShoppingCart);
        return getInstance(ShoppingCartPage.class);
    }

    public WishListPage navigateToWishlistPage() throws Exception {
        clickElement(lnkWishList);
        return getInstance(WishListPage.class);
    }

    public String getHomePageTitle() throws IOException {
      //  takeWebElementScreenshot(getElement(logo));
        return getPageTitle();
    }

}
