package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    /** Using getScreenshotAs() method of Interface TakesScreenshot
     * Then copy the screenshot file to desFile
     * The file type need to be img file .png/.jpeg extension
     * */

    public void takeFullScreenshot(WebDriver drv, File desFile) throws IOException {
        File srcFile = ((TakesScreenshot) drv).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, desFile);
    }

    /** Take screenshot of element is available from Selenium v4.x
     * We can use this to take an area or element
     * */

    public void takeWebElementScreenshot(WebElement element, File desFile) throws IOException {
        File srcFile = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, desFile);
    }

    /** Capture the screenshot of a particular element by cropping the full page screenshot?
     *       1 - Capture the screenshot
     *       2 - Convert to a buffered Image.
     *       3 - Get element's height and width using getSize() method.
     *       4 - Get element's X Y coordinates using Point class.
     *       5 - Read buffered Image.
     *       6 - Crop buffered Image using element's x, y coordinate position, and height, width parameters.
     *       7 - Save cropped Image at destination location physically.
     * */

    public void takeScreenshotParEle(WebDriver driver, WebElement element, File desFile) throws IOException {
        // Get screenshot of the visible part of the web page
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Convert the screenshot into BufferedImage
        BufferedImage fullScreen = ImageIO.read(scrFile);

        //Find width and height of the located element
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        //Find location of the webElement  on the page
        Point location = element.getLocation();

        //cropping the full image to get only the screenshot
        BufferedImage logoImage = fullScreen.getSubimage(location.getX(), location.getY(), width, height);
        ImageIO.write(logoImage, "png", scrFile);

        //Save cropped Image at destination location physically.
        FileUtils.copyFile(scrFile, desFile);
    }

    /** Using Ashot() method of the thirst party
     * Adding dependence
        <dependency>
            <groupId>ru.yandex.qatools.ashot</groupId>
            <artifactId>ashot</artifactId>
            <version>1.5.3</version>
            <scope>test</scope>
        </dependency>
     * */

    public void takeFullScreenshotAshot(WebDriver drv, WebElement ele, File desFile) throws IOException {
        Screenshot scrShot = new AShot().takeScreenshot(drv);
        ImageIO.write(scrShot.getImage(), "PNG", desFile);

    }

    public void takeScreenshotEleAshot(WebDriver drv, WebElement ele, File desFile) throws IOException {
        // pass driver as well as the element in takeScreenshot() method.
        Screenshot webEle = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(drv, ele);
        String s = desFile.toString();
        // For saving the screenshot in .png/.jpeg format at the desired location
        ImageIO.write(webEle.getImage(), "PNG", desFile);
    }

}
