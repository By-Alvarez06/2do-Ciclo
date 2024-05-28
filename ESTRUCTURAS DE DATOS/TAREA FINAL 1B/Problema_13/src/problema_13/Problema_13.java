/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problema_13;

import java.util.Scanner;

/**
 *
 * @author Usuario iTC
 */
public class Problema_13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        // Ingreso de estudiantes
        System.out.println("Ingrese la cantidad de estudiantes:");
        int numEstudiantes = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea

        String[] estudiantes = new String[numEstudiantes];
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println("Ingrese el nombre del estudiante " + (i + 1) + ":");
            estudiantes[i] = sc.nextLine();
        }

        // Ingreso de cursos
        System.out.println("Ingrese la cantidad de cursos:");
        int numCursos = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea

        String[] cursos = new String[numCursos];
        for (int i = 0; i < numCursos; i++) {
            System.out.println("Ingrese el nombre del curso " + (i + 1) + ":");
            cursos[i] = sc.nextLine();
        }

        // Ingreso de notas
        int[][] notas = new int[numEstudiantes][numCursos];
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println("Ingrese las notas de " + estudiantes[i] + ":");
            for (int j = 0; j < numCursos; j++) {
                System.out.println("Nota en " + cursos[j] + ":");
                notas[i][j] = sc.nextInt();
            }
        }

        sc.nextLine(); // Consumir la nueva línea

        // Búsqueda de notas
        System.out.println("Ingrese el nombre del estudiante para buscar su nota:");
        String estudiante = sc.nextLine();
        System.out.println("Ingrese el nombre del curso:");
        String curso = sc.nextLine();

        int indiceEstudiante = -1;
        int indiceCurso = -1;

        // Buscar el índice del estudiante
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].equalsIgnoreCase(estudiante)) {
                indiceEstudiante = i;
                break;
            }
        }

        // Buscar el índice del curso
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i].equalsIgnoreCase(curso)) {
                indiceCurso = i;
                break;
            }
        }

        // Imprimir la nota si se encontraron los índices
        if (indiceEstudiante != -1 && indiceCurso != -1) {
            System.out.println(estudiante + " tiene " + notas[indiceEstudiante][indiceCurso] + " en " + curso);
        } else {
            System.out.println("Estudiante o curso no encontrado.");
        }
    }
}
