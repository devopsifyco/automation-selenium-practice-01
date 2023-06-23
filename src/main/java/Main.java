
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class Main {
    public static Logger log;

    public static void main(String[] args) {
        System.out.println("testing");
        log = LogManager.getLogger(Main.class);
        log.info("Running in the TestLog4j main method - INFO");
        log.error("Running in the TestLog4j main method - ERROR");
/*

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
*/


        // BasicConfigurator.configure();

        log.info("This is my first log4j's statement");

    }
}

