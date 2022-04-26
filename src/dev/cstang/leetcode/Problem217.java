package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 217. Contains Duplicate
 *
 * <p>https://leetcode.com/problems/contains-duplicate/
 *
 * @author Cheryl Tang
 */
public class Problem217 extends Problem {

  public boolean containsDuplicate(int[] nums) {
    Map<Integer, Boolean> valueMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (valueMap.containsKey(nums[i])) {
        return true;
      } else {
        valueMap.put(nums[i], true);
      }
    }

    return false;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[] {
          containsDuplicate(new int[] {1, 2, 3, 1}), // true
          containsDuplicate(new int[] {1, 2, 3, 4}), // false
          containsDuplicate(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}) // true
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
