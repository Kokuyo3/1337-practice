package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 *
 * <p>https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author Cheryl Tang
 */
public class Problem26 extends Problem {

  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int lastUniqueIndex = 0;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[lastUniqueIndex]) {
        lastUniqueIndex++;
        nums[lastUniqueIndex] = nums[i];
      }
    }

    return lastUniqueIndex + 1;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[] {
          removeDuplicates(new int[] {1, 1, 2}), // [1,2] -> 2
          removeDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}), // [0,1,2,3,4] -> 5
          removeDuplicates(new int[] {1, 1, 1}) // [1] -> 1
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
