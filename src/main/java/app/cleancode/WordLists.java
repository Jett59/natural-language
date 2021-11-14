package app.cleancode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordLists {
    public static final Set<String> nouns =
            Collections.unmodifiableSet(new HashSet<>(Resources.getLines("/nouns.txt")));
    public static final Set<String> prepositions =
            Collections.unmodifiableSet(new HashSet<>(Resources.getLines("/prepositions.txt")));
}
