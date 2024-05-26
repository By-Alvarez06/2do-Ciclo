package ej5;
// Done
import java.util.Scanner;

public class Ej5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        
        System.out.print("Ingrese la cantidad de numeros primos a mostrar: ");
        n = sc.nextInt();
        
        int[] arrayPr = new int[n];
        int j = 0;
        
        for (int i = 1; j < n; i++) {
            if (primo(i)) {
                arrayPr[j] = i;
                j++;
            }
        }
        
        System.out.println("Arreglo de numeros primos:");
        for (int i = 0; i < arrayPr.length; i++) {
            System.out.print(arrayPr[i] + " ");
            
        }

    }

    public static boolean primo(int num) {
        boolean esPrimo = false;
        int c;
        if (num >= 2) {
            c = num - 1;
            while (num % c != 0) {
                c = c - 1;
            }
            if (c == 1) {
                esPrimo = true;
            }
        }
        return esPrimo;
    }

}
