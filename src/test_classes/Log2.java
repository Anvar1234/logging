package test_classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Log2 {
    public static Logger getLogger(String className){
        try(FileInputStream in = new FileInputStream("log2.properties")){
            LogManager.getLogManager().readConfiguration(in);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return Logger.getLogger(className);
    }
}
