package model;

public interface IPriorityQueue<K, T> {

    K heapExtractMax ();
    K getmaX ();
    String increaseKey(int position, K key);
    void add(K key,T value);
    void delete(T value);
    int getSize();
    //T get(int index);
}
