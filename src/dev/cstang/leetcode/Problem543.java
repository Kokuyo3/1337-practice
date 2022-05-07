package dev.cstang.leetcode;

import dev.cstang.Problem;

/**
 * 543. Diameter of Binary Tree
 *
 * <p>https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * @author Cheryl Tang
 */
public class Problem543 extends Problem {
  private int _max = 0;

  private int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftLength = maxDepth(root.left);
    int rightLength = maxDepth(root.right);

    _max = Math.max(_max, leftLength + rightLength);

    return 1 + Math.max(leftLength, rightLength);
  }

  public int diameterOfBinaryTree(TreeNode root) {
    maxDepth(root);

    return _max;
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
