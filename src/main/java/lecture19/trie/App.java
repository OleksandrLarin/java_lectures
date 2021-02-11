package lecture19.trie;

public class App {
    public static void main(String[] args) {
        StringTrie<String> trie = new StringTrie<>();
        trie.put("a", "A");
        trie.put("bc", "BC");
        trie.put("bcd", "BCD");

        System.out.println("key a:" + trie.get("a"));
        System.out.println("key bc:" + trie.get("bc"));
        System.out.println("key bcd:" + trie.get("bcd"));
        System.out.println("key D:" + trie.get("D"));

        System.out.println("remove 'bc':" + trie.remove("bc"));
        trie.put("bc", "BC1");

        System.out.println("key bc:" + trie.get("bc"));
    }
}
