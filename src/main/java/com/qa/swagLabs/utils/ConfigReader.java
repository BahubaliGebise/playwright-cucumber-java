package com.qa.swagLabs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public Properties initProp(){
        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public static String getProperty(String key){
        ConfigReader configReader = new ConfigReader();
        Properties properties = configReader.initProp();
        return properties.getProperty(key);
    }
}
