package recursividad;

public class Recursividad {
    public static void main(String[] args) {
        Printnum(4);
        System.out.println("Fin");
    }
    
    static void Printnum(int n){
        System.out.println(n);
        if (n > 1){
            Printnum2(n - 1);
        }
        System.out.println(n);
    }
    
    static void Printnum2(int n){
        Printnum(n);
    }
    
}
