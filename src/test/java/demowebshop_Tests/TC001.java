/*
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

    @Test(priority = 1)
    public void verifyToHomePageSuccessfully() throws Exception {
        String actualTitle = page.getInstance(HomePage.class).getHomePageTitle();
        Assert.assertEquals(actualTitle,expTitleHomePage);
    }
    @Test(priority = 2)
    public void verifyToRegisterPageSuccessfully() throws Exception {
        RegisterPage registerPage = page.getInstance(HomePage.class).navigateToPage();
        Assert.assertEquals(registerPage.getRegisterPageTitle(),expTitleRegisterPage);
    }
}
*/
