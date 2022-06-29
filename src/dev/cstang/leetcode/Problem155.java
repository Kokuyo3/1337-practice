package dev.cstang.leetcode;

import dev.cstang.Problem;

/**
 * 155. Min Stack
 * <p>
 * https://leetcode.com/problems/min-stack/
 *
 * @author Cheryl Tang
 */
public class Problem155 extends Problem {

  @Override
  public void runTestCases() {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin()); // return -3
    minStack.pop();
    System.out.println(minStack.top());    // return 0
    System.out.println(minStack.getMin()); // return -2
  }

  /**
   * This solution uses an internal MinNode class to keep track of the next node in the stack and
   * the current min element if that node were to be at the top of the stack. The time complexity is
   * of all methods are O(1) because we are just using getters to access the MinNode fields. The
   * space complexity is O(n) where n is the number of items in the stack since we are creating a
   * MinNode object for each added value.
   */
  class MinStack {

    private MinNode _head;

    public MinStack() {
    }

    public void push(int val) {
      int min;

      if (_head == null) {
        min = val;
      } else {
        min = Math.min(val, _head.getMin());
      }

      _head = new MinNode(val, min, _head);
    }

    public void pop() {
      _head = _head.getNext();
    }

    public int top() {
      return _head.getValue();
    }

    public int getMin() {
      return _head.getMin();
    }

    private class MinNode {

      private final int _val;
      private final int _min;
      private final MinNode _next;

      public MinNode(int val, int min, MinNode next) {
        _next = next;
        _val = val;
        _min = min;
      }

      public int getMin() {
        return _min;
      }

      public MinNode getNext() {
        return _next;
      }

      public int getValue() {
        return _val;
      }
    }
  }
}
