package app.cleancode;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class WordLists {
    public static final Set<String> nouns = Collections.unmodifiableSet(Resources
            .getLines("/nouns.txt").stream().map(String::toLowerCase).collect(Collectors.toSet()));
    public static final Set<String> prepositions =
            Collections.unmodifiableSet(Resources.getLines("/prepositions.txt").stream()
                    .map(String::toLowerCase).collect(Collectors.toSet()));
    public static final Set<String> adjectives =
            Collections.unmodifiableSet(Resources.getLines("/adjectives.txt").stream()
                    .map(String::toLowerCase).collect(Collectors.toSet()));
    public static final Set<String> adverbs =
            Collections.unmodifiableSet(Resources.getLines("/adverbs.txt").stream()
                    .map(String::toLowerCase).collect(Collectors.toSet()));
    public static final Set<String> verbs = Collections.unmodifiableSet(Resources
            .getLines("/verbs.txt").stream().map(String::toLowerCase).collect(Collectors.toSet()));
}
