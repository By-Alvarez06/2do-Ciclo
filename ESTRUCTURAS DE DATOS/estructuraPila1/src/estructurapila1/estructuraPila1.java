package estructurapila1;

public class estructuraPila1 {
    public static String[] myArray = new String[4];
    public static int tope = -1;
    public static boolean vacio = true;
    public static void main(String[] args) {
        System.out.println("Ingreso de datos a una pila: ");
        push("mensaje1");
        System.out.println("Ingreso 1: ");
        mostrarArray();
        push("mensaje2");
        System.out.println("Ingreso 2:");
        mostrarArray();
        pop();
        System.out.println("Eliminar el elemento de la pila: ");
        mostrarArray();
        
    }
    public static void push(String elemento){
        if(vacio && tope < myArray.length-1){
            tope++;
            myArray[tope] = elemento;            
        } else{
            System.out.println("Pila llena, no se puede llenar mas datos");
        }
        
        if(tope == myArray.length){
            vacio = false;
        }
    }
    public static void pop(){
        if(vacio != true || tope >= 0){
            myArray[tope] = null;
            tope--;
        } else{
            System.out.println("Pila vacia, no se puede eliminar mas datos");
        }
        
        if(tope == 0){
            vacio = true;
        }
    }
    public static void mostrarArray(){
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " - ");
        }
        System.out.println("");
    }
    
}
