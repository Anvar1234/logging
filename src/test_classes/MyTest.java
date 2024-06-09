package test_classes;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MyTest {
    private static final Logger logger = Log.log(MyTest.class.getName());

    public int sum(int x, int y) {
        logger.info("Зашли в метод sum()");
       return x + y;
    }

    public double division(int x, int y) {
        logger.info("Зашли в метод division()");
        logger.warning("Возможно деление на ноль!");
        double result = 0d;
        //правильно сначала проверять какой уровень логгирования пропустит конфигурация, и только потом создавать лог.
        //так как у меня для корневого логгера установлен уровень FINE, то это сообщение пройдет, но без установки
        // этого уровня я не понимал, почему не выводилось в файл.
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("y == " + y);
        }
        try {
            result = x/y;
        } catch (Exception ex) {
            //так логгируем исключения.
            logger.log(Level.SEVERE, "Exception: ", ex);
        }
        return result;
    }
}
/**
 * Класс для загрузки конфигураций логгера в статическом блоке, а также методом, возвращающим экземпляр логгера.
 */
class Log {
    static {
        try(FileInputStream in = new FileInputStream("log3.properties")){
            LogManager.getLogManager().readConfiguration(in);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static Logger log(String className) {
        return Logger.getLogger(className);
    }
}

class Main {
    public static void main(String[] args) {
        MyTest myTest = new MyTest();

        System.out.println("sum : " + myTest.sum(5, 10));
        System.out.println("division : " + myTest.division(5, 2));
    }
}
