package arbolesavl;

import java.util.Scanner;
/*
AUTORES: BYRON ALVAREZ - DANIEL CAMPOVERDE
*/
public class Principal {

    public static void main(String[] args) {
        arbolAVL arbol = new arbolAVL();
        /*
        Arbol utilizado de ejemplo para comprobar su funcionamiento:
        https://lh4.googleusercontent.com/proxy/T6KhIj9PplAPcCWT7FGo238pNirXeMz6ImycUA81LOvlU_OPuZkVj_CjkUXbZ4XM1Iup1IqFSsdCbxS3aZ9c059iGSwdJ9Y
        */

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menu Arbol AVL ---");
            System.out.println("1. Insertar un valor");
            System.out.println("2. Eliminar un valor");
            System.out.println("3. Buscar un valor");
            System.out.println("4. Mostrar recorrido in-order");
            System.out.println("5. Mostrar recorrido pre-order");
            System.out.println("6. Mostrar recorrido post-order");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor a insertar: ");
                    int valorInsertar = scanner.nextInt();
                    arbol.insertar(valorInsertar);
                    System.out.println("Valor insertado.");
                    break;
                case 2:
                    System.out.print("Ingrese el valor a eliminar: ");
                    int valorEliminar = scanner.nextInt();
                    NodoAVL resultadoE = arbol.buscar(valorEliminar);
                    if (resultadoE != null) {
                        arbol.eliminar(valorEliminar);
                        System.out.println("Valor eliminado.");
                    } else {
                        System.out.println("Valor no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el valor a buscar: ");
                    int valorBuscar = scanner.nextInt();
                    NodoAVL resultado = arbol.buscar(valorBuscar);
                    if (resultado != null) {
                        System.out.println("Valor encontrado: " + resultado.valor);
                        arbol.buscarEnArbol(valorBuscar);
                    } else {
                        System.out.println("Valor no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Recorrido in-order:");
                    arbol.inOrder();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Recorrido pre-order:");
                    arbol.preOrder();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Recorrido post-order:");
                    arbol.postOrder();
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
                    break;
            }
        } while (opcion != 7);
    }

}
