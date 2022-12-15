package com.SkyBlue.LibraryCT.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();

    // having static block because static runs first
    static {

        try {
            // Create FileInputStream object to open file as a stream in Java memory
            FileInputStream file = new FileInputStream("config.properties");
            // Load "properties" object with the "file" we opened using FileInputStream
            properties.load(file);

        } catch (IOException e) {
            System.out.println("File not found in ConfigurationReader class");
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }


}
