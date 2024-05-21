package ej14;
import java.util.Scanner;

public class CedulaClientes {
    public static int[] arrayCed;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de clientes a procesar: ");
        int n = sc.nextInt();
        arrayCed = new int[n];
        
    }
    
    public static void mostrarCola1(){
        for (int i = 0; i < cola1.length; i++) {
            System.out.print(cola1[i] + "-");
        }
        System.out.println();
    }
    
    public static void popCola1(){
        if(vacio != true || topeC >= 0){
            for (int i = 0; i < cola1.length-1; i++) {
                cola1[i] = cola1[i+1];  
            }
            cola1[cola1.length-1] = 0;
            topeC--;
        } else{
            System.out.println("Pila vacia, no se puede eliminar mas datos");
        }
        
        if(topeC == 0){
            vacio = true;
        }
    }
    
}
