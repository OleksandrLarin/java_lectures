package lecture17.collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtils {
    public static void main(String[] args) {
        List<String> words = List.of("one", "two", "three", "four", "five", "six");
        Map<Integer, List<String>> map = countWords(words);

        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("one","один");
        dictionary.put("two","два");
        dictionary.put("three","три");

        Map<String, String> translatedWords = translate(dictionary);

        System.out.println(translatedWords);
    }

    private static Map<String, String> translate(Map<String, String> dictionary) {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, String> entry: dictionary.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    private static Map<Integer, List<String>> countWords(List<String> list) {
        Map<Integer, List<String>> words = new HashMap<>();
        for (String word : list){
            if (words.containsKey(word.length())) {
                List<String> strings = words.get(word.length());
                strings.add(word);
            } else {
                ArrayList<String> wordList = new ArrayList<>();
                wordList.add(word);
                words.put(word.length(), wordList);
            }
        }
        return words;
    }
}
