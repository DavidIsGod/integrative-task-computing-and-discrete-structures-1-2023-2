package ArbolN_ary;

import java.util.ArrayList;
import java.util.List;

public class Arbol<T> {
    private Nodo<T> raiz;

    public Arbol(T valorRaiz) {
        raiz = new Nodo<>(valorRaiz);
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public void agregarHijo(Nodo<T> padre, Nodo<T> nuevoHijo) {
        if (padre != null) {
            padre.agregarHijo(nuevoHijo);
        } else {

            System.err.println("Error: El nodo padre es nulo.");
        }
    }

    // Otras operaciones como agregar un hijo a un nodo, recorridos, etc.

    public List<T> preorden() {
        List<T> resultado = new ArrayList<>();
        preordenRecursivo(raiz, resultado);
        return resultado;
    }

    private void preordenRecursivo(Nodo<T> nodo, List<T> resultado) {
        if (nodo == null) {
            return;
        }
        resultado.add(nodo.getValor());
        for (Nodo<T> hijo : nodo.getHijos()) {
            preordenRecursivo(hijo, resultado);
        }
    }

    public List<T> posorden() {
        List<T> resultado = new ArrayList<>();
        posordenRecursivo(raiz, resultado);
        return resultado;
    }

    private void posordenRecursivo(Nodo<T> nodo, List<T> resultado) {
        if (nodo == null) {
            return;
        }
        for (Nodo<T> hijo : nodo.getHijos()) {
            posordenRecursivo(hijo, resultado);
        }
        resultado.add(nodo.getValor());
    }
}
