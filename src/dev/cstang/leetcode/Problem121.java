package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * <p>https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author Cheryl Tang
 */
public class Problem121 extends Problem {

  public int maxProfit(int[] prices) {
    int left = 0;
    int right = 1;
    int currentMax = 0;

    while (right < prices.length) {
      if (prices[right] > prices[left]) {
        int profit = prices[right] - prices[left];

        currentMax = Math.max(profit, currentMax);
      } else {
        left = right;
      }

      right += 1;
    }

    return currentMax;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[] {
          maxProfit(new int[] {7, 1, 5, 3, 6, 4}), // 5
          maxProfit(new int[] {7, 6, 4, 3, 1}), // 0
          maxProfit(new int[] {3, 8, 4, 0, 0, 5, 1}) // 5
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
