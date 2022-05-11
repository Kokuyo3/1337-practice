package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1971. Find if Path Exists in Graph
 *
 * <p>https://leetcode.com/problems/find-if-path-exists-in-graph/
 *
 * @author Cheryl Tang
 */
public class Problem1971 extends Problem {
  private Map<Integer, Set<Integer>> _convertToAdjacencyList(int[][] edges) {
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

  public boolean validPath(int n, int[][] edges, int source, int destination) {
    Map<Integer, Set<Integer>> graph = _convertToAdjacencyList(edges);

    return _hasPath(graph, source, destination, new HashSet<>());
  }

  private boolean _hasPath(
      Map<Integer, Set<Integer>> graph, int source, int destination, Set<Integer> visited) {
    if (visited.contains(source)) {
      return false;
    }

    visited.add(source);

    if (source == destination) {
      return true;
    }

    for (int neighbor : graph.get(source)) {
      if (_hasPath(graph, neighbor, destination, visited)) {
        return true;
      }
    }

    return false;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[] {
          validPath(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}, 0, 2), // true
          validPath(6, new int[][] {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5), // false
          validPath(
              10,
              new int[][] {
                {4, 3}, {1, 4}, {4, 8}, {1, 7}, {6, 4}, {4, 2}, {7, 4}, {4, 0}, {0, 9}, {5, 4}
              },
              5,
              9) // true
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
