package Leetcodes.Leetcode_V1.WarmUp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    //169.
    public static int majorityElement(int[] nums) {
        //Method: O(1) Time. O(N) Memory
        //using HashMap

        Map<Integer, Integer> hm = new HashMap<>();
        int maxFrequency = 0;
        int majority = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i], hm.get(nums[i])+1);//update the value 
                if(hm.get(nums[i])>maxFrequency){
                    majority= nums[i];
                    maxFrequency = Math.max(maxFrequency,hm.get(nums[i]));//update the majority
                }
                
            }else{
                hm.put(nums[i],1);
            }
        }
       // for(int n: hm.values())
        return majority;
    }
    //Method 2: Sort the array, nums[mid]--> majority
    public static int majorityElementBySort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    //Method 3: Boyer-Moore
    //O(n) time, O(1) space
    public static int majorityBoyerMoore(int[] nums){
        int candidant = nums[0];
        int count = 0;
        for(int i =1; i<nums.length;i++){
            if(count ==0){
                candidant = nums[i];//set new candidant for majority
            }
            if(candidant != nums[i]){
                count--;
            }else{
                count++;
            }
        }
        return candidant;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums)); 
    }
}
