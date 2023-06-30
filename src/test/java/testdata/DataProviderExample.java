package testdata;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DataProviderExample {
    @DataProvider
    public static Object[][]Dataprovider1(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("data1", "value1");
        map.put("data2", "value2");
        map.put("data10", "value10");
        return new Object[][] {
                {map}
        };
    }
    @Test()
    public void testScenario1() {
        System.out.println(122);

    }

    @Test(dataProvider = "Dataprovider1" )
    public void testScenario1(Map<String, String> data) {
        System.out.println(data.get("data1"));

        // 3 - Print keys and values
        for (String k : data.keySet()) {
            System.out.println("key: " + k + " ---->   value: " + data.get(k));
        }
    }
}
