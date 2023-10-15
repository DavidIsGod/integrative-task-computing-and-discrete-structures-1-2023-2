package model;

public class Stack <T> {
    private Nodo<T> top;
    private int size;
    public Stack() {
        top = null;
        size = 0;
    }
    public void push(T value) {
        Nodo<T> newNode = new Nodo<T>(value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }
    public T peek() {
        if (top == null) {
            return null;
        }
        return top.getValue();
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


}
