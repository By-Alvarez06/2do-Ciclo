/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problema_11;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Usuario iTC
 */
public class Problema_11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner (System.in);
        System.out.println("Ingrese el numero de filas y columnas de la matriz: ");
        int n = sc.nextInt();
        int[][] matriz = new int[n][n];
        Random rand = new Random();

    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = rand.nextInt(99) + 1;
            }
        }

        System.out.println("Matriz original:");
        mostrarMatriz(matriz);

     a
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int temp = matriz[i][j];
                matriz[i][j] = matriz[n - 1 - j][n - 1 - i];
                matriz[n - 1 - j][n - 1 - i] = temp;
            }
        }

        System.out.println("Matriz transpuesta (sobre la diagonal secundaria):");
        mostrarMatriz(matriz);
    }
    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }
    
    
}
