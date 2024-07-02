package algoritmofloyd;
/*
AUTORES: BYRON ALVAREZ - DANIEL CAMPOVERDE
*/

import static algoritmofloyd.Floyd.INF;

public class AlgoritmoFloyd {

    public static void main(String[] args) {
        // Ejemplo de grafo de entrada
        int[][] graph = {
            {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };
        int V = graph.length;

        Floyd fw = new Floyd();
        fw.floydWarshall(graph, V);
    }
}

/*
      10
 (0)------->(3)
  |         /|\
5 |          |
  |          | 1
 \|/         |
 (1)------->(2)
      3
*/
