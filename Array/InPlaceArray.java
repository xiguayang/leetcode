package Array;

import java.util.Arrays;

public class InPlaceArray {
    /**Replace Elements with Greatest Element on Right Side
     * Given an array arr,
     * replace every element in that array with the greatest element among the elements to its right,
     * and replace the last element with -1.*/
    public static int[] replaceElements(int[] arr) {
        //if only one element
        if(arr.length==1){
            arr[0]=-1;
            return arr;
        }

        int max = arr[arr.length-1];
        int temp = arr[arr.length-2];
        for(int i=arr.length-3;i>=0;i--){

            max =(temp>max)?temp:max;
            temp = arr[i];
            arr[i]=max;

        }
        //replace the second last element to the last and the last to -1
        arr[arr.length-2]=arr[arr.length-1];
        arr[arr.length-1]=-1;

        return arr;

    }

    public int removeDuplicates(int[] nums) {

        // Check for edge cases.
        if (nums == null) {
            return 0;
        }

        // Use the two pointer technique to remove the duplicates in-place.
        // The first element shouldn't be touched; it's already in its correct place.
        int writePointer = 1;
        // Go through each element in the Array.
        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            // If the current element we're reading is *different* to the previous
            // element...
            if (nums[readPointer] != nums[readPointer - 1]) {
                // Copy it into the next position at the front, tracked by writePointer.
                nums[writePointer] = nums[readPointer];
                // And we need to now increment writePointer, because the next element
                // should be written one space over.
                writePointer++;
            }
        }

        // This turns out to be the correct length value.
        return writePointer;
    }


    /**Move Zeroes
     Given an integer array nums,
     move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     Note that you must do this in-place without making a copy of the array.
     Example 1:
     Input: nums = [0,1,0,3,12]
     Output: [1,3,12,0,0]
     Example 2:
     Input: nums = [0]
     Output: [0]
     Constraints:
     1 <= nums.length <= 104
     -231 <= nums[i] <= 231 - 1*/
    public void moveZeroes(int[] nums) {

        int nzero = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[nzero]=nums[i];
                nzero++;
            }
        }
        //fill the left elements with 0
        for(int i = nzero;i<nums.length;i++){
            nums[i]=0;
        }
    }

/** Sort Array By Parity
    Given an array nums of non-negative integers,
    return an array consisting of all the even elements of nums, followed by all the odd elements of nums.
    Example 1:
    Input: nums = [3,1,2,4]
    Output: [2,4,3,1]
    The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
    Note:

            1 <= nums.length <= 5000
            0 <= nums[i] <= 5000
 */
    public int[] sortArrayByParity(int[] nums) {
        /** Approach 1: Use Arrays.sort()method
         * Time Complexity: O(NlogN), where NN is the length of A.
         * Space Complexity: O(N) for the sort, depending on the built-in implementation of sort.*/
        Integer[] B = new Integer[nums.length];
        for (int t = 0; t < nums.length; ++t)
            B[t] = nums[t];

        Arrays.sort(B, (a, b) -> Integer.compare(a%2, b%2));

        for (int t = 0; t < nums.length; ++t)
            nums[t] = B[t];
        return nums;

    }

    public int[] sortArrayByParityByTwoPasse(int[] nums) {
        /** Approach 2: iterate the array 2 times, create a new array
         * Time Complexity: O(N), where NN is the length of A.
         * Space Complexity: O(N), the space used by the answer.*/
        int[] temp = new int[nums.length];
        int j = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]%2 ==0){
                temp[j++] = nums[i];
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i]%2 ==1){
                temp[j++] = nums[i];
            }
        }
        return temp;
    }

    public int[] sortArrayByParityInPlace(int[] nums) {
        /**Approach 3: In-Place: do quick sort
         *             Use 2 pointers, i and j, i starts from left, j from right
         *             4 cases: if nums[i] even, nums[j] odd: i++, j--
         *                      if nums[i] odd,  nums[j] even: swap them
         *                      if nums[i] even, nums[j] even: i++, no change for j
         *                      if nums[i] odd, nums[j] odd: j--, no change for i
         * Time Complexity: O(N), where N is the length of A.
         * Each step of the while loop makes j-i decrease by at least one.
         * (Note that while quicksort is O(NlogN) normally,
         * this is O(N) because we only need one pass to sort the elements.)
         * Space Complexity: O(1)O(1) in additional space complexity. */
        //use 2 pointers from left and right individually
        int i = 0;
        int j = nums.length-1;
        //if odd % should be 1; even % should be 0
        while(i<j){
            //nums[i]odd, nums[j] even, swap them
            if(nums[i]%2 >nums[j]%2){
                int temp = nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
            }
            //if nums[i] is even, move to next
            if(nums[i] % 2 == 0) i++;
            //if nums[j] is odd, move to next
            if(nums[j] % 2==1) j--;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{17,18,5,4,6,1};
        replaceElements(arr);

    }
}
