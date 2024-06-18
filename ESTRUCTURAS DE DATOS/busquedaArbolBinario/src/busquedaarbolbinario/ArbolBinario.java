package busquedaarbolbinario;

public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }
    
    // Método para agregar un valor al árbol
    public void agregar(int valor) {
        raiz = agregarRecursivo(raiz, valor);
    }

    // Método recursivo para agregar un valor al árbol
    private Nodo agregarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            nodo = new Nodo(valor);
            nodo.derecha = null;
            nodo.izquierda = null;
            return nodo;
        }

        if (valor < nodo.valor) {
            nodo.izquierda = agregarRecursivo(nodo.izquierda, valor);
        } else {
            nodo.derecha = agregarRecursivo(nodo.derecha, valor);
        }

        return nodo;
    }

    // Método para recorrer el árbol en preorden
    public void recorrerPreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " "); // Visitar nodo
            recorrerPreorden(nodo.izquierda);  // Recorrer subárbol izquierdo
            recorrerPreorden(nodo.derecha);    // Recorrer subárbol derecho
        }
    }

    // Método para recorrer el árbol en inorden
    public void recorrerInorden(Nodo nodo) {
        if (nodo != null) {
            recorrerInorden(nodo.izquierda);  // Recorrer subárbol izquierdo
            System.out.print(nodo.valor + " "); // Visitar nodo
            recorrerInorden(nodo.derecha);    // Recorrer subárbol derecho
        }
    }

    // Método para recorrer el árbol en posorden
    public void recorrerPosorden(Nodo nodo) {
        if (nodo != null) {
            recorrerPosorden(nodo.izquierda);  // Recorrer subárbol izquierdo
            recorrerPosorden(nodo.derecha);    // Recorrer subárbol derecho
            System.out.print(nodo.valor + " "); // Visitar nodo
        }
    }
}
