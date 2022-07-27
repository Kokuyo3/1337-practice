package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. Minimum Absolute Difference
 * <p>
 * https://leetcode.com/problems/minimum-absolute-difference/
 *
 * @author Cheryl Tang
 */
public class Problem1200 extends Problem {

  /**
   * This solution sorts the traverses the arr once while maintaining the current minDiff. The time
   * complexity is O(nlogn) where n = arr.length because we sort then traverse arr once. The space
   * complexity is O(n) because in the worst case where the diff of pairs is the same until the
   * final pair, we have n-2 pairs stored in the result list. If the difference between the largest
   * and smallest element in arr is not very large, a Count Sort approach would have a more
   * efficient time complexity of O(m + n) where m = difference between the largest and smallest
   * values in arr.
   */
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(arr);

    if (arr.length == 2) {
      List<Integer> pair = List.of(arr[0], arr[1], arr[0], arr[1]);

      result.add(pair);

      return result;
    }

    int diff;
    int minDiff = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length - 1; i++) {
      diff = arr[i + 1] - arr[i];

      if (diff < minDiff) {
        minDiff = diff;

        result.clear();
        result.add(List.of(arr[i], arr[i + 1]));
      } else if (diff == minDiff) {
        List<Integer> pair = List.of(arr[i], arr[i + 1]);

        if (!result.contains(pair)) {
          result.add(List.of(arr[i], arr[i + 1]));
        }
      }
    }

    return result;
  }

  /**
   * Count Sort solution (copy pasted)
   */
  public List<List<Integer>> minimumAbsDifferenceCountSort(int[] arr) {
    // Initialize the auxiliary array `line`.
    // Keep a record of the minimum element and the maximum element.
    int minElement = arr[0];
    int maxElement = arr[0];
    for (int num : arr) {
      minElement = Math.min(minElement, num);
      maxElement = Math.max(maxElement, num);
    }
    int shift = -minElement;
    int[] line = new int[maxElement - minElement + 1];
    List<List<Integer>> answer = new ArrayList();

    // For each integer `num` in `arr`, we increment line[num + shift] by 1.
    for (int num : arr) {
      line[num + shift] = 1;
    }

    // Start from the index representing the minimum integer, initialize the
    // absolute difference `min_pair_diff` as a huge value such as
    // `max_element - min_element` in order not to miss the absolute
    // difference of the first pair.
    int minPairDiff = maxElement - minElement;
    int prev = 0;

    // Iterate over the array `line` and check if line[curr]
    // holds the occurrence of an input integer.
    for (int curr = 1; curr <= maxElement + shift; ++curr) {
      // If line[curr] == 0, meaning there is no occurrence of the integer (curr - shift)
      // held by this index, we will move on to the next index.
      if (line[curr] == 0) {
        continue;
      }

      // If the difference (curr - prev) equals `minPairDiff`, we add this pair
      // {prev - shift, curr - shift} to the answer list. Otherwise, if the difference
      // (curr - prev) is smaller than `minPairDiff`, we empty the answer list and add
      // the pair {curr - shift, prev - shift} to the answre list and update the `minPairDiff`
      if (curr - prev == minPairDiff) {
        answer.add(Arrays.asList(prev - shift, curr - shift));
      } else if (curr - prev < minPairDiff) {
        answer = new ArrayList();
        minPairDiff = curr - prev;
        answer.add(Arrays.asList(prev - shift, curr - shift));
      }

      // Update prev as curr.
      prev = curr;
    }

    return answer;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            minimumAbsDifference(new int[]{4, 2, 1, 3}), // [[1,2],[2,3],[3,4]]
            minimumAbsDifference(new int[]{1, 3, 6, 10, 15}), // [[1,3]]
            minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27})
            // [[-14,-10],[19,23],[23,27]]
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
