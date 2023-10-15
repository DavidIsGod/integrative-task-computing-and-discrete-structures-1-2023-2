package model;

<<<<<<< HEAD
public class PriorityQueue<T>{
=======
public class PriorityQueue implements IPriorityQueue {
>>>>>>> f4836d7694b6ec8ec92f2cb1f560ca1004b02b0f

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
