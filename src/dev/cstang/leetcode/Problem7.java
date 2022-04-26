package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;
import java.util.Stack;

/**
 * 7. Reverse Integer
 *
 * <p>https://leetcode.com/problems/reverse-integer/
 *
 * @author Cheryl Tang
 */
public class Problem7 extends Problem {

  public int reverse(int x) {
    char[] charArray = String.valueOf(x).toCharArray();
    Stack<Character> digitStack = new Stack<>();

    for (char digit : charArray) {
      digitStack.push(digit);
    }

    StringBuilder reversedSb = new StringBuilder(charArray.length);

    for (int i = 0; i < charArray.length; i++) {
      char digit = digitStack.pop();

      if (digit != '-') {
        reversedSb.append(digit);
      } else {
        reversedSb.insert(0, digit);
      }
    }

    long reversedLong = Long.parseLong(reversedSb.toString());

    if ((reversedLong > Integer.MIN_VALUE) && (reversedLong < Integer.MAX_VALUE)) {
      return (int) reversedLong;
    } else {
      return 0;
    }
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[] {
          reverse(123), // 321
          reverse(-123), // -321
          reverse(120) // 21
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
