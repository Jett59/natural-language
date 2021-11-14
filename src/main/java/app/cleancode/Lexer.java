package app.cleancode;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Lexer {
    private static final Logger logger = Logger.getLogger(Lexer.class.getName());

    public List<String> lex(String sentence) {
        logger.fine("Lexing " + sentence);
        List<String> result = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == '\n' || c == '\t' || c == ' ' || c == '.') {
                if (temp.length() > 0) {
                    logger.finer("Got token: " + temp);
                    result.add(temp);
                    temp = "";
                }
                if (c == '.') {
                    temp += '.';
                }
            } else {
                temp += c;
            }
        }
        if (temp.length() > 0) {
            logger.finer("Got token: " + temp);
            result.add(temp);
        }
        logger.fine(String.format("Found %d tokens", result.size()));
        return result;
    }
}
