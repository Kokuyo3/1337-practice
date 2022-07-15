package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * <p>
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * @author Cheryl Tang
 */
public class Problem560 extends Problem {

  /**
   * This solution uses a map of prefix sums. The time complexity is O(n) where n is nums.length
   * because it loops over the length of nums once. The space complexity is O(n) where n is
   * nums.length because the size of the prefix sum map is the same as nums.
   */
  public int subarraySum(int[] nums, int k) {
    int subarrays = 0;
    int currentSum = 0;

    Map<Integer, Integer> prefixSums = new HashMap<>();

    prefixSums.put(0, 1);

    for (int n : nums) {
      currentSum += n;
      int diff = currentSum - k;

      subarrays += prefixSums.getOrDefault(diff, 0);

      prefixSums.put(currentSum, 1 + prefixSums.getOrDefault(currentSum, 0));
    }

    return subarrays;
  }


  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            subarraySum(new int[]{1, 2, 3}, 3), // 2
            subarraySum(new int[]{1, 1, 1}, 2), // 2
            subarraySum(new int[]{3, -2, 1, 0, -5}, 3), // 1
            subarraySum(new int[]{-1, -1, 1}, 0), // 1
            subarraySum(new int[]{1}, 1), // 1
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
