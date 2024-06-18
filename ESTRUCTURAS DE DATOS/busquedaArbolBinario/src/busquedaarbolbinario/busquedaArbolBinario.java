package busquedaarbolbinario;
import java.util.Scanner;

/*
AUTORES: BYRON ALVAREZ - DANIEL CAMPOVERDE
*/

public class busquedaArbolBinario {

    public static Scanner sc = new Scanner(System.in);
    public static ArbolBinario arbol = new ArbolBinario();
    public static void main(String[] args) {
        boolean bandera = true;
        int nodo1;
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

        
        mostrarArbol();
        
        // Eliminar valores mayores del cuarto nivel
        System.out.println("Eliminando valores mayores del cuarto nivel...");
        arbol.eliminarCuartoNivelDerecha();
        System.out.println("Recorrido en inorden después de eliminar mayores del cuarto nivel:");
        arbol.recorrerInorden(arbol.raiz);
        System.out.println();
        
        // Eliminar valores menores del tercer nivel
        System.out.println("Eliminando valores menores del tercer nivel...");
        arbol.eliminarMenoresTercerNivel();
        System.out.println("Recorrido en inorden después de eliminar menores del tercer nivel:");
        arbol.recorrerInorden(arbol.raiz);
        System.out.println();

        
        
        System.out.println("\n\nResultado final en pantalla");
        mostrarArbol();
    }
    
    public static void mostrarArbol(){
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
