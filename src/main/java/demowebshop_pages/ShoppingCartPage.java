package demowebshop_pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

    private final By header = By.tagName("h1");
    private final By messagecontent = By.tagName("h1");
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String getShoppingCartPageTitle(){
        return getPageTitle();
    }
    public String getHeader(){
        return getValue(header);
    }
    public String getMessageContent(){
        return getValue(messagecontent);
    }
}
