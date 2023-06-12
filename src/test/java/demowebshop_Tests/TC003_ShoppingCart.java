package demowebshop_Tests;

import base.BaseTests;
import demowebshop_pages.HomePage;
import demowebshop_pages.ShoppingCartPage;
import demowebshop_pages.WishListPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testcase.BaseTest;

import java.util.ArrayList;

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

    @Test(priority = 2)
    public void verifyShoppingCart() throws Exception {
        String txtHeader = page.getInstance(ShoppingCartPage.class).getHeader();
        String txtContent = page.getInstance(ShoppingCartPage.class).getContent();

        Boolean b=false;
        if( txtHeader.equals("Shopping cart") && txtContent.equals("Your Shopping Cart is empty!") ){
            b=true;
        } else{
            b = false;
        }
        Assert.assertTrue(b);
    }

    @Test(priority = 3)
    public void verifyOrderProgress() throws Exception {
        ArrayList<String> sA;
        Boolean b=false;
        sA = page.getInstance(ShoppingCartPage.class).getProgress();
        for (String s: sA ){
            if (s.equals("Cart_active-step")){
                b = true;
                continue;
            }else if (s.equals("Address_inactive-step")){
                b = true;
                continue;
            }else if (s.equals("Shipping_inactive-step")){
                b = true;
                continue;
            }else if (s.equals("Payment_inactive-step")){
                b = true;
                continue;
            }else if (s.equals("Confirm_inactive-step")){
                b = true;
                continue;
            }else if (s.equals("Complete_inactive-step")){
                b = true;
                continue;
            }
            else{
                b= false;
                break;
            }
        }
        Assert.assertTrue(b);
    }

}
