package org.Selenium.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private Properties properties;

    public ConfigManager() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/configuration.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl() {
        return properties.getProperty("api.baseUrl");
    }
}
