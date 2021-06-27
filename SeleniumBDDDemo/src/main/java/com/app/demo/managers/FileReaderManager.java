package com.app.demo.managers;

import com.app.demo.utils.ConfigFileReader;

public class FileReaderManager {
    private static FileReaderManager fileReaderManager;
    private ConfigFileReader configFileReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance() {
        if (fileReaderManager == null)
            fileReaderManager = new FileReaderManager();

        return fileReaderManager;
    }

    public ConfigFileReader getConfigReader() {
        if (configFileReader == null)
            configFileReader = new ConfigFileReader();
        return configFileReader;
    }
}
