package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 347. Top K Frequent Elements
 * <p>
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * @author Cheryl Tang
 */
public class Problem347 extends Problem {

  /**
   * This solution uses a HashMap to store the counts of each array element. The time complexity is
   * O(nlogn), where n = nums.length because stream sort is called. The space complexity is O(n)
   * because each unique element in nums is stored in a HashMap.
   */
  public int[] topKFrequentBrute(int[] nums, int k) {
    if (nums.length == k) {
      return nums;
    }

    Map<Integer, Integer> frequencyMap = _getFrequencyMap(nums);

    return frequencyMap.entrySet().stream()
        .sorted(((o1, o2) -> o2.getValue().compareTo(o1.getValue())))
        .limit(k)
        .mapToInt(Entry::getKey)
        .toArray();
  }

  /**
   * This solution uses Bucket Sorting to store an inverted frequency array. The space complexity is
   * O(n), simplified from O(n) + O(k) where n = nums.length. The space complexity is O(n).
   */
  public int[] topKFrequent(int[] nums, int k) {
    if (nums.length == k) {
      return nums;
    }

    Map<Integer, Integer> frequencyMap = _getFrequencyMap(nums);

    LinkedList<Integer>[] frequencyBuckets = _bucketSort(frequencyMap, nums.length);

    int[] topK = new int[k];
    int topIndex = 0;

    for (LinkedList<Integer> bucket : frequencyBuckets) {
      if (bucket == null) {
        continue;
      }

      for (int num : bucket) {
        topK[topIndex++] = num;

        if (topIndex == k) {
          return topK;
        }
      }
    }

    return topK;
  }

  private LinkedList<Integer>[] _bucketSort(Map<Integer, Integer> frequencyMap, int bucketMax) {
    LinkedList<Integer>[] buckets = new LinkedList[bucketMax];

    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
      int num = entry.getKey();
      int frequency = entry.getValue();
      int index = bucketMax - frequency;

      if (buckets[index] == null) {
        buckets[index] = new LinkedList<>();
      }

      buckets[index].addFirst(num);
    }

    return buckets;
  }

  private Map<Integer, Integer> _getFrequencyMap(int[] nums) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();

    for (int num : nums) {
      frequencyMap.merge(num, 1, Integer::sum);
    }

    return frequencyMap;
  }

  @Override
  public void runTestCases() {
    int[][] testCaseSolutions =
        new int[][]{
            topKFrequent(new int[]{-1, 1}, 1),
            topKFrequent(new int[]{3, 4, 3, 2, 2, 3}, 2),
            topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2),
            topKFrequent(new int[]{1}, 1)
        };

    Arrays.stream(testCaseSolutions)
        .forEach(solution -> System.out.println(Arrays.toString(solution)));
  }
}
