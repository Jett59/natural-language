package app.cleancode;

import java.util.Collections;
import java.util.List;

public class WordLists {
    public static final List<String> nouns =
            Collections.unmodifiableList(Resources.getLines("/nouns.txt"));
}
