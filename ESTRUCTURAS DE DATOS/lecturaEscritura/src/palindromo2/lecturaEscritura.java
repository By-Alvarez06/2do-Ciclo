package palindromo2;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;

public class lecturaEscritura {

    public static void main(String[] args) {
        System.out.println("LECTURA Y ESCRITURA DE UN ARCHIVO");
        //Lectura del archivo, llamamos a la función leer archivo
        leerArchivo("listado.txt");

        System.out.println("NUEVO ARCHIVO CON ENNUMERACIÓN REESCRITA (Archivo: nuevoListado.txt):");
        leerArchivo("nuevoListado.txt");
    }

    public static void leerArchivo(String nombreArch) {
        try {
            //Abre el archivo en la dirección indicada
            File archivo = new File("src/" + nombreArch);
            Scanner f = new Scanner(archivo);
            int i = 1;
            //Función while, mientras haya contenido de texto en la linea, entra
            while (f.hasNextLine()) {
                String contenido = f.nextLine();
                if (nombreArch.equals("nuevoListado.txt")) {
                    System.out.println(contenido);
                } else {
                    System.out.println(contenido);
                    escribirArchivo(contenido, i);
                    i += 1;
                }
                // Ponemos el contenido de la linea en una variable y usamos 
                // la funcion escribirArchivo que lo escribirá en el nuevo archivo

            }
            System.out.println();
            f.close();
        } catch (Exception e) {
            System.err.println("Error en la lectura del archivo: " + e.getMessage());
        }
    }

    public static void escribirArchivo(String frase, int contador) {
        // En el FileWriter se agrega el parámetro "true" para abrir en modo "append"
        // Esto nos permite escribir lineas con un salto de linea y que no se sobreescriba el contenido
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter("src/nuevoListado.txt", true))) {
            // Uso esto para que replaceAll elimine los numeros y puntos de la
            // ennumeración anterior
            frase = frase.replaceAll("[0-9.]", "");
            //La cariable contador la utilizo para que por cada linea que envia
            //crezca en +1 y sirva como numerador al inicio de las frases
            bw.write(contador + "." + frase + "\n");
            bw.close();
        } catch (Exception e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

}
