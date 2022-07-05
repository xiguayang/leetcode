package Leetcodes.Leetcode_V1.WarmUp;

public class RemoveElement {
    //27
    public int removeElement(int[] nums, int target) {
        int slow = 0;
        int fast = 0;
        while(fast<nums.length){
            if(nums[fast]!=target){
                nums[slow] = nums[fast];
                slow++;
            }
            fast ++;
        }
        return slow;
    }
}
