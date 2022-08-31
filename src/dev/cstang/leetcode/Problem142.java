package dev.cstang.leetcode;

import dev.cstang.Problem;

/**
 * 142. Linked List Cycle II
 * <p>
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * @author Cheryl Tang
 */
public class Problem142 extends Problem {

  /**
   * This solution uses a fast and slow pointer to find the length of the LinkedList cycle, then
   * moves the fastPointer ahead of head by that length. Then, both the slow and fast pointers are
   * incremented one node at a time until they meet - since the fast pointer is a cycle length ahead
   * of the slow pointer, it must have completed one loop in the cycle when they meet. That meeting
   * point will be the start of the cycle.
   * <p>
   * The time complexity is O(N) where N is the number of nodes in the LinkedList because we iterate
   * over the length of the LinkedList at most 3 times in the worst case. This would be O(3N), which
   * simplifies to O(N).
   * <p>
   * The space complexity is O(1) because space used does not scale with the length of the
   * LinkedList.
   */
  public ListNode detectCycle(ListNode head) {
    if (head.next == null) {
      return null;
    }

    ListNode fastPointer = head;
    ListNode slowPointer = head;

    while (fastPointer != null && fastPointer.next != null) {
      fastPointer = fastPointer.next.next;
      slowPointer = slowPointer.next;

      if (fastPointer == slowPointer) {
        int cycleLength = calculateCycleLength(slowPointer);

        slowPointer = head;
        fastPointer = head;

        for (int i = 0; i < cycleLength; i++) {
          fastPointer = fastPointer.next;
        }

        while (fastPointer != slowPointer) {
          fastPointer = fastPointer.next;
          slowPointer = slowPointer.next;
        }

        return slowPointer;
      }
    }

    return null;
  }

  private int calculateCycleLength(ListNode slowPointer) {
    ListNode current = slowPointer;
    int length = 0;

    do {
      current = current.next;
      length++;
    } while (current != slowPointer);

    return length;
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
