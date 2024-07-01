package grafosalgoritmo1;

import java.util.List;

public class GrafosAlgoritmo1 {

    public static void main(String[] args) {
        // Crear los nodos del grafo
        Nodo nodoA = new Nodo("A");
        Nodo nodoB = new Nodo("B");
        Nodo nodoC = new Nodo("C");
        Nodo nodoD = new Nodo("D");
        Nodo nodoE = new Nodo("E");

        // Añadir las aristas a cada nodo
        nodoA.adyacencias.add(new Arista(nodoB, 5));
        nodoA.adyacencias.add(new Arista(nodoC, 10));
        nodoB.adyacencias.add(new Arista(nodoD, 3));
        nodoC.adyacencias.add(new Arista(nodoD, 1));
        nodoD.adyacencias.add(new Arista(nodoE, 2));

        // Crear el grafo y ejecutar el algoritmo de Dijkstra desde el nodo A
        Grafo grafo = new Grafo();
        grafo.dijkstra(nodoA);

        // Obtener y mostrar el camino más corto desde A hasta E
        List<Nodo> camino = grafo.obtenerCaminoMasCortoHasta(nodoE);
        System.out.println("Ruta más corta de A a E: " + camino);
    }

}
