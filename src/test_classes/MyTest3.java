package test_classes;

import java.io.IOException;
import java.util.logging.*;

public class MyTest3 {
    private static Logger createLogger() {

        Logger logger = Logger.getLogger(MyTest2.class.getName());
        logger.setUseParentHandlers(false); // отключаем родительские обработчики

        try {
            // Настраиваем FileHandler для записи в файл
            FileHandler fileHandler = new FileHandler("log3.txt");
            fileHandler.setLevel(Level.WARNING); // Уровень логирования для файла
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

            // Настраиваем ConsoleHandler для вывода на консоль
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.INFO); // Уровень логирования для консоли
            consoleHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(consoleHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.setLevel(Level.ALL); // Устанавливаем уровень логгера для обработки всех сообщений

        return logger;
    }

    public static void main(String[] args) {
        Logger logger = createLogger();

        logger.severe("Это сообщение уровня SEVERE");
        logger.warning("Это сообщение уровня WARNING");
        logger.info("Это сообщение уровня INFO");
        logger.config("Это сообщение уровня CONFIG");
        logger.fine("Это сообщение уровня FINE");
        logger.finer("Это сообщение уровня FINER");
        logger.finest("Это сообщение уровня FINEST");
    }
}

