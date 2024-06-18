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

    public Nodo eliminar(Nodo raiz, int valor) {
        if (raiz == null) {
            return raiz;
        }

        // Caso 1: Si el valor a eliminar es menor que el valor de la raíz, recursivamente eliminar en el subárbol izquierdo
        if (valor < raiz.valor) {
            raiz.izquierda = eliminar(raiz.izquierda, valor);
        } // Caso 2: Si el valor a eliminar es mayor que el valor de la raíz, recursivamente eliminar en el subárbol derecho
        else if (valor > raiz.valor) {
            raiz.derecha = eliminar(raiz.derecha, valor);
        } // Caso 3: Valor encontrado, realizar la eliminación
        else {
            // Caso 1 y Caso 2: Nodo con un solo hijo o sin hijos
            if (raiz.izquierda == null) {
                return raiz.derecha;
            } else if (raiz.derecha == null) {
                return raiz.izquierda;
            }

            // Caso 3: Nodo con dos hijos, encontrar el sucesor en orden (mínimo en el subárbol derecho)
            raiz.valor = encontrarMinimo(raiz.derecha).valor;

            // Eliminar el sucesor en orden
            raiz.derecha = eliminar(raiz.derecha, raiz.valor);
        }

        return raiz;
    }

// Función auxiliar para encontrar el nodo con el valor mínimo en un subárbol
    public Nodo encontrarMinimo(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.izquierda != null) {
            actual = actual.izquierda;
        }
        return actual;
    }

    public void eliminarMenoresTercerNivel() {
        eliminarMenoresTercerNivelRecursivo(raiz, 1);
    }

    private void eliminarMenoresTercerNivelRecursivo(Nodo nodo, int nivel) {
        if (nodo == null) {
            return;
        }

        if (nivel == 2) {
            if (nodo.izquierda != null) {
                nodo.izquierda = eliminar(nodo.izquierda, nodo.izquierda.valor);
            }
        } else {
            eliminarMenoresTercerNivelRecursivo(nodo.izquierda, nivel + 1);
            eliminarMenoresTercerNivelRecursivo(nodo.derecha, nivel + 1);
        }
    }

    public void eliminarCuartoNivelDerecha() {
        eliminarCuatroNivelDerechaRecursivo(raiz, 1);
    }

    private void eliminarCuatroNivelDerechaRecursivo(Nodo nodo, int nivel) {
        if (nodo == null) {
            return;
        }

        if (nivel == 3) { // Tercer nivel
            if (nodo.derecha != null) {
                nodo.derecha = eliminar(nodo.derecha, nodo.derecha.valor);
            }
        } else if (nivel == 4) { // Cuarto nivel
            if (nodo.derecha != null) {
                nodo.derecha = eliminar(nodo.derecha, nodo.derecha.valor);
            }
        } else {
            eliminarCuatroNivelDerechaRecursivo(nodo.izquierda, nivel + 1);
            eliminarCuatroNivelDerechaRecursivo(nodo.derecha, nivel + 1);
        }
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
