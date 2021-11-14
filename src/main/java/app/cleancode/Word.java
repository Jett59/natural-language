package app.cleancode;

public record Word(String word, boolean adjective, boolean adverb, boolean noun,
        boolean preposition, boolean verb) {
    public Word(String word) {
        this(word, WordLists.adjectives.contains(word.toLowerCase()),
                WordLists.adverbs.contains(word.toLowerCase()),
                WordLists.nouns.contains(word.toLowerCase()),
                WordLists.prepositions.contains(word.toLowerCase()),
                WordLists.verbs.contains(word.toLowerCase()));
    }
}
