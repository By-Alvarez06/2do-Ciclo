package tablaperiodica;

import java.io.File;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class tablaPeriodica {

    public static TablaP[] elementos = new TablaP[118];
    public static TablaP[] cola1;
    public static TablaP[] cola2;
    public static TablaP[] cola3;
    public static TablaP[] cola4;
    public static TablaP[] pila1;
    public static int num;
    public static int topeC = num*4;
    public static int topeP = -1;
    public static boolean vacio = true;

    public static void main(String[] args) {
        leerArchivo();
        mostrarArray();
        Scanner sc = new Scanner(System.in);

        System.out.print("\nIngrese el numero de elementos a ingresar en la cola: ");
        num = sc.nextInt();
        cola1 = new TablaP[num];
        cola2 = new TablaP[num];
        cola3 = new TablaP[num];
        cola4 = new TablaP[num];
        pila1 = new TablaP[num*4];
        colasRandomicas();
        mostrarColas();
    }

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

    public static void mostrarArray() {
        for (int i = 0; i < elementos.length; i++) {
            TablaP elemento = elementos[i];
            System.out.printf("\n%d, %s, %s, %.2f", elemento.getnAtomico(),
                    elemento.getElAtomico(), elemento.getSiAtomico(), elemento.getMasAtomico());
        }
        System.out.println();
    }

    public static void colasRandomicas() {
        Random rand = new Random();
        for (int i = 0; i < num; i++) {
            cola1[i] = elementos[rand.nextInt(118)];
            cola2[i] = elementos[rand.nextInt(118)];
            cola3[i] = elementos[rand.nextInt(118)];
            cola4[i] = elementos[rand.nextInt(118)];
        }
    }
    
    public static void mostrarColas(){
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
    
    public static void pushPila(TablaP elemento){
        if(vacio && topeP < pila1.length-1){
            topeP++;
            pila1[topeP] = elemento;            
        } else{
            System.out.println("Pila llena, no se puede llenar mas datos");
        }
        
        if(topeP == pila1.length){
            vacio = false;
        }
    }
    

    public static void comparar() {
        float valores[] = {cola1[0].getMasAtomico(), cola2[0].getMasAtomico(),
            cola3[0].getMasAtomico(), cola4[0].getMasAtomico()};
        burbuja(valores);
        
        //If else, comparando los valores burbuja con el atributo
        
        pushPila(valores[3]);
        pushPila(valores[2]);
        pushPila(valores[1]);
        pushPila(valores[0]);
    }

    public static void burbuja(float[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambiar arreglo[j] y arreglo[j+1]
                    float temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

}
