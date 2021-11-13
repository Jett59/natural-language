package app.cleancode;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;

public class Resources {
    private static final Logger logger = Logger.getLogger(Resources.class.getName());

    private Resources() {}

    public static List<String> getLines(String resourcePath) {
        logger.fine("Reading from classpath: " + resourcePath);
        try (InputStream input = Resources.class.getResourceAsStream(resourcePath);
                BufferedInputStream bufferedInput = new BufferedInputStream(input)) {
            byte[] bytes = bufferedInput.readAllBytes();
            String str = new String(bytes, StandardCharsets.UTF_8);
            logger.finest("Contents of " + resourcePath + ": " + str);
            List<String> lines = List.of(str.split("\n"));
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
