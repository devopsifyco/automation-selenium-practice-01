package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;


public class BasePage extends Page{
    private String path = "\\target\\screenshots\\";
    private File desFile;


    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        //Take screenshot
        /*try {
            takeFullScreenshot();
        } catch (IOException e) {

            LOGGER.severe(e.getMessage());
        }*/
        return driver.getTitle();//lenh nay cua selnium
    }

    @Override
    public WebElement getElement(By locator) {
        try {
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            //Wait for element to be appeared
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            return driver.findElement(locator);
        } catch (Exception e){
            System.out.println(locator.toString() + e);
        }
        return null;
    }

    @Override
    public List<WebElement> getLstElement(By locator) {
        try {
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            //Wait for element to be appeared
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            return driver.findElements(locator);
        } catch (Exception e){
            System.out.println(locator.toString() + e);
        }
        return null;
    }

    @Override
    public String getPageHeader(By locator, String att) {

        return getElement(locator).getAttribute(att);
    }

    @Override
    public void enter(By locator, String text) {
        WebElement e = getElement(locator);
        if (e.isDisplayed() && e.isEnabled()){
            e.clear();
            e.sendKeys(text);
        }else {
            System.out.println("Not allow editable");
        }
    }

    @Override
    public String getValue(By locator) {
        return getElement(locator).getText();
    }
//Overloading
    @Override
    public String getAttributeValue(WebElement e,String attribute) {
        return e.getAttribute(attribute);
    }

    public String getAttributeValue(By locator,String attribute) {
        return getElement(locator).getAttribute(attribute);
    }

    @Override
    public void clickElement(By locator) {//locator kieu by
        WebElement e = getElement(locator);
        if (e.isDisplayed() && e.isEnabled()){
            e.click();
        }else {
            System.out.println("Not allow clickable");
        }
    }

    /** Using getScreenshotAs() method of Interface TakesScreenshot
     * Then copy the screenshot file to desFile
     * The file type need to be img file .png/.jpeg extension
     * */

    public void takeScreenshot(File desFile) throws IOException {

        File srcFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,desFile);
        //System.out.println("Capture screenshot successfully - image name is "+ screenshotName);
       // LOGGER.log(Level.INFO,"Capture screenshot successfully - image name is "+ screenshotName);
    }

    @Override
    public void takeFullScreenshot(String pathDesFile) throws IOException {

        File srcFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        desFile = new File(System.getProperty("user.dir")+pathDesFile);
        FileUtils.copyFile(srcFile,desFile);
        //System.out.println("Capture screenshot successfully - image name is "+ screenshotName);
        LOGGER.log(Level.INFO,"Capture screenshot successfully - image name is "+ pathDesFile);
    }

    /**Take screenshot of element is available from Selenium v4.x
     * We can use this to take an area or element
     * */

    @Override
    public void takeWebElementScreenshot(WebElement element, String pathDesFile) throws IOException {
        File srcFile = element.getScreenshotAs(OutputType.FILE);
        desFile = new File(pathDesFile);
        FileUtils.copyFile(srcFile, desFile);
        //System.out.println("Capture screenshot successfully - image name is "+ "TakeElement_" + screenshotName);
        //LOGGER.log(Level.INFO,"Capture screenshot successfully - image name is "+ "TakeElement_" + screenshotName);
    }
    @Override
    public boolean imageComparision (WebElement ele, File expFile) throws IOException {
        boolean b = false;
        BufferedImage expectedImage = ImageIO.read(expFile);
        Screenshot eleImageScreenshot = new AShot().takeScreenshot(driver,ele);

        //File scrFile = ele.getScreenshotAs(OutputType.FILE);
        BufferedImage  actualImage = eleImageScreenshot.getImage();

        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);

        if (diff.hasDiff())        //Checking the difference using in-built functions)
        {
            System.out.println("Both logo images matched"); //in case when no difference found

        }else{
            System.out.println("The logo images are different"); //in case when difference found
        }
        return diff.hasDiff();
    }
    @Override
    public void actionSearch(By locator ,String value){
        Actions builder = new Actions(driver);
        System.out.println("tessting");

        builder.moveToElement(getElement(locator ))
                .click()
                .sendKeys(value)
                .perform();
    }
    @Override
    public void selectDate(By locatorMonth, By locatorYear,By locatordate, String date){
        String month ="May";
        String dateSelect ="25";
        String year="2022";
        //select tag
        Select datepickerFrom_month = new Select(getElement(locatorMonth));

        datepickerFrom_month.selectByVisibleText(month);

        Select datepickerFrom_year = new Select(getElement(locatorYear));
        datepickerFrom_year.selectByVisibleText(year);

        //table get day
        List<WebElement> allDates = getLstElement(locatordate);

        for (WebElement ele : allDates) {
            if (ele.isEnabled() && ele.isDisplayed() && dateSelect.equalsIgnoreCase(ele.getText())) {
                ele.click();
                break;
            }
        }
    }
}
