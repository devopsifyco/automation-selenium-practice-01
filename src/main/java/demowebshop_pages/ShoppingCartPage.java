package demowebshop_pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage extends BasePage {
    /* Web Element Locators*/
    private By header = By.tagName("h1");
    private By content = By.className("order-summary-content");
    private By listOrderProcess = By.xpath("//*[@class='order-progress']//li/a");


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String getShoppingCartPageTitle(){
        return getPageTitle();
    }

    public String getHeader(){
        return getValue(header);
    }
    public String getContent(){
        return getValue(content);
    }

    public ArrayList<String> getProgress(){
        List<WebElement> lstElement = getLstElement(listOrderProcess);
        ArrayList<String> progress = new ArrayList<>();

        for (WebElement e : lstElement){
            progress.add(e.getText()+"_"+ getAttributeValue(e, "class"));
        }
        return progress;
    }

}
