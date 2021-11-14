package app.cleancode;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Parser {
    private static final Logger logger = Logger.getLogger(Parser.class.getName());

    private int position = 0;
    private final List<String> tokens;

    public Parser(List<String> tokens) {
        this.tokens = tokens;
    }

    public Sentence parse() {
        logger.fine("Parsing " + tokens.toString());
        parseNoun();
        return null;
    }

    private boolean isNoun(String word) {
        return WordLists.nouns.contains(word.toLowerCase());
    }

    private boolean isPreposition(String word) {
        return WordLists.prepositions.contains(word.toLowerCase());
    }

    private boolean isAdjective(String word) {
        return WordLists.adjectives.contains(word.toLowerCase());
    }

    private Noun parseNoun() {
        List<String> adjectives = new ArrayList<>();
        String firstWord = tokens.get(position);
        if (firstWord.equalsIgnoreCase("a") || firstWord.equalsIgnoreCase("an")
                || firstWord.equalsIgnoreCase("the") || firstWord.equalsIgnoreCase("some")) {
            position++;
        }
        while (isAdjective(tokens.get(position))) {
            if (position == tokens.size()) {
                throw new IllegalArgumentException(
                        "Unexpected end of token list while searching for a noun");
            }
            adjectives.add(tokens.get(position));
            position++;
        }
        String name = tokens.get(position++);
        logger.fine("Found adjectives: " + adjectives.toString() + " and name " + name);
        if (!isNoun(name)) {
            logger.warning(String.format("Name %s may not be a noun", name));
        }
        return new Noun(adjectives, name);
    }
}
