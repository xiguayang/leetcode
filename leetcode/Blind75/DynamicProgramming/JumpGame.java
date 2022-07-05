package Leetcodes.Blind75.DynamicProgramming;

public class JumpGame {
    //55. Jump Game
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len==1) return true;
        // move the arriving goals when the goal can be reached
        int goal = len-1;
        for(int i =len-2;i>=0;i--){
            int steps = nums[i];
            if(i+steps>=goal){
                goal=i;
            }
            
        }
        return goal==0;
        
    }
}
