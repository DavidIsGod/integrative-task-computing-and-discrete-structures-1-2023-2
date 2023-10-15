package model;

public interface IPriorityQueue<K, T> {


    K heapExtractMax ();
    K getmaX ();
    public String increaseKey(int position, K key);
    void insert (K key,T value);
    void delete(T value);

}
