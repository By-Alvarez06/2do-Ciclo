package ej14;
// Done
import java.util.Scanner;

public class CedulaClientes {

    public static int[] arrayCed;
    public static int topeC = 0;
    public static boolean vacio = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de clientes a procesar: ");
        int n = sc.nextInt();
        byte opc;
        arrayCed = new int[n];
        do {
            System.out.println("\nIngrese la accion que desea realizar: ");
            System.out.print("1. Ingresar nuevo cliente - 2. Atender Cliente - "
                    + "3. Retirarse de la cola (Digite 4 para salir): ");
            opc = sc.nextByte();
            switch (opc) {
                case 1 -> {
                    System.out.print("\nIngrese la cedula del cliente a procesar: ");
                    int cedula = sc.nextInt();
                    pushCola(cedula);
                    mostrarCola();
                }
                case 2 -> {
                    popCola();
                    mostrarCola();
                }
                case 3 -> {
                    popCliente();
                    mostrarCola();
                }
                case 4 ->
                    System.out.println("Saliendo del programa, Adios!");
                default ->
                    System.out.println("Opcion incorrecta o fuera de rango");
            }
        } while (opc != 4);
    }

    public static void mostrarCola() {
        for (int i = 0; i < arrayCed.length; i++) {
            System.out.print(arrayCed[i] + "-");
        }
        System.out.println();
    }

    public static void pushCola(int cedula) {
        if (vacio || topeC < arrayCed.length) {
            arrayCed[topeC] = cedula;
            topeC++;
            System.out.println("Ingreso correcto de cliente!");
        } else {
            System.out.println("No se puede agregar otro cliente a la cola");
        }
        if (topeC == arrayCed.length - 1) {
            vacio = false;
        }
    }

    public static void popCliente() {
        if (vacio != true || topeC > 0) {
            for (int i = topeC - 1; i < arrayCed.length - 1; i++) {
                arrayCed[i] = arrayCed[i + 1];
            }
            arrayCed[arrayCed.length - 1] = 0;
            topeC--;
            System.out.println("Cliente retirado de la cola");
        } else {
            System.out.println("No hay clientes por retirar");
        }

        if (topeC == 0) {
            vacio = true;
        }
    }

    public static void popCola() {
        if (vacio != true || topeC > 0) {
            for (int i = 0; i < arrayCed.length - 1; i++) {
                arrayCed[i] = arrayCed[i + 1];
            }
            arrayCed[arrayCed.length - 1] = 0;
            topeC--;
            System.out.println("Cliente Atendido!");
        } else {
            System.out.println("No hay clientes por atender");
        }

        if (topeC == 0) {
            vacio = true;
        }
    }

}
