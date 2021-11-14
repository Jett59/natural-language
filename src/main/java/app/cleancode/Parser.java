package app.cleancode;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Parser {
    private static final Logger logger = Logger.getLogger(Parser.class.getName());

    private int position = 0;
    private final List<Word> tokens;

    public Parser(List<Word> tokens) {
        this.tokens = tokens;
    }

    public Sentence parse() {
        logger.fine("Parsing " + tokens.toString());
        parseNoun();
        return null;
    }

    private Noun parseNoun() {
        List<String> adjectives = new ArrayList<>();
        String firstWord = tokens.get(position).word();
        if (firstWord.equalsIgnoreCase("a") || firstWord.equalsIgnoreCase("an")
                || firstWord.equalsIgnoreCase("the") || firstWord.equalsIgnoreCase("some")) {
            position++;
        }
        while (tokens.get(position).adjective()) {
            if (position == tokens.size()) {
                throw new IllegalArgumentException(
                        "Unexpected end of token list while searching for a noun");
            }
            Word currentWord = tokens.get(position);
            Word nextWord = position + 1 == tokens.size() ? null : tokens.get(position + 1);
            if (nextWord == null || (!nextWord.adjective() && !nextWord.noun())) {
                break;
            } else {
                adjectives.add(currentWord.word());
            }
            position++;
        }
        Word name = tokens.get(position++);
        logger.fine("Found adjectives: " + adjectives.toString() + " and name " + name.word());
        if (!name.noun()) {
            throw new IllegalArgumentException("Name " + name + " is not a noun");
        }
        return new Noun(adjectives, name.word());
    }
}
