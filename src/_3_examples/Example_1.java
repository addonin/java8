package _3_examples;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dimon
 * @since 16/11/15.
 */
public class Example_1 {
    public static void main(String[] args) {
        logIf(Level.INFO, () -> true, () -> "msg");
    }

    public static void logIf(Level level, Supplier<Boolean> condition, Supplier<String> message) {
        Logger logger = Logger.getGlobal();
        if (logger.isLoggable(level) && condition.get()) {
            logger.log(level, message.get());
        }
    }
}
