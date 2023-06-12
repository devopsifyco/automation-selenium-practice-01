package demowebshop_pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    public String getShoppingCartPageTitle(){
        return getPageTitle();
    }
}
