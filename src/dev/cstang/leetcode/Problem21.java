package dev.cstang.leetcode;

import dev.cstang.Problem;

/**
 * 21. Merge Two Sorted Lists
 *
 * <p>https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * @author Cheryl Tang
 */
public class Problem21 extends Problem {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 != null && list2 != null) {
      ListNode sortedListNode = new ListNode(Math.min(list1.val, list2.val));

      if (list1.val < list2.val) {
        sortedListNode.next = mergeTwoLists(list1.next, list2);
      } else {
        sortedListNode.next = mergeTwoLists(list1, list2.next);
      }

      return sortedListNode;
    } else if (list1 != null) {
      return list1;
    } else {
      return list2;
    }
  }

  @Override
  public void runTestCases() {
    throw new IllegalCallerException(
        "Can't run test cases because this problem depends on API from the leetcode site that wasn't provided");
  }

  /** Definition for singly-linked list. */
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
