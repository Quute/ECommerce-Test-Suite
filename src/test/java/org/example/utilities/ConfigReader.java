package org.example.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {

private static Properties properties;

static {
    try {
        String path = "configuration.properties";

        FileInputStream input = new FileInputStream(path);
        properties = new Properties();
        properties.load(input);

        input.close();
    } catch (Exception e) {
        e.printStackTrace(); //Hata olursa konsola yazdır.
    }
}
    public static String getProperty(String key){
        return properties.getProperty(key);


    }

}
