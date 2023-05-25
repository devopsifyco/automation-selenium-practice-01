package testcase;

import Pages.GooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_ChangeLanguageSuccess extends BaseTest {

    @Test(priority = 1)
    public void navGoogle1(){
        driver.get("https://www.google.com/");
        System.out.println("Nav:"+ driver);
        Assert.assertEquals(driver.getTitle(),"Google");
    }


    @Test (priority = 2)
    public void changeToVietnamese(){
        GooglePage g = new GooglePage(driver);
        g.changeLanguage("TV");
        g.setA(15);
        int c = g.b;
        int d = g.getA();
        //  Assert.assertEquals(g.btnGoogleSearch,"Tìm trên TC001_ChangeLanguageSuccess");
        Assert.assertEquals(g.getTextLucky(),"Xem trang đầu tiên tìm được");
    }

    @Test (priority = 3)
    public void changeToEnglish(){
        GooglePage g = new GooglePage(driver);
        g.changeLanguage("English");
      //  Assert.assertEquals(g.btnGoogleSearch,"Tìm trên TC001_ChangeLanguageSuccess");
        Assert.assertEquals(g.getTextLucky(),"Xem trang đầu tiên tìm được");

    }
}
