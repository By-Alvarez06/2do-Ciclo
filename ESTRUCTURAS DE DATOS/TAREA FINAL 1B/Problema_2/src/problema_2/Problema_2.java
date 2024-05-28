/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problema_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario iTC
 */
public class Problema_2 {

    /**
     * @param args the command line arguments
     */
    
    public static String cedula, apellidos, nombres, fecha, alergias, datos[];
    public static double peso, estatura;

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int num;

        System.out.println("¿Cuantos pacientes va a ingresar?: ");
        num = sc.nextInt();
        sc.nextLine();
        for (int c = 0; c < num; c++) {
            System.out.println("Ingrese la cédula del paciente " + (c + 1) + ": ");
            cedula = sc.nextLine();
            System.out.println("Ingrese los apellidos del paciente: ");
            apellidos = sc.nextLine();
            System.out.println("Ingrese los nombres del paciente: ");
            nombres = sc.nextLine();
            System.out.println("Ingrese la fecha de nacimiento del paciente: ");
            fecha = sc.nextLine();
            System.out.println("Ingrese la estatura del paciente: ");
            estatura = sc.nextDouble();
            System.out.println("Ingrese el peso del paciente: ");
            peso = sc.nextDouble();
            sc.nextLine();
            System.out.println("Ingrese las alergias del paciente;");
            alergias = sc.nextLine();
            escribirArchivo();

        }
        mostrarPacientes();
    }

    public static void escribirArchivo() {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter("data/" + "Pacientes.txt", true))) {
            bw.write("Cédula de identidad: "+ cedula +";"+
                    "Apellidos completos: "+ apellidos +";"+
                    "Nombres completos: "+ nombres +";"+
                    "Fecha de nacimiento: "+ fecha +";"+
                    "Estatura: "+ estatura +";"+
                    "Peso: "+ peso +";"+
                    "Alergias: "+ alergias +"\n");
            bw.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    public static void mostrarPacientes() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/Pacientes.txt"))) {
            String linea;
            System.out.println("\nListado de pacientes:");
            int c = 1;
            
            while ((linea = br.readLine()) != null) {
                datos = linea.split(";");
                System.out.println("Paciente "+c);
                for (int i = 0; i < datos.length; i++){
                    
                    System.out.println(datos[i]);
                }
                c++;
                System.out.println("");  
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}
