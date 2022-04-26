package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 495. Teemo Attacking
 *
 * <p>https://leetcode.com/problems/teemo-attacking/
 *
 * @author Cheryl Tang
 */
public class Problem495 extends Problem {

  public int findPoisonedDuration(int[] timeSeries, int duration) {
    if (duration == 0) {
      return 0;
    }

    int poisonDuration = duration;

    for (int i = 0; i < timeSeries.length - 1; i++) {
      if (timeSeries[i + 1] - timeSeries[i] < duration) {
        poisonDuration += (timeSeries[i + 1] - timeSeries[i]);
      } else {
        poisonDuration += duration;
      }
    }

    return poisonDuration;
  }

  @Override
  public void runTestCases() {
    int[] testCaseSolutions =
        new int[] {
          findPoisonedDuration(new int[] {1, 4}, 2),
          findPoisonedDuration(new int[] {1, 2}, 2),
          findPoisonedDuration(new int[] {1, 7}, 3),
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
