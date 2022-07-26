package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 441. Arranging Coins
 * <p>
 * https://leetcode.com/problems/arranging-coins/
 *
 * @author Cheryl Tang
 */
public class Problem441 extends Problem {

  /**
   * This solution uses binary search and a math formula used as the constraint for the number of
   * coins needed for k rows: k * (k + 1) / 2 <= n. The time complexity is O(log(N)) because of the
   * binary search approach. The space complexity is O(1) because we only store variables unrelated
   * to the size of the input. This can also be solved by solving for k using the above mentioned
   * formula.
   */
  public int arrangeCoins(int n) {
    long left = 0;
    long right = n;
    long mid;
    long coins;

    while (left <= right) {
      mid = left + (right - left) / 2;
      coins = mid * (mid + 1) / 2;

      if (coins == n) {
        return (int) mid;
      }

      if (n < coins) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return (int) right;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            arrangeCoins(5), // 2
            arrangeCoins(1804289383) // 60070
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
