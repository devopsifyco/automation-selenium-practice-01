package testcase;

import Pages.GooglePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC002_SearchGoogle extends BaseTest{

    @Test
    public void navGoogle1(){
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(),"Google");
    }

    @Parameters("Search")//test
    @Test
    public void searchWith(String sSearch){
        // Create an object of class .... (GooglePage)
        // GooglePage g = new GooglePage(); // get error due to driver is null
        GooglePage g = new GooglePage(driver); // IMPORTANCE : truyen Driver (Tu BaseTest) vao  --> De truyen vao duoc can tao mot ham constructor co parameter nhan vao la mot WebDriver
        g.search(sSearch);
        Assert.assertEquals(2,2);
    }

}
