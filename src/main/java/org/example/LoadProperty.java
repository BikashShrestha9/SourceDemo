package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperty {

    static FileInputStream input;
    static Properties prop;
    public String getValue(String key){
        prop=new Properties();
        try {
            //loading the data from source file
            input = new FileInputStream("src/test/Resources/testDataConfig.properties");
            prop.load(input);
            input.close();;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
