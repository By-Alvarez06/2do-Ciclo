package ej7;
import java.util.Scanner;
// Done

public class Ej7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, sumaPares, sumaImpares;
        int[] lista;
        float porcentajePar;
        System.out.print("Cuantos # va a ingresar?: ");
        n = sc.nextInt();
        lista = new int[n];
        sumaPares = 0;
        sumaImpares = 0;
        
        for (int i = 0; i < lista.length; i++){
            System.out.print("Ingrese el #" + (i + 1) + " numero: ");
            lista[i] = sc.nextInt();
            if (lista[i] % 2 == 0){
                sumaPares = sumaPares + lista[i];
            } else{
                sumaImpares = sumaImpares + lista[i];
            }
        }
        
        System.out.println("\nLista ingresada:");
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i] + " ");
            
        }
        System.out.println("\nEn total, la suma de los numeros pares de la lista"
                + " es igual a " + sumaPares + " y la suma de los numeros "
                        + "impares de la lista es igual a " + sumaImpares);
    }
}
