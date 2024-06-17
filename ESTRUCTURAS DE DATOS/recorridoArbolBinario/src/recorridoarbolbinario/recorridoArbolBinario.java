package recorridoarbolbinario;

public class recorridoArbolBinario {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        
        // Crear el árbol binario
        arbol.raiz = new Nodo(1);
        arbol.raiz.izquierda = new Nodo(2);
        arbol.raiz.derecha = new Nodo(3);
        arbol.raiz.izquierda.izquierda = new Nodo(4);
        arbol.raiz.izquierda.derecha = new Nodo(5);
        arbol.raiz.izquierda.izquierda.izquierda = new Nodo(8);
        arbol.raiz.izquierda.izquierda.derecha = new Nodo(9);
        arbol.raiz.izquierda.derecha.izquierda = new Nodo(10);
        arbol.raiz.derecha.izquierda = new Nodo(6);
        arbol.raiz.derecha.derecha = new Nodo(7);
        
        /*
        Arbol basado en la imagen: 
        https://slideplayer.es/slide/2971477/11/images/16/Recorrido+de+%C3%A1rboles+%284%29.jpg
        */

        System.out.println("Recorrido en preorden:");
        arbol.recorrerPreorden(arbol.raiz);
        System.out.println();

        System.out.println("Recorrido en inorden:");
        arbol.recorrerInorden(arbol.raiz);
        System.out.println();

        System.out.println("Recorrido en posorden:");
        arbol.recorrerPosorden(arbol.raiz);
        System.out.println();
    }
    
}
