/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problema_10;

import java.util.Scanner;

/**
 *
 * @author Usuario iTC
 */
public class Problema_10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de filas: ");
        int filas = sc.nextInt();
        System.out.println("Ingrese la cantidad de columnas: ");
        int columnas = sc.nextInt();
        char[][] asientos = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                asientos[i][j] = 'V';
            }
        }

        while (true) {
            System.out.println("Estado actual de los asientos:");
            mostrarAsientos(asientos);
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ocupar asiento");
            System.out.println("2. Liberar asiento");
            System.out.println("3. Salir");
            int opcion = sc.nextInt();

            if (opcion == 3) {
                break;
            }

            System.out.println("Ingrese el número de fila:");
            int fila = sc.nextInt() - 1;
            System.out.println("Ingrese el número de asiento:");
            int asiento = sc.nextInt() - 1;

            if (opcion == 1) {
                if (asientos[fila][asiento] == 'V') {
                    asientos[fila][asiento] = 'O';
                    System.out.println("Asiento ocupado.");
                } else {
                    System.out.println("El asiento ya está ocupado.");
                }
            } else if (opcion == 2) {
                if (asientos[fila][asiento] == 'O') {
                    asientos[fila][asiento] = 'V';
                    System.out.println("Asiento liberado.");
                } else {
                    System.out.println("El asiento ya está vacío.");
                }
            }
        }
    }

    public static void mostrarAsientos(char[][] asientos) {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println();
        }
    }

}
