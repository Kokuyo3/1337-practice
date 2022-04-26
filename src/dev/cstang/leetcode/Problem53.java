package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 53. Maximum Subarray
 *
 * <p>https://leetcode.com/problems/maximum-subarray/
 *
 * @author Cheryl Tang
 */
public class Problem53 extends Problem {

  public int maxSubArray(int[] nums) {
    int localMax = nums[0];
    int globalMax = nums[0];

    for (int i = 1; i < nums.length; i++) {
      localMax = Math.max(nums[i], nums[i] + localMax);

      if (localMax > globalMax) {
        globalMax = localMax;
      }
    }

    return globalMax;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[] {
          maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}), // 6
          maxSubArray(new int[] {1}), // 1
          maxSubArray(new int[] {5, 4, -1, 7, 8}) // 23
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
