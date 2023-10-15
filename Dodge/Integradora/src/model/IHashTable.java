package model;

public interface IHashTable <K,V> {
    public void add(K key, V value);
    public V search(K key);
    public void delete(K key);
    public String print();
    
}