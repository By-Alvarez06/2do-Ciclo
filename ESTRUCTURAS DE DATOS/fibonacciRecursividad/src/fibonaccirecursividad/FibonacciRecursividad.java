package fibonaccirecursividad;

import java.util.Scanner;

public class FibonacciRecursividad {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("Ingrese un valor para imprimir los n valores de la serie fibonacci: ");
            n = sc.nextInt();
            if (n <= 0){
                System.out.println("No se puede mostrar numeros negativos de la serie\n");
            }
        } while(n <= 0);  
        
        for (int i = 0; i < n; i++){
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
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
