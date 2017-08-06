package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * at
 * Created by admin on 01/08/2017.
 */
public class ConfigReader {

    public static Properties user = loadProperties("src/test/java/properties/user.properties");




    private static Properties loadProperties(String filePath) {
        Properties properties = new Properties();
        try {
            FileInputStream f = new FileInputStream(filePath);
            properties.load(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


/*
    public static String getPropertyValue(String path, String key) {
        Properties p = loadProperties(path);
        String result = "";
        Set<String> values = p.stringPropertyNames();
        for (String value : values) {
            if (StringUtils.equalsAnyIgnoreCase(value, key)) {
                result = p.getProperty(value);
                break;
            }
        }
        return result;
    }
*/
}
