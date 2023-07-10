package demowebshop_Tests;

import base.BaseTests;
import demowebshop_pages.HomePage;
import demowebshop_pages.RegisterPage;
import demowebshop_pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

//TC001: Register new account successfully
public class TC001_Seach extends BaseTests {

    String expTitleHomePage ="Demo Web Shop";
    String expTitleSearchPage = "Demo Web Shop. Search";
    String expTitleRegisterPage ="Demo Web Shop. Register";
    String expRegisterSuccMessage= "Your registration completed";
    String expValidationError = "The specified email already exists";
    String searchValue = "Computing and Internet";
    RegisterPage registerPage;
    SearchPage searchPage;

    @Test(priority = 1)
    public void verifyToHomePageSuccessfully() throws Exception {
        String actualTitle = page.getInstance(HomePage.class).getHomePageTitle();
        //Take screenshot
        //page.takeFullScreenshot();
        Assert.assertEquals(actualTitle,expTitleHomePage);
    }

    /* Action on Search : Search "laptop" -> Press Arrow Down to select "14.1-inch Laptop" -> Delete text -> Enter "Computing and Internet" -> Press ENTER key
    1 - Xac Dinh Element Search    -> HomePage class
    2 - Action class (condition: Driver, Element)  -> Common / Action method of HomePage
    3 - Get Title of search page , get search value on search page => create new SearchPage class  Done
    4 - Write Test case - TC01
    * */
    @Test(priority = 2)
    public void search() throws Exception {

        //Search "laptop" -> Press Arrow Down to select "14.1-inch Laptop" -> Delete text -> Enter "Computing and Internet" -> Press ENTER key
        searchPage =  page.getInstance(HomePage.class).searchtext("Laptop",searchValue);
       // searchPage = page.getInstance(HomePage.class).search();


        //Step  verify Expected Ressult = Actual Result
        Assert.assertEquals(searchPage.getSearchPageTitle(),expTitleSearchPage);
        Assert.assertEquals(searchPage.getSearchValue(),searchValue);
        //Assert.assertEquals(registerPage.getRegisterPageTitle(),expTitleRegisterPage);
    }

}
