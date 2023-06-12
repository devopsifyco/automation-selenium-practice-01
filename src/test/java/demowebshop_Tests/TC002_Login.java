package demowebshop_Tests;

import base.BaseTests;
import demowebshop_pages.HomePage;
import demowebshop_pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_Login extends BaseTests {
    String expTitleLoginPage ="Demo Web Shop. Login";
    String expTitleHomePage = "Demo Web Shop.";
   // String expRegisterSuccMessage= "Your registration completed";

  //  String expValidationError = "The specified email already exists";
    TC001 t = new TC001();
    LoginPage loginPage;

/*    @Test(priority = 1)
    public void verifyToHomePageSuccessfully() throws Exception {
        String actualTitle = page.getInstance(HomePage.class).getHomePageTitle();
        Assert.assertEquals(actualTitle,expTitleHomePage);
    }*/
    @Test(priority = 1)
    public void verifyNavigateToLoginPageSuccessfully() throws Exception {
        t.verifyToHomePageSuccessfully();
       /* String actualTitle = page.getInstance(LoginPage.class).getLoginPageTitle();
        Assert.assertEquals(actualTitle, expTitleLoginPage);*/
        loginPage = page.getInstance(HomePage.class).navigateToLoginPage();
        Assert.assertEquals(loginPage.getLoginPageTitle(),expTitleLoginPage);
    }

    @Test(priority = 2)
    public void verifyLoginSuccessfully()
    {
        //
    }

    /* @Test(priority = 4)
    public void verifyToRegisterExistingAccout() {
        registerPage.registerInfor("Huyen","Tran","consiu862@gmail.com","123@QWa4");
        Assert.assertEquals(registerPage.getValiationError(), expValidationError);
    }*/
}
