package Leetcodes.Blind75.DynamicProgramming;

public class HouseRobII {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        //because it is a circle
        //it's not allowed to rob both first and last house at one time
        //use House Robber I as helper method
        //get the max by given the array without first or last house
        return Math.max(robHouse(nums, 0, nums.length-2), robHouse(nums,1,nums.length-1));
    }
    private int robHouse(int[] nums, int start, int end){
        int rob1=0;
        int rob2= 0;
        for(int i =start; i<=end;i++){
            int temp = Math.max(rob1+nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
    public static void main(String[] args) {
        HouseRobII test = new HouseRobII();
        int[] houses = new int[]{1,2,3,1};
        System.out.print(test.rob(houses));
    }
}
