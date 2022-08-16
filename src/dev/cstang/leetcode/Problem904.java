package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 904. Fruits into Baskets
 * <p>
 * https://leetcode.com/problems/fruit-into-baskets/
 *
 * @author Cheryl Tang
 */
public class Problem904 extends Problem {

  /**
   * This solution uses a HashMap to store the frequencies of each unique fruit. The time complexity
   * is O(N + N) where N = fruits.length, which simplifies to O(N) because we iterate over each item
   * in fruits once and the while loops over at most N items. The space complexity is O(1) because
   * the HashMap will only ever store at most 3 entries.
   */
  public int totalFruit(int[] fruits) {
    if (fruits.length <= 2) {
      return fruits.length;
    }

    int windowStart = 0;
    int maxFruitCount = 0;
    HashMap<Integer, Integer> fruitFrequencies = new HashMap<>();

    for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
      fruitFrequencies.merge(fruits[windowEnd], 1, Integer::sum);

      while (fruitFrequencies.size() > 2) {
        fruitFrequencies.computeIfPresent(fruits[windowStart], (key, val) ->
            val - 1 == 0 ? null : val - 1);

        windowStart++;
      }

      maxFruitCount = Math.max(maxFruitCount, windowEnd - windowStart + 1);
    }

    return maxFruitCount;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            totalFruit(new int[]{0, 1, 2, 2}),
            totalFruit(new int[]{1, 2, 3, 2, 2}),
            totalFruit(new int[]{1, 2, 1})
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
