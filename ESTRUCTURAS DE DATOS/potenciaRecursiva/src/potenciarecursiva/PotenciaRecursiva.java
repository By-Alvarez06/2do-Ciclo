package potenciarecursiva;
import java.util.Scanner;

public class PotenciaRecursiva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base, expo;
        System.out.print("Ingrese la base de la potencia: ");
        base = sc.nextInt();
        System.out.print("Ingrese el exponente de la potencia: ");
        expo = sc.nextInt();
        System.out.println("La potencia de base " + base + " y exponente "
                + expo + " es igual a: " + potencia(base, expo));
    }
    
    public static double potencia(int x, int y){
        if (y == 0) {
            return 1;
        } else if (y > 0) {
            return x * potencia(x, y - 1);
        } else {
            return 1 / potencia(x, -y);
        }
    }
    
}
