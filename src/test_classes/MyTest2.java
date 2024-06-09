package test_classes;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyTest2 {
    private static final Logger logger = createLogger();

    public int sum2(int x, int y) {
        logger.info("Зашли в метод sum2()");
        return x + y;
    }

    public int division2(int x, int y) {
        logger.info("Зашли в метод division2()");
        logger.warning("Возможно деление на ноль!");
        return x / y;
    }

    private static Logger createLogger() {

        Logger logger = Logger.getLogger(MyTest2.class.getName());
        FileHandler fh;
        try {
            fh = new FileHandler("log2.txt");
            logger.addHandler(fh);
            fh.setFormatter(new SimpleFormatter()); // текстовый формат
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logger;
    }
}
