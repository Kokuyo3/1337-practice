package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 704. Binary Search
 *
 * <p>https://leetcode.com/problems/binary-search/
 *
 * @author Cheryl Tang
 */
public class Problem704 extends Problem {

  public int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }

    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int pivot = left + (right - left) / 2;

      if (nums[pivot] == target) {
        return pivot;
      } else if (nums[pivot] < target) {
        left = pivot + 1;
      } else {
        right = pivot - 1;
      }
    }

    return -1;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[] {
          search(new int[] {-1, 0, 3, 5, 9, 12}, 9), // 4
          search(new int[] {-1, 0, 3, 5, 9, 12}, 2) // -1
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
