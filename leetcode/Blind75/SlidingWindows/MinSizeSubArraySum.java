package Leetcodes.Blind75.SlidingWindows;

public class MinSizeSubArraySum {
    //209
    public int minSubArrayLen(int target, int[] nums) {
        //minimum length of subArray
        int min =Integer.MAX_VALUE;
        int sum = 0;
        //using 2 pointers to represent a sliding window[l,r]
        int l =0;
        int r = 0;
        //a big loop to move r
        while(r<nums.length){
            //each time move r, adding num to sum
            sum = sum+nums[r];
            //if sum >=target, start to shrink window by moving l
            while(sum>=target){
                min = Math.min(r-l+1, min);
                //shrink the sub window
                sum = sum-nums[l];
                l=l+1;
            }
            r++;
        }
        //return 0 if no such subarray
        if(min!=Integer.MAX_VALUE){
            return min;
        }else{
            return 0;
        }
    }
}
