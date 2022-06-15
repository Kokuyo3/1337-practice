package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.Arrays;

/**
 * 74. Search a 2D Matrix
 * <p>
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * @author Cheryl Tang
 */
public class Problem74 extends Problem {

  /**
   * This solution uses a 2D binary search to find the target value. Binary Search is used to find
   * the correct row before searching that row horizontally. The time complexity is O(log(m*n))
   * where m = the number of rows in the matrix and n = the number of columns in the matrix because
   * we do a binary search for the row then another binary search for the column. This is O(logm) +
   * O(logn) which simplifies to O(log(m*n)). The space complexity is O(1) because the variables
   * used don't scale with the input size.
   * <p>
   * Other approaches are to convert the matrix to a single sorted list and to treat the matrix like
   * a BST (visually, if you rotate it 45 deg CCW). Converting to a sorted list has the same time
   * complexity but can cause an int overflow due to the index conversion. Treating it like a BST
   * has a worse runtime of O(m + n).
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    int rowLength = matrix.length;
    int columnLength = matrix[0].length;

    if (rowLength == 1 && columnLength == 1) {
      return matrix[0][0] == target;
    }

    int left = 0;
    int right = columnLength - 1;
    int top = 0;
    int bot = rowLength - 1;

    while (top <= bot) {
      int rowPivot = top + (bot - top) / 2;

      if (matrix[rowPivot][0] > target) {
        bot = rowPivot - 1;
      } else if (matrix[rowPivot][columnLength - 1] < target) {
        top = rowPivot + 1;
      } else if (matrix[rowPivot][0] < target && matrix[rowPivot][columnLength - 1] > target) {
        while (left <= right) {
          int pivot = left + (right - left) / 2;

          if (matrix[rowPivot][pivot] > target) {
            right = pivot - 1;
          } else if (matrix[rowPivot][pivot] < target) {
            left = pivot + 1;
          } else {
            return true;
          }
        }
        return false;
      } else {
        return true;
      }
    }
    return false;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3), // true
            searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13),
            // false
            searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 30), // true
            searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 1), // true
            searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 60), // true
            searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 0), // false
            searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 100),
            // false
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
