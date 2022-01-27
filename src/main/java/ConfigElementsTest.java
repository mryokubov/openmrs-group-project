import utils.ConfigReader;

import java.io.IOException;

public class ConfigElementsTest {
    public static void main(String[] args) throws IOException {
ConfigReader.setProperties("familyName","newfamilyname");
        System.out.println(ConfigReader.getProperty("familyName"));
        System.out.println(ConfigReader.getProperty("firstName"));


    }
}