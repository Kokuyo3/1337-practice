package dev.cstang.interview.amazon.OA1;

import dev.cstang.Problem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Amazon Hackerrank Online Assessment 1, Question 2 (5-11-2022)
 *
 * <p>https://leetcode.com/discuss/interview-question/373202/amazon-oa-2019-optimal-utilization
 *
 * @author Cheryl Tang
 */
public class Problem2 extends Problem {

  public static List<List<Integer>> applicationPairs(
      int deviceCapacity,
      List<List<Integer>> foregroundAppList,
      List<List<Integer>> backgroundAppList) {

    foregroundAppList.sort(Comparator.comparingInt(o -> o.get(1)));
    backgroundAppList.sort(Comparator.comparingInt(o -> o.get(1)));

    List<List<Integer>> optimalPairs = new ArrayList<>();

    int left = 0;
    int right = foregroundAppList.size() - 1;
    int currentMax = 0;

    while (left < backgroundAppList.size() && right >= 0) {
      List<Integer> foregroundApp = foregroundAppList.get(right);
      List<Integer> backgroundApp = backgroundAppList.get(left);

      int pairMemorySum = foregroundApp.get(1) + backgroundApp.get(1);

      if (pairMemorySum > deviceCapacity) {
        right--;
      } else {
        if (pairMemorySum < currentMax) {
          left++;
          continue;
        } else if (pairMemorySum > currentMax) {
          currentMax = pairMemorySum;

          optimalPairs.clear();
        }

        List<Integer> pair = new ArrayList<>();
        pair.add(foregroundApp.get(0));
        pair.add(backgroundApp.get(0));

        optimalPairs.add(pair);

        left++;
      }
    }

    return optimalPairs;
  }

  @Override
  public void runTestCases() {
    System.out.println(
        applicationPairs(
            7,
            new ArrayList<>(
                Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 4), Arrays.asList(3, 6))),
            new ArrayList<>(Collections.singletonList(Arrays.asList(1, 2)))));

    System.out.println(
        applicationPairs(
            10,
            new ArrayList<>(
                Arrays.asList(
                    Arrays.asList(1, 3),
                    Arrays.asList(2, 5),
                    Arrays.asList(3, 7),
                    Arrays.asList(4, 10))),
            new ArrayList<>(
                Arrays.asList(
                    Arrays.asList(1, 2),
                    Arrays.asList(2, 3),
                    Arrays.asList(3, 4),
                    Arrays.asList(4, 5)))));

    System.out.println(
        applicationPairs(
            20,
            new ArrayList<>(
                Arrays.asList(Arrays.asList(1, 8), Arrays.asList(2, 7), Arrays.asList(3, 14))),
            new ArrayList<>(
                Arrays.asList(Arrays.asList(1, 5), Arrays.asList(2, 10), Arrays.asList(3, 14)))));

    System.out.println(
        applicationPairs(
            20,
            new ArrayList<>(
                Arrays.asList(Arrays.asList(1, 8), Arrays.asList(2, 15), Arrays.asList(3, 9))),
            new ArrayList<>(
                Arrays.asList(Arrays.asList(1, 8), Arrays.asList(2, 11), Arrays.asList(3, 12)))));
  }
}
