package sortandmerge;

import java.util.Arrays;
import java.util.Comparator;

public class SortAnagram {
    public static void main(String[] args) {
        String[] s = new String[]{"ananas", "saanan", "cooking", "spiderman", "duck", "banana", "kingcoo"};
        Arrays.sort(s, new AnagramComparator());
        System.out.println(Arrays.toString(s));
    }
}

class AnagramComparator implements Comparator<String> {
    public String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }

    @Override
    public int compare(String s1, String s2) {
        return sort(s1).compareTo(sort(s2));
    }
}
