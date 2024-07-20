package enunciado01;
import java.util.Scanner;

/*
Clase Nodo la cual nos sirve para cada nodo definido del arbol binario
*/
class Nodo {
    int valor;
    int repeticiones;
    Nodo izquierdo, derecho;

    public Nodo(int valor) {
        this.valor = valor;
        this.repeticiones = 1;
        this.izquierdo = this.derecho = null;
    }
}

/*
Clase necesaria para implementar las funciones del arbol binario como la inserción
*/
class ArbolBinarioBusqueda {
    Nodo raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    /*
    Funcion que inserta un nuevo nodo desde el main, esta funcion llama a una
    funcion recursiva la cual trabaja desde la clase
    */
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    /*
    Funcion insertar recursiva, ingresa nuevos nodos comparando su valor con la
    raiz (si es mayor al nodo va al nodo derecho, sino al izquierdo) y si se
    repite aumenta la varible contador definida
    */
    private Nodo insertarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = insertarRec(raiz.derecho, valor);
        } else {
            // Si el valor ya existe, incrementa el contador de repeticiones
            raiz.repeticiones++;
        }

        return raiz;
    }

    public void mostrarEnOrden() {
        mostrarEnOrdenRec(raiz);
    }
    /*
    Muestra los valores del arbol binario, muestra por pantalla el numero y
    la cantidad de repeticiones del mismo
    */
    private void mostrarEnOrdenRec(Nodo raiz) {
        if (raiz != null) {
            mostrarEnOrdenRec(raiz.izquierdo);
            System.out.println("Número: " + raiz.valor + ", Repeticiones: " + raiz.repeticiones);
            mostrarEnOrdenRec(raiz.derecho);
        }
    }
}

public class Enunciado01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de la matriz (n): ");
        int n = sc.nextInt();

        int[][] matriz = new int[n][n];
        System.out.println("Ingrese los números bajo la diagonal principal:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();

        // Insertar los elementos de la matriz en el árbol binario
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                abb.insertar(matriz[i][j]);
            }
        }

        // Mostrar los números en orden y sus repeticiones
        System.out.println("Números en orden y sus repeticiones:");
        abb.mostrarEnOrden();
    }
}
