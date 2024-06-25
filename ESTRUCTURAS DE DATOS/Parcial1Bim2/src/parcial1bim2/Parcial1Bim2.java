package parcial1bim2;

import java.util.Scanner;

public class Parcial1Bim2 {

    public static Scanner sc = new Scanner(System.in);
    public static ArbolBinario arbol = new ArbolBinario();

    public static void main(String[] args) {
        System.out.println("Ingrese la expresión (sin espacios) para definir su arbol binario:");
        String expresion = sc.nextLine();

        for (int i = 0; i < expresion.length(); i++) {
            String valor = String.valueOf(expresion.charAt(i));
            // Si es un operador, se agrega como raíz del árbol
            if (esOperador(valor)) {
                arbol.agregarComoRaiz(valor);
            } else {
                arbol.agregar(valor); // Si es un operando, se agrega como nodo hoja
            }
        }

        mostrarArbol();
    }

    /*
    Funcion para comprobar al recorrer la expresion, si es un operador, este se
    ingresa al arbol como raiz
     */
    public static boolean esOperador(String valor) {
        return valor.equals("+") || valor.equals("-") || valor.equals("*") || valor.equals("/");
    }

    public static void mostrarArbol() {
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
