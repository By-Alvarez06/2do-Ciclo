package ej3;
// Done
public class Ej3 {

    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        long[] arrayB = new long[10];
        
        System.out.println("Arreglo A:");
        for (int i = 0; i < arrayA.length; i++) {
            System.out.print(arrayA[i] + " ");
        }
        
        System.out.println("\nArreglo B (Factorial de los numeros del arreglo A):");
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = factorial(arrayA[i]);
        }
        for (int i = 0; i < arrayB.length; i++) {
            System.out.print(arrayB[i] + " ");
        }
        System.out.println();
    }

    //Funcion que calcula el factorial con recursividad
    public static long factorial(int x) {
        long fact;
        if (x == 0) {
            fact = 1;
        } else {
            fact = x * factorial(x - 1);
        }
        return fact;
    }

}
