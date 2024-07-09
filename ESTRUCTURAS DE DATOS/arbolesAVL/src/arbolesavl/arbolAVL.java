package arbolesavl;

public class arbolAVL {
    private NodoAVL raiz;

    // Método para obtener la altura de un nodo
    private int obtenerAltura(NodoAVL nodo) {
        if (nodo == null) return 0;
        return nodo.altura;
    }

    // Método para obtener el factor de balance de un nodo
    private int obtenerBalance(NodoAVL nodo) {
        if (nodo == null) return 0;
        return obtenerAltura(nodo.izquierdo) - obtenerAltura(nodo.derecho);
    }

    // Método para rotar a la derecha
    private NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        y.altura = Math.max(obtenerAltura(y.izquierdo), obtenerAltura(y.derecho)) + 1;
        x.altura = Math.max(obtenerAltura(x.izquierdo), obtenerAltura(x.derecho)) + 1;

        return x;
    }

    // Método para rotar a la izquierda
    private NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        x.altura = Math.max(obtenerAltura(x.izquierdo), obtenerAltura(x.derecho)) + 1;
        y.altura = Math.max(obtenerAltura(y.izquierdo), obtenerAltura(y.derecho)) + 1;

        return y;
    }

    // Método para insertar un nodo
    public NodoAVL insertar(NodoAVL nodo, int valor) {
        if (nodo == null) return new NodoAVL(valor);

        if (valor < nodo.valor)
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        else if (valor > nodo.valor)
            nodo.derecho = insertar(nodo.derecho, valor);
        else // No se permiten valores duplicados en el árbol AVL
            return nodo;

        nodo.altura = 1 + Math.max(obtenerAltura(nodo.izquierdo), obtenerAltura(nodo.derecho));

        int balance = obtenerBalance(nodo);

        // Rotaciones para balancear el árbol
        if (balance > 1 && valor < nodo.izquierdo.valor)
            return rotarDerecha(nodo);

        if (balance < -1 && valor > nodo.derecho.valor)
            return rotarIzquierda(nodo);

        if (balance > 1 && valor > nodo.izquierdo.valor) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        if (balance < -1 && valor < nodo.derecho.valor) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    // Método público para insertar
    public void insertar(int valor) {
        raiz = insertar(raiz, valor);
    }

    // Métodos para los recorridos (in-order, pre-order, post-order)
    public void inOrder(NodoAVL nodo) {
        if (nodo != null) {
            inOrder(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inOrder(nodo.derecho);
        }
    }

    public void preOrder(NodoAVL nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preOrder(nodo.izquierdo);
            preOrder(nodo.derecho);
        }
    }

    public void postOrder(NodoAVL nodo) {
        if (nodo != null) {
            postOrder(nodo.izquierdo);
            postOrder(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    public void inOrder() { inOrder(raiz); }
    public void preOrder() { preOrder(raiz); }
    public void postOrder() { postOrder(raiz); }
    
    // Método para buscar un valor específico y obtener información adicional
    public void buscarEnArbol(int valor) {
        buscar(raiz, valor, 0, "Raíz");
    }

    private void buscar(NodoAVL nodo, int valor, int nivel, String rama) {
        if (nodo == null) {
            System.out.println("Valor no encontrado.");
            return;
        }

        if (valor == nodo.valor) {
            System.out.println("Valor encontrado: " + valor);
            System.out.println("Nivel: " + nivel);
            System.out.println("Rama: " + rama);
            return;
        }

        if (valor < nodo.valor)
            buscar(nodo.izquierdo, valor, nivel + 1, "Izquierda");
        else
            buscar(nodo.derecho, valor, nivel + 1, "Derecha");
    }
    
    
    // Método para buscar un valor específico
    public NodoAVL buscar(NodoAVL nodo, int valor) {
        if (nodo == null || nodo.valor == valor)
            return nodo;

        if (nodo.valor > valor)
            return buscar(nodo.izquierdo, valor);

        return buscar(nodo.derecho, valor);
    }

    public NodoAVL buscar(int valor) {
        return buscar(raiz, valor);
    }
    
    // Implementación de eliminación
    public NodoAVL eliminar(NodoAVL nodo, int valor) {
        if (nodo == null) return nodo;

        if (valor < nodo.valor)
            nodo.izquierdo = eliminar(nodo.izquierdo, valor);
        else if (valor > nodo.valor)
            nodo.derecho = eliminar(nodo.derecho, valor);
        else {
            if ((nodo.izquierdo == null) || (nodo.derecho == null)) {
                NodoAVL temp = null;
                if (temp == nodo.izquierdo) temp = nodo.derecho;
                else temp = nodo.izquierdo;

                if (temp == null) {
                    temp = nodo;
                    nodo = null;
                } else nodo = temp;
            } else {
                NodoAVL temp = obtenerMinimo(nodo.derecho);
                nodo.valor = temp.valor;
                nodo.derecho = eliminar(nodo.derecho, temp.valor);
            }
        }

        if (nodo == null) return nodo;

        nodo.altura = Math.max(obtenerAltura(nodo.izquierdo), obtenerAltura(nodo.derecho)) + 1;

        int balance = obtenerBalance(nodo);

        if (balance > 1 && obtenerBalance(nodo.izquierdo) >= 0)
            return rotarDerecha(nodo);

        if (balance > 1 && obtenerBalance(nodo.izquierdo) < 0) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        if (balance < -1 && obtenerBalance(nodo.derecho) <= 0)
            return rotarIzquierda(nodo);

        if (balance < -1 && obtenerBalance(nodo.derecho) > 0) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    public void eliminar(int valor) {
        raiz = eliminar(raiz, valor);
    }

    private NodoAVL obtenerMinimo(NodoAVL nodo) {
        NodoAVL actual = nodo;
        while (actual.izquierdo != null) actual = actual.izquierdo;
        return actual;
    }
}
