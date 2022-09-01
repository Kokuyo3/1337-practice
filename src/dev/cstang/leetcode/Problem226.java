package dev.cstang.leetcode;

import dev.cstang.Problem;

/**
 * 226. Invert Binary Tree
 * <p>
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * @author Cheryl Tang
 */
public class Problem226 extends Problem {

  /**
   * This solution uses recursion to swap the left and right children of each node.
   * <p>
   * The time complexity is O(N) where N = nodes in the tree because we visit each one to invert
   * it.
   * <p>
   * The space complexity is O(N) where N = nodes in the tree. The complexity is technically O(h)
   * where h = height of the tree, since each level is another call in the stack due to the
   * recursion. However, in the worst case there is only one child per node, so N = h in such a
   * case.
   */
  public TreeNode invertTree(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return root;
    }

    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    root.left = right;
    root.right = left;

    return root;
  }

  @Override
  public void runTestCases() {
    throw new IllegalCallerException(
        "Can't run test cases because this problem depends on API from the leetcode site that wasn't provided");
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

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
