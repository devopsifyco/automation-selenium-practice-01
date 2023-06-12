package demowebshop_pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class WishListPage extends BasePage {
    /* Web Element Locators*/
    private By header = By.tagName("h1");
    private By content = By.className("wishlist-content");



    /*Constructor*/
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    /* Methods*/
    public String getWishListPageTitle(){
        return getPageTitle();
    }

    public String getHeader(){
        return getValue(header);
    }
    public String getContent(){
        return getValue(content);
    }
}
