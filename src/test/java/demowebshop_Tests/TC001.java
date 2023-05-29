package demowebshop_Tests;

import base.BaseTests;
import demowebshop_pages.HomePage;
import demowebshop_pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

//TC001: Register new account successfully
public class TC001 extends BaseTests {

    String expTitleHomePage ="Demo Web Shop";
    String expTitleRegisterPage ="Demo Web Shop. Register";
    String expRegisterSuccMessage= "Your registration completed";

    String expValidationError = "The specified email already exists";
    RegisterPage registerPage;

    @Test(priority = 1)
    public void verifyToHomePageSuccessfully() throws Exception {
        String actualTitle = page.getInstance(HomePage.class).getHomePageTitle();
        Assert.assertEquals(actualTitle,expTitleHomePage);
    }
    @Test(priority = 2)
    public void verifyNavigateToRegisterPageSuccessfully() throws Exception {
        registerPage = page.getInstance(HomePage.class).navigateToRegisterPage();
        Assert.assertEquals(registerPage.getRegisterPageTitle(),expTitleRegisterPage);
    }
   /*  @Test(priority = 3)
    public void verifyToRegisterNewAccount() {
        registerPage.registerInfor("Phu","Tran","consiu862@gmail.com","123@QWa4");
        Assert.assertEquals(registerPage.getValidationSuccMessage(), expRegisterSuccMessage);
    }*/

    @Test(priority = 4)
    public void verifyToRegisterExistingAccout() {
        registerPage.registerInfor("Huyen","Tran","consiu862@gmail.com","123@QWa4");
        Assert.assertEquals(registerPage.getValiationError(), expValidationError);
    }

}
