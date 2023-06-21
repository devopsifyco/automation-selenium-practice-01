package utils;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

/*
* 1 - Create a class and then implement TestNG 'ITestListener'.
* 2 - Creat method called 'onTestFailure'. We need to add the code to take the screen shot in this method.
* */
public class TestListener  implements ITestListener  {


    public void onTestFailure(ITestResult result) {
    }


    public void onFinish(ITestContext context) {}

    public void onTestStart(ITestResult result) {   }

    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}
