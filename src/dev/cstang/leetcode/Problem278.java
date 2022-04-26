package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 278. First Bad Version
 *
 * <p>https://leetcode.com/problems/first-bad-version/
 *
 * @author Cheryl Tang
 */
public class Problem278 extends Problem {

  private static int FIRST_BAD_VERSION;

  /* The isBadVersion API is defined in the parent class VersionControl.
  boolean isBadVersion(int version); */
  public int firstBadVersion(int n) {
    FIRST_BAD_VERSION = (int) (Math.random() * (n - 1)) + 1; // For running outside leetcode site
    System.out.println("bad = " + FIRST_BAD_VERSION); // For running outside leetcode site

    int left = 1;
    int right = n;

    while (left < right) {
      int pivot = left + (right - left) / 2;

      if (isBadVersion(pivot)) {
        right = pivot;
      } else {
        left = pivot + 1;
      }
    }

    return left;
  }

  private boolean isBadVersion(int pivot) {
    return pivot >= FIRST_BAD_VERSION;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[] {
          firstBadVersion(5),
          firstBadVersion(36),
          firstBadVersion(15),
          firstBadVersion(21),
          firstBadVersion(143),
          firstBadVersion(9),
          firstBadVersion(1)
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
