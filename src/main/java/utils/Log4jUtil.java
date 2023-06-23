package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Log4jUtil {
    // Define logger
  /*  public static Logger log ;
    public static void setupLog4j() {
        try {
            // you need to do something like below instaed of Logger.getLogger(....);
            log = LogManager.getLogger(Log4jUtil.class);
            String propFileName = System.getProperty("user.dir") +"src/main/resources/property-files/log4j.properties" ;

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

            // logger.setLevel(Level.TRACE);
            log.debug("log4j configured");
        } catch (Exception e) {
           e.getMessage();
        }
    }*/
}
