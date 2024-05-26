/*
AUTORES: BYRON ALVAREZ - DANIEL CAMPOVERDE

CODIGO COMENTADO, EN EL MAIN, PROCESOS Y FUNCIONES TIENEN SU PROPIO BLOQUE
DE COMENTARIO ANTES DE CADA FUNCION

CLASE TablaP PARA LOS OBJETOS ADJUNTADO EN EL MISMO PAQUETE DE NETBEANS
*/

package tablaperiodica;

import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class tablaPeriodica {
    /*
    Lista de variables globales para trabajar sobre ellas en las funciones y main
    */
    public static TablaP[] elementos = new TablaP[118]; 
    // Array de 118 elementos de la tabal periodica
    
    public static TablaP[] cola1;
    public static TablaP[] cola2;
    public static TablaP[] cola3;
    public static TablaP[] cola4;
    public static TablaP[] pila1;
    // Arrays de objetos de la clase TablaP, 4 colas y 1 pila
    
    public static int num;
    public static int topeC; // Tope de las colas
    public static int topeP = -1; // Tope de la pila
    public static boolean vacio = true; // Booleanos de vacio o lleno de Cola
    public static boolean vacioP = true; // Y pila

    public static void main(String[] args) {
        leerArchivo();
        
        System.out.println("Array de los elementos químicos de la tabla periodica");
        System.out.println("Formato:");
        System.out.println("\nN Atomico, Elemento Químico, Simbolo Químico, Masa Atomica");
        
        mostrarArray();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el numero de elementos a ingresar en la cola: ");
        num = sc.nextInt();
        cola1 = new TablaP[num];
        cola2 = new TablaP[num]; // Lee el valor de elementos a ingresar en las 
        cola3 = new TablaP[num]; // colas creadas y asigna la longitud de las 
        cola4 = new TablaP[num]; // colas en funcion a la variable "num"
        pila1 = new TablaP[num * 4];
        topeC = num * 4;
        
        colasRandomicas();
        mostrarColas();
        
        System.out.println("\nA continuación se procede a ingresar en una pila"
                + " los primeros elementos de las colas en orden mayor a menor");
        for (int i = 0; i <= num; i++) {
            comparar();
        }
        mostrarPila();
    }
    
    /*
    Funcion que lee el archivo csv y separa los elementos de cada linea por sus
    comas, y los valores los envia a los atributos de la clase de manera
    correspondiente, unicamente hasta el 3 indice o coma, debido a que hasta ahí
    se cumplen los atributos necesarios
    */
    public static void leerArchivo() {
        try {
            File arch = new File("src/Elements.csv");
            Scanner sc = new Scanner(arch);
            String[] element;
            int i = 0;
            while (sc.hasNextLine()) {
                element = sc.nextLine().split(",");
                TablaP elementoN = new TablaP();
                elementoN.setnAtomico(Integer.parseInt(element[0]));
                elementoN.setElAtomico(element[1]);
                elementoN.setSiAtomico(element[2]);
                elementoN.setMasAtomico(Float.parseFloat(element[3]));
                elementos[i] = elementoN;
                i++;
            }
            sc.close();

        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    /*
    Funcion que sirve para mostrar el array de 118 elementos una vez asignado
    en pantalla, con el formato que se especifica al inicio de la impresion
    */
    public static void mostrarArray() {
        for (int i = 0; i < elementos.length; i++) {
            TablaP elemento = elementos[i];
            System.out.printf("\n%d, %s, %s, %.2f", elemento.getnAtomico(),
                    elemento.getElAtomico(), elemento.getSiAtomico(), elemento.getMasAtomico());
        }
        System.out.println();
    }

    /*
    Funcion la cual, una vez ingresado en valor de "num" por teclado procede a
    llenar las 4 colas creadas con elementos al azar del array de 118 elementos
    */
    public static void colasRandomicas() {
        Random rand = new Random();
        for (int i = 0; i < num; i++) {
            cola1[i] = elementos[rand.nextInt(118)];
            cola2[i] = elementos[rand.nextInt(118)];
            cola3[i] = elementos[rand.nextInt(118)];
            cola4[i] = elementos[rand.nextInt(118)];
        }
    }

    /*
    Funcion que muestra las 4 colas en orden, una vez fueron llenadas de manera
    random, cada vez que se muestra una cola o pila por pantalla, para separar
    y tener una mejor compresion de sus objetos se usa de separador -+- despues
    de cada objeto de los arreglos (colas o pilas)
    */
    public static void mostrarColas() {
        System.out.print("Cola 1: \n{");
        for (int i = 0; i < cola1.length; i++) {
            TablaP elemento = cola1[i];
            System.out.printf("%d, %s, %s, %.2f -+- ", elemento.getnAtomico(),
                    elemento.getElAtomico(), elemento.getSiAtomico(), elemento.getMasAtomico());
        }
        System.out.print("}\n");
        System.out.print("Cola 2: \n{");
        for (int i = 0; i < cola2.length; i++) {
            TablaP elemento = cola2[i];
            System.out.printf("%d, %s, %s, %.2f -+- ", elemento.getnAtomico(),
                    elemento.getElAtomico(), elemento.getSiAtomico(), elemento.getMasAtomico());
        }
        System.out.print("}\n");
        System.out.print("Cola 3: \n{");
        for (int i = 0; i < cola3.length; i++) {
            TablaP elemento = cola3[i];
            System.out.printf("%d, %s, %s, %.2f -+- ", elemento.getnAtomico(),
                    elemento.getElAtomico(), elemento.getSiAtomico(), elemento.getMasAtomico());
        }
        System.out.print("}\n");
        System.out.print("Cola 4: \n{");
        for (int i = 0; i < cola4.length; i++) {
            TablaP elemento = cola4[i];
            System.out.printf("%d, %s, %s, %.2f -+- ", elemento.getnAtomico(),
                    elemento.getElAtomico(), elemento.getSiAtomico(), elemento.getMasAtomico());
        }
        System.out.print("}\n");
    }

    /*
    Funcion que envia a la cola principal los objetos de tipo TablaP una vez han
    sido ordenados
    */
    public static void pushPila(TablaP elemento) {
        if (vacioP && topeP < pila1.length - 1) {
            topeP++;
            pila1[topeP] = elemento;
        }

        if (topeP == pila1.length) {
            vacioP = false;
        }
    }

    /*
    Funcion principal que hace el envio a la Pila Principal, consiste en crear
    un arreglo de objetos, en el cual cada posicion del arreglo, es el primer
    objeto de cada cola, una vez los agrega, se envia a un ciclo burbuja en el 
    cual se compara el atributo de la masa atomica de los objetos, se ordenan
    los objetos en base a sus masas atomicas y finalmente llama a la funcion
    pushPila en el orden de mayor a menor, en este caso, como se ordenó por burbuja
    se envia desde el ultimo elemento del arreglo, al primero
    */
    public static void comparar() {
        TablaP valores[] = {cola1[0], cola2[0], cola3[0], cola4[0]};
        
        burbuja(valores);

        pushPila(valores[3]);
        pushPila(valores[2]);
        pushPila(valores[1]);
        pushPila(valores[0]);
    }

    /*
    Ciclo burbuja que ordena los objetos en relacion a sus atributos (masa atom)
    */
    public static void burbuja(TablaP[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - i - 1; j++) {
                if (arreglo[j].getMasAtomico() > arreglo[j + 1].getMasAtomico()) {
                    // Intercambiar arreglo[j] y arreglo[j+1]
                    TablaP temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    /*
    Funcion que muestra la Pila Principal, una vez se han agregado todos los 
    elementos, usando el separador ya mencionado en los procesos anteriores
    (objeto) -+- (objeto)...
    */
    public static void mostrarPila() {
        System.out.println("\nPila Elementos:");
        System.out.print("{");
        for (int i = 0; i < pila1.length; i++) {
            TablaP elemento = pila1[i];
            System.out.printf("%d, %s, %s, %.2f -+- ", elemento.getnAtomico(),
                    elemento.getElAtomico(), elemento.getSiAtomico(), elemento.getMasAtomico());
        }
        System.out.print("}\n");

    }

}
