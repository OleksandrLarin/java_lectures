package lecture19.trie;

public interface Trie<K, V> {
    public V get(K key);

    public boolean put(K key, V value);

    public V remove(K key);
}
