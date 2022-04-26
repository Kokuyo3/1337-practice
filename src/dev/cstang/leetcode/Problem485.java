package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 485. MAx Consecutive Ones
 *
 * <p>https://leetcode.com/problems/max-consecutive-ones/
 *
 * @author Cheryl Tang
 */
public class Problem485 extends Problem {

  public int findMaxConsecutiveOnes(int[] nums) {
    int consecutive = 0;
    int consecutiveMax = 0;

    for (int i : nums) {
      if (i == 1) {
        consecutive++;
      } else if (i == 0) {
        if (consecutive > consecutiveMax) {
          consecutiveMax = consecutive;
        }
        consecutive = 0;
      }
    }

    return Math.max(consecutive, consecutiveMax);
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[] {
          findMaxConsecutiveOnes(new int[] {1, 1, 0, 1, 1, 1}), // 3
          findMaxConsecutiveOnes(new int[] {1, 0, 1, 1, 0, 1}), // 2
          findMaxConsecutiveOnes(new int[] {1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1}), // 5
          findMaxConsecutiveOnes(new int[] {1, 0, 0, 0, 0, 1}), // 1
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
