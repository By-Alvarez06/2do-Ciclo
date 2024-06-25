package parcial1bim2;

public class Nodo {
    String valor; // Cambiamos el tipo de 'valor' a String para permitir operadores
    Nodo izquierda;
    Nodo derecha;

    public Nodo(String v) {
        valor = v;
        izquierda = null;
        derecha = null;
    }
}
