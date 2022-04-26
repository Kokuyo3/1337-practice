package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * <p>https://leetcode.com/problems/two-sum/
 *
 * @author Cheryl Tang
 */
public class Problem1 extends Problem {

  /** Memoized solution */
  public int[] twoSum(int[] nums, int target) {
    int numLength = nums.length;

    Map<Integer, Integer> memo = new HashMap<>();

    for (int i = 0; i < numLength; i++) {
      memo.put(nums[i], i);
    }

    for (int i = 0; i < numLength; i++) {
      int remainder = target - nums[i];

      if (memo.containsKey(remainder) && memo.get(remainder) != i) {
        return new int[] {memo.get(remainder), i};
      }
    }

    return null;
  }

  @Override
  public void runTestCases() {
    int[][] testCaseSolutions =
        new int[][] {
          twoSum(new int[] {2, 7, 11, 15}, 9),
          twoSum(new int[] {3, 2, 4}, 6),
          twoSum(new int[] {3, 3}, 6)
        };

    Arrays.stream(testCaseSolutions)
        .forEach(solution -> System.out.println(Arrays.toString(solution)));
  }
}
