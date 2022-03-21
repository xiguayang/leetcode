/**704 Easy
 * Given an array sorted: nums, an integer: target,
 * function to search target in nums, return index or -1
 * O(LogN) 
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int mid = 0;
        int lo = 0;
        int hi = nums.length-1;
        while(lo <=hi){
            mid = lo+(hi-lo)/2;
            if(nums[mid] ==target) return mid;
            if(target <nums[mid]){
                hi = mid -1;
            }else{
                lo = mid +1;
            }
        }
        return -1;
    }
}
