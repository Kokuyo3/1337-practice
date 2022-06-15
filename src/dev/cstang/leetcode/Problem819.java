package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 819. Most Common Word
 * <p>
 * https://leetcode.com/problems/most-common-word/
 *
 * @author Cheryl Tang
 */
public class Problem819 extends Problem {

  /**
   * This solution uses a HashMap and HashSet to store the word counts and banned words,
   * respectively. The time complexity is O(n + k) where n = paragraph.length() and k =
   * banned.length() because the solution iterates over n and k one time each. The space complexity
   * is O(n + k) because we have a HashMap to count the frequency of each unique word and a HashSet
   * to store the banned words.
   */
  public String mostCommonWord(String paragraph, String[] banned) {
    String[] splitParagraph = paragraph.split("[\\s\"!?',;.]+");

    Set<String> bannedWords = new HashSet<>();

    for (String bannedWord : banned) {
      bannedWords.add(bannedWord.toLowerCase());
    }

    Map<String, Integer> wordCounts = new HashMap<>();

    int maxCount = 0;
    String mostCommonWord = null;

    for (String word : splitParagraph) {
      String lowercaseWord = word.toLowerCase();

      if (!bannedWords.contains(lowercaseWord)) {
        int count = wordCounts.merge(lowercaseWord, 1, Integer::sum);

        if (count > maxCount) {
          maxCount = count;
          mostCommonWord = lowercaseWord;
        }
      }
    }

    return mostCommonWord;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"}),
            mostCommonWord("a.", new String[]{}),
            mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{})
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
