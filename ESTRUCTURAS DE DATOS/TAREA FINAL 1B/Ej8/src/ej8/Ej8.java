package ej8;
//Done
import java.util.Random;

public class Ej8 {

    public static void main(String[] args) {
        // Constantes
        int nEstudiantes = 20;
        int nAsignaturas = 4;

        // Variables
        int[][] notas = new int[nEstudiantes][nAsignaturas];
        float[] promedioEstudiantes = new float[nEstudiantes];
        float[] promedioAsignaturas = new float[nAsignaturas];
        float promedioGeneral = 0;

        // Generación de datos aleatorios
        Random random = new Random();
        for (int i = 0; i < nEstudiantes; i++) {
            for (int j = 0; j < nAsignaturas; j++) {
                notas[i][j] = random.nextInt(11);
            }
        }

        // Cálculo del promedio de cada estudiante
        for (int i = 0; i < nEstudiantes; i++) {
            float promedioEstudiante = 0;
            for (int j = 0; j < nAsignaturas; j++) {
                promedioEstudiante += notas[i][j];
            }
            promedioEstudiantes[i] = promedioEstudiante / nAsignaturas;
        }

        // Cálculo del promedio de cada asignatura
        for (int j = 0; j < nAsignaturas; j++) {
            float promedioAsignatura = 0;
            for (int i = 0; i < nEstudiantes; i++) {
                promedioAsignatura += notas[i][j];
            }
            promedioAsignaturas[j] = promedioAsignatura / nEstudiantes;
        }

        // Cálculo del promedio general
        for (int i = 0; i < nEstudiantes; i++) {
            promedioGeneral += promedioEstudiantes[i];
        }
        promedioGeneral = promedioGeneral / nEstudiantes;
        
        // Impresion de matriz por pantalla
        System.out.println("Impresion de notas por pantalla en formato:");
        System.out.println("Estudiante N: Nota1 / Nota2 / Nota3 / Nota4");
        for (int i = 0; i < nEstudiantes; i++) {
            System.out.print("\nEstudiante #" + (i + 1) + ": ");
            for (int j = 0; j < nAsignaturas; j++) {
                System.out.print(notas[i][j] + " / ");
            }
            System.out.println();
        }

        // Impresión de resultados
        System.out.println("\nPromedio de cada estudiante:");
        for (int i = 0; i < nEstudiantes; i++) {
            System.out.printf("Estudiante %d: %.2f\n", i + 1, promedioEstudiantes[i]);
        }

        System.out.println("\nPromedio de cada asignatura:");
        for (int j = 0; j < nAsignaturas; j++) {
            System.out.printf("Asignatura %d: %.2f\n", j + 1, promedioAsignaturas[j]);
        }

        System.out.printf("\nPromedio general: %.2f\n", promedioGeneral);
    }

}
