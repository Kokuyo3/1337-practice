package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 1790. Check if One String Swap Can Make Strings Equal
 *
 * <p>https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 *
 * @author Cheryl Tang
 */
public class Problem1790 extends Problem {

  public boolean areAlmostEqual(String s1, String s2) {
    if (s1.equals(s2)) {
      return true;
    }

    int charPositionDifferenceCount = 0;

    for (int i = 0; i < s1.length(); i++) {
      if (!s1.contains(String.valueOf(s2.charAt(i))) || charPositionDifferenceCount > 2) {
        return false;
      }

      if (s1.charAt(i) != s2.charAt(i)) {
        charPositionDifferenceCount++;
      }
    }

    return charPositionDifferenceCount == 2;
  }

  @Override
  public void runTestCases() {
    boolean[] testCaseSolutions =
        new boolean[] {
          areAlmostEqual("bank", "kanb"),
          areAlmostEqual("craa", "aaz"),
          areAlmostEqual("borsder", "rsordeb")
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
