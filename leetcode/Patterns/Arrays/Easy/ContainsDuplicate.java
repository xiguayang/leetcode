package Patterns.Arrays.Easy;
import java.util.HashSet;

// # 217. Array
// Given an integer array nums, 
// return true if any value appears at least twice in the array, 
// and return false if every element is distinct.

class ContainsDuplicate {
    //using HashSet as the structrue to record all unique elements
    //Time Complexity: O(N)
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> uniqueNums = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            int num = nums[i];
            if(uniqueNums.contains(num)){
                return true;
            }else{
                uniqueNums.add(num);
            }
        }
        return false;
    }
}