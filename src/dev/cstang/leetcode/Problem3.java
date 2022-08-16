package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @author Cheryl Tang
 */
public class Problem3 extends Problem {

  /**
   * This solution uses a HashSet to store each unique character. The time complexity is O(N+N)
   * where N = s.length(), which simplifies to O(N), because we loop over the length of s once and
   * the while loop iterates over at most s.length() characters. The space complexity is O(N) where
   * N = s.length() because in the worst case where s only has unique letters, the HashSet would
   * contain s.length() items.
   */
  public int lengthOfLongestSubstring(String s) {
    if (s.length() < 2) {
      return s.length();
    }

    int windowStart = 0;
    int longestLength = 0;

    HashSet<Character> uniqueCharacters = new HashSet<>();
    for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
      while (uniqueCharacters.contains(s.charAt(windowEnd))) {
        uniqueCharacters.remove(s.charAt(windowStart));
        windowStart++;
      }

      uniqueCharacters.add(s.charAt(windowEnd));

      longestLength = Math.max(longestLength, windowEnd - windowStart + 1);
    }

    return longestLength;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            lengthOfLongestSubstring("abcabcbb"),
            lengthOfLongestSubstring("bbbbb"),
            lengthOfLongestSubstring("pwwkew"),
            lengthOfLongestSubstring("   "),
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
