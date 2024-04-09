package palindromo1;
public class Palindromo1 {
    public static void main(String[] args) {
        String str1 = "Se verlas al reves";
        System.out.println("Frase: " + str1); //Muestra la frase en pantalla
        str1 = str1.toLowerCase(); //Hace toda la frase en minusculas
        str1 = str1.replaceAll(" +", "");//Elimina todos los espacios
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
