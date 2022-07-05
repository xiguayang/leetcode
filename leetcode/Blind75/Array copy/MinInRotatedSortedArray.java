package Leetcodes.Blind75.Array;

public class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l =0;
        int r = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(l<=r){
            int mid = l+(r-l)/2;     
            // compare nums[mid] >= nums[l]
            // ==> left is ascending order, min is at the right partition {l=mid+1, r} 
            if(nums[mid]>=nums[l]){
                //always compare nums[mid] with min to get the min
                min = Math.min(min,nums[l]);
                l=mid+1;
            }else{
                //nums[mid] < nums[l] ==> left is not ascending order, min is at the partition {l, r=mid-1}
                min = Math.min(min,nums[mid]);
                r =mid-1;
            }
        }
        return min;
    }
}
