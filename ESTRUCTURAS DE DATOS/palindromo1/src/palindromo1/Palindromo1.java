package palindromo1;
import java.util.Scanner;
public class Palindromo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una frase: ");
        String str1 = sc.nextLine();
        System.out.println("Frase: " + str1); //Muestra la frase en pantalla
        str1 = str1.toLowerCase(); //Hace toda la frase en minusculas
        str1 = str1.replaceAll(" +", "");//Elimina todos los espacios
        str1 = str1.replaceAll(",", "");//Elimina todos las comas
        str1 = str1.replaceAll(".", "");//Elimina todos los puntos
        boolean palind = true;//Booleano para determinar si es o no Palindromo
        for (int i = 0; i < (str1.length()/2); i++){
            if (str1.charAt(i) != str1.charAt(str1.length()-1-i)){
                palind = false; //Si no coincide los caracteres, el booleano es falso
                break;//y sale del bucle
            } else{
                palind = true;
            }
        }
        if (palind){
            System.out.println("La frase SI es un palindromo");
        } else{
            System.out.println("La frase NO es un palindromo");
        }
    }
    
}
