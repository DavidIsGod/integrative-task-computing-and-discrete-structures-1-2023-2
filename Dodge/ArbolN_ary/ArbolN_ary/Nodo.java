package ArbolN_ary;

import java.util.ArrayList;
import java.util.List;

public class Nodo<T> {
    private T valor;
    private List<Nodo<T>> hijos;

    public Nodo(T valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>();
    }

    public T getValor() {
        return valor;
    }

    public List<Nodo<T>> getHijos() {
        return hijos;
    }

    public void agregarHijo(Nodo<T> hijo) {
        hijos.add(hijo);
    }
}
