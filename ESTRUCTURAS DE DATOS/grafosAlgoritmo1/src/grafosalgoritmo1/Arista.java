package grafosalgoritmo1;

public class Arista {
    public final Nodo destino;  // Nodo destino al que llega la arista
    public final double peso;  // Peso de la arista

    // Constructor para inicializar el nodo destino y el peso de la arista
    public Arista(Nodo destino, double peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

