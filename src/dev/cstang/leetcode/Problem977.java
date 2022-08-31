package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 * <p>
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * @author Cheryl Tang
 */
public class Problem977 extends Problem {

  /**
   * This solution uses two pointers, where one moves forward to iterate non-negative numbers and
   * the other moves backwards to iterate negative numbers. The time complexity is O(N) where N =
   * nums.length because we iterate the input array only once. The space complexity is O(N) because
   * of the output array, `squares`.
   */
  public static int[] sortedSquares(int[] nums) {
    int[] squares = new int[nums.length];
    int left = 0;
    int right = nums.length - 1;
    int index = nums.length - 1;

    while (left <= right) {
      int leftPow = nums[left] * nums[left];
      int rightPow = nums[right] * nums[right];

      if (leftPow < rightPow) {
        squares[index--] = rightPow;
        right--;
      } else {
        squares[index--] = leftPow;
        left++;
      }
    }
    return squares;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            sortedSquares(new int[]{-4, -1, 0, 3, 10}), // [0,1,9,16,100]
            sortedSquares(new int[]{-7, -3, 2, 3, 11}) // [4,9,9,49,121]
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
