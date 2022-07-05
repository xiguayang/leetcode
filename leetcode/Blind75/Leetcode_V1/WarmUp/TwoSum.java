package Leetcodes.Leetcode_V1.WarmUp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
        //Method1: sort the array, using 2 pointers
        //Time: O(nlogn), Memory: O(n)
    public int[] twoSumUsingSortCopiedArray(int[] nums, int target) {

        int[] copied = Arrays.copyOf(nums,nums.length);
        Arrays.sort(copied);
        int l =0;
        int r = copied.length-1;
        while(l<r){
            if(copied[l]+copied[r]==target){
                //return new int[]{l,r};
                //find nums in original array
                return findInOriginal(copied[l],copied[r], nums);
            }else if(copied[l]+copied[r] < target){
                l=l+1;
            }else{
                r=r-1;
            }
        }
        return new int[]{-1,-1};
        
    }
    private int[] findInOriginal(int n1, int n2, int[] nums){
        int[] result = new int[2];
        for(int i =0;i<nums.length;i++){
            if(nums[i]==n1){
                result[0]=i;
                break;
            }
        }
        for(int i =nums.length-1;i>=0;i--){
            if(nums[i]==n2){
                result[1]=i;
                break;
            }
        }

        return result;
    }

    //Method2: Using HashMap to record the 
    public int[] twoSum(int[] nums, int target) {
        //Method2: sort the HashMap to record the num as key and the index of original element as value
        //Time: O(n), Memory: O(n)
        Map<Integer, Integer> hm = new HashMap<>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            int cur = nums[i];
            int remain = target-cur;
            //go to hm to find if the map contains the remain
            if(hm.containsKey(remain)){
                res[0]=hm.get(remain);
                res[1]= i;
            }else{
                hm.put(cur, i);
            }
        }
        return res;
    }
}
