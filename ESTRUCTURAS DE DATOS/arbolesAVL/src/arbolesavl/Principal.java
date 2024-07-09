package arbolesavl;

public class Principal {
    public static void main(String[] args) {
        arbolAVL arbol = new arbolAVL();
        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(30);
        arbol.insertar(40);
        arbol.insertar(50);
        arbol.insertar(25);

        System.out.println("Recorrido in-order:");
        arbol.inOrder();

        System.out.println("\nRecorrido pre-order:");
        arbol.preOrder();

        System.out.println("\nRecorrido post-order:");
        arbol.postOrder();

        System.out.println("\nBuscando valor 30:");
        NodoAVL resultado = arbol.buscar(30);
        if (resultado != null) {
            System.out.println("Valor encontrado: " + resultado.valor);
        } else {
            System.out.println("Valor no encontrado.");
        }

        System.out.println("\nEliminando valor 40:");
        arbol.eliminar(40);
        System.out.println("Recorrido in-order después de la eliminación:");
        arbol.inOrder();
    }
    
}
