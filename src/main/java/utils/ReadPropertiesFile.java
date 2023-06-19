package utils;

import java.io.FileInputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

    public Properties fileProperties = new Properties();

    public  ReadPropertiesFile(FileInputStream filePath) throws IOException {
        fileProperties.load(filePath);
    }

    public String readPropertiesValue(String name){
        return fileProperties.getProperty(name);
    }

    public String encodeString(String password) {
        byte[] encodedString = Base64.encodeBase64(password.getBytes());
        return (new String (encodedString));
    }

    public String decodeString(String encodePass) {
        byte[] decodedString = Base64.decodeBase64(encodePass.getBytes());
        return (new String (decodedString));
    }

    public static void main (String[] args) throws IOException {
        String path = System.getProperty("user.dir")+"/src/main/resources/propertyfiles/config.properties";
        FileInputStream sConfigFile = new FileInputStream(path);
        ReadPropertiesFile r = new ReadPropertiesFile(sConfigFile);

        String sPwd = r.readPropertiesValue("password");

        System.out.println( r.encodeString(sPwd));
        System.out.println(r.decodeString("MTIzQFFXYTQ="));

    }
}
