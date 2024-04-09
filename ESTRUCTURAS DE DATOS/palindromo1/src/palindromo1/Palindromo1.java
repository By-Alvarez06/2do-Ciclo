package palindromo1;
public class Palindromo1 {
    public static void main(String[] args) {
        String str1 = "Se verlas al reves";
        System.out.println("Frase: " + str1);
        str1 = str1.toLowerCase();
        str1 = str1.replaceAll(" +", "");
        boolean palind = true;
        for (int i = 0; i < (str1.length()/2); i++){
            if (str1.charAt(i) != str1.charAt(str1.length()-1-i)){
                palind = false;
                break;
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
