package ej6;
// Done
import java.util.Scanner;

public class Ej6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo a ingresar: ");
        int num = sc.nextInt();
        int[] array = new int[num];
        boolean orden = true;
        for (int i = 0; i < array.length; i++) {
            System.out.print("Ingrese el elemento #" + (i+1) + ": ");
            array[i] = sc.nextInt();
        }
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
                orden = false;
                break;
            }
        }
        System.out.println("\nArreglo ingresado por teclado:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            
        }
        
        if (orden) {
            System.out.println("\nEl arreglo esta ordenado");
        } else{
            System.out.println("\nEl arreglo no esta ordenado");
        }
    }
    
}
