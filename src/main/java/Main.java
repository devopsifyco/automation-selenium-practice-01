
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import testdata.ReadExcelFile;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class Main {
    public static Logger log;

    public static void main(String[] args) {
        log = LogManager.getLogger(Main.class);

        // This data needs to be written (Object[])
        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();

        studentData.put("1",new Object[] { "Roll No", "NAME", "Year" ,"Note"});
        studentData.put("2",new Object[] { "128", "Aditya","2nd year" });
        studentData.put("3",new Object[] { "129", "Narayana", "2nd year" });
        studentData.put("4", new Object[] { "130", "Mohan","2nd year" });
        studentData.put("5", new Object[] { "131", "Radha","2nd year" });
        studentData.put("6", new Object[] { "132", "Gopal","2nd year" });
        studentData.put("7",new Object[] { "128", "Aditya","2nd year","testing" });
        studentData.put("9",new Object[] { "129", "Narayana", "2nd year" });
        studentData.put("10", new Object[] { "130", "Mohan","2nd year" });
        studentData.put("11", new Object[] { "131", "Radha","2nd year" });
        studentData.put("13", new Object[] { "132", "Gopal","2nd year" });

        ReadExcelFile re = new ReadExcelFile();
        File fileName = new File(System.getProperty("user.dir") + "/src/main/resources/datafiles/exmaple2.xlsx");

        //re.writeExcelFileSimple(fileName,"example");
        //re.writeExcelFile(studentData, fileName, "Student Data ");
        re.writeExistingExcelFile(fileName,"Student Data ");
        log.info("write file successfully");

     /*   System.out.println("testing");
        log = LogManager.getLogger(Main.class);
        log.info("Running in the TestLog4j main method - INFO");
        log.error("Running in the TestLog4j main method - ERROR");


        String propFileName = System.getProperty("user.dir") + "src/main/resources/property-files/log4j.properties";

        File f = new File(propFileName);

        if (f.exists()) {
            try {
                FileInputStream inStreamLog4j = new FileInputStream(f);
                Properties propertiesLog4j = new Properties();

                propertiesLog4j.load(inStreamLog4j);
                PropertyConfigurator.configure(propertiesLog4j);

            } catch (Exception e) {
                e.printStackTrace();
                BasicConfigurator.configure();
            }
        } else {
            BasicConfigurator.configure();
        }



        // BasicConfigurator.configure();

        log.info("This is my first log4j's statement");
*/
    }
}

