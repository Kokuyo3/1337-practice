package dev.cstang.leetcode;

import dev.cstang.Problem;

/**
 * 100. Same Tree
 *
 * <p>https://leetcode.com/problems/same-tree/
 *
 * @author Cheryl Tang
 */
public class Problem100 extends Problem {

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    } else if (p == null || q == null) {
      return false;
    }

    if (p.val == q.val) {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    return false;
  }

  @Override
  public void runTestCases() {
    throw new IllegalCallerException(
        "Can't run test cases because this problem depends on API from the leetcode site that wasn't provided");
  }

  /* Definition for a binary tree node. */
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
