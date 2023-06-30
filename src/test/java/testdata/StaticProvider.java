package testdata;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.Iterator;

public class StaticProvider {

    @DataProvider(name = "example1")
    public Object[][] dpMethod1() {
        return new Object[][]{{"First-Value"}, {"Second-Value"}};
    }

    @DataProvider(name = "example2")
    public static Object[][] dpMethod2() {
        return new Object[][] { new Object[] {42}};
    }

    @DataProvider(name = "data_provider_01")
    public Object[][] dpMethod() {
        return new Object[][] {{"huyentran@gmail.com", "123@123", "admin"},
                                {"ngonguyen@gmail.com", "456@456", "member"}};
    }

    @DataProvider (name = "data-provider")
    public Object[][] dpMethod (Method m){
        System.out.println("method name = " + m.getName());
        switch (m.getName()) {
            case "SumofAandB":
                return new Object[][] {{2, 3 , 5}, {5, 7, 9}};
            case "Diff":
                return new Object[][] {{2, 3, -1}, {5, 7, -2}};
            default:
                return new Object[][] {{1, 4, 3}, {6, 8, -2}};
        }

    }

    @DataProvider(name = "users")
    public Object[][] loginAccount(){
        Reporter.log("provide list of users");
 /*       String[][] lgnAcct = {{"atproject1","atProject@1"},
                {"atproject2","atProject@1"},
                {"atproject3","atPrject@1"}};
        */

        return new String[][]{{"atproject1","atProject@1"},
                {"atproject2","atProject@1"},
                {"atproject3","atPrject@1"}};
    }
}
