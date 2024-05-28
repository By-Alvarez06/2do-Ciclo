/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problema_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Usuario iTC
 */
public class Problema_1 {

    public static String[] datos;

    public static void main(String[] args) {
        String archivo = "data/Deudas-1.txt";
        try ( BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Separar la línea por espacios
                datos = linea.split(" ");
                // Asignar datos a variables
                escribirArchivo();

            }
        } catch (IOException e) {
        }

    }

    public static void escribirArchivo() {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter("data/" + "DeudaActualizada.txt", true))) {
            bw.write(datos[0] +" "+ datos[1] + " Liberado " + datos[5] + "\n");
            bw.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

}
