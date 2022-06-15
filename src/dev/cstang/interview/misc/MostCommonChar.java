package dev.cstang.interview.misc;

import dev.cstang.Problem;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Find Most Common Letter in String
 * <p>
 * Counterpointe Solutions - Phone Screen
 * <p>
 * Similar to https://leetcode.com/discuss/interview-question/1761891/google-phone-screen-most-frequent-character-in-string-grouped-by-characters
 * <p>
 * Problem Statement: Write a method that finds the letter that appears the most number of times in
 * a string. If there's a tie, return either one. We can assue all letters are lowercase English
 * letters. Example "aaabb" returns "a", "cbcb" returns "b" or "c"
 *
 * @author Cheryl Tang
 */
public class MostCommonChar extends Problem {

  /**
   * This solution uses a HashMap to store the counts of each letter. It has a time complexity of
   * O(n) because it loops through the input once. The space complexity is O(1) because there are
   * only 26 possible letters since all letters in the input are lowercase English letters.
   */
  public char findLetter(String input) {
    Map<Character, Integer> letterCounts = new HashMap<>();

    int currentMax = 0;
    char mostCommonChar = 0;

    for (int i = 0; i < input.length(); i++) {
      char currentChar = input.charAt(i);

      int count = letterCounts.merge(input.charAt(i), 1, Integer::sum);

      if (count > currentMax) {
        currentMax = count;
        mostCommonChar = currentChar;
      }
    }

    return mostCommonChar;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            findLetter("aaabb"),
            findLetter("cbcb"),
            findLetter("anagramming")
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
