package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 * <p>
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 *
 * @author Cheryl Tang
 */
public class Problem340 extends Problem {

  /**
   * This solution uses sliding window and a HashMap to store the frequency of each unique
   * character, witch characters being added/removed as the sliding window grows/shrinks.
   * <p>
   * The time complexity is O(N*k) where n = str.length() because the for loop iterates over each
   * character in the string where a while loop processes each character only once.
   * <p>
   * The space complexity is O(k) because that is the most characters that will be stored in the
   * HashMap.
   */
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (k == 0) {
      return 0;
    }

    int strLength = s.length();

    if (strLength <= k) {
      return strLength;
    }

    Map<Character, Integer> uniqueChars = new HashMap<>();
    int longestLength = 0;
    int windowStart = 0;

    for (int windowEnd = 0; windowEnd < strLength; windowEnd++) {
      char endChar = s.charAt(windowEnd);

      uniqueChars.put(endChar, uniqueChars.getOrDefault(endChar, 0) + 1);

      while (uniqueChars.size() > k) {
        char startChar = s.charAt(windowStart);

        uniqueChars.put(startChar, uniqueChars.get(startChar) - 1);

        windowStart++;

        if (uniqueChars.get(startChar) == 0) {
          uniqueChars.remove(startChar);
        }
      }

      longestLength = Math.max(longestLength, windowEnd - windowStart + 1);
    }
    return longestLength;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            lengthOfLongestSubstringKDistinct("eceba", 2), // 3
            lengthOfLongestSubstringKDistinct("aa", 1), // 2
            lengthOfLongestSubstringKDistinct("abaccc", 2) // 4
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
