package notasarray;

import java.util.Scanner;

public class notasArray {
    
    public static int ev;
    public static float myArray[];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el numero de notas a ingresar: ");
        int num = sc.nextInt();
        myArray = new float[num];
        ev = myArray.length;
        for (int i = 0; i < myArray.length; i++) {
            //Ciclo repetitivo para aceptar numeros >= 0 y <= 10
            do {
                System.out.print("Ingrese el elemento N°" + (i + 1) + ": ");
                myArray[i] = sc.nextFloat();
                if (myArray[i] < 0 || myArray[i] > 10) {
                    System.out.println("Numero fuera de rango (0> x >10)");
                } else {
                    break;
                }
                
            } while (true);

        }
        //Presentación por pantalla del array
        System.out.print("\nEl arreglo ingresado es: {");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.print("}\n");
        //Llamar al metodo secuencial para determinar la posicion de un numero
        System.out.print("\nIngrese el numero para determinar la posicion en "
                + "la que se encuentra: ");
        float temp = sc.nextFloat();
        if (secuencial(temp) != -1) {
            System.out.println("El numero " + temp + " esta en la posicion " + secuencial(temp));
        } else{
            System.out.println("El numero " + temp + " no se encuentra en el arreglo");
        }
        
    }
    //Recibe como parametro un numero para buscar en que posicion del array se encuentra
    public static int secuencial(float num) {
        for (int i = 0; i < ev; i++) {
            if (myArray[i] == num) {
                return i;
            }
        }
        return -1;
    }
    //Metodo para hacer la eliminacion logica de un numero en un arreglo
    public static void eliminar(float num){
        int pos = secuencial(num);
        if (pos != -1) {
            desplazarIzquierda(pos);
            ev--;
        } else{
            System.out.println("El elemento no existe");
        }
    }
}
