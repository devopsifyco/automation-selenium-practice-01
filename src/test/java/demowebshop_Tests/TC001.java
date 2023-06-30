package demowebshop_Tests;

import base.BaseTests;
import demowebshop_pages.HomePage;
import demowebshop_pages.RegisterPage;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

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
        //Take screenshot
        //page.takeFullScreenshot();
        Assert.assertEquals(actualTitle,expTitleHomePage);
    }

    @Test(priority = 2, enabled = false)
    public void verifyNavigateToRegisterPageSuccessfully() throws Exception {
        registerPage = page.getInstance(HomePage.class).navigateToRegisterPage();
        Assert.assertEquals(registerPage.getRegisterPageTitle(),expTitleRegisterPage);
    }
/*
     @Test(priority = 3)
    public void verifyToRegisterNewAccount(String firstName, String lastName, String email, String pwd) throws Exception {
        //registerPage.registerInfor("Phu","Tran","consiu862@gmail.com","123@QWa4");
         registerPage.registerInfor(firstName, lastName, email, pwd);
        Assert.assertEquals(registerPage.getValidationSuccMessage(), expRegisterSuccMessage);

    }*/

    /*@Test(priority = 4)
    public void verifyToRegisterExistingAccout() {
        registerPage.registerInfor("Huyen","Tran","consiu862@gmail.com","123@QWa4");
        Assert.assertEquals(registerPage.getValiationError(), expValidationError);
    }*/
    @Test(priority = 3, dataProvider = "excel-data" , dataProviderDynamicClass =  "testdata.DataProviderWithExcel")
    public void verifyToRegisterMutilAccounts(String firstName, String lastName, String email, String pwd) throws Exception {
        //registerPage.registerInfor("Phu","Tran","consiu862@gmail.com","123@QWa4");
        System.out.println("firstName : " + firstName + " - " + lastName + " - " + email+ "pwd "+ pwd);
        registerPage = page.getInstance(HomePage.class).navigateToRegisterPage();
        registerPage.registerInfor(firstName, lastName, email, pwd);
        Assert.assertEquals(registerPage.getValidationSuccMessage(), expRegisterSuccMessage);

    }
}
