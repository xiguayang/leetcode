package TwoPointers;

/**
 * 167. Two Sum II - Input array is sorted[E]
 * 
 * Given an array of integers numbers that is already sorted in non-decreasing
 * order, find two numbers such that they add up to a specific target number.
 * Return the indices of the two numbers (1-indexed) as an integer array answer
 * of size 2, where 1 <= answer[0] < answer[1] <= numbers.length. The tests are
 * generated such that there is exactly one solution. You may not use the same
 * element twice.
 */
// Example 1:
// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
// Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
public class TwoSumII {
    // Solution: The given array is sorted, so we use two pointers traverse opposite
    // directions.
    // 1. the left pointer starts from 0; the right pointer starts from end
    // 2. if the sum of elements left and right point to is less than the target,
    // move left one step;
    // if sum is larger than the target, move right one step to the left.
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            int sum = numbers[left]+ numbers[right]
            if(sum==target){
                result[0]=left+1;
                result[1]=right+1;
                return result;
            }else if(sum<target){
                left=left+1;
            }else{
                right=right+1;
            }
        }
        return null;
    }
}
