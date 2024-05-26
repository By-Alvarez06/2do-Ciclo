package ej4;
// Done
import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de numeros a mostrar: ");
        int num = sc.nextInt();
        int[] arrayFib = new int[num];
        System.out.println("Serie fibonacci en un arreglo:");
        for (int i = 0; i < arrayFib.length; i++) {
            arrayFib[i] = fibonacci(i);
            System.out.print(arrayFib[i] + " ");
        }
    }
    public static int fibonacci(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            return fibonacci(x - 1) + fibonacci(x - 2);
        }
    }
    
}
