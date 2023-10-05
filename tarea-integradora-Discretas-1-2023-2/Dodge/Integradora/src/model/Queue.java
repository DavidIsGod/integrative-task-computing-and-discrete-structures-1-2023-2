package model;



public class Queue<T> {


    private Nodo<T> first;
    private Nodo<T> last;

    private int size = 0;

    public Queue() {

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

    public T dequeue() {
        T value = null;
        if (first != null) {
            value = first.getValue();
            first = first.getNext();
            size--;
        }
        return value;
    }

    public T peek() {
        T value = null;
        if (first != null) {
            value = first.getValue();
        }
        return value;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }









}
