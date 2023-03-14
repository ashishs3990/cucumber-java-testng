package com.learn.cucumber.utils;

import lombok.experimental.UtilityClass;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@UtilityClass
public class ConfigReader {
    public String getConfigValue(String key) throws IOException {
        FileReader fileReader = new FileReader("config.properties");
        Properties properties = new Properties();
        properties.load(fileReader);
        return properties.getProperty(key);
    }
}
