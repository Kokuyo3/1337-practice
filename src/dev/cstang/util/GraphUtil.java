package dev.cstang.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Cheryl Tang
 */
public class GraphUtil {
  public static Map<Integer, Set<Integer>> convertEdgesToAdjacencyList(int[][] edges) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();

    for (int[] edge : edges) {
      if (!graph.containsKey(edge[0])) {
        graph.put(edge[0], new HashSet<>());
      }

      if (!graph.containsKey(edge[1])) {
        graph.put(edge[1], new HashSet<>());
      }

      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }

    return graph;
  }

  public static Map<Integer, Set<Integer>> convertMatrixToAdjacencyList(int[][] adjacencyMatrix) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();

    for (int i = 0; i < adjacencyMatrix.length; i++) {
      if (!graph.containsKey(i)) {
        graph.put(i, new HashSet<>());
      }

      Set<Integer> neighbors = graph.get(i);

      for (int j = 0; j < adjacencyMatrix.length; j++) {
        if (adjacencyMatrix[i][j] == 1) {
          neighbors.add(j);
        }
      }
    }

    return graph;
  }
}
