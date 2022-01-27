package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    private static final String propertyFilePath="src/main/resources/config.properties";

    private ConfigReader(){}

// important thing to note is that all the classes in the project are being considered at runtime
    //if you have an error in one class... any other classes runtime will be effected during complie time.
    static { // static block- executed once and only once and is executed before anything else even the constructor
        System.out.println("Static Block has been called"); // to check the static block method
        System.out.println("The Test Has Began");
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



