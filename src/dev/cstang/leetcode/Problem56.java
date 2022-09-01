package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 * <p>
 * https://leetcode.com/problems/merge-intervals/
 *
 * @author Cheryl Tang
 */
public class Problem56 extends Problem {

  /**
   * This solution first sorts the array of intervals based on the start numbers, then compares the
   * previous interval with the current to determine if there is an overlap.
   * <p>
   * The time complexity is O(N*log(N)) because we sort the input array of intervals.
   * <p>
   * The space complexity is O(N) because we create a list of merged intervals, that in the worse
   * case (where there are no overlaps) will be the same as the original input.
   */
  public int[][] merge(int[][] intervals) {
    if (intervals.length < 2) {
      return intervals;
    }

    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

    List<int[]> mergedIntervals = new ArrayList<>();

    mergedIntervals.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      int prevEnd = mergedIntervals.get(mergedIntervals.size() - 1)[1];
      int curStart = intervals[i][0];

      if (prevEnd >= curStart) {
        mergedIntervals.get(mergedIntervals.size() - 1)[1] = Math.max(prevEnd, intervals[i][1]);
      } else {
        mergedIntervals.add(intervals[i]);
      }
    }

    return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
  }

  @Override
  public void runTestCases() {
    int[][][] testCaseSolutions =
        new int[][][]{
            merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}),
            merge(new int[][]{{1, 4}, {4, 5}}),
            merge(new int[][]{{1, 3}, {8, 10}}),
            merge(new int[][]{{1, 7}, {2, 6}, {5, 10}, {15, 18}})
        };

    for (int[][] testCaseSolution : testCaseSolutions) {
      Arrays.stream(testCaseSolution)
          .forEach(mergedInterval -> System.out.println(Arrays.toString(mergedInterval)));

      System.out.println("-----");
    }
  }
}
