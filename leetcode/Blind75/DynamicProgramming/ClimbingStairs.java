package Leetcodes.Blind75.DynamicProgramming;

public class ClimbingStairs {
    //70. O(n)
    public int climbStairs(int n) {
        //dp[i]: the ways to climb i stairs
        // 0....n
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1] = 1;
        for(int i=2;i<dp.length;i++){
            //dp[i-1]: 1 step
            //dp[i-2]: 2 steps
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
