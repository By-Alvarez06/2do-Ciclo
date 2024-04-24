package factorial1;

import java.util.Scanner;

public class Factorial1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("Ingrese un numero para determinar su factorial: ");
            n = sc.nextInt();
            if (n < 0) {
                System.out.println("No se puede calcular factorial de un numero negativo\n");
            }
        } while (n < 0);
        System.out.println("El factorial de " + n + " es " + factorial(n));
    }
    
    public static int factorial(int n){
        if(n > 1){
            return n * factorial(n - 1);
        } else{
            return 1;
        }
    }

}
