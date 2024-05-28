/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problema_9;

import java.util.Scanner;

/**
 *
 * @author Usuario iTC
 */
public class Problema_9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Preguntar la cantidad de clientes
        System.out.println("Ingrese la cantidad de clientes:");
        int numClientes = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea

        // Crear arreglo de clientes con los nombres ingresados por teclado
        String[] clientes = new String[numClientes];
        for (int i = 0; i < numClientes; i++) {
            System.out.println("Ingrese el nombre del cliente " + (i + 1) + ":");
            clientes[i] = sc.nextLine();
        }

        // Matriz de asistencia (filas: clientes, columnas: días de la semana)
        boolean[][] asistencia = new boolean[numClientes][6];

        // Registrar asistencia
        for (int i = 0; i < numClientes; i++) {
            System.out.println("Registrando asistencia para " + clientes[i] + ":");
            for (int j = 0; j < 6; j++) {
                String dia = obtenerDia(j);
                System.out.println("¿Asistió el " + dia + "? (s/n)");
                String respuesta = sc.nextLine();
                asistencia[i][j] = respuesta.equalsIgnoreCase("s");
            }
        }

        // Calcular y mostrar clientes con descuento
        System.out.println("Clientes con descuento del 20%:");
        for (int i = 0; i < numClientes; i++) {
            int diasAsistidos = 0;
            for (int j = 0; j < 6; j++) {
                if (asistencia[i][j]) {
                    diasAsistidos++;
                }
            }
            if (diasAsistidos >= 3) {
                System.out.println(clientes[i]);
            }
        }
    }

    // Método para obtener el nombre del día de la semana según el índice
    public static String obtenerDia(int indice) {
        switch (indice) {
            case 0: return "lunes";
            case 1: return "martes";
            case 2: return "miércoles";
            case 3: return "jueves";
            case 4: return "viernes";
            case 5: return "sábado";
            default: return "";
        }
    }
    
}
