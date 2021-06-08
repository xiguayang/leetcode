
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
     * not found Distinguishing Syntax: Initial Condition: left = 0, right =
     * length-1 Termination: left > right Searching Left: right = mid-1 Searching
     * Right: left = mid+1
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int mid = 0;
        int left = 0;
        int right = nums.length - 1;
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

    public static void main(String[] args) {
        // int re = mySqrt(5);
        int[] arr = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int re = searchRotatedSortedArray(arr, 0);
        System.out.println(re);
    }
}
