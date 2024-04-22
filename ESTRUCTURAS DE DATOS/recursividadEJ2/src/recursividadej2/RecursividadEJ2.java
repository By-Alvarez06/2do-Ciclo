package recursividadej2;
public class RecursividadEJ2 {
    public static void main(String[] args) {
        multiplo(3);
    }
    public static void multiplo(int n){
        if (n < 30){
            System.out.println(n);
            multiplo(n+3);
        }
    }
    
}
