package utils;

import base.BasePage;
import base.BaseTests;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;



/*
* 1 - Create a class and then implement TestNG 'ITestListener'.
* 2 - Creat method called 'onTestFailure'. We need to add the code to take the screenshot in this method.
* */
public class TestListener implements ITestListener {

// This belongs to ITestListener and will execute before the whole Test starts

    @Override
    public void onStart(ITestContext arg0) {
        Reporter.log("About to begin executing Class " + arg0.getName(), true);
    }

    // This belongs to ITestListener and will execute, once the whole Test is finished

    @Override
    public void onFinish(ITestContext arg0) {
        Reporter.log("About to end executing Class " + arg0.getName(), true);
    }
    // This belongs to ITestListener and will execute before each test method

    @Override
    public void onTestStart(ITestResult result) {
        Reporter.log("Testcase - " + result.getName() + " started successfully", true);
    }

    // This belongs to ITestListener and will execute only in the event of a successful test method
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Testcase - " + result.getName() + " run PASSED", true);
    }

    // This belongs to ITestListener and will execute only in the event of a fail test

    public void onTestFailure(ITestResult result) {
        String s="";
        BaseTests b = new BaseTests();
         /*private Date d = new Date();
        private String screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";*/

        Reporter.log("Testcase - " + result.getName() + " run <b style=\"color:red\"> FAILED</b>", true);

        if (!result.isSuccess()){
            try {
                s = b.takeScreenShotOnFailure(result);
                System.out.println("file path = "+ s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Reporter.log("<a href='"+ s +"'><img src='"+ s +"' height='100' width='100'> img here</a>", true);
        }

    }

    // This belongs to ITestListener and will execute only in the event of the skipped test method

    public void onTestSkipped(ITestResult result) {
        Reporter.log("Testcase - " + result.getName() + " got SKIPPED", true);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }

}
