package model;

public class Stack <K,T> {
    private Nodo<T> top;

    private int size = 0;

    public Stack() {

    }



    public boolean push(T value) {
        Nodo<T> nuevoNodo = new Nodo<>(value);
        boolean flag = false;
        if (top == null) {
            top = nuevoNodo;
        } else {
            nuevoNodo.setNext(top);
            top = nuevoNodo;
        }
        size++;
        return flag;

    }


    public T pop() {
        T value = null;
        if (top != null) {
            value = top.getValue();
            top = top.getNext();
            size--;
        }
        return value;
    }

    public T peek() {
        T value = null;
        if (top != null) {
            value = top.getValue();
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
