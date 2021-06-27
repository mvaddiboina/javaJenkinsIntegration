package com.app.demo.utils;

import com.app.demo.base.BrowserType;
import com.app.demo.base.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath = "src//test//resources//configuration.properties";

    public ConfigFileReader() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Properties file not found at path : " + propertyFilePath);
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException ignore) {
            }
        }
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("baseUrl");
        if (url != null) return url;
        else
            throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
    }

    public BrowserType getBrowser() {
        String browserName = properties.getProperty("browserType");
        if (browserName == null || browserName.equals("chrome")) return BrowserType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox")) return BrowserType.FIREFOX;
        else
            throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environmentType");
        if (environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
        else if (environmentName.equals("remote")) return EnvironmentType.REMOTE;
        else
            throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
    }


}
