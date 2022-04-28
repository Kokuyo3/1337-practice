package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 125. Valid Palindrome
 *
 * <p>https://leetcode.com/problems/valid-palindrome/
 *
 * @author Cheryl Tang
 */
public class Problem125 extends Problem {

  public boolean isPalindrome(String s) {
    StringBuilder sb = new StringBuilder();

    for (char c : s.trim().toLowerCase().toCharArray()) {
      if (Character.isLetterOrDigit(c)) {
        sb.append(c);
      }
    }

    String formattedString = sb.toString();

    if (formattedString.length() <= 1) {
      return true;
    }

    return formattedString.equals(sb.reverse().toString());
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            isPalindrome("assa"), // true
            isPalindrome("asdsb"), // false
            isPalindrome("A man, a plan, a canal: Panama"), // true
            isPalindrome("race a car"), // false
            isPalindrome(" "), // true
            isPalindrome("  asdfdsa         "), // true
            isPalindrome("0P") // false
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
