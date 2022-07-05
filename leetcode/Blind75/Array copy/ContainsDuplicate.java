package Leetcodes.Blind75.Array;

import java.util.Arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums){
        //using hashSet to record visited nums
        //O(n), O(n)
        Set<Integer> visted = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(visted.contains(nums[i])){
                return true;
            }else{
                visted.add(nums[i]);
            }
        }
        return false;
    }

    public boolean containsDuplicateBySorting(int[] nums){
        //Sort the array, compare adjacent elements 2 by 2
        //O(nlogN), O(1)
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
