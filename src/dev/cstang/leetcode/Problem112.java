package dev.cstang.leetcode;

import dev.cstang.Problem;

/**
 * 112. Path Sum
 *
 * <p>https://leetcode.com/problems/path-sum/
 *
 * @author Cheryl Tang
 */
public class Problem112 extends Problem {

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null) {
      return root.val == targetSum;
    }

    boolean leftHasSum = hasPathSum(root.left, targetSum - root.val);
    boolean rightHasSum = hasPathSum(root.right, targetSum - root.val);

    return leftHasSum || rightHasSum;
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
