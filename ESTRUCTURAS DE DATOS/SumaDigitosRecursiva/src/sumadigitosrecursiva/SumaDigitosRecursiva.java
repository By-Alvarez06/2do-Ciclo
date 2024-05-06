package sumadigitosrecursiva;
import java.util.Scanner;

public class SumaDigitosRecursiva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un numero para determinar la suma de sus dígitos: ");
        int num = sc.nextInt();
        System.out.println("La suma de los digitos del numero: " + num +
                " es igual a: " + sumarDigitos(num));
    }
    public static int sumarDigitos(int numero) {
        if (numero == 0) {
            return 0;
        } else {
            return numero % 10 + sumarDigitos(numero / 10);
        }
    }
    
}
