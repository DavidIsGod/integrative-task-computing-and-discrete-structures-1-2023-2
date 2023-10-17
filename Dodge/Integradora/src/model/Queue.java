package model;

public class Queue<T> {

    private Nodo<T> first;
    private Nodo<T> last;

    private int size = 0;

    public Queue() {

    }

    public boolean enqueue(T value) {
        Nodo<T> newNode = new Nodo<>(value);
        boolean flag = false;
        if (first == null) {
            first = newNode;
            last = newNode;
            size++;
        } else {
            last.setSiguiente(newNode);
            last = newNode;
            size++;
        }
        setSize(size);
        return flag;

    }

    public T dequeue() {
        T value = null;
        if (first != null) {
            value = first.getValue();
            first = first.getSiguiente();
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
                    first = first.getSiguiente();
                } else {
                    previous.setSiguiente(current.getSiguiente());
                }
                size--;
                return;
            }
            previous = current;
            current = current.getSiguiente();
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }

        Nodo<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getSiguiente();
        }

        return current.getValue();
    }

    public String print() {
        if (first == null) {
            return "Queue is empty";
        }
        return print(first);

    }

    private String print(Nodo<T> current) {
        if (current == null) {
            return "";
        }
        return current.getValue().toString() + "\n" + print(current.getSiguiente());
    }

}
