package demowebshop_Tests;

import base.BaseTests;
import demowebshop_pages.HomePage;
import demowebshop_pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testcase.BaseTest;

public class TC003_ShoppingCart extends BaseTests {
    //private String expTitleShoppingCartPage= "Demo Web Shop. Shopping Cart";

    TC001 tc001 = new TC001();
    @Parameters({"expTitleShoppingCartPage"})
    @Test(priority = 1)
    public void verifyNavigateToShoppingCartPageSuccessfully(String expTitle) throws Exception {
        tc001.verifyToHomePageSuccessfully();
        page.getInstance(HomePage.class).navigateToShoppingCartPage();
        Assert.assertEquals(page.getInstance(ShoppingCartPage.class).getShoppingCartPageTitle(),expTitle);
    }
}
