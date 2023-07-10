package demowebshop_pages;


import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.logging.Level;

public class SearchPage extends BasePage {
    //NO WRITE - only READ
    //Page objects
    private final By searchValuetxt = By.id("Q");


    public SearchPage(WebDriver driver) { //constructor, gọi hàm của lớp cha-Basepage
        super(driver);//để chắc rằng biến driver trong lớp Basepage cho parameter driver này
    }

    public String getSearchValue (){
        return getAttributeValue(searchValuetxt, "value");
    }


    public String getSearchPageTitle() {
      //  takeWebElementScreenshot(getElement(logo));
        return getPageTitle();
    }

}
