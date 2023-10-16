package model;

public class Nodo<T> {
    T valor;
    private Nodo<T> siguiente;

    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    private Nodo<T> previous;

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getPrevious() {
        return previous;
    }

    public Nodo<T> getprevious() {
        return previous;
    }

    public T getValue() {

        return valor;
    }

    public void setValue(T valor) {
        this.valor = valor;
    }

    public void setPrevious(Nodo<T> previous) {
        this.previous = previous;
    }

}