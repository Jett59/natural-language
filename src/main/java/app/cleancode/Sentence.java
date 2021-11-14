package app.cleancode;

import java.util.List;

public record Sentence(String verb, List<String> adverbs, List<Noun> nouns) {

}
