package archivos;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;

public class Archivos {
    public static void main(String[] args) {
        //Ingresar el nombre del archivo y el contenido del mismo
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo a crear: ");
        String nombre = sc.nextLine();
        nombre = nombre.replaceAll("[^a-zA-Z0-9]", "");
        nombre = nombre.toLowerCase();
        nombre = nombre + ".txt";
        
        String contenido;
        do{
            System.out.print("Ingrese el contenido que se desea escribir en el "
                    + "archivo (Ingrese 0 para salir): ");
             contenido = sc.nextLine();
             escribirArchivo(nombre, contenido);
        } while (!"0".equals(contenido));
        
        leerArchivo(nombre);
        
    }
    public static void escribirArchivo(String nombArch, String mensaje){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/archivos/" + nombArch))){
            bw.write(mensaje);
            System.out.println("Archivo: '" + nombArch + "' creado correctamente.\n");
            bw.close();
        } catch(Exception e){
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    public static void leerArchivo(String nombArch){
        try{
            File archivo = new File("src/archivos/" + nombArch);
            Scanner f = new Scanner(archivo);
            System.out.println("Contenido del archivo:\n");
            while(f.hasNextLine()){
                String contenido = f.nextLine();
                System.out.println(contenido);
            }
            f.close();
        } catch (Exception e){
            System.err.println("Error en la lectura del archivo: " + e.getMessage());
        }
    }
    
}
