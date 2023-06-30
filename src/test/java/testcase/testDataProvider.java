package testcase;

import org.testng.annotations.Test;
import testdata.DataProviderExample;
import testdata.StaticProvider;

import java.util.Map;

public class testDataProvider {
/*
    @Test(dataProvider = "example1", dataProviderClass = StaticProvider.class)
    public void test(String n) {
        System.out.println(n);
    }
    @Test(dataProvider = "example2", dataProviderClass = StaticProvider.class)
    public void test(Integer n) {
        System.out.println(n);
    }

    @Test(dataProvider = "example3" , dataProviderClass = StaticProvider.class)
    public void testDataProvider(String username, String password, String role) {
        System.out.println("Username is: " + username);
        System.out.println("Password is: " + password);
        System.out.println("Role is: " + role);
    }*/

    @Test(dataProvider = "data-provider", dataProviderClass = StaticProvider.class)
    public void SumofAandB(int a, int b, int result) {
        int sum = a + b;
        System.out.println(a + " + "+ b +" = "+ result );
        System.out.println(sum);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = StaticProvider.class)
    public void Diff(int a, int b, int result) {
        int diff = a - b;
        System.out.println(a + " - " + b +" = "+ result );
        System.out.println(diff);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = StaticProvider.class)
    public void Other(int a, int b, int result) {
        int mult = a * b;
        System.out.println(a + " * " + b +" = "+ result );
        System.out.println(mult);
    }
}
