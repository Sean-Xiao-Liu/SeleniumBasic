package carfax.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private  static Properties properties;
    static{
        try{
            String path= "configuration.properties";
            FileInputStream inputStream=new FileInputStream(path);

            // create a property object without default value
            properties=new Properties();

            // Reads a property list (key and element pairs) from the input stream
            // since the Properties class extends Hashtable class
            properties.load(inputStream);
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // get property as a String
    public static  String get(String keyName){
        return properties.getProperty(keyName);
    }
}
