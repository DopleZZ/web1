import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class LoggerConfig {

    public static Logger getLogger(String name) throws  IOException {
        Logger logger = Logger.getLogger(name);
        logger.setLevel(Level.INFO);

        FileHandler handler = new FileHandler("text.log", true);
        logger.addHandler(handler);
        SimpleFormatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);

        //logger.addHandler(new FileHandler("./logs/text.log", true));
        return logger;
    }

}
