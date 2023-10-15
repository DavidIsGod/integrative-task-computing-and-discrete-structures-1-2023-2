package model;

public class PriorityQueue implements IPriorityQueue {

    private Nodo<T> first;

    private Nodo<T> last;

    private int size = 0;

    public PriorityQueue() {

    }

    public boolean enqueue(T value) {
        Nodo<T> nuevoNodo = new Nodo<>(value);
        boolean flag = false;
        if (first == null) {
            first = nuevoNodo;
            last = nuevoNodo;
        } else {
            last.setNext(nuevoNodo);
            last = nuevoNodo;
        }
        size++;
        return flag;

    }
}
