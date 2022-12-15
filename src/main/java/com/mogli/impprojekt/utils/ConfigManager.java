package com.mogli.impprojekt.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class ConfigManager {

    private Properties properties;

    public ConfigManager() throws IOException {

        properties = new Properties();

        loadConfig();
    }

    public void loadConfig() throws IOException {
        //CREATE CONFIG
        File configFile = new File("config.properties");

        if(!configFile.exists()) {
            configFile.createNewFile();
        }

        //LOAD CONFIG
        InputStream inputStream = new FileInputStream(configFile);
        properties.load(inputStream);
        System.out.println("IMPSTART: Config loaded!");
    }

    public Object get(String key) {
        if(properties.get(key) != null) {
            return properties.get(key);
        }
        return new ErrorMessage().printError(this);
    }

    public void set(String key, String value) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File("config.properties"));
        properties.setProperty(key, value);
        properties.store(fileOutputStream, null);
        fileOutputStream.close();
    }

}
