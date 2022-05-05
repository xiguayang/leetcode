package Array.BinarySearch;
import java.util.ArrayList;

/**
 * 3 Parts of a Successful Binary Search: Binary Search is generally composed of
 * 3 main sections:
 *
 * 1. Pre-processing - Sort if collection is unsorted. 2. Binary Search - Using
 * a loop or recursion to divide search space in half after each comparison. 3.
 * Post-processing - Determine viable candidates in the remaining space.
 *
 */
public class BinarySearchArray {
    /**
     * Template #1 is the most basic and elementary form of Binary Search. used to
     * search for an element or condition which can be determined by accessing a
     * single index in the array. Search Condition can be determined without
     * comparing to the element's neighbors (or use specific elements around it) No
     * post-processing required because at each step, you are checking to see if the
     * element has been found. If you reach the end, then you know the element is
     * not found Distinguishing Syntax: Initial Condition: left = 0, right =length-1
     * Termination: left > right Searching Left: right = mid-1 Searching Right: left
     * = mid+1
     */
    public int binarySearchI(int[] nums, int target) {
        
        if (nums == null || nums.length == 0)
            return -1;
        int mid = 0;
        int left = 0;
        int right = nums.length - 1;
        // 避免当 target 小于nums[0] or > nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        //search the target between [left, right]
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    /**
     * Template #2 is an advanced form of Binary Search. It is used to search for an
     * element or condition which requires accessing the current index and its
     * immediate right neighbor's index in the array.
     * 
     * 1. Search Condition needs to access element's immediate right neighbor 2. Use
     * element's right neighbor to determine if condition is met and decide whether
     * to go left or right 3. Gurantees Search Space is at least 2 in size at each
     * step 4. Post-processing required. Loop/Recursion ends when you have 1 element
     * left. Need to assess if the remaining element meets the condition. Initial
     * Condition: left = 0, right = length Termination: left == right Searching
     * Left: right = mid Searching Right: left = mid+1
     */

    public int binarySearchII(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        //search between [left, right)
        while (left < right) {
            // prevent (left+right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
                
            else if (nums[mid] < target) {
                //go to the right part of array
                left = mid + 1;
            } else {
                //go to the right part of array, must including mid itself
                right = mid;
            }
        }
        // post -processing
        // end condition: left ==right
        if (left != nums.length && nums[left] == target)
            return left;
        return -1;
    }

    public static int mySqrt(int x) {
        if (x == 0)
            return 0;
        int start = 1, end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x)// Found the result
                return mid;
            else if (mid > x / mid)// Keep checking the left part
                end = mid;
            else
                start = mid + 1;// Keep checking the right part
        }
        return start;
    }

    /**
     * Search in Rotated Sorted Array [4,5,6,1,3]
     */
    public static int searchRotatedSortedArray(int[] nums, int target) {
        int min = getMinIndex(nums);
        // find the smallest element of the array, it divides the array into two parts
        // each part is a standard sorted array
        // if nums[0]>target, search the target in right part
        // if nums[0]<=target, search the target in the left part
        if (nums[0] <= target) {
            return binarySearch(nums, 0, min - 1, target);
        } else {
            return binarySearch(nums, min, nums.length - 1, target);
        }
        // int left = binarySearch(nums, 0, min - 1, target);
        // int right = binarySearch(nums, min, nums.length - 1, target);
        // if (left == -1 && right == -1) {
        // return -1;
        // } else if (left == -1) {
        // return right;
        // } else {
        // return left;
        // }

    }

    public static int getMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int length = nums.length;
        while (left <= right) {
            // if it's roated array,nums[0]>nums[length-1]
            // or its just a sorted array, nums[0] is smallest
            if (nums[left] <= nums[right]) {
                return left;
            }
            int mid = left + (right - left) / 2;
            int next = (mid + 1) % length;
            int prev = (mid - 1 + length) % length;

            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                return mid;
                // [5,6,7,1,2,3,4]
                // mid=3
            } else if (nums[left] <= nums[mid]) {
                // [5,6,7,1,2,4]
                // mid=2
                left = mid + 1;
            } else if (nums[mid] <= nums[right]) {
                // [6,7,1,2,3,4,5]
                // mid=3
                right = mid - 1;
            }
        }
        return 0;

    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    /** First Bad Version */

    /**
     * 162[M] Find Peak Element A peak element is an element that is strictly
     * greater than its neighbors. Given an integer array nums, find a peak element,
     * and return its index. If the array contains multiple peaks, return the index
     * to any of the peaks. You may imagine that nums[-1] = nums[n] = -∞. You must
     * write an algorithm that runs in O(log n) time. 1 <= nums.length <= 1000 -231
     * <= nums[i] <= 231 - 1 nums[i] != nums[i + 1] for all valid i.
     */
    public static int findPeakElement(int[] nums) {

        // 1,4,5,2,4,6,7,8,9
        // peak is 2
        // find mid, if(mid-1<mid >mid+1) peak = mid
        // else if mid-1<mid<mid+1===> check right part: left = mid+1, check left part:
        // right = mid-1
        // else if mid<mid-1:check==> check left part: right = mid
        // ========> due to mid might be 0, mid-1 will exceeds the limit
        // only consider mid>mid+1 and mid<mid+1
        // if (mid>mid+1): check left: right = mid
        // if (mid< mid+1):
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        // int re = mySqrt(5);
        int[] arr = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int re = searchRotatedSortedArray(arr, 0);
        System.out.println(re);
    }
}
