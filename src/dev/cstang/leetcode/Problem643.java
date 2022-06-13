package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 643. Maximum Average Subarray I
 *
 * <p>https://leetcode.com/problems/maximum-average-subarray-i/
 *
 * @author Cheryl Tang
 */
public class Problem643 extends Problem {

  /**
   * This solution uses a Sliding Window pattern and runs in O(n) time complexity with O(1) space
   * complexity. This can alternatively be split into two sequential for loops, the first for
   * indices [0..k-1] and the second for [k..nums.length].
   */
  public double findMaxAverage(int[] nums, int k) {
    if (k == 0 || nums.length == 0) {
      return 0;
    }

    double maxAverage = Integer.MIN_VALUE;
    double windowSum = 0;
    int windowStart = 0;

    for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
      windowSum += nums[windowEnd];

      if (windowEnd >= k - 1) {
        maxAverage = Math.max(windowSum / k, maxAverage);

        windowSum -= nums[windowStart];

        windowStart++;
      }
    }

    return maxAverage;
  }


  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4), // 12.75
            findMaxAverage(new int[]{5}, 1), // 5
            findMaxAverage(new int[]{0}, 0), // 0
            findMaxAverage(new int[]{-1}, 1) // -1
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
