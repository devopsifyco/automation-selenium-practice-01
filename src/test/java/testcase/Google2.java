package testcase;

import org.testng.annotations.Test;

public class Google2 extends BaseTest{
    @Test
    public void navGoogle1(){
        driver.get("https://www.google.com/");
    }
}
