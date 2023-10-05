package model;

class Nodo<T> {
    T valor;
    Nodo<T> siguiente;

    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}