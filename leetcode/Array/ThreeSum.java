package Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 3Sum[M] Given an integer array nums, return all the triplets [nums[i],
 * nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j]
 * + nums[k] == 0. Notice that the solution set must not contain duplicate
 * triplets.
 *
 * Example 1: Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]]
 * Example 2: Input: nums = [] Output: [] Example 3: Input: nums = [0] Output:
 * []
 * 
 * Constraints: 0 <= nums.length <= 3000 -105 <= nums[i] <= 105
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > 0 || nums.length < 3) {
            return null;
        }
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int target = 0 - nums[i];
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == 0 - nums[i]) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l + 1] == nums[l]) {
                            l = l + 1;
                        }
                        while (l < r && nums[r - 1] == nums[r]) {
                            r = r - 1;
                        }
                        l = l + 1;
                        r = r - 1;
                    } else if (nums[l] + nums[r] < 0 - nums[i]) {
                        l = l + 1;
                    } else {
                        r = r - 1;
                    }
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] testarr = new int[] { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> res = new LinkedList<>();
        res = threeSum(testarr);
    }
}
