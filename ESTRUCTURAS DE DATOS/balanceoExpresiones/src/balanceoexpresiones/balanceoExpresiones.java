package balanceoexpresiones;

/*
Usamos la clase propia de java denominada Stack, la cual nos permite realizar
las acciones propias de una estructura tipo pila como son push, pop, comprobar
si está vacia, etc.
 */
import java.util.Stack;

public class balanceoExpresiones {

    public static void main(String[] args) {
        String expresion1 = "{[()]}";
        String expresion2 = "{[(])}";
        String expresion3 = "{{[[(())]]}}";
        String expresion4 = "[{(a+b}";
        String expresion5 = "[{(a+b])}";

        imprimirMensaje(expresion1); // true
        imprimirMensaje(expresion2); // false
        imprimirMensaje(expresion3); // true
        imprimirMensaje(expresion4); // false
        imprimirMensaje(expresion5); // false
    }

    public static boolean verificarBalance(String expresion) {
        Stack<Character> pila = new Stack<>();

        /*
        La variable c, por cada vez que pase por el ciclo FOR va a tomar la
        posicion desde el inicio hasta el final de la expresion, gracias a la
        funcion toCharArray() la cual convierte cualquier cadena en un arreglo
        de "Char" o caracteres unitarios
         */
        for (char c : expresion.toCharArray()) {
            /*
            Si el caracter es igual a cualquier de los que se especifica en
            la condicion, utiliza push para insertarlo en la pila
             */
            if (c == '(' || c == '{' || c == '[') {
                pila.push(c);
                
            /*
            Por otro lado, si el caracter en el que se encuentra el puntero, es
            cualquiera de los caracteres pero cerrados, pasa a comprobar la 
            condicion:
            Si la pila esta vacia o si la cima de la pila es distinto a el
            caracter de parentesis abierto, automáticamente retorna FALSE ya que
            no se estaría cumpliendo la condicion. SINO, es decir, si ES un
            caracter abierto, con la funcion pop saca el elemento de la pila
            */
            } else if (c == ')') {
                if (pila.isEmpty() || pila.peek() != '(') {
                    System.out.print("Orden incorrecto de la expresion: ");
                    return false;
                } else {
                    pila.pop();
                }
            } else if (c == '}') {
                if (pila.isEmpty() || pila.peek() != '{') {
                    System.out.print("Orden incorrecto de la expresion: ");
                    return false;
                } else {
                    pila.pop();
                }
            } else if (c == ']') {
                if (pila.isEmpty() || pila.peek() != '[') {
                    System.out.print("Orden incorrecto de la expresion: ");
                    return false;
                } else {
                    pila.pop();
                }
            }
        }

        return pila.isEmpty();
        /*
        Al final con la funcion isEmpty (de la clase Stack importada) comprueba
        si la pila despues de pasar por todas las comprobaciones del ciclo for
        se encuentra vacia, si es así la expresion está balanceada, sino, sería
        falso.
        */
    }
    
    /*
    Finalmente una funcion la cual muestre un mensaje por pantalla en el cual
    dependiendo de si retorna verdadero o falso la comprobación del balance, le
    diga al usuario si está o no balanceada la expresion
    */
    public static void imprimirMensaje(String expresion) {
        if (verificarBalance(expresion)) {
            System.out.println("La expresión: | " + expresion + " | está balanceada.");
        } else {
            System.out.print(expresion + "\n");
        }
    }
}
