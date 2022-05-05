package Blind75.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
        /**
     * 1. Two Sum [E] Given an array of integers nums and an integer target, return
     * indices of the two numbers such that they add up to target. You may assume
     * that each input would have exactly one solution, and you may not use the same
     * element twice. You can return the answer in any order.
     *
     * Example 1: Input: nums = [2,7,11,15], target = 9 Output: [0,1] Output:
     * Because nums[0] + nums[1] == 9, we return [0, 1]. Example 2: Input: nums =
     * [3,2,4], target = 6 Output: [1,2] Example 3: Input: nums = [3,3], target = 6
     * Output: [0,1]
     *
     * Constraints:
     *
     * 2 <= nums.length <= 104 -109 <= nums[i] <= 109 -109 <= target <= 109 Only one
     * valid answer exists.
     *
     *
     * Time complexity : O(n^2) For each element, we try to find its complement by
     * looping through the rest of array which takes O(n) time. Therefore, the time
     * complexity is O(n^2) Space complexity : O(1)O(1).
     *
     * Follow-up: Can you come up with an algorithm that is less than O(n2) time
     * complexity? Use HashTable
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    // better: nlog(n)
    public int[] twoSumUnsorted(int[] nums, int target) {
        // Step1: copy the array to a new array and sort it using quick sort, O(nlogn)
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);
        int l = 0;
        int r = numsCopy.length - 1;
        int[] result = new int[2];
        // Step2: find the two number sums to target by two pointers (O(n))
        while (l < r) {
            int tempSum = numsCopy[l] + numsCopy[r];
            if (tempSum == target) {
                break;
            } else if (tempSum < target) {
                l = l + 1;
            } else {
                r = r - 1;
            }
        }
        // Step3: find the indexes of the two numbers in original array o(n)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == numsCopy[l]) {
                result[0] = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == numsCopy[r]) {
                result[1] = i;
                break;
            }
        }
        return result;
    }

    // Using HashMap       
    public static int[] findTwoSum(int[] list, int sum) {
        Map<Integer, Integer> numPositions = new HashMap<Integer, Integer>();
        System.out.println("sum: " + sum);
        if (list == null || list.length <= 1)
            return null;
        
        for (int i = 0; i < list.length; i++) {
            int toRetrieve = sum - list[i]; 
            if (numPositions.containsKey(toRetrieve)) {
                //if (toRetrieve + list[i] == sum) 
                return new int[]{numPositions.get(toRetrieve), i};
            }
            numPositions.put(list[i], i);
            
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 3, 9}, 5);
        int[] indices2 = findTwoSum(new int[] { 1, 3, 5, 3, 9}, 6);
        int[] indices3 = findTwoSum(new int[] { 1, 2}, 5);
        if (indices != null) {
            System.out.println("indices: " + indices[0] + " " + indices[1]);
        }
        if (indices2 != null) {
            System.out.println("indices2: " + indices2[0] + " " + indices2[1]);
        }
        if (indices3 != null) {
            System.out.println("indices3: " + indices3[0] + " " + indices3[1]);
        }
    }

    /**
     * 167. Two Sum II - Input array is sorted[Easy] Given an array of integers
     * numbers that is already sorted in ascending order, find two numbers such that
     * they add up to a specific target number. Return the indices of the two
     * numbers (1-indexed) as an integer array answer of size 2, where 1 <=
     * answer[0] < answer[1] <= numbers.length. You may assume that each input would
     * have exactly one solution and you may not use the same element twice. Example
     * 1: Input: numbers = [2,7,11,15], target = 9 Output: [1,2] Explanation: The
     * sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2. Example 2: Input:
     * numbers = [2,3,4], target = 6 Output: [1,3] Example 3: Input: numbers =
     * [-1,0], target = -1 Output: [1,2] Constraints: 2 <= numbers.length <= 3 * 104
     * -1000 <= numbers[i] <= 1000 numbers is sorted in increasing order. -1000 <=
     * target <= 1000 Only one valid answer exists. O(N)
     */
    public int[] twoSumSorted(int[] numbers, int target) {
        int[] result = new int[2];
        /* Using two pointers, one to the left one to the right end */
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int temp = numbers[l] + numbers[r];
            if (temp == target) {
                result[0] = l + 1;
                result[1] = r + 1;
                break;
            } else if (temp > target) {
                r = r - 1;
            } else {
                l = l + 1;
            }
        }
        return result;
    }

    /**
     * 653. Two Sum IV - Input is a BST Given the root of a Binary Search Tree and a
     * target number k, return true if there exist two elements in the BST such that
     * their sum is equal to the given target. Example 1: Input: root =
     * [5,3,6,2,4,null,7], k = 9 Output: true Example 2: Input: root =
     * [5,3,6,2,4,null,7], k = 28 Output: false Example 3: Input: root = [2,1,3], k
     * = 4 Output: true Example 4: Input: root = [2,1,3], k = 1 Output: false
     * Example 5: Input: root = [2,1,3], k = 3 Output: true Constraints: The number
     * of nodes in the tree is in the range [1, 104]. -104 <= Node.val <= 104 root
     * is guaranteed to be a valid binary search tree. -105 <= k <= 105
     */
    public boolean findTarget(TreeNode root, int k) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left.right != null && left.left != null) {
            if (left.val + root.val < k) {
                left = left.right;
            }
            if (left.val + root.val > k) {
                left = left.left;
            }
        }

        while (root.left != null && root.right != null) {
            if (k - root.val > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return true;
    }
}
