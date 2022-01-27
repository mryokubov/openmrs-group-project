package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    private static final String propertyFilePath="src/main/resources/config.properties";

    private ConfigReader(){

    }

    static {
        try {
            FileInputStream inputStream = new FileInputStream(propertyFilePath);
            properties=new Properties();
            properties.load(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyName){
        return properties.getProperty(keyName);

    }
    public static void setProperties(String key,String value)throws IOException {
        properties.store(new FileOutputStream("src/main/resources/config.properties"),null);
        properties.setProperty(key,value);
    }
}



