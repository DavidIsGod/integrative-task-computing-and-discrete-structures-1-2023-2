package model;

public class TaskHashTable<K, V> implements IHashTable<K, V> {

    private HashNode<K, V>[] table;
    private int size;

    public TaskHashTable(int size) {
        this.size = size;
        this.table = new HashNode[size];
    }

    public int hash(K key) {
        return key.hashCode() % size;
    }

    @Override
    public void add(K key, V value) {
        int index = hash(key);
        HashNode<K, V> nodeToAdd = new HashNode<K, V>(key, value);
        if (table[index] == null) {
            table[index] = nodeToAdd;
        } else {
            nodeToAdd.setNext(table[index]);
            table[index] = nodeToAdd;
        }
    }

    @Override
    public V search(K key) {
        int index = hash(key);
        return search(table[index], key);
    }

    private V search(HashNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        if (node.getKey().equals(key)) {
            return node.getValue();
        }
        return search(node.getNext(), key);
    }

    @Override
    public void delete(K key) {
        int index = hash(key);
        if (table[index].getKey().equals(key)) {
            table[index] = table[index].getNext();
        }
        delete(table[index], key);
    }

    private void delete(HashNode<K, V> node, K key) {
        if (node == null) {
            return;
        }
        if (node.getKey().equals(key)) {
            node = node.getNext();
            return;
        }
    }

    @Override
    public String print() {
        return "";
    }


}
