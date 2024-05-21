package estructurapila1;

public class estructuraCola1 {
    public static String[] myArray = new String[4];
    public static int tope = -1;
    public static boolean vacio = true;
    public static void main(String[] args) {
        System.out.println("Ingreso de datos a una cola: ");
        push("mensaje1");
        System.out.println("Ingreso 1: ");
        mostrarArray();
        push("mensaje2");
        System.out.println("Ingreso 2:");
        mostrarArray();
        push("mensaje3");
        System.out.println("Ingreso 3:");
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
            myArray[0] = null;
            for (int i = 0; i < myArray.length-1; i++) {
                myArray[i] = myArray[i+1];  
            }
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
