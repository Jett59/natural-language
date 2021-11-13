package app.cleancode;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Entrypoint {
    private static final Logger logger = Logger.getLogger(Entrypoint.class.getName());

    public static void main(String[] args) {
        Arrays.stream(Logger.getLogger("").getHandlers())
                .forEach(handler -> handler.setLevel(Level.ALL));
        Logger packageLogger = logger.getParent();
        packageLogger.setLevel(Level.FINE);
        logger.info("Setting up");
        logger.fine(String.format("Found %d nouns", WordLists.nouns.size()));
    }
}
