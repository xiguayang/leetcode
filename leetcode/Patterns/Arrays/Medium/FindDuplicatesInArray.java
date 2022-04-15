package Patterns.Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * #442 Find All Duplicates in an Array
 * 
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.

 
 */
public class FindDuplicatesInArray {
    //Solution: Time: O(N) Space: O(1)
    // 1. All num in array is between 1->N, N is the length
    // 2. the value (num-1)  is between 0 -> N-1， 每个num-1都有一个对应的index
    // 3. loop the array, 
    //  如果|num|是第一次出现，那么|num|-1作为index，将此位置上的num变为负数
    //  如果|num|-1 位置上的value已经是负数了，证明现在遇到第二次|num|
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i =0;i<nums.length;i++){
            int newIndex = Math.abs(nums[i])-1;
            if(nums[newIndex]<0){
                nums[newIndex] = - nums[newIndex];
            }else{
                res.add(Math.abs(nums[i]));
            }
        }
        return res;
    }
}
