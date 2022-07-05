package Leetcodes.Leetcode_V1.BinarySearch;

public class SearchInRotatedSortedArray {
    //33. Search in Rotated Sorted Array
    public int search(int[] nums, int target) {
        //Rotated sorted array
        //also have 2 parts, find the pivot which is the smallest num in the array
        // 4,5,6,7 ...0,1,2,3
       // if(nums[0]>nums[nums.length-1]){
            //it is rotated
            //Step1: find the smallest num, get partitions 
            int minIndex = getSmallest(nums);
            //Step2: Binary Search the part which may have the target
            if(nums[0]<=target){//the left part
                return binarySearch(nums, 0, (minIndex-1+nums.length)%nums.length, target);
            }else{
                return binarySearch(nums, minIndex, nums.length-1, target);
            }
            
        // }else{
        //     //normal sorted array, just binary search
        //     //same with minIndex =0;
        //     binarySearch(nums,0, nums.length-1, target);
        // }
    }
    private int getSmallest(int[] nums){
        int l =0;
        int r = nums.length-1;
        while(l<=r){
            if(nums[l]<=nums[r]) return l;
            int mid = l+(r-l)/2;
            int next =(mid+1)%nums.length;//add length and using % to avoid out of boundry
            int pre = (mid-1+nums.length)%nums.length;//add length and using % to avoid out of boundry
            if(nums[pre]>=nums[mid]&& nums[mid]<=nums[next]){
                return mid;
            }else if(nums[l]<=nums[mid]){
                l=mid+1;
            }else if(nums[mid]<=nums[r]){
                r=mid-1;
            }
        }
        return -1;
    }
    private int binarySearch(int[] nums, int l, int r, int target){
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r=mid-1;
            }else if(nums[mid]<target){
                l=mid+1;
            }
        }
        return -1;
    }

    public boolean searchRepeatedRotated(int[] nums, int target) {
        //binary search
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return true;
            }else if(nums[mid]>nums[l]){//[l...mid] is sorted
                if(nums[l]<=target&& target<nums[mid]){ //target is in [l, mid), which is sorted too
                    r = mid-1;          
                }else {//target is not in [l..mid]
                    l = mid+1;
                }
            }else if(nums[mid]<nums[l]){//[mid...r] is sorted part
                if(nums[mid]<target && target<=nums[r]){//target in (mid,r], which is sorted
                    l = mid+1;
                }else if(nums[mid]<target){
                    r = mid-1;
                }
            }else if(nums[mid] == nums[l]){//[l...mid] all same elements 
                if(nums[l]==target) return true;
                else{
                    l++;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
        int[] nums = new int[]{1,2,1};
       // System.out.println(test.search(nums, 3));
        System.out.println(test.searchRepeatedRotated(nums, 0));
    }
}
