package listanodos;

import java.util.Scanner;

/*
Autores: BYRON ALVAREZ - DANIEL CAMPOVERDE
 */
public class ListaNodos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        /*
        Se instancia un objeto de tipo ListaEnlazada para apartir de ahi llamar
        a los metodos de la clase (insertar, eliminar...)
        */
        ListaEnlazada L = new ListaEnlazada();
        do {
            System.out.println("\nLista de acciones con listas enlazadas:");
            System.out.println("""
                           1. Insertar Nodo
                           2. Eliminar Nodo
                           3. Buscar un Nodo
                           4. Recorrer un Nodo
                           5. Salir del programa
                           
                           Ingrese la opción: """);
            opcion = sc.nextInt();
            System.out.println();
            int nuevoNodo;
            switch (opcion) {
                case 1:
                    L.insertar();
                    break;
                case 2:
                    L.eliminar();
                    break;
                case 3:
                    System.out.println("Ingrese el elemento a buscar: ");
                    nuevoNodo = sc.nextInt();
                    L.buscar(nuevoNodo);
                    L.imprimir();
                    break;
                case 4:
                    L.imprimir();
                    break;
                case 5:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 5);
    }

}
