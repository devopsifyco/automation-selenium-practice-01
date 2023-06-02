package demowebshop_Tests;

import base.BaseTests;
import demowebshop_pages.HomePage;
import demowebshop_pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_003 extends BaseTests {
    TC001 x = new TC001();
    String expectedTitle = "Demo Web Shop. Shopping Cart";
    @Test
    public void VerifyToShoppingCartPage() throws Exception {
        x.verifyToHomePageSuccessfully();
        page.getInstance(HomePage.class).navigateToShoppingCartPage();
        String actualTitle = page.getInstance(ShoppingCartPage.class).getShoppingCartPageTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
