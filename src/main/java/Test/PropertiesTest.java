package Test;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PropertiesTest  {

    public static void main(String[] args) {

        testLoadProPerties();
    }

    private static void testLoadProPerties() {

        //加载mysql-jdbc.properties
        Properties properties=new Properties();

        try {
            //spring提供的方法
            properties= PropertiesLoaderUtils.loadAllProperties("mysql-jdbc.properties");

            System.out.println(properties.toString());




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
