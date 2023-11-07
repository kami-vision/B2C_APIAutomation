package com.kami.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Util {

    public static Properties readConfig(String filePath)throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream(filePath));
        return properties;

    }
}
