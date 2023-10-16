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
            size++;

        } else {
            last.setNext(nuevoNodo);
            last = nuevoNodo;
            size++;
        }
        setSize(size);
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

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void delete(T value) {
        Nodo<T> current = first;
        Nodo<T> previous = null;
        while (current != null) {
            if (current.getValue().equals(value)) {
                if (previous == null) {
                    first = first.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de límites");
        }

        Nodo<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getValue();
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        Nodo<T> current = first;
        while (current != null) {
            result.append(current.getValue()).append("\n");
            current = current.getNext();
        }
        return result.toString();
    }
}
