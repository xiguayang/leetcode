package Leetcodes.Blind75.Array;


public class SearchInRotatedSortedArray{
    public static int search(int[] nums, int target) {
        //Step1: find the min of the array by binary search, it is the pivot of the array
        // left subarray (pivot) right subarray
        // so both left subarray left of pivot and right subarray(includindg pivot) is sorted
        //Step2: check the target with nums[l]
            //2.1: if nums[l]>target, only search right partition
            //2.2: if nums[l]<=target, only search left partition
        int res =-1;
        int pivot = getMinIndex(nums);
        int l=0;
        int r = nums.length-1;
        if(nums[l]>target){
            res= binarySearch(nums, pivot, r, target);
        }else{
            res= binarySearch(nums, l, (pivot-1+nums.length)%nums.length, target);
        }
        return res;
    }
    public static int binarySearch(int[] nums, int left, int right, int target) {
        while (left <=right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int getMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int length = nums.length;
        while (left <= right) {
            // if it's roated array,nums[0]>nums[length-1]
            // or its just a sorted array, nums[0] is smallest
            if (nums[left] <= nums[right]) {
                return left;
            }
            int mid = left + (right - left) / 2;
            int next = (mid + 1) % length;
            int prev = (mid - 1 + length) % length;

            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                return mid;
                // [5,6,7,1,2,3,4]
                // mid=3
            } else if (nums[left] <= nums[mid]) {
                // [5,6,7,1,2,4]
                //     mid : increasing left half -->right half
                left = mid + 1;
            } else if (nums[mid] <= nums[right]) {
                // [6,7,1,2,3,4,5]
                //       mid: increasing right half--> left half
                right = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        System.out.println(search(nums, 3));
    }
}