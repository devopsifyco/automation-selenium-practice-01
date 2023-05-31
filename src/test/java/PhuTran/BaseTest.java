package PhuTran;

import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected WebDriver driver;
    public abstract void Setup();
    public abstract void SignInMoonstake();
    public void Teardown(){
        driver.quit();
    };
    public void ExecuteTest(){
        Setup();
        SignInMoonstake();
        Teardown();
    }
}
