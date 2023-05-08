package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class GooglePage {
    private WebDriver driver;

    /* Page locators - Variables*/
    //USING CLASS By
    public By txtSearch = By.name("q");
    public By btnGoogleSearch = By.name("btnK");
    public By lblLanguage = By.id("SIvCob");
    public By lblLucky = By.name("btnI");
    public By linkTiengViet = By.linkText("Tiếng Việt");
    public By linkEnglish = By.linkText("English");
    public By linkGmail = By.linkText("Gmail");

    //constructor  --> default -> error due to this.driver is null
    public GooglePage() {
        System.out.println(driver);
     }

     // IMPORTANCE ===>So define a constructor with parameter web-driver to make sure has the same driver with BaseTest.
    public GooglePage(WebDriver driver1) {
        this.driver = driver1;
    }


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
