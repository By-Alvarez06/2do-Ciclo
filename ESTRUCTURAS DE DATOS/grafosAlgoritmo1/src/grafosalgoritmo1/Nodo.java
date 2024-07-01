package grafosalgoritmo1;

import java.util.ArrayList;
import java.util.List;

public class Nodo implements Comparable<Nodo> {
    public final String nombre;  // Nombre del nodo
    public List<Arista> adyacencias;  // Lista de aristas adyacentes
    public double distanciaMinima = Double.POSITIVE_INFINITY;  // Distancia mínima desde el nodo origen
    public Nodo previo;  // Nodo previo en el camino más corto

    // Constructor para inicializar el nombre del nodo y la lista de adyacencias
    public Nodo(String nombre) {
        this.nombre = nombre;
        adyacencias = new ArrayList<>();
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int compareTo(Nodo otro) {
        return Double.compare(distanciaMinima, otro.distanciaMinima);
    }
}
