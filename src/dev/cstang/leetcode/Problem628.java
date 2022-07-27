package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 628. Maximum Product of Three Numbers
 * <p>
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 *
 * @author Cheryl Tang
 */
public class Problem628 extends Problem {

  /**
   * This solution sorts the input array then finds the max between: the product of the last 3 array
   * elements vs the product of the first 2 and last array elements (in case a product with 2
   * negative and 1 positive elements is greater). The time complexity is O(nlogn) where n =
   * nums.length because we sort the input array. The space complexity is O(logn) because
   * Arrays.sort() takes O(logn) space.
   */
  public int maximumProductSort(int[] nums) {
    int length = nums.length;

    if (length == 3) {
      return nums[0] * nums[1] * nums[2];
    }

    Arrays.sort(nums);

    return Math.max(nums[0] * nums[1] * nums[length - 1],
        nums[length - 1] * nums[length - 2] * nums[length - 3]);
  }

  /**
   * This optimal solution loops through the input array once to find and store the 2 smallest (min1
   * and min2) and the three largest values(max1, max2, max3). We then find the max between (max1 *
   * max2 * max3) and (min1 * min2 * max1), where the latter checks for the case where a product of
   * 2 negative and 1 positive elements may be greater. The time complexity is O(n) where n =
   * nums.length because we iterate over it once. The space complexity is O(1) because we only store
   * 3 max and 2 min variables.
   */
  public int maximumProduct(int[] nums) {
    if (nums.length == 3) {
      return nums[0] * nums[1] * nums[2];
    }

    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int max3 = Integer.MIN_VALUE;

    for (int num : nums) {
      if (num >= max1) {
        max3 = max2;
        max2 = max1;
        max1 = num;
      } else if (num >= max2) {
        max3 = max2;
        max2 = num;
      } else if (num >= max3) {
        max3 = num;
      }

      if (num <= min1) {
        min2 = min1;
        min1 = num;
      } else if (num <= min2) {
        min2 = num;
      }
    }

    return Math.max(min1 * min2 * max1, max1 * max2 * max3);
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            maximumProduct(new int[]{1, 2, 3}),
            maximumProduct(new int[]{1, 2, 3, 4}),
            maximumProduct(new int[]{-1, -2, -3}),
            maximumProduct(new int[]{-1, -2, -3, 1, 2, 3})
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
