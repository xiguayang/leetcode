package Leetcodes.Blind75.Array;
public class MaxSubarray {
    public int maxSubarray(int[] nums){
        int max = Integer.MIN_VALUE;
        int sum =0;
        for(int i = 0;i<nums.length;i++){
            sum = sum +nums[i];
            max = Math.max(sum, max);
            if(sum<0){
                sum =0;
            }
            //sum >0, move to next
        }
        return max;
    }
}
