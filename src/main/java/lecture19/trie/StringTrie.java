package lecture19.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringTrie<V> implements Trie<String, V> {

    private Node<V> baseNode = new Node<>();
    private Node<V> currentNode;

    @Override
    public V get(String key) {
        resetCurrentNode();
        if (key == null) {
            throw new IllegalArgumentException("null value is not allowed here!!!");
        }
        findNodeByKey(key);
        if (currentNode == null || currentNode.isTransitional) {
            return null;
        }
        return currentNode.value;
    }

    private void findNodeByKey(String key) {
        for (int i = 0; i < key.length(); i++) {
            String k = getCharByIndex(key, i);
            currentNode = findNode(k);
            if (currentNode == null) {
                break;
            }
        }
    }

    private String getCharByIndex(String key, int i) {
        return String.valueOf(key.charAt(i));
    }

    @Override
    public boolean put(String key, V value) {
        resetCurrentNode();

        for (int i = 0; ; i++) {
            if (i == key.length()) {
                currentNode.isTransitional = false;
                currentNode.value = value;
                break;
            }
            String k = getCharByIndex(key, i);
            currentNode = getNode(k);
        }
        resetCurrentNode();
        return true;
    }

    private void resetCurrentNode() {
        currentNode = baseNode;
    }

    private Node<V> getNode(String k) {
        Node<V> newNode = findNode(k);
        if (newNode == null) {
            newNode = createNewNode(k);
            currentNode.children.add(newNode);
        }

        return newNode;
    }

    private Node<V> findNode(String k) {
        for (Node<V> node : currentNode.children) {
            if (Objects.equals(node.key, k)) {
                return node;
            }
        }
        return null;
    }

    private Node<V> createNewNode(String k) {
        Node<V> node = new Node<>();
        node.key = k;
        return node;
    }


    @Override
    public V remove(String key) {
        resetCurrentNode();
        findNodeByKey(key);
        if (currentNode != null){
            currentNode.isTransitional = true;
            return currentNode.value;
        }
        return null;
    }

    private class Node<V> {

        Node() {
            key = "";
        }

        Node(String key, V value) {
            this.key = key;
            this.value = value;
        }

        String key;
        V value;
        boolean isTransitional = true;
        List<Node<V>> children = new ArrayList<>();
    }
}
