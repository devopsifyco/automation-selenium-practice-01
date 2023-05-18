package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase02 {
    @Test//them annotation
    public void Sum03() {
        System.out.println("Tong lan 3:");
    }

    @Test(groups = "A")
    public void Sum04() {
        System.out.println("Tong lan 4:");
    }
}


