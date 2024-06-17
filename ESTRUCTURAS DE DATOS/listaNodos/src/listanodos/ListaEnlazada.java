package listanodos;
import java.util.Scanner;

public class ListaEnlazada {
    Nodo primero;
    Nodo ultimo;

    // Constructor
    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
    }

    // Método para imprimir la lista
    public void imprimir() {
        Nodo actual = primero;
        System.out.println("Lista de nodos:");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Método para eliminar un nodo con un dato específico, solicitando al usuario el dato
    public void eliminar() {
        /*
        Si no se ha ingresado ningun dato aun por pantalla, no se realiza todo
        el proceso de la funcion
        */
        if (primero == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el dato del nodo que desea eliminar: ");
        int dato = scanner.nextInt();

        if (primero.dato == dato) {
            primero = primero.siguiente;
            if (primero == null) {
                ultimo = null;
            }
            System.out.println("Nodo eliminado.");
            return;
        }

        Nodo actual = primero;
        while (actual.siguiente != null && actual.siguiente.dato != dato) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            if (actual.siguiente == null) {
                ultimo = actual;
            }
            System.out.println("Nodo eliminado.");
        } else {
            System.out.println("El dato no se encontró en la lista.");
        }
    }

    // Método para insertar un nodo en una posición específica de la lista, solicitando al usuario la posición
    public void insertar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el dato del nodo que desea insertar: ");
        int dato = scanner.nextInt();
        System.out.print("Ingrese la posición en la lista donde desea insertar el nodo: ");
        int posicion = scanner.nextInt();

        Nodo nuevoNodo = new Nodo(dato);

        if (posicion <= 0) {
            System.out.println("Posición inválida.");
            return;
        }

        if (posicion == 1) {
            nuevoNodo.siguiente = primero;
            primero = nuevoNodo;
            if (ultimo == null) {
                ultimo = nuevoNodo;
            }
            System.out.println("Nodo insertado al principio de la lista.");
            return;
        }

        Nodo actual = primero;
        int contador = 1;
        while (actual != null && contador < posicion - 1) {
            actual = actual.siguiente;
            contador++;
        }
        if (actual != null) {
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
            if (actual == ultimo) {
                ultimo = nuevoNodo;
            }
            System.out.println("Nodo insertado en la posición " + posicion + " de la lista.");
        } else {
            System.out.println("La posición excede el tamaño actual de la lista.");
        }
    }

    // Método para buscar un nodo con un dato específico
    public void buscar(int dato) {
        Nodo actual = primero;
        boolean respuesta = false;
       
        int c = 1;
        while (actual != null) {
            if (actual.dato == dato) {
                respuesta = true;
                System.out.println("El elemento "+dato+" se encuentra en la posicion "+c);
            }
            actual = actual.siguiente;
            c++;
        }
        if (!respuesta){
            System.out.println("ELEMENTO NO ENCONTRADO");
        } 
    }
}
