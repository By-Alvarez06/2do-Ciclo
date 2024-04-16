package palindromo2;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;

public class Palindromo2 {

    public static void main(String[] args) {
        System.out.println("PROGRAMA PARA REVISAR LOS PALINDROMOS DE UN ARCHIVO");
        //Lectura del archivo, llamamos a la función leer archivo
        leerArchivo("listado.txt");

        System.out.println("LISTA CON LAS FRASES SOLO PALINDROMOS (Archivo: listPalindromo.txt):\n");
        leerArchivo("listPalindromo.txt");
    }

    public static void leerArchivo(String nombreArch) {
        try {
            //Abre el archivo en la dirección indicada
            File archivo = new File("src/" + nombreArch);
            Scanner f = new Scanner(archivo);
            //Función while, mientras haya contenido de texto en la linea, entra
            while (f.hasNextLine()) {
                String contenido = f.nextLine();
                if (nombreArch.equals("listPalindromo.txt")) {
                    System.out.println(contenido);
                } else {
                    if (Palindromo(contenido)) {
                        escribirArchivo(contenido);
                    }
                }
                // Ponemos el contenido de la linea en una variable y usamos la 
                // función esPalindromo, si nos retorna un valor verdadero pasa
                // a la funcion escribirArchivo que lo escribirá en el nuevo archivo

            }
            f.close();
        } catch (Exception e) {
            System.err.println("Error en la lectura del archivo: " + e.getMessage());
        }
    }

    public static void escribirArchivo(String frase) {
        // En el FileWriter se agrega el parámetro "true" para abrir en modo "append"
        // Esto nos permite escribir lineas con un salto de linea y que no se sobreescriba el contenido
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/listPalindromo.txt", true))) {
            bw.write(frase + "\n");
            bw.close();
        } catch (Exception e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static boolean Palindromo(String texto) {
        int longitud, longitud2, diferencias = 0;
        boolean respuesta;

        texto = texto.toLowerCase();
        texto = texto.replaceAll("á", "a");
        texto = texto.replaceAll("é", "e");
        texto = texto.replaceAll("í", "i");
        texto = texto.replaceAll("ó", "o");
        texto = texto.replaceAll("ú", "u");
        texto = texto.replaceAll("[^a-zA-Z0-9]", "");
        texto = texto.replaceAll("[0-9]", "");
        longitud = texto.length();
        longitud2 = longitud - 1;

        for (int i = 0; i < longitud / 2; i++) {
            if (texto.charAt(i) != texto.charAt(longitud2)) {
                return false;
            }
            longitud2--;
        }

        return true;

    }

}
