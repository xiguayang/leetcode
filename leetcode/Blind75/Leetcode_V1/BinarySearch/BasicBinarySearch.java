package Leetcodes.Leetcode_V1.BinarySearch;

public class BasicBinarySearch {
    //704
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int r = nums.length-1;
        int l = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r = mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
}
