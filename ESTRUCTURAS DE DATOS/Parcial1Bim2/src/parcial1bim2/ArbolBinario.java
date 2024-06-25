package parcial1bim2;

public class ArbolBinario {

    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Método para agregar un nodo al árbol con un valor
    public void agregar(String valor) {
        raiz = agregarRecursivo(raiz, valor);
    }

    // Método recursivo para agregar un nodo con un valor al árbol
    private Nodo agregarRecursivo(Nodo nodo, String valor) {
        if (nodo == null) {
            nodo = new Nodo(valor);
            nodo.derecha = null;
            nodo.izquierda = null;
        } else {
            // Agregar de forma alternada izquierda y derecha
            if (nodo.izquierda == null) {
                nodo.izquierda = new Nodo(valor);
            } else if (nodo.derecha == null) {
                nodo.derecha = new Nodo(valor);
            } else {
                // Si ambos hijos están ocupados, agregar al hijo izquierdo
                nodo.izquierda = agregarRecursivo(nodo.izquierda, valor);
            }
        }
        return nodo;
    }

    // Método para agregar un nodo como raíz del árbol
    public void agregarComoRaiz(String valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.izquierda = raiz; // El nodo actual raíz se convierte en hijo izquierdo del nuevo nodo
        nuevoNodo.derecha = null;   // Por ahora el nuevo nodo no tiene hijo derecho

        raiz = nuevoNodo; // El nuevo nodo se convierte en la nueva raíz del árbol
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
