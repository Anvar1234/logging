package test_classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyTest4 {
    private static final Logger logger = Logger.getLogger(MyTest4.class.getName()); //получаем экземпляр обычного логгера.

    public int sum4(int x, int y) {
        logger.info("Зашли в метод sum4()");
        return x + y;
    }

    public int division4(int x, int y) {
        logger.info("Зашли в метод division4()");
        logger.warning("Возможно деление на ноль!");
        return x / y;
    }
    // метод для загрузки файла с пропертями.
    private static void loadProperties(){
        try(FileInputStream in = new FileInputStream("log.properties")){
            LogManager.getLogManager().readConfiguration(in);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyTest4 myTest4 = new MyTest4(); //По сути здесь уже есть логгер со стандартной конфигурацией.
       loadProperties(); //И только в этот момент подгружаем файл свойств.
        System.out.println("sum : " + myTest4.sum4(8, 12));
        System.out.println("division : " + myTest4.division4(15, 2));
    }
}
