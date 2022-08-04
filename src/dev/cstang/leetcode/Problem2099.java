package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2099. Find Subsequence of Length K With the Largest Sum
 * <p>
 * https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
 *
 * @author Cheryl Tang
 */
public class Problem2099 extends Problem {

  /**
   * This solution uses a PriorityQueue with a created with comparator to sort by nums[index] in
   * ascending order.
   * <p>
   * The time complexity is O(n*log(k)) where n = nums.length because enqueing and dequeing is
   * O(log(n)). These methods are called at most twice for each value in nums.
   * <p>
   * The space complexity is O(k) because that is the maximum size of the PriorityQueue.
   */
  public int[] maxSubsequence(int[] nums, int k) {
    if (nums.length == k) {
      return nums;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> nums[i]));

    for (int i = 0; i < nums.length; ++i) {
      pq.offer(i);

      if (pq.size() > k) {
        pq.poll();
      }
    }
    return pq.stream().sorted().mapToInt(i -> nums[i]).toArray();
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            maxSubsequence(new int[]{2, 1, 3, 3}, 2),
            maxSubsequence(new int[]{-1, -2, 3, 4}, 3),
            maxSubsequence(new int[]{3, 4, 3, 3}, 2)
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
