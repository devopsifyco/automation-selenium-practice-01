package demowebshop_Tests;

import base.BaseTests;
import demowebshop_pages.HomePage;
import demowebshop_pages.WishListPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TC004_Wishlist extends BaseTests {

    TC001 tc001 = new TC001();

    @Parameters({"expTitleWishListPage"})
    @Test(priority = 1)
    public void verifyNavigateToShoppingCartPageSuccessfully(String expTitle) throws Exception {
        tc001.verifyToHomePageSuccessfully();
        page.getInstance(HomePage.class).navigateToWishlistPage();
        Assert.assertEquals(page.getInstance(WishListPage.class).getWishListPageTitle(),expTitle);
    }

    @Test(priority = 2)
    public void verifyWishList() throws Exception {
        String txtHeader = page.getInstance(WishListPage.class).getHeader();
        String txtContent = page.getInstance(WishListPage.class).getContent();

        Boolean b=false;
        if( txtHeader.equals("Wishlist") && txtContent.equals("The wishlist is empty!") ){
            b=true;
        } else{
            b = false;
        }
        Assert.assertTrue(b);
    }

}
