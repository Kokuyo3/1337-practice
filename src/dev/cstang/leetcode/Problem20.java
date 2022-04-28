package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * <p>https://leetcode.com/problems/valid-parentheses/
 *
 * @author Cheryl Tang
 */
public class Problem20 extends Problem {

  private static final Map<Character, Character> _bracketPairs = _createBracketPairMap();

  private static Map<Character, Character> _createBracketPairMap() {
    Map<Character, Character> bracketPairs = new HashMap<>();

    bracketPairs.put('(', ')');
    bracketPairs.put('{', '}');
    bracketPairs.put('[', ']');

    return bracketPairs;
  }

  public boolean isValid(String s) {
    if (s.length() % 2 != 0) { // Invalid if string has odd number of chars
      return false;
    }

    if (!_bracketPairs.containsKey(s.charAt(0))) { // Invalid if first char isn't an open bracket
      return false;
    }

    Stack<Character> bracketStack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char currentBracket = s.charAt(i);

      if (_bracketPairs.containsKey(currentBracket)) { // Check if the char is another open bracket
        bracketStack.push(currentBracket);
      } else { // if closed bracket, check that it is a valid closer for the previous bracket
        if (!bracketStack.isEmpty() && currentBracket == _bracketPairs.get(bracketStack.peek())) {
          bracketStack.pop();
        } else {
          return false;
        }
      }
    }

    return bracketStack.size() == 0;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[] {
          isValid("(){}}{"), // false
          isValid("())"), // false
          isValid("()"), // true
          isValid("()[]{}"), // true
          isValid("(]"), // false
          isValid("))[}"), // false
          isValid("(({}))"), // true
          isValid("()[{}][]"), // true
          isValid("([{))]"), // false
          isValid("((") // false
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
