package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 1708. Largest Subarray with Length K
 *
 * <p>https://leetcode.com/problems/largest-subarray-length-k/
 *
 * @author Cheryl Tang
 */
public class Problem1708 extends Problem {

  /**
   * This solution uses a Sliding Window pattern to find the largest element in nums from
   * [0..nums.length - k] since a subarray A is larger than an array B if it's first index i where
   * A[i] != B[i] and A[i] > B[i]. By finding the largest value, any subarray started from that will
   * be the largest under those constraints. This solution runs in O(n) time complexity and O(1)
   * space complexity.
   */
  public int[] largestSubarray(int[] nums, int k) {
    int maxValue = Integer.MIN_VALUE;
    int maxIndex = 0;

    for (int i = 0; i <= nums.length - k; i++) {
      if (nums[i] > maxValue) {
        maxValue = nums[i];
        maxIndex = i;
      }
    }

    return Arrays.copyOfRange(nums, maxIndex, maxIndex + k);
  }

  @Override
  public void runTestCases() {
    int[][] testCaseSolutions =
        new int[][]{
            largestSubarray(new int[]{1, 4, 5, 2, 3}, 3),
            largestSubarray(new int[]{1, 4, 5, 2, 3}, 4),
            largestSubarray(new int[]{1, 4, 5, 2, 3}, 1)
        };

    Arrays.stream(testCaseSolutions)
        .forEach(solution -> System.out.println(Arrays.toString(solution)));
  }
}
