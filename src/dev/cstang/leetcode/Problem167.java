package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 167. Two Sum II - Input Array Is Sorted
 *
 * <p>https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author Cheryl Tang
 */
public class Problem167 extends Problem {

  /**
   * This solution uses a Two Pointer pattern. It has a time complexity of O(n) and uses O(1) space.
   * Since the input array is sorted, we can increment the left pointer if the sum is less than the
   * target or decrement the right pointer if the sum is greater than the target. This is repeated
   * until both pointers add up to the target sum.
   */
  public int[] twoSum(int[] numbers, int target) {
    if (numbers.length == 2 && (numbers[0] + numbers[1] == target)) {
      return new int[]{1, 2};
    }

    int left = 0;
    int right = numbers.length - 1;

    int[] solution = new int[2];

    while (left < right) {
      int twoSum = numbers[left] + numbers[right];

      if (twoSum < target) {
        left++;
      } else if (twoSum > target) {
        right--;
      } else {
        solution[0] = left + 1;
        solution[1] = right + 1;

        break;
      }
    }

    return solution;
  }

  @Override
  public void runTestCases() {
    int[][] testCaseSolutions =
        new int[][]{
            twoSum(new int[]{2, 7, 11, 15}, 9), // [1,2]
            twoSum(new int[]{2, 3, 4}, 6), // [1, 3]
            twoSum(new int[]{3, 3}, 6), // [1, 2]
            twoSum(new int[]{-1, 0}, -1) // [1, 2]
        };

    Arrays.stream(testCaseSolutions)
        .forEach(solution -> System.out.println(Arrays.toString(solution)));
  }
}
