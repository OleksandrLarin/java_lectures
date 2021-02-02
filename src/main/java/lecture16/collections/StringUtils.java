package lecture16.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StringUtils {
    public static <T> List<T> getDuplicates(List<T> list) {
        List<T> duplicates = new ArrayList<>();
        for (T item : list) {
            if (list.indexOf(item) != list.lastIndexOf(item)) {
                if (!duplicates.contains(item)) {
                    duplicates.add(item);
                }
            }
        }
        return duplicates;
    }

    public static <T> List<T> getDuplicates_2(List<T> list) {
        Set<T> temp = new HashSet<>();
        Set<T> duplicates = new HashSet<>();
        for (T item : list) {
            if (!temp.add(item)) {
                duplicates.add(item);
            }
        }
        return new ArrayList<>(duplicates);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 1, 5, 6, 8, 9, 5);
        System.out.println(getDuplicates(numbers));

        List<String> words = List.of("a", "ab", "abc", "aa", "qwe");
        System.out.println(getLongestString(words));
    }

    public static String getLongestString(List<String> words) {
        Iterator<String> iterator = words.iterator();
        String temp = iterator.next();
        while (iterator.hasNext()) {
            String word = iterator.next();
            if (temp.length() <= word.length()) {
                temp = word;
            }
        }
        return temp;
    }
}
