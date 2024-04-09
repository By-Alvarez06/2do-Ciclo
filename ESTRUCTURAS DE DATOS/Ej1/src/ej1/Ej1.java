package ej1;
import java.util.Scanner;
public class Ej1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una cadena de texto: ");
        String str1 = sc.nextLine();
        
        //Recorrer los indices de un string desde 0 hasta la longitud de este
//        for (int i = 0; i < str1.length(); i++){
//            System.out.println(i + ": " + str1.charAt(i));
//        }

            //Reemplazar espacios en blanco de un string
//        System.out.println(str1);
//        str1 = str1.replaceAll(" +", " ");
//        str1 = str1.trim();
//        System.out.println(str1);
        //Recorrer los indices de un string al revés, desde el ultimo digito al primero
        for (int i = str1.length()-1; i >= 0; i--){
            System.out.println(i + ": " + str1.charAt(i));
        }
    }
    
}
