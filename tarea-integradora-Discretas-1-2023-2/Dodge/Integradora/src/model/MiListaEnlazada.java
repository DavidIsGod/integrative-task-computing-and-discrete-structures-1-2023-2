package model;

class MiListaEnlazada<T> {
    private Nodo<T> cabeza;
    private int tamaño;

    public MiListaEnlazada() {
        cabeza = null;
        tamaño = 0;
    }

    public void agregar(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamaño++;
    }

    public void mostrar() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public void eliminar(T valor) {
        if (cabeza == null) {
            return; // La lista está vacía, no hay elementos que eliminar
        }

        if (cabeza.valor.equals(valor)) {
            cabeza = cabeza.siguiente;
            tamaño--;
            return; // El elemento estaba al principio de la lista
        }

        Nodo<T> actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.valor.equals(valor)) {
                actual.siguiente = actual.siguiente.siguiente;
                tamaño--;
                return; // El elemento se eliminó
            }
            actual = actual.siguiente;
        }
    }

    public int obtenerTamaño() {
        return tamaño;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public int getTamaño() {
        return tamaño;
    }

}