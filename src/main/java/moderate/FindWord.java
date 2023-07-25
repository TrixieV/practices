package moderate;

import java.util.HashMap;

public class FindWord {

    private static HashMap<String, Integer> dict(String[] book) {
        HashMap<String, Integer> dictionary = new HashMap<>();
        for (String word : book) {
            word = word.toLowerCase().trim();
            if (!word.equals("")) {
                if (!dictionary.containsKey(word)) {
                    dictionary.put(word, 1);
                }
                else {
                    int count = dictionary.get(word);
                    dictionary.put(word, count++);
                }
            }

        }
        return dictionary;
    }

    private static Integer wordFound(String word, String[] book) {
        HashMap<String, Integer> dict = new HashMap<>();
        dict = dict(book);
        word = word.toLowerCase().trim();
        return dict.get(word);
    }
}
