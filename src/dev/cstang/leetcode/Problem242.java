package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 *
 * <p>https://leetcode.com/problems/valid-anagram/
 *
 * @author Cheryl Tang
 */
public class Problem242 extends Problem {

  /**
   * An alternate solution is to sort both strings then compare them. If they both contain the same
   * number of each letter, the sorted strings would be equal. This sacrifices time complexity (from
   * O(n) to O(n*log(n)) if a good sort algo is used) in return for O(1) space complexity. Although
   * technically, the underlying sort would be using space as well.
   */
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    if (s.equals(t)) {
      return true;
    }

    Map<Character, Integer> sCharacterMap = new HashMap<>();
    Map<Character, Integer> tCharacterMap = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      sCharacterMap.merge(s.charAt(i), 1, Integer::sum);
      tCharacterMap.merge(t.charAt(i), 1, Integer::sum);
    }

    return sCharacterMap.equals(tCharacterMap);
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[] {
          isAnagram("anagram", "nagaram"), // true
          isAnagram("leek", "keel"), // true
          isAnagram("rat", "car"), // false
          isAnagram("race", "tassle"), // false
          isAnagram("lock", "locl"), // false
          isAnagram("tab", "batt") // false
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
