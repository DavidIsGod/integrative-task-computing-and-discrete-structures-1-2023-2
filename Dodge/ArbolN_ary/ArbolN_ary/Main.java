package ArbolN_ary;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Arbol<Integer> arbol = new Arbol<>(1);
        Nodo<Integer> raiz = arbol.getRaiz();
        Nodo<Integer> hijo1 = new Nodo<>(2);
        Nodo<Integer> hijo2 = new Nodo<>(3);
        raiz.agregarHijo(hijo1);
        raiz.agregarHijo(hijo2);
        Nodo<Integer> nieto1 = new Nodo<>(4);
        hijo1.agregarHijo(nieto1);

        List<Integer> resultadoPosorden = arbol.posorden();
        System.out.println(resultadoPosorden); // Imprimirá [4, 2, 3, 1]
    }
}
