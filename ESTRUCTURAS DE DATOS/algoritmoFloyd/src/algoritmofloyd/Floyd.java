/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmofloyd;

public class Floyd {
    
    static final int INF = 99999; // Representa la "infinitud"

    public void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];
        int[][] pred = new int[V][V];

        // Inicializar la matriz de distancias y de predecesores
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (i == j || graph[i][j] == INF) {
                    pred[i][j] = -1; // No hay predecesor
                } else {
                    pred[i][j] = i; // El predecesor de j es i
                }
            }
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // Si k es un vértice intermedio en el camino de i a j y mejora el camino
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pred[i][j] = pred[k][j]; // Actualizar predecesor de j a k
                    }
                }
            }
        }

        // Imprimir la matriz de distancias mínimas y los caminos más cortos
        printSolution(dist, pred, V);
    }

    // Método para imprimir la solución
    public void printSolution(int[][] dist, int[][] pred, int V) {
        System.out.println("Matriz de distancias mínimas entre cada par de vértices:");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }

        System.out.println("\nCaminos más cortos:");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && pred[i][j] != -1) {
                    System.out.print("Camino desde " + i + " hasta " + j + ": " + i);
                    printPath(pred, i, j);
                    System.out.println();
                }
            }
        }
    }

    // Método recursivo para imprimir el camino desde el vértice origen al vértice destino
    private void printPath(int[][] pred, int i, int j) {
        if (i != j) {
            printPath(pred, i, pred[i][j]);
            System.out.print(" -> " + j);
        }
    }
}
