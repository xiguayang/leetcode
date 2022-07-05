package Leetcodes.Blind75.DynamicProgramming;

public class CombinationSumIV {
    //377
    public int combinationSum4(int[] nums, int target) {
        //dp[x]: is all possible combination ways number
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int i =1;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                //i >= all numbers in nums
                //dp[4] = dp[4-1] + dp[4-2]+ dp[4-3]
                //dp[1] = dp[1-1]
                //dp[i]= dp[i-num1]+dp[i-num2]+dp[i-num3]
                if(i-nums[j]>=0){
                    dp[i]=dp[i-nums[j]]+dp[i];
                }
            }
        }
        return dp[target];
    }
}
