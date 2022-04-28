package dev.cstang.leetcode;

import dev.cstang.Problem;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * <p>https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * @author Cheryl Tang
 */
public class Problem104 extends Problem {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int leftDepth = maxDepth(root.left);
      int rightDepth = maxDepth(root.right);

      return 1 + Math.max(leftDepth, rightDepth);
    }
  }

  @Override
  public void runTestCases() {
    throw new IllegalCallerException(
        "Can't run test cases because this problem depends on API from the leetcode site that wasn't provided");
  }

  /** Definition for a binary tree node. */
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
