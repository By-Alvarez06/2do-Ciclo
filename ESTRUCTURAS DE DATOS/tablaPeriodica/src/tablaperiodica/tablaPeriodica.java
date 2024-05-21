package tablaperiodica;

import java.io.File;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;

public class tablaPeriodica {
    public static TablaP[] elementos = new TablaP[118];
    public static void main(String[] args) {
        leerArchivo();
        mostrarArray();
    }
    
    public static void leerArchivo(){
        try{
            File arch = new File("src/Elements.csv");
            Scanner sc = new Scanner(arch);
            String[] element;
            TablaP elementoN = new TablaP();
            int i = 0;
            while(sc.hasNextLine()){
                element = sc.nextLine().split(",");
                elementoN.setnAtomico(Integer.parseInt(element[0]));
                elementoN.setElAtomico(element[1]);
                elementoN.setSiAtomico(element[2]);
                elementoN.setMasAtomico(Float.parseFloat(element[3]));
                elementos[i] = elementoN;
                i++;
            }
            sc.close();
            
            
        } catch (Exception e){
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    
    public static void mostrarArray(){
        for (int i = 0; i < elementos.length; i++) {
            TablaP elemento = elementos[i];
            System.out.printf("%d, %s, %s, %f", elemento.getnAtomico(), 
                    elemento.getElAtomico(),elemento.getSiAtomico(), elemento.getMasAtomico());
            
        }
    }
    
}
