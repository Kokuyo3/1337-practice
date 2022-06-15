package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 169. Majority Element
 * <p>
 * https://leetcode.com/problems/majority-element/
 *
 * @author Cheryl Tang
 */
public class Problem169 extends Problem {

  /**
   * This solution sorts the input then finds the element at the mid index, since there will be at
   * least n/2 of the majority element. The time complexity is O(nlogn) because Arrays.sort was
   * called. The space complexity is O(n) because the underlying implementation of Arrays.sort uses
   * O(n) space when sorting primitives.
   */
  public int majorityElement(int[] nums) {
    Arrays.sort(nums);

    return nums[nums.length / 2];
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}), // 2
            majorityElement(new int[]{3, 2, 3}), // 3
            majorityElement(new int[]{1, 2, 1, 2, 1, 1}) // 1
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
