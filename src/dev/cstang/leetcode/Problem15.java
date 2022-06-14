package dev.cstang.leetcode;

import dev.cstang.Problem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 *
 * <p>https://leetcode.com/problems/3sum/
 *
 * @author Cheryl Tang
 */
public class Problem15 extends Problem {

  /**
   * This solution uses a two pointer pattern. The input array is sorted and one digit is fixed via
   * a loop, then the rest of the problem becomes a Two Sum problem with added logic to avoid
   * duplicates. Since the input is sorted, the time complexity is O(nlogn) + O(n^2), which
   * simplifies to just O(n^2). The space complexity is between O(1) or O(n), depending on how the
   * underlying sort algorithm is implemented and the types being sorted. In this case where we are
   * sorting primitives, it is O(logn) space complexity.
   */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> triplets = new ArrayList<>();

    if (nums.length < 3) {
      return triplets;
    }

    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
          int threeSum = nums[i] + nums[left] + nums[right];

          if (threeSum < 0) {
            left++;
          } else if (threeSum > 0) {
            right--;
          } else {
            List<Integer> triplet = new ArrayList<>();

            triplet.add(nums[i]);
            triplet.add(nums[left]);
            triplet.add(nums[right]);

            triplets.add(triplet);

            left++;
            right--;

            while (nums[left] == nums[left - 1] && left < right) {
              left++;
            }

            while (nums[right] == nums[right + 1] && left < right) {
              right--;
            }
          }
        }
      }
    }

    return triplets;
  }

  @Override
  public void runTestCases() {
    Object[] testCaseSolutions =
        new Object[]{
            threeSum(new int[]{-1, 0, 1, 2, -1, -4}), // [[-1,-1,2],[-1,0,1]]
            threeSum(new int[]{}), // []
            threeSum(new int[]{0}), // []
        };

    System.out.println(Arrays.toString(testCaseSolutions));
  }
}
