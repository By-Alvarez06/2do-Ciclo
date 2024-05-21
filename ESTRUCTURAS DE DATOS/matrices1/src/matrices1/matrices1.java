package matrices1;

import java.util.Scanner;

public class matrices1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while (n <= 1 || n >= 11) {
            System.out.print("Ingrese el tamaño del arreglo cuadrado (2<x<10): ");
            n = sc.nextInt();
        }
        int[][] myMatriz = new int[n][n];

        //Rellenar la matriz con las condiciones
        int temp = 0;
        for (int i = 0; i < myMatriz.length; i++) {
            if (i == 0 || i == 3) {
                temp = 0;
            } else {
                temp = 1;
            }
            for (int j = 0; j < myMatriz.length; j++) {
                //Switch para rellenar las filas segun la condicion
                //Si es la primera fila lo rellena con multiplos de 5
                switch (i) {
                    case 0:
                        myMatriz[i][j] = temp;
                        temp = temp + 5;
                        break;
                //Si es la 2da rellena con impares desde 1
                    case 1:
                        if (temp % 2 != 0) {
                            myMatriz[i][j] = temp;
                            temp = temp + 2;
                        } else {
                            temp++;
                        }
                        break;
                //Si es la 3ra rellena con pares desde el 2
                    case 2:
                        if (temp % 2 == 0) {
                            temp = temp + 2;
                            myMatriz[i][j] = temp;
                        } else {
                            temp++;
                            myMatriz[i][j] = temp;
                        }
                        break;
                //Si es la 4ta rellena con multiplos de 3
                    case 3:
                        temp = temp + 3;
                        myMatriz[i][j] = temp;
                        break;
                }
            }
        }

        //Presentar el arreglo por pantalla
        for (int i = 0; i < myMatriz.length; i++) {
            System.out.println();
            for (int j = 0; j < myMatriz.length; j++) {
                System.out.print(myMatriz[i][j] + " ");
            }
        }
        System.out.println();
    }

}
