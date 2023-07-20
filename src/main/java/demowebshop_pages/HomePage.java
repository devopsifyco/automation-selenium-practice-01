package demowebshop_pages;


import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
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

    private final By searchfield = By.id("small-searchterms");


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
    public void enterDateTo(String dateto, String DateFrom){
        selectDate(lnkRegister, lnkRegister, lnkRegister, DateFrom);
        selectDate(lnkRegister, lnkRegister, lnkRegister, dateto);

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

    public SearchPage searchtext(String searchValue1, String searchValue2){
        //enter(searchfield,searchValue);
        actionSearch(searchfield,searchValue1);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Press Arrow Down to select "14.1-inch Laptop" -> Delete text -> Enter "Computing and Internet" -> Press ENTER key
        Actions a = new Actions(driver);
        System.out.println(searchValue2);
        a.moveToElement(getElement(searchfield))
                .click()
                .keyDown(Keys.ARROW_DOWN)
                .keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.DELETE)
                .keyUp(Keys.DELETE)
                .sendKeys(searchValue2)
                .pause(Duration.ofSeconds(10))
                .sendKeys(Keys.ENTER)
                .perform();

        return getInstance(SearchPage.class);
    }

    public String getHomePageTitle() throws IOException {
      //  takeWebElementScreenshot(getElement(logo));
        return getPageTitle();
    }

}
