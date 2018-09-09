package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApplicationProperties {

    private static String profile = "qa";
    public static final String APPLICATION_PROPERTIES_PATH = "C:\\MyWork\\EXReport-Demo\\src\\main\\resources\\proeprties\\application.properties";
    private static Properties properties = new Properties();
    private static Map<String, String> propertiesMap = new HashMap<String, String>();

    static {
        try (InputStream inputStream = new FileInputStream(APPLICATION_PROPERTIES_PATH)) {
            properties.load(inputStream);
            Enumeration enumeration = properties.propertyNames();
            while (enumeration.hasMoreElements()) {
                String key = (String) enumeration.nextElement();
                String value = properties.getProperty(key);
                propertiesMap.put(key, value);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private ApplicationProperties() {
    }

    public static String get(String key) {
        return propertiesMap.get(key);
    }
}
