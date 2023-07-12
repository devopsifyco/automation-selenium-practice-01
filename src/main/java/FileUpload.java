import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class FileUpload {
    public void uploadFile (WebDriver driver) throws AWTException {
        String filePath ="D:\\Devopsify\\automation-selenium-practice-01\\sample.pdf";

        driver.get("https://www.monsterindia.com/");
        // driver.findElement(By.xpath("//span[@class='uprcse semi-bold']")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Upload Resume')]")).click();

       /* // Approach 1 - Locate the drop area and using sendkeys method
        driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys(filePath);*/

        // Approach 2 - locate the drop area and using Robot class
      /*  JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@id='file-upload']")));

        dropFileUsingRobot(driver, filePath);*/



        // Approach 2 - locate the drop area and using Dropzone

        uploadFileUsingDropzone(new File(filePath), driver.findElement(By.xpath("//input[@id='file-upload']")), 0, 0);
    }
    public void dropFileUsingRobot(WebDriver driver, String filePath) throws AWTException {

        //put path to file in a clipboard
        StringSelection ss = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        robot.delay(250);

        //Press CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        //Release CTRL+V
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(2000);

        //Press ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void uploadFileUsingDropzone(File filePath, WebElement target, int offsetX, int offsetY)
    {
        WebDriver driver = ((RemoteWebElement)target).getWrappedDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        String JS_DROP_FILE =
                "var target = arguments[0]," +
                        "    offsetX = arguments[1]," +
                        "    offsetY = arguments[2]," +
                        "    document = target.ownerDocument || document," +
                        "    window = document.defaultView || window;" +
                        "" +
                        "var input = document.createElement('INPUT');" +
                        "input.type = 'file';" +
                        "input.style.display = 'none';" +
                        "input.onchange = function () {" +
                        "  var rect = target.getBoundingClientRect()," +
                        "      x = rect.left + (offsetX || (rect.width >> 1))," +
                        "      y = rect.top + (offsetY || (rect.height >> 1))," +
                        "      dataTransfer = { files: this.files };" +
                        "" +
                        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
                        "    var evt = document.createEvent('MouseEvent');" +
                        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
                        "    evt.dataTransfer = dataTransfer;" +
                        "    target.dispatchEvent(evt);" +
                        "  });" +
                        "" +
                        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                        "};" +
                        "document.body.appendChild(input);" +
                        "return input;";

        WebElement input =  (WebElement)js.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
        input.sendKeys(filePath.getAbsoluteFile().toString());

    }
}
