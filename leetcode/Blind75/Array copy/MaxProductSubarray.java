package Leetcodes.Blind75.Array;

public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curMin=1;
        int curMax = 1;
        //leaner keep recording the curMin and curMax product of the substring
        for(int i=0;i<nums.length;i++){
            //if encounters with 0, reset curMin and curMax as 1
            if(nums[i]==0){
                curMin =1;
                curMax =1;
            }
            //compare with product of both curMin*n and curMax*n 
            int temp = curMin;
            curMin = Math.min(Math.min(nums[i],nums[i]*curMin), nums[i]*curMax);
            curMax = Math.max(Math.max(nums[i],nums[i]*temp),nums[i]*curMax);
            max = Math.max(max, curMax);
        }
        return max;
    }
}
