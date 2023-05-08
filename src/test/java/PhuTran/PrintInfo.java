package PhuTran;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PrintInfo {
    @Test
    @Parameters ({"fullname","birthday"})
    public void printname(String fullname, int birthday){
        System.out.println("fullname is:" +fullname);
        System.out.println("birthday is:" +birthday);
    }
}
