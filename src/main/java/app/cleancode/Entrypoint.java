package app.cleancode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Entrypoint {
    private static final Logger logger = Logger.getLogger(Entrypoint.class.getName());

    public static void main(String[] args) throws Exception {
        Arrays.stream(Logger.getLogger("").getHandlers())
                .forEach(handler -> handler.setLevel(Level.ALL));
        Logger packageLogger = logger.getParent();
        packageLogger.setLevel(Level.FINE);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please type a sentence: ");
        String sentence = reader.readLine();
        logger.fine("Received sentence: " + sentence);
        Lexer lexer = new Lexer();
        List<String> tokens = lexer.lex(sentence);
        logger.info("Categorizing words");
        List<Word> words = tokens.stream().map(Word::new).collect(Collectors.toList());
        logger.fine("Found tokens: " + words.toString());
        Parser parser = new Parser(words);
        logger.info("Parsing");
        parser.parse();
    }
}
