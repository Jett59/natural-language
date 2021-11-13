package app.cleancode;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Resources {
    private Resources() {}

    public static List<String> getLines(String resourcePath) {
        try (InputStream input = Resources.class.getResourceAsStream(resourcePath);
                BufferedInputStream bufferedInput = new BufferedInputStream(input)) {
            byte[] bytes = bufferedInput.readAllBytes();
            String str = new String(bytes, StandardCharsets.UTF_8);
            List<String> lines = List.of(str.split("\n"));
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
