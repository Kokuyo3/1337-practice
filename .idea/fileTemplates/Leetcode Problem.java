package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * ${LEETCODE_NUMBER}. ${LEETCODE_TITLE}
 *
 * <p>${LEETCODE_URL}
 *
 * @author Cheryl Tang
 */
public class Problem${LEETCODE_NUMBER} extends Problem {

  ${BASE_SOLUTION_METHOD}

  @Override
  public void runTestCases() {
#if (${USES_LEETCODE_API} && ${USES_LEETCODE_API} != "")
    throw new IllegalCallerException(
        "Can't run test cases because this problem depends on API from the leetcode site that wasn't provided");
#else
    // TODO
    Object[] testCaseSolutions =
        new Object[] {
          null,
          null,
          null
        };

    System.out.println(Arrays.toString(testCaseSolutions));
#end
  }
}
