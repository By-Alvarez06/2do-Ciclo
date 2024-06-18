package busquedaarbolbinario;

import java.util.Scanner;

public class busquedaArbolBinario {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        boolean bandera = true;
        int raiz, nodo1, nodo2;
        String opcion;
        do {
            System.out.print("Ingrese el valor del nodo (o digite 's' para salir): ");
            if (sc.hasNextInt()) {
                nodo1 = sc.nextInt();
                arbol.agregar(nodo1);
            } else {
                opcion = sc.next();
                if (opcion.equals("s")) {
                    bandera = false;
                }
            }
            // Consumir el carácter de nueva línea restante si se ha ingresado un entero
            sc.nextLine();
            
            /*
            EXPLICACION DEL METODO AGREGAR CON UN EJEMPLO
            arbol.agregar(4); // Raíz
            arbol.agregar(2); // Nivel 1 - Izquierda
            arbol.agregar(6); // Nivel 1 - Derecha
            arbol.agregar(1); // Nivel 2 - Izquierda de 2
            arbol.agregar(3); // Nivel 2 - Derecha de 2
            arbol.agregar(5); // Nivel 2 - Izquierda de 6
            arbol.agregar(7); // Nivel 2 - Derecha de 6
            */
            
        } while (bandera);

        /*
        Arbol basado en la imagen: 
        https://slideplayer.es/slide/2971477/11/images/16/Recorrido+de+%C3%A1rboles+%284%29.jpg
         */
        System.out.println("Recorrido en preorden:");
        arbol.recorrerPreorden(arbol.raiz);
        System.out.println();

        System.out.println("Recorrido en inorden:");
        arbol.recorrerInorden(arbol.raiz);
        System.out.println();

        System.out.println("Recorrido en posorden:");
        arbol.recorrerPosorden(arbol.raiz);
        System.out.println();
    }

}
