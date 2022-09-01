package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 206. Reverse Linked List
 * <p>
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * @author Cheryl Tang
 */
public class Problem206 extends Problem {

  /**
   * This solution uses a `previous` and `next` variable to help reverse the `current` node step by
   * step.
   * <p>
   * The time complexity is O(N) where N = nodes in the LinkedList because we iterate over each node
   * once.
   * <p>
   * The space complexity is O(1) because space used doesn't scale with input size.
   */
  public ListNode reverseList(ListNode head) {
    ListNode current = head;
    ListNode previous = null;
    ListNode next = null;

    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    return previous;
  }

  @Override
  public void runTestCases() {
    throw new IllegalCallerException(
        "Can't run test cases because this problem depends on API from the leetcode site that wasn't provided");
  }

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
