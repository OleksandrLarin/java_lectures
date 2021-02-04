package lecture17.collections.map;

import java.util.HashMap;
import java.util.Map;

public class EntryExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(3, "Three");
        map.put(2, "Two");
        map.put(5, "Five");

        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }
        System.out.println(map);
    }
}
