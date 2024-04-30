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
            //Ciclo repetitivo para aceptar myArray >= 0 y <= 10
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
        System.out.println("Ingrese que desea realizar: ");

        //Presentación por pantalla del array
        System.out.print("\nEl arreglo ingresado es: {");
        mostrarArray();
        System.out.print("}\n");

        //Llamar al metodo secuencial para determinar la posicion de un numero
        System.out.print("\nIngrese el numero para determinar la posicion en "
                + "la que se encuentra: ");
        float temp = sc.nextFloat();
        if (secuencial(temp) != -1) {
            System.out.println("El numero " + temp + " esta en la posicion " + secuencial(temp));
        } else {
            System.out.println("El numero " + temp + " no se encuentra en el arreglo");
        }

        //Uso del metodo eliminar
        System.out.print("\nIngrese el numero a eliminar: ");
        temp = sc.nextFloat();
        eliminar(temp);
        mostrarArray();

        //Uso del metodo insercion en el array
        System.out.print("\n\nIngrese un numero para insertarlo en el array: ");
        temp = sc.nextFloat();
        insCaso1(temp);
        mostrarArray();
        
        System.out.print("\n\nEl arrelgo ordenado de forma ascendente es igual a: {");
        burbujaUp();
        mostrarArray();
        System.out.print("}");
        
        System.out.print("\n\nEl arrelgo ordenado de forma descendente es igual a: {");
        burbujaDown();
        mostrarArray();
        System.out.print("}");
        
    }

    public static void mostrarArray() {
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
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
    public static void eliminar(float num) {
        int pos = secuencial(num);
        if (pos != -1) {
            desplazarIzquierda(pos);
            ev--;
        } else {
            System.out.println("El elemento no existe");
        }
    }

    //Metodo desplazar a la izquierda
    public static void desplazarIzquierda(int pos) {
        for (int i = pos; i < ev - 1; i++) {
            myArray[i] = myArray[i + 1];
        }
        myArray[ev - 1] = 0; // Pone 0 en la última posición después del desplazamiento.
    }

    //Metodo desplazar a la derecha
    public static void desplazarDerecha(int pos) {
        for (int i = ev; i > pos; i--) {
            myArray[i] = myArray[i - 1];
        }
        myArray[pos] = 0; // Pone 0 en la posición donde estaba el elemento eliminado.
    }

    //Insercion de un elemento nuevo en un arreglo desordenado
    public static float insCaso1(float elem) {
        if (ev < myArray.length) {
            myArray[ev] = elem;
            ev++;
        } else {
            System.out.println("No hay espacio...");
        }
        return ev;
    }
    
    //Ciclo burbuja ascendente
    public static void burbujaUp(){
        float temp;
        for (int i = 0; i < ev; i++){
            for (int j = 0; j < ev; j++){
                if (myArray[i] < myArray[j]){
                    temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
    }
    
    //Ciclo burbuja descendente
    public static void burbujaDown(){
        float temp;
        for (int i = 0; i < ev; i++){
            for (int j = 0; j < ev; j++){
                if (myArray[i] > myArray[j]){
                    temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
    }
}
