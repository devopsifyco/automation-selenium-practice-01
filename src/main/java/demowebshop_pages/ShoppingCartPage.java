package demowebshop_pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage extends BasePage {
    /* Web Element Locators*/
    private final By logo = By.xpath("//*[@class= 'header-logo']//a/img");

    private By header = By.tagName("h1");
    private By content = By.className("order-summary-content");
    private By listOrderProcess = By.xpath("//*[@class='order-progress']//li/a");


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String getShoppingCartPageTitle(){
        return getPageTitle();
    }
    public boolean compareLogo() throws IOException {
        //File expectedFile = new File("src/test/resources/TakeElement_Wed_Jun_21_15_41_17_ICT_2023.jpg");
        File expectedFile = new File("src/test/resources/logo1.jpg");
        return imageComparision(getElement(logo),expectedFile);

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
