package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 547. Number of Provinces
 *
 * <p>https://leetcode.com/problems/number-of-provinces/
 *
 * @author Cheryl Tang
 */
public class Problem547 extends Problem {
  private Map<Integer, Set<Integer>> _convertMatrixToAdjacencyList(int[][] adjacencyMatrix) {
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

  public int findCircleNum(int[][] isConnected) {
    Map<Integer, Set<Integer>> graph = _convertMatrixToAdjacencyList(isConnected);

    Set<Integer> visited = new HashSet<>();

    int provinceCount = 0;

    for (int currentNode : graph.keySet()) {
      if (_exploreProvince(currentNode, graph, visited)) {
        provinceCount++;
      }
    }

    return provinceCount;
  }

  private boolean _exploreProvince(
      int current, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
    if (visited.contains(current)) {
      return false;
    }

    visited.add(current);

    for (int neighbor : graph.get(current)) {
      _exploreProvince(neighbor, graph, visited);
    }

    return true;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[] {
          findCircleNum(new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}), // 2
          findCircleNum(new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}) // 3
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
