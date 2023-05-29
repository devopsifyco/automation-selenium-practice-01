package PhuTran;


import org.openqa.selenium.WebDriver;


public abstract class BaseTest {
    protected WebDriver driver;


    public abstract void setUp();


    public abstract void runTest();


    public void tearDown() {
        driver.quit();
    }


    public void executeTest() {
        setUp();
        runTest();
        tearDown();
    }
}
