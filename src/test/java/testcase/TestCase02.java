package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase02 {
    @Test//them annotation
    public void Sum03() {
        System.out.println("Tong la:");
    }

    @Test(groups = "A")
    public void Sum04() {
        System.out.println("Tong 02 la:");
        Assert.assertEquals(2,2);
    }
}


