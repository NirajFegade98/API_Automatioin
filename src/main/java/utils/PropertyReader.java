package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader
{

    public static String propertyReader(String filepath , String key)
    {
        String value = null;

        try(InputStream input = new FileInputStream(filepath))
        {
            //object creation for property class
            Properties prop = new Properties();

            //load a properties file
            prop.load(input);

            //getproperty will fetch value
            value = prop.getProperty(key);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return value;
    }
}
