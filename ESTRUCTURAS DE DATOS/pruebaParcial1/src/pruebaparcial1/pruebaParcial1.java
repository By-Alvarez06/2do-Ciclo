//NOMBRE: BYRON ALVAREZ
//ESTRUCTURAS DE DATOS

package pruebaparcial1;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;

public class pruebaParcial1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Creación del archivo de texto de fibonacci"
                + " (Ubicacion: src/fibonacci.txt)\n");
        for (int i = 0; i < 10; i++) {
            //Llamamos al método escribir archivo con una llamada a la vez del
            //metodo fibonacci para que el parametro del numero se escriba en
            //en el archivo de texto
            escribirArchivo(fibonacci(i));
        }
        System.out.println("Presentación de los elementos del archivo en un array:");
        /*
        Creamos el arreglo y lo enviamos al metodo lecturaArchivo el cual
        Se va a encargar de cada linea del archivo convertirla en un entero y
        agregarla al arreglo enviado
         */
        int[] array = new int[10];
        lecturaArchivo(array);
        
        //Metodo mostrarArray para mostrar por pantalla el arreglo
        mostrarArray(array);
        
        System.out.println("\nA continuación se eliminará el elemento repetido:");
        //Metodo desplazarIzquierda para eliminar el elemento repetido
        desplazarIzquierda(1, array);
        mostrarArray(array);
        
        System.out.println("\nAhora se va a eliminar el elemento en la 5ta "
                + "posicion del arreglo:");
        desplazarIzquierda(5, array);
        mostrarArray(array);
        
        System.out.println("\nAhora se ingresarán dos numeros al final del arreglo");
        System.out.print("Ingrese el primer numero a agregar: ");
        int temp = sc.nextInt();
        /*
        El metodo addNum lo que hace es que recibe como parametro tanto el numero
        a agregar como el arreglo
        */
        addNum(temp, array);
        System.out.print("Ingrese el segundo numero a agregar: ");
        temp = sc.nextInt();
        addNum(temp, array);
        System.out.println("\nArreglo con los dos numeros agregados: ");
        mostrarArray(array);
        
        System.out.println("\nFinalmente se muestra por pantalla el arreglo final"
                + " y ordenado de manera ascendente:");
        burbuja(array);
        mostrarArray(array);
        

    }
    
    //Metodo recursivo fibonacci
    public static int fibonacci(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            return fibonacci(x - 1) + fibonacci(x - 2);
        }
    }

    public static void escribirArchivo(int contenido) {
        // En el FileWriter se agrega el parámetro "true" para abrir en modo "append"
        // Esto nos permite escribir lineas con un salto de linea y que no se sobreescriba el contenido
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/fibonacci.txt", true))) {
            bw.write(contenido + "\n");
            bw.close();
        } catch (Exception e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void lecturaArchivo(int[] array) {
        try {
            File archivo = new File("src/fibonacci.txt");
            Scanner f = new Scanner(archivo);
            int i = 0;
            while (f.hasNextLine()) {
                String s = f.nextLine();
                array[i] = Integer.parseInt(s);
                i++;
            }
            f.close();
        } catch (Exception e) {
            System.err.println("Error en la lectura del archivo");
        }
    }

    public static void mostrarArray(int[] array) {
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    public static void desplazarIzquierda(int pos, int[] array) {
        for (int i = pos; i < 10 - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0; // Pone 0 en la última posición después del desplazamiento.
    }
    
    //Insercion de un elemento nuevo en el arreglo
    public static void addNum(int num, int[] array) {
        //Para el caso de el primer numero a enviar
        if (array[array.length - 2] == 0) {
            array[array.length - 2] = num;
        } else {
            //Para el caso del segundo numero a enviar
            array[array.length - 1] = num;
        }
    }
    
    //Ciclo burbuja ascendente
    public static void burbuja(int[] array){
        int temp;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                if (array[i] < array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
