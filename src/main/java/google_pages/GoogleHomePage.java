package google_pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
* Encapsulation
* */
public class GoogleHomePage extends BasePage {
    //Page objects  - store all locator of web elements in GoogleHomePage

    private final By txtSearch = By.name("q");
    private final By btnGoogleSearch = By.name("btnK");
    private final By lblLanguage = By.id("SIvCob");
    private final By lblLucky = By.name("btnI");
    private final By linkTiengViet = By.linkText("Tiếng Việt");
    private final By linkEnglish = By.linkText("English");
    private final By linkGmail = By.linkText("Gmail");

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public By getTxtSearch() {
        return txtSearch;
    }

    public By getBtnGoogleSearch() {
        return btnGoogleSearch;
    }

    public By getLblLanguage() {
        return lblLanguage;
    }

    public By getLblLucky() {
        return lblLucky;
    }

    public By getLinkTiengViet() {
        return linkTiengViet;
    }

    public By getLinkEnglish() {
        return linkEnglish;
    }

    public By getLinkGmail() {
        return linkGmail;
    }

    // Action methods
    /* Page actions */
    public String getTextGoogleSearch(){
        return driver.findElement(btnGoogleSearch).getText();
    }
    public String getTextLucky(){
        return driver.findElement(lblLucky).getText();
    }
    /*-----------------------*/
    public void search(String sSearch){
        WebElement eSearch = driver.findElement(txtSearch);
        eSearch.sendKeys(sSearch);

        eSearch.sendKeys(Keys.ENTER);
        System.out.println("test search");
    }

    public void changeLanguage(String language){
        System.out.println(driver);
        WebElement eLinkE = driver.findElement(linkEnglish);
        WebElement eLinkV = driver.findElement(linkTiengViet);


        if (language.equals("English")){
            eLinkE.click();
        }else {
            eLinkV.click();
        }
    }
    public void goToGmail(){
        WebElement eLinkGmail = driver.findElement(linkGmail);
        eLinkGmail.click();
    }

}
