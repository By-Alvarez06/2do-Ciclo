package algoritmofloyd;

public class AlgoritmoFloyd {

    public static void main(String[] args) {
        // Ejemplo de grafo de entrada
        int[][] graph = {
            {0, 5, Integer.MAX_VALUE, 10},
            {Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };

        Floyd fw = new Floyd();
        fw.floydWarshall(graph);
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