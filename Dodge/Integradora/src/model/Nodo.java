package model;

public class Nodo<T> {
    T valor;
    Nodo<T> siguiente;

    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    private Nodo<T> next;
    private Nodo<T> previous;




    public Nodo<T> getprevious() {
        return previous;
    }

    public T getValue() {
        return valor;
    }

    public void setValue (T valor) {
        this.valor = valor;
    }

    public Nodo <T> getNext() {
        return next.getNext();
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public void setPrevious(Nodo<T> previous) {
        this.previous = previous;
    }




}