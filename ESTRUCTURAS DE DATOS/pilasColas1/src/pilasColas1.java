/**
 *
 * AUTORES: DANIEL CAMPOVERDE - BYRON ALVAREZ
 */
import java.util.Arrays;
import java.util.Random;
public class pilasColas1 {
    /*
    Variables globales para usar en los metodos
    1. Array de 30 elementos llenado al azar
    2. Funcion random
    3. Pila que sirve como el recipiente mayor
    4 y 5. Cola 1 y Cola 2 que representan los tubos de ensayo
    6. Tope que nos indica el tope de las colas
    7. Tope de la Pila
    8. Variable para saber si esta vacio o lleno usado en los push y pop
    */
    public static int[] arrayElem = new int[30];
    public static Random r = new Random();
    public static int[] pila1 = new int[20];
    public static int[] cola1 = new int[10];
    public static int[] cola2 = new int[10];
    public static int topeC = 19;
    public static int topeP = -1;
    public static boolean vacio = true;
    
    public static void main(String[] args) {
        llenaArray1();
        llenaColas();
        System.out.println("Tubo de ensayo 1: ");
        mostrarCola1();
        System.out.println("\nTubo de ensayo 2: ");
        mostrarCola2();
        System.out.println("\nSe va a proceder a llenar el recipiente: ");
        /*
        LLama al ciclo que compara y llena la pila 10 veces, debido a que por
        cada iteracion llena 2 elementos, y la pila es de 20 elementos
        */
        for (int i = 0; i < 10; i++) {
            comparar();
        }
        System.out.println(Arrays.toString(pila1));
        
    }
    
    /*
    Funcion para llenar el array de 30 elementos de manera aleatoria
    */
    public static void llenaArray1(){
        for (int i = 0; i < arrayElem.length; i++) {
            arrayElem[i] = r.nextInt(101);
        }
    }
    
    /*
    Funciones mostrarCola sirven con ciclos FOR para mostrar por pantalla las
    colas
    */
    public static void mostrarCola1(){
        for (int i = 0; i < cola1.length; i++) {
            System.out.print(cola1[i] + "-");
        }
        System.out.println();
    }
    
    public static void mostrarCola2(){
        for (int i = 0; i < cola2.length; i++) {
            System.out.print(cola2[i] + "-");
        }
        System.out.println();
    }
    
    /*
    Llena las colas con elementos al azar del array de 30 elementos
    */
    public static void llenaColas(){
        int nRand;
        for (int i = 0; i < cola1.length; i++) {
            nRand = r.nextInt(arrayElem.length);
            cola1[i] = nRand;
            nRand = r.nextInt(arrayElem.length);
            cola2[i] = nRand;
            
        }
    }
    
    /*
    PushPila sirve para enviar los elementos que se coloquen en la Pila
    */
    public static void pushPila(int elemento){
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
    
    /*
    PopCola1 y 2 sirven para eliminar los elementos de las colas respectivamente
    */
    public static void popCola1(){
        if(vacio != true || topeC >= 0){
            for (int i = 0; i < cola1.length-1; i++) {
                cola1[i] = cola1[i+1];  
            }
            cola1[cola1.length-1] = 0;
            topeC--;
        } else{
            System.out.println("Pila vacia, no se puede eliminar mas datos");
        }
        
        if(topeC == 0){
            vacio = true;
        }
    }
    
    public static void popCola2(){
        if(vacio != true || topeC >= 0){
            for (int i = 0; i < cola2.length-1; i++) {
                cola2[i] = cola2[i+1];  
            }
            cola2[cola1.length-1] = 0;
            topeC--;
        } else{
            System.out.println("Pila vacia, no se puede eliminar mas datos");
        }
        
        if(topeC == 0){
            vacio = true;
        }
    }
    
    /*
    Ciclo que sirve para saber cual numero envia primero, dando prioridad al
    numero mayor como envio siempre
    */
    public static void comparar(){
        if(cola1[0] >= cola2[0]){
            pushPila(cola1[0]);
            pushPila(cola2[0]);
            popCola1();
            popCola2();
        } else{
            pushPila(cola2[0]);
            pushPila(cola1[0]);
            popCola2();
            popCola1();
        }
    }
}
