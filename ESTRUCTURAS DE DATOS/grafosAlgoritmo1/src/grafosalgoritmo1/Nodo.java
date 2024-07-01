package grafosalgoritmo1;

import java.util.ArrayList;
import java.util.List;

/*
Cuando una clase implementa la interfaz Comparable, se compromete a proporcionar 
una implementación del método compareTo. Este método define un orden natural para 
los objetos de esa clase. En este caso, implements Comparable<Nodo> indica que la 
clase Nodo debe implementar el método compareTo para que los nodos puedan compararse 
entre sí.
*/

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

    /*
    El método compareTo recibe un objeto de la clase Nodo (denominado otro) y 
    compara la distancia mínima (distanciaMinima) del nodo actual (this) con la 
    distancia mínima del nodo otro.
    */
    @Override
    public int compareTo(Nodo otro) {
        return Double.compare(distanciaMinima, otro.distanciaMinima);
    }
}
