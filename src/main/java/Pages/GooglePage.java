package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

//encapsulation

public class GooglePage {
    private WebDriver driver;//declare
    //driver IS NULL , do not know start what browser

    /* Page locators - Variables*/
    //USING CLASS By
    //public  WebElement  e = driver.findElement(By.name("test")); // ->  driver IS NULL
    private By txtSearch = By.name("q");
    private final By btnGoogleSearch = By.name("btnK");
    private final By lblLanguage = By.id("SIvCob");
    private final By lblLucky = By.name("btnI");
    private final By linkTiengViet = By.linkText("Tiếng Việt");
    private final By linkEnglish = By.linkText("English");
    private final By linkGmail = By.linkText("Gmail");

    private int a=12;
    public  int b=13;

    //constructor  --> default -> error due to this.driver is null
    public GooglePage() {
        System.out.println(driver);
     }

     // IMPORTANCE ===>So define a constructor with parameter web-driver to make sure has the same driver with BaseTest.
    public GooglePage(WebDriver driver1) {
        this.driver = driver1; //init driver
    }


    public int getA() {
        return (a>0)?a:0;
    }
    public void setA(int a) {
        this.a = a;
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
