package model;

public interface IPriorityQueue<T> {

    void insert(T value);

    T extractMax();

    T max();

    int getSize();

    boolean isEmpty();

    void heapify(int index);

    boolean enqueue(T value);

    boolean dequeue();

    T peek();


}
