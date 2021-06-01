package BinarySearch;
/**
 * 3 Parts of a Successful Binary Search:
 * Binary Search is generally composed of 3 main sections:
 *
 * 1. Pre-processing - Sort if collection is unsorted.
 * 2. Binary Search - Using a loop or recursion to divide search space in half after each comparison.
 * 3. Post-processing - Determine viable candidates in the remaining space.
 *
 * */
public class BinarySearchArray {
    /**Template #1 is the most basic and elementary form of Binary Search.
     * used to search for an element or condition which can be determined by accessing a single index in the array.
     * Search Condition can be determined without comparing to the element's neighbors (or use specific elements around it)
     * No post-processing required because at each step, you are checking to see if the element has been found.
     * If you reach the end, then you know the element is not found
     * Distinguishing Syntax:
     * Initial Condition: left = 0, right = length-1
     * Termination: left > right
     * Searching Left: right = mid-1
     * Searching Right: left = mid+1*/
    public int search(int[] nums, int target) {
        if(nums==null || nums.length ==0) return -1;
        int mid = 0;
        int left = 0;
        int right = nums.length-1;
        while(left <=right){
            mid = left+(right-left)/2;
            if(nums[mid] ==target) return mid;
            if(target <nums[mid]){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return -1;
    }
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int start = 1, end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid*mid <=x && (mid + 1) *(mid+1)>x)// Found the result
                return mid;
            else if (mid>x/mid)// Keep checking the left part
                end = mid;
            else
                start = mid + 1;// Keep checking the right part
        }
        return start;
    }

    public static void main(String[] args) {
        int re = mySqrt(5);
        System.out.println(re);
    }
}
