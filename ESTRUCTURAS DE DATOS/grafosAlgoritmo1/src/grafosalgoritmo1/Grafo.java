package grafosalgoritmo1;

import java.util.PriorityQueue;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Grafo {
    // Método que implementa el algoritmo de Dijkstra
    public void dijkstra(Nodo origen) {
        origen.distanciaMinima = 0;  // La distancia mínima al nodo origen es 0
        PriorityQueue<Nodo> colaNodos = new PriorityQueue<>();  // Cola de prioridad para procesar los nodos
        colaNodos.add(origen);  // Añadir el nodo origen a la cola

        while (!colaNodos.isEmpty()) {
            Nodo u = colaNodos.poll();  // Obtener el nodo con la distancia mínima

            // Visitar cada arista que sale del nodo u
            for (Arista e : u.adyacencias) {
                Nodo v = e.destino;  // Nodo destino de la arista
                double peso = e.peso;  // Peso de la arista
                double distanciaAtravésDeU = u.distanciaMinima + peso;  // Calcular la distancia total a través del nodo u
                // Si se encuentra una distancia más corta al nodo v
                if (distanciaAtravésDeU < v.distanciaMinima) {
                    colaNodos.remove(v);  // Eliminar el nodo v de la cola
                    v.distanciaMinima = distanciaAtravésDeU;  // Actualizar la distancia mínima al nodo v
                    v.previo = u;  // Establecer el nodo previo de v como u
                    colaNodos.add(v);  // Añadir el nodo v a la cola
                }
            }
        }
    }

    // Método para obtener el camino más corto desde el nodo origen al nodo destino
    public List<Nodo> obtenerCaminoMasCortoHasta(Nodo destino) {
        List<Nodo> camino = new ArrayList<>();  // Lista para almacenar el camino
        for (Nodo nodo = destino; nodo != null; nodo = nodo.previo) {
            camino.add(nodo);  // Añadir cada nodo al camino empezando desde el destino
        }
        Collections.reverse(camino);  // Invertir la lista para obtener el camino desde el origen al destino
        return camino;
    }
}

