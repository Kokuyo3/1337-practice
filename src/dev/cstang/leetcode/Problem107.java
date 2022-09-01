package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. Binary Tree Level Order Traversal II
 * <p>
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * @author Cheryl Tang
 */
public class Problem107 extends Problem {

  /**
   * This solution uses a Queue to hold each level of nodes.
   * <p>
   * The time complexity is O(N) where N = number of nodes in the tree because we iterate over each
   * node once.
   * <p>
   * The space complexity is O(N) because we return a List with the same number of elements as the
   * number of nodes in the tree.
   */
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();

    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();

      List<Integer> levelValues = new ArrayList<>(levelSize);

      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.remove();

        levelValues.add(node.val);

        if (node.left != null) {
          queue.add(node.left);
        }

        if (node.right != null) {
          queue.add(node.right);
        }
      }

      result.add(0,
          levelValues); // Can also use Collections.reverse on an ArrayList instead of LinkedList.add at index 0
    }

    return result;
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
