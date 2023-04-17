package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase01 {
    @Test//them annotation
    public void Sum() {
        System.out.println("Tong la:");
    }

    @Test
    public void Sum02() {
        System.out.println("Tong 02 la:");
        Assert.assertEquals(2,6);
    }
}
