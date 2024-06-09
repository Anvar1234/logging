package test_classes;

import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Log4 {
    public static void loadProperties(String className){
        try(FileInputStream in = new FileInputStream("log.properties")){
            LogManager.getLogManager().readConfiguration(in);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
