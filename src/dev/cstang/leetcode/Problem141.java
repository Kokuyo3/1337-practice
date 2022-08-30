package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 141. Linked List Cycle
 * <p>
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * @author Cheryl Tang
 */
public class Problem141 extends Problem {

  /**
   * This solution uses a fast and slow pointer to detect a cycle based on whether the two pointers
   * eventually meet. The time complexity is O(N) where N = number of nodes in the linked list
   * because the fast pointer will meet the slow pointer in the loop once the slow pointer enters
   * the cycle. The space complexity is O(1) because the space used doesn't scale with the input size.
   */
  public boolean hasCycle(ListNode head) {
    ListNode fastPointer = head;
    ListNode slowPointer = head;

    while (fastPointer != null && fastPointer.next != null) {
      fastPointer = fastPointer.next.next;
      slowPointer = slowPointer.next;

      if (slowPointer == fastPointer) {
        return true;
      }
    }

    return false;
  }

  @Override
  public void runTestCases() {
    throw new IllegalCallerException(
        "Can't run test cases because this problem depends on API from the leetcode site that wasn't provided");
  }

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
