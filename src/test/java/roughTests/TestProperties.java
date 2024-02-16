package roughTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) throws IOException {

        Properties configProperties = new Properties();
        Properties ORproperties = new Properties();

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/properties/Config.properties");
        configProperties.load(fileInputStream);

        fileInputStream = new FileInputStream("src/test/resources/properties/OR.properties");
        ORproperties.load(fileInputStream);


    }
}
