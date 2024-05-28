/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problema_12;

import java.util.Scanner;

/**
 *
 * @author Usuario iTC
 */
public class Problema_12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de cursos: ");
        int numCursos = sc.nextInt(); 
        System.out.println("Ingres el numeero de alumnos: ");
        int numAlumnos = sc.nextInt(); 
        int[][] notas = new int[numAlumnos][numCursos];

        // Cargar notas de los alumnos
        for (int i = 0; i < numAlumnos; i++) {
            System.out.println("Ingrese las notas del alumno " + (i + 1) + ":");
            for (int j = 0; j < numCursos; j++) {
                System.out.println("Nota del curso " + (j + 1) + ":");
                notas[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matriz de notas:");
        mostrarMatriz(notas);
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
