import com.github.javafaker.Faker;
import utils.ConfigReader;

import java.io.IOException;

public class ConfigElementsTest {
    public static void main(String[] args) throws IOException {

        System.out.println(ConfigReader.getProperty("familyName"));


    }
}