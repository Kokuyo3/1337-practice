package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 1295. Find Numbers with Even Number of Digits
 *
 * <p>https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 *
 * @author Cheryl Tang
 */
public class Problem1295 extends Problem {

  public int findNumbers(int[] nums) {
    int evenCount = 0;

    for (int n : nums) {
      int digits = 0;

      while (n != 0) {
        n /= 10;
        digits++;
      }

      if (digits % 2 == 0) {
        evenCount++;
      }
    }

    return evenCount;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[] {
          findNumbers(new int[] {12, 345, 2, 6, 7896}), // 2
          findNumbers(new int[] {555, 901, 482, 1771}), // 1
          findNumbers(
              new int[] {5, 789, 15, 17952, 1561, 18975645, 489875, 454654, 4841, 484, 983}) // 6
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
